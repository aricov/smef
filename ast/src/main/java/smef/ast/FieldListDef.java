package smef.ast;

import java.util.Collections;
import java.util.List;

public abstract class FieldListDef {

	public final List<FieldDef> fields;
	
	protected FieldListDef(List<FieldDef> fields) {
		this.fields = Collections.unmodifiableList(fields);
	}
}
