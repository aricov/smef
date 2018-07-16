package smef.ast;

import java.util.Objects;

public class TypeRef {

	public final String domain;
	public final String name;
	
	public TypeRef(String domain, String name) {
		Objects.requireNonNull(name, "domain cann not be null");	
		this.domain = domain != null ? domain : "";
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( obj == null ) return false;
		
		if ( !(obj instanceof TypeRef) ) return false;
		
		TypeRef that = (TypeRef) obj;
		
		return this.domain.equals(that.domain) && this.name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return domain.hashCode() * 13 + name.hashCode();
	}
	
	public String toString() {
		return String.format("%s.%s", domain, name);
	}
}
