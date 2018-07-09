package smef.generator;

import java.io.Writer;

import smef.ast.MessageDef;

public interface SmefMessageWriter extends MessageDef.VConsumer {
	
	String domain();
	
	Writer writer();
	
}
