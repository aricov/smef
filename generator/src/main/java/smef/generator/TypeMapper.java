package smef.generator;

import java.util.Optional;

import smef.ast.TypeSpec;

public interface TypeMapper {

	/** Map a type specification to the simple name of the type in the target dialect.
	 * 
	 * @param spec the type specification to map.
	 * @return The simple name of the type for the specification, or empty if no mapping can be found. 
	 */
	Optional<String> map(TypeSpec spec);
	
}
