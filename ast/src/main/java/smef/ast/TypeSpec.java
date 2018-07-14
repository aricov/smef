package smef.ast;

public class TypeSpec extends TypeRef {

	public final Quantifier quantifier;
	
	public TypeSpec(Quantifier quantifier, String domain, String name) {
		super(domain, name);
		this.quantifier = quantifier;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( obj == null ) return false;
		
		if ( !(obj instanceof TypeSpec) ) return false;
		
		TypeSpec other = (TypeSpec) obj;
		
		return super.equals(obj) && other.quantifier == this.quantifier;
	}

	@Override
	public int hashCode() {
		return super.hashCode() * 31 + quantifier.hashCode();
	}
}
