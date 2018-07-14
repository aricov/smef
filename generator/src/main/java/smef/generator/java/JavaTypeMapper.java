package smef.generator.java;

import static smef.ast.Quantifier.MANY;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import smef.ast.TypeSpec;
import smef.generator.TypeMapper;

public class JavaTypeMapper implements TypeMapper {

	private static final Map<String, String> singleTypeMappings = new HashMap<>();
	private static final Map<String, String> multiTypeMappings = new HashMap<>();
	static {
		singleTypeMappings.put("boolean", "boolean");
		singleTypeMappings.put("integer", "int");
		singleTypeMappings.put("decimal", "float");
		singleTypeMappings.put("string", "String");
		singleTypeMappings.put("uuid", UUID.class.getName());
		
		multiTypeMappings.put("boolean", Boolean.class.getSimpleName());
		multiTypeMappings.put("integer", Integer.class.getSimpleName());
		multiTypeMappings.put("decimal", Float.class.getSimpleName());
		multiTypeMappings.put("string", String.class.getSimpleName());
		multiTypeMappings.put("uuid", UUID.class.getName());
	}
	private final Map<String, String> domainMappings;
	
	
	private JavaTypeMapper(Map<String, String> domainMappings) {
		this.domainMappings = domainMappings;
	}

	public static JavaTypeMapper withDomainMappings(Map<String, String> domainMappings) {
		return new JavaTypeMapper(domainMappings);
	}
	
	@Override
	public Optional<String> map(TypeSpec spec) {
		if ( spec == null ) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(
			spec.domain == null || spec.domain.isEmpty()
				? mapUnqualifiedType(spec)
				: mapDomainType(spec)
		);
	}
	
	private String mapUnqualifiedType(TypeSpec spec) {
		if ( spec.quantifier == MANY ) {
			return multiTypeMappings.get(spec.name);
		}
		
		return singleTypeMappings.get(spec.name);
	}
	
	public String mapDomainType(TypeSpec spec) {
		String pkg = Optional.ofNullable(domainMappings.get(spec.domain)).orElse(spec.domain);
		return pkg + "." + spec.name;		
	}

}
