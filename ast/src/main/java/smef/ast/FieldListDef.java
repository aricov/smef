package smef.ast;

import static java.util.function.Predicate.isEqual;
import static smef.ast.BuiltinTypeRef.DATE;
import static smef.ast.BuiltinTypeRef.DATETIME;
import static smef.ast.BuiltinTypeRef.TIME;
import static smef.ast.BuiltinTypeRef.URI;
import static smef.ast.BuiltinTypeRef.UUID;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class FieldListDef {

	public final List<FieldDef> fields;
	
	protected FieldListDef(List<FieldDef> fields) {
		this.fields = Collections.unmodifiableList(fields);
	}
	
	Stream<TypeRef> refStream() {
		return fields.stream().map(field -> field.type);
	}
	
	public Set<TypeRef> refs() {
		return refStream()
				.sorted(
						(left, right) -> left.toString().compareTo(right.toString()) 
				).collect(Collectors.toCollection(LinkedHashSet::new));
	}
	
	public boolean hasMany() {
		return fields.stream().anyMatch(field -> field.quantifier == Quantifier.MANY);
	}
	
	public boolean hasOpt() {
		return fields.stream().anyMatch(field -> field.quantifier == Quantifier.OPT);
	}
	
	public boolean hasDate() {
		return refStream().anyMatch(isEqual(DATE));
	}
	
	public boolean hasDateTime() {
		return refStream().anyMatch(isEqual(DATETIME));
	}
	
	public boolean hasTime() {
		return refStream().anyMatch(isEqual(TIME));
	}
	
	public boolean hasUuid() {
		return refStream().anyMatch(isEqual(UUID));
	}
	
	public boolean hasUri() {
		return refStream().anyMatch(isEqual(URI));
	}
	
	
	
}
