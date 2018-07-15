package smef.ast;

import static java.util.Collections.unmodifiableList;

import java.util.List;

public class UnionMessageDef extends MessageDef {

	public final List<SimpleMessageDef> members;

	public UnionMessageDef(String name, List<String> comments, List<TypeRef> traits, List<FieldDef> fields, List<SimpleMessageDef> cases) {
		super(name, comments, traits, fields);
		this.members = unmodifiableList(cases);
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
