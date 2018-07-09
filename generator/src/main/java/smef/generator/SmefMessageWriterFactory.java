package smef.generator;

import java.io.Writer;

public interface SmefMessageWriterFactory {

	SmefMessageWriter create(String domain, Writer writer);
	
}
