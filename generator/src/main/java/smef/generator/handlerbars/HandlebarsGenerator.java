package smef.generator.handlerbars;

import java.io.IOException;
import java.io.Writer;

import smef.ast.SmefUnit;
import smef.generator.SmefDialect;
import smef.generator.SmefGenerator;
import smef.generator.SmefMessageWriter;
import smef.generator.SmefMessageWriterFactory;

public class HandlebarsGenerator implements SmefGenerator {

	private SmefMessageWriterFactory factory;

	public HandlebarsGenerator(SmefDialect dialect) throws IOException {
		factory = HandlebarsMessageWriterFactory.create(dialect);
	}

	@Override
	public void generate(SmefUnit unit, Writer writer) {
		SmefMessageWriter messageWriter = factory.create(unit.domain, writer);
		messageWriter.accept(unit.def);
	}

}
