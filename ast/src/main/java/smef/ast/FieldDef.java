package smef.ast;

public class FieldDef {

	public final String name;
	
	public final TypeRef type;
	
	public final Quantifier quantifier;
	
	public FieldDef(String name, Quantifier quantifier, TypeRef type) {
		this.name = name;
		this.type = type;
		this.quantifier = quantifier;	
	}
	
}
