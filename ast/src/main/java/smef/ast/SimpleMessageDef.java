package smef.ast;

import java.util.List;

public class SimpleMessageDef extends MessageDef {

	public SimpleMessageDef(String name, List<String> comment, List<TypeRef> traits, List<FieldDef> fields) {
		super(name, comment, traits, fields);
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
