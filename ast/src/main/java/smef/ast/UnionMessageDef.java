package smef.ast;

import static java.util.Collections.unmodifiableList;

import java.util.List;
import java.util.stream.Stream;

public class UnionMessageDef extends MessageDef {

	public final List<SimpleMessageDef> members;

	public UnionMessageDef(String name, List<String> comments, List<TypeRef> traits, List<FieldDef> fields, List<SimpleMessageDef> cases) {
		super(name, comments, traits, fields);
		this.members = unmodifiableList(cases);
	}
	
	@Override
	Stream<TypeRef> refStream() {
		return Stream.concat(
				super.refStream(),
				members.stream().flatMap(SimpleMessageDef::refStream)
		);
	}
	
	@Override
	public boolean hasMany() {
		return super.hasMany() || members.stream().anyMatch(SimpleMessageDef::hasMany);
	}

	@Override
	public boolean hasOpt() {
		return super.hasOpt() || members.stream().anyMatch(SimpleMessageDef::hasOpt);
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
