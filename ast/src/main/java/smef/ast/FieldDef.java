package smef.ast;

import java.util.Collections;
import java.util.List;

public class FieldDef {

	public final String name;
	
	public final TypeRef type;
	
	public final Quantifier quantifier;
	
	public final TypeSpec typeSpec;
	
	public final List<String> comments;
	
	public FieldDef(String name, Quantifier quantifier, TypeRef type) {
		this(name, quantifier, type, Collections.emptyList());
	}

	public FieldDef(String name, Quantifier quantifier, TypeRef type, List<String> comments) {
		this.name = name;
		this.type = type;
		this.quantifier = quantifier != null ? quantifier : Quantifier.ONE;	
		this.typeSpec = new TypeSpec(this.quantifier, type.domain, type.name);
		this.comments = comments;
	}
	
	
	
}
