package smef.ast;

import java.util.List;

public class TraitDef extends MessageDef {

	public TraitDef(String name, List<String> comments, List<TypeRef> traits, List<FieldDef> fields) {
		super(name, comments, traits, fields);
	}
	
	@Override
	protected void accept(VConsumer consumer) throws Exception {
		consumer.accept(this);
	}
	
	@Override
	protected <R> R accept(VFunction<R> function) throws Exception {
		return function.apply(this);
	}

}
