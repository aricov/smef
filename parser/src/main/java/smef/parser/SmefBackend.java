package smef.parser;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenSource;

import smef.ast.SmefFile;
import smef.parser.SmefParser.SmefFileContext;

public class SmefBackend {

	public SmefFile parse(InputStream stream) throws IOException {
		CharStream code = CharStreams.fromStream(stream);
		TokenSource source = new SmefLexer(code);
		CommonTokenStream tokens = new CommonTokenStream(source);
		SmefParser parser = new SmefParser(tokens);
		SmefFileContext smefFile = parser.smefFile();
		SmefInterpreter interpreter = new SmefInterpreter();
		return interpreter.visitSmefFile(smefFile);
	}
	
}
