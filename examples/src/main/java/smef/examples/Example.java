package smef.examples;

import static smef.ast.Smef.a;
import static smef.ast.Smef.domain;
import static smef.ast.Smef.field;
import static smef.ast.Smef.fields;
import static smef.ast.Smef.is;
import static smef.ast.Smef.member;
import static smef.ast.Smef.simple;
import static smef.ast.Smef.trait;
import static smef.ast.Smef.union;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import smef.ast.MessageDef;
import smef.ast.SmefFile;
import smef.generator.SmefDialect;
import smef.generator.SmefMessageWriter;
import smef.generator.SmefMessageWriterFactory;
import smef.generator.handlerbars.HandlebarsMessageWriterFactory;
import smef.generator.java.SmefJavaDialect;

public class Example {

	public static SmefFile common = 
		domain("common",
			trait("Identified", 
				field("uuid", "uuid")
			),
			trait("Owned", 
				field("user", "string")
			)
		);
		
	public static SmefFile todo = 
		domain("todo",
			union("Command", 
				fields(
					field("uuid", "uuid"),
					field("user", "string")
				),
				member("Add", 
					field("text", "string")
				),
				member("Edit",
					field("text", "string")
				),
				member("Cancel"),
				member("Complete")
			),
			
			union("Event", 
				is( 
					a("Common", "Identified"), 
					a("Common", "Owned") 
				),
				fields(
					field("uuid", "uuid"),
					field("user", "string")
				),
				member("Added", 
						field("text", "string")
					),
				member("Edited",
					field("text", "string")
				),
				member("Cancelled"),
				member("Completed")
			),
			
			simple("State",
				field("uuid", "uuid"),
				field("user", "string"),
				field("cancelled", "boolean"),
				field("completed", "boolean")
			)
		);
	
	public static void main(String...args) throws IOException {
		Map<String, String> mappings = new HashMap<>();
		mappings.put("common", "smef.examples.common");
		mappings.put("todo", "smef.examples.todo");
		
		SmefDialect javaDialect = new SmefJavaDialect(mappings);
		
		SmefMessageWriterFactory writerFactory = HandlebarsMessageWriterFactory.create(javaDialect );
		
		try (PrintWriter out = new PrintWriter(System.out) ) {			
			SmefMessageWriter writer = writerFactory.create(todo.domain, out);
			
			for ( MessageDef def : todo.messages) {
				writer.accept(def);
				out.println();
				out.println("===========================================");
			}
			
			out.println();
			out.println("******************************************");
			out.println();
			
			writer = writerFactory.create(common.domain, out);
			for ( MessageDef def : todo.messages) {
				writer.accept(def);
				out.println();
				out.println("===========================================");
			}
			
		}
				
	}

}
