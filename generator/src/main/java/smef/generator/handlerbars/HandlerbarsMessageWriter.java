package smef.generator.handlerbars;

import java.io.IOException;
import java.io.Writer;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.context.FieldValueResolver;
import com.github.jknack.handlebars.context.MapValueResolver;
import com.github.jknack.handlebars.context.MethodValueResolver;

import smef.ast.MessageDef;
import smef.ast.SimpleMessageDef;
import smef.ast.TraitDef;
import smef.ast.UnionMessageDef;
import smef.generator.SmefMessageWriter;

public class HandlerbarsMessageWriter implements SmefMessageWriter {
	
	private final Template union;
	private final Template simple;
	private final Template trait;
	
	private final String domain;
	private final Writer writer;

	public HandlerbarsMessageWriter(Template union, Template simple, Template trait, String domain, Writer writer) {
		this.union = union;
		this.simple = simple;
		this.trait = trait;
		this.domain = domain;
		this.writer = writer;
	}
	
	@Override
	public String domain() {
		return domain;
	}
	
	@Override
	public Writer writer() {
		return writer;
	}

	@Override
	public void accept(TraitDef def) throws IOException {
		trait.apply(context(def), writer);
	}
	
	@Override
	public void accept(UnionMessageDef def) throws IOException {
		union.apply(context(def), writer);
	}
	
	@Override
	public void accept(SimpleMessageDef def) throws IOException {
		simple.apply(context(def), writer);
	}

	private Context context(MessageDef def) {
		return Context
				.newBuilder(def)
				.combine("domain", domain)
				.resolver(
						FieldValueResolver.INSTANCE,
						MapValueResolver.INSTANCE,
						MethodValueResolver.INSTANCE
						)
				.build();	
	}
}
