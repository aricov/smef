package smef.ast;

public class BuiltinTypeRef extends TypeRef {

	private BuiltinTypeRef(String name) {
		super("", name);
	}

	public static final TypeRef BOOLEAN = new BuiltinTypeRef("boolean");
	
	public static final TypeRef INTEGER = new BuiltinTypeRef("integer");
	
	public static final TypeRef DECIMAL = new BuiltinTypeRef("decimal");
	
	public static final TypeRef STRING = new BuiltinTypeRef("string");	
	
	public static final TypeRef DATE = new BuiltinTypeRef("date");
	
	public static final TypeRef DATETIME = new BuiltinTypeRef("datetime");
	
	public static final TypeRef TIME = new BuiltinTypeRef("time");
	
	public static final TypeRef UUID = new BuiltinTypeRef("uuid");
	
	public static final TypeRef URI = new BuiltinTypeRef("uri");
	
}
