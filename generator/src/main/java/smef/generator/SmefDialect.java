package smef.generator;

import java.nio.file.Path;
import java.util.Map;

import smef.ast.SmefUnit;

public interface SmefDialect {

	String name();
	
	Map<String, String> getDomainMappings();
	
	Map<String, String> getTypeMappings();

	Path getOutputPath(SmefUnit smefUnit);
	
}
