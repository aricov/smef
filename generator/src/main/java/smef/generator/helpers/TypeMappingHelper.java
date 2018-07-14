package smef.generator.helpers;

import java.io.IOException;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import smef.ast.TypeSpec;
import smef.generator.TypeMapper;

public class TypeMappingHelper implements Helper<TypeSpec> {

	public static final String NAME = "mapType";
	
	private final TypeMapper typeMapper;

	public TypeMappingHelper(TypeMapper typeMapper) {
		this.typeMapper = typeMapper;
	}

	@Override
	public CharSequence apply(TypeSpec typeSpec, Options options) throws IOException {
		return typeMapper.map(typeSpec)
			.orElseGet(() -> {
				//Output a default representation of the type *ref*
				String prefix = typeSpec.domain;
				return !prefix.isEmpty() ? prefix + "." + typeSpec.name : typeSpec.name;				
			});
	}
	
		
	public static Handlebars register(Handlebars handlebars, TypeMapper typeMapper) {
		return handlebars.registerHelper(NAME, new TypeMappingHelper(typeMapper));
	}


}
