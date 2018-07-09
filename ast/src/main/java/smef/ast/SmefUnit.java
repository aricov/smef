package smef.ast;

public class SmefUnit {

	public final String domain;
	public final MessageDef def;

	public SmefUnit(String domain, MessageDef def) {
		this.domain = domain;
		this.def = def;
	}

}
