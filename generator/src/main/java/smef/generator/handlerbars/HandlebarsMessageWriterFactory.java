package smef.generator.handlerbars;

import java.io.IOException;
import java.io.Writer;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.helper.ConditionalHelpers;
import com.github.jknack.handlebars.helper.StringHelpers;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import smef.generator.SmefDialect;
import smef.generator.SmefMessageWriterFactory;
import smef.generator.helpers.DomainMappingHelper;
import smef.generator.helpers.TypeMappingHelper;

public class HandlebarsMessageWriterFactory implements SmefMessageWriterFactory {

	private final Template union;
	private final Template simple;
	private final Template trait;

	public HandlebarsMessageWriterFactory(Template union, Template simple, Template trait) {
		this.union = union;
		this.simple = simple;
		this.trait = trait;
	}

	@Override
	public HandlerbarsMessageWriter create(String domain, Writer writer) {
		return new HandlerbarsMessageWriter(union, simple, trait, domain, writer);
	}

	public static SmefMessageWriterFactory create(SmefDialect dialect) throws IOException {
		TemplateLoader loader = new ClassPathTemplateLoader("/smef/templates/" + dialect.name());
		
		Handlebars handlebars = new Handlebars(loader);
		
		for ( ConditionalHelpers helper: ConditionalHelpers.values() ) {
			handlebars.registerHelper(helper.name(), helper);
		};

		for ( StringHelpers helper: StringHelpers.values() ) {
			handlebars.registerHelper(helper.name(), helper);
		};
		
		DomainMappingHelper.register(handlebars, dialect.getDomainMappings());
		TypeMappingHelper.register(handlebars, dialect.getTypeMapper());
		
		handlebars.prettyPrint(true);
		
		Template trait = handlebars.compile("trait");
		Template simple = handlebars.compile("simple");
		Template union = handlebars.compile("union");
		
		return new HandlebarsMessageWriterFactory(union, simple, trait);
		
	}
}
