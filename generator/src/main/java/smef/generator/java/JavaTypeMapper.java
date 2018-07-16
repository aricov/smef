package smef.generator.java;

import static smef.ast.Quantifier.MANY;

import java.net.URI;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
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
		singleTypeMappings.put("date", LocalDate.class.getSimpleName());
		singleTypeMappings.put("datetime", OffsetDateTime.class.getSimpleName());
		singleTypeMappings.put("time", OffsetTime.class.getSimpleName());
		singleTypeMappings.put("uuid", UUID.class.getSimpleName());
		singleTypeMappings.put("uri", URI.class.getSimpleName());
		
		multiTypeMappings.put("boolean", Boolean.class.getSimpleName());
		multiTypeMappings.put("integer", Integer.class.getSimpleName());
		multiTypeMappings.put("decimal", Float.class.getSimpleName());
		multiTypeMappings.put("string", String.class.getSimpleName());
		multiTypeMappings.put("date", LocalDate.class.getSimpleName());
		multiTypeMappings.put("datetime", OffsetDateTime.class.getSimpleName());
		multiTypeMappings.put("time", OffsetTime.class.getSimpleName());
		multiTypeMappings.put("uuid", UUID.class.getSimpleName());
		multiTypeMappings.put("uri", URI.class.getSimpleName());
	}
	
	private JavaTypeMapper() {
	}

	public static JavaTypeMapper INSTANCE = new JavaTypeMapper();
	
	@Override
	public Optional<String> map(TypeSpec spec) {
		if ( spec == null ) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(
			spec.domain == null || spec.domain.isEmpty()
				? mapUnqualifiedType(spec)
				: spec.name
		);
	}
	
	private String mapUnqualifiedType(TypeSpec spec) {
		if ( spec.quantifier == MANY ) {
			return multiTypeMappings.get(spec.name);
		}
		
		return singleTypeMappings.get(spec.name);
	}
}
