package smef.maven.plugin;

import static java.lang.String.format;
import static java.nio.file.Files.createDirectories;
import static java.nio.file.Files.newBufferedWriter;
import static java.nio.file.Files.notExists;
import static java.util.Collections.emptyMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.compiler.util.scan.SimpleSourceInclusionScanner;
import org.codehaus.plexus.compiler.util.scan.SourceInclusionScanner;
import org.codehaus.plexus.compiler.util.scan.mapping.SourceMapping;
import org.codehaus.plexus.compiler.util.scan.mapping.SuffixMapping;

import smef.ast.SmefFile;
import smef.ast.SmefUnit;
import smef.generator.SmefDialect;
import smef.generator.handlerbars.HandlebarsGenerator;
import smef.generator.java.SmefJavaDialect;
import smef.parser.SmefBackend;

@Mojo(
	name="generate", 
	defaultPhase=LifecyclePhase.GENERATE_SOURCES,
	requiresDependencyResolution = ResolutionScope.COMPILE,
	requiresProject = true
)
public class SmefGenerateMojo extends AbstractMojo {

	@Parameter(defaultValue="${basedir}/src/main/smef")
	private File sourceDirectory;
	
	@Parameter(defaultValue="${project.build.directory}/generated-sources/smef")
	private File outputDirectory;
		
	@Parameter
	private Map<String, String> domainMappings;
	
    @Parameter(
    		property="project",
    		required=true,
    		readonly=true
    )
    protected MavenProject project;	

    private Set<String> includes = new HashSet<>();
    
    private Set<String> excludes = new HashSet<>();
	
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info(format("source directory: %s", sourceDirectory.getAbsolutePath()));
		getLog().info(format("output directory: %s", outputDirectory.getAbsolutePath()));
        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs();
        }

        Set<File> sources = null;
        
        try {
			SourceMapping mapping = new SuffixMapping(".smef", Collections.<String>emptySet());
			SourceInclusionScanner scanner = new SimpleSourceInclusionScanner(getIncludePatterns(), excludes);
			scanner.addSourceMapping(mapping);
			sources = scanner.getIncludedSources(sourceDirectory, null);
        } catch (Exception e) {
        	throw new MojoExecutionException("Failed to retrieve sources", e);
        }


        Set<SmefFile> smefFiles = new HashSet<>();
        SmefBackend backend = new SmefBackend();
        for (File source : sources) {
        	try {
        		FileInputStream inputStream = new FileInputStream(source);
				smefFiles.add(backend.parse(inputStream));
			} catch (Exception e) {
				throw new MojoFailureException("Failed to parse source at " + source.getPath() , e);
			}
        }
        
        //Java specific 
		SmefDialect javaDialect = new SmefJavaDialect(getDomainMappings());
		
		HandlebarsGenerator smef;
		try {
			smef = new HandlebarsGenerator(javaDialect);
		} catch (IOException e) {
			throw new MojoExecutionException("Failed to load dialect", e);
		}
		
        //First we split the smefFiles into new ones, one per definition.
        Set<SmefUnit> units = smefFiles.stream()
        		.flatMap(SmefFile::units)
        		.collect(Collectors.toSet());
        
        for( SmefUnit unit : units ) {
        	Path outputDir = outputDirectory.toPath();
        	Path relativePath = javaDialect.getOutputPath(unit);
        	
        	getLog().info(format("Generating %s under %s", relativePath, outputDir));
        	
        	Path classFile = outputDir.resolve(relativePath);
        	try {
	        	if ( notExists(classFile.getParent()) ) {
	        		createDirectories(classFile.getParent());
	        	}
        	} catch(IOException e) {
        		throw new MojoExecutionException(format("Failed to create output folder %s", classFile.getParent()));
        	}
        	
        	try (Writer classWriter = newBufferedWriter(classFile, StandardCharsets.UTF_8)) {
        		smef.generate(unit, classWriter);
			} catch (Exception e) {
				throw new MojoExecutionException(
						format("Failed to generate code for %s: %s", relativePath, e.getMessage()),
						e
				);
			}
        };
        
		project.addCompileSourceRoot(outputDirectory.getPath());        
	}
	
	private Set<String> getIncludePatterns() {
		if ( includes == null || includes.isEmpty() ) {
			return Collections.singleton("**/*.smef");
		}
		return includes;
	}
	
	private Map<String, String> getDomainMappings() {
		if ( domainMappings == null ) {
			return emptyMap();
		}
		return domainMappings;
	}
	
}
