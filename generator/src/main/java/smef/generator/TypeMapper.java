package smef.generator;

import java.util.Optional;

import smef.ast.TypeSpec;

public interface TypeMapper {

	Optional<String> map(TypeSpec spec);
	
}
