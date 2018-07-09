package smef.ast;

public enum Quantifier {

	ONE(""),
	OPT("?"),
	MANY("*");
	
	private final String symbol;
	
	Quantifier(String symbol) {
		this.symbol = symbol;
	}
	
	public String symbol() {
		return symbol;
	}

	public static Quantifier forSymbol(String symbol) {
		switch ( symbol ) {
		case "*": return MANY;
		case "?": return OPT;
		default : return ONE;
		}
	}
	
}
