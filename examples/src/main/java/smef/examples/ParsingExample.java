package smef.examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import smef.ast.MessageDef;
import smef.ast.SmefFile;
import smef.generator.SmefDialect;
import smef.generator.SmefMessageWriter;
import smef.generator.SmefMessageWriterFactory;
import smef.generator.handlerbars.HandlebarsMessageWriterFactory;
import smef.generator.handlerbars.SmefJavaDialect;
import smef.parser.SmefBackend;

public class ParsingExample {

	public ParsingExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		SmefBackend smef = new SmefBackend();
		InputStream stream = ParsingExample.class.getResourceAsStream("/smef/examples/todo.smef");
		SmefFile smefFile = smef.parse(stream);

		Map<String, String> mappings = new HashMap<>();
		mappings.put("common", "smef.examples.common");
		mappings.put("todo", "smef.examples.todo");
		
		SmefDialect javaDialect = new SmefJavaDialect(mappings);
		
		SmefMessageWriterFactory writerFactory = HandlebarsMessageWriterFactory.create(javaDialect );
		
		try (PrintWriter out = new PrintWriter(System.out) ) {			
			SmefMessageWriter writer = writerFactory.create(smefFile.domain, out);
			for ( MessageDef def : smefFile.messages) {
				writer.accept(def);
				out.println();
				out.println("===========================================");
			}
		}
	}
	
}
