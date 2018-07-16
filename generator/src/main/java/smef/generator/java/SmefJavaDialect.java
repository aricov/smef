package smef.generator.java;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

import smef.ast.SmefUnit;
import smef.generator.SmefDialect;
import smef.generator.TypeMapper;

public class SmefJavaDialect implements SmefDialect {

	private final Map<String, String> domainToPackage;

	private final TypeMapper typeMapper;
	
	public SmefJavaDialect(Map<String, String> domainToPackage) {
		this.domainToPackage = domainToPackage;
		this.typeMapper = JavaTypeMapper.INSTANCE;
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
	public TypeMapper getTypeMapper() {
		return typeMapper;
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
