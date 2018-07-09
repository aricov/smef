package smef.generator;

import java.io.Writer;

import smef.ast.SmefUnit;

public interface SmefGenerator {

	void generate(SmefUnit smef, Writer writer);

}
