package smef.generator.handlerbars;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import smef.ast.SmefUnit;
import smef.generator.SmefDialect;

public class SmefJavaDialect implements SmefDialect {

	private static final Map<String, String> stdTypeMappings = new HashMap<>();
	
	private final Map<String, String> domainToPackage;

	public SmefJavaDialect(Map<String, String> domainToPackage) {
		this.domainToPackage = domainToPackage;
		stdTypeMappings.put("boolean", "boolean");
		stdTypeMappings.put("integer", "int");
		stdTypeMappings.put("decimal", "float");
		stdTypeMappings.put("string", "String");
		stdTypeMappings.put("uuid", UUID.class.getName());
	}

	@Override
	public String name() {
		return "java";
	}

	@Override
	public Map<String, String> getDomainMappings() {
		return domainToPackage;
	}
	
	@Override
	public Map<String, String> getTypeMappings() {
		return stdTypeMappings;
	}
	
	@Override
	public Path getOutputPath(SmefUnit smefUnit) {
		String pkg = domainToPackage.get(smefUnit.domain);
		if ( pkg == null ) {
			pkg = smefUnit.domain;
		}
		
		// Couldn't figure out the path separator thing,
		// so went on to getting individual names...
		String[] names = pkg.split("\\.");
		
		int len = names.length;
		String head = names[0];
		String[] tail = len > 1 ? Arrays.copyOfRange(names, 1, len) : new String[]{};
				
		Path pkgPath = Paths.get(head,  tail);
		String classFile = smefUnit.def.name + ".java"; 
		return pkgPath.resolve(classFile);
	}

}
