package smef.generator.helpers;

import java.io.IOException;
import java.util.Map;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import smef.ast.TypeRef;

public class TypeMappingHelper implements Helper<TypeRef> {

	public static final String NAME = "mapType";
	
	private final Map<String, String> domainMappings;
	
	private final Map<String, String> typeMappings;

	public TypeMappingHelper(Map<String,String> domainMappings, Map<String, String> typeMappings) {
		this.domainMappings = domainMappings;
		this.typeMappings = typeMappings;
	}

	@Override
	public CharSequence apply(TypeRef typeRef, Options options) throws IOException {
		String key = mappingKey(typeRef);
		String value = typeMappings.get(key);
		if ( value != null ) {
			return value;
		}
		String prefix = null;
		if ( typeRef.domain != null && !typeRef.domain.isEmpty() ) {
			prefix = domainMappings.get(typeRef.domain);
		}
		
		return prefix != null ? prefix + "." + typeRef.name : key;
	}
	
	private String mappingKey(TypeRef typeRef) {
		if (typeRef.domain == null || typeRef.domain.isEmpty() ) {
			return typeRef.name;
		}
		return typeRef.domain + "." + typeRef.name;
	}
	
	public static Handlebars register(Handlebars handlebars, Map<String, String> packageMappings, Map<String, String> typeMappings) {
		return handlebars.registerHelper(NAME, new TypeMappingHelper(packageMappings, typeMappings));
	}


}
