package smef.ast;

import static java.util.Collections.unmodifiableList;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class MessageDef extends FieldListDef {

	public final String name;
	public final List<TypeRef> traits;

	protected MessageDef(String name, List<TypeRef> traits, List<FieldDef> fields) {
		super(fields);
		this.name = name;
		this.traits = unmodifiableList(traits);
	}
	
	abstract protected void accept(VConsumer consumer) throws Exception;
	
	abstract protected <R> R accept(VFunction<R> function) throws Exception;
	
	protected <P> void accept(VBiConsumer<P> consumer, P param) throws Exception {
		accept(new VConsumer() {
			@Override
			public void accept(SimpleMessageDef def) throws Exception {
				consumer.accept(def, param);
			}
			
			@Override
			public void accept(UnionMessageDef def) throws Exception {
				consumer.accept(def, param);
			}
			
			@Override
			public void accept(TraitDef def) throws Exception {
				consumer.accept(def, param);
			}
		});
	}
	
	public interface VConsumer extends Consumer<MessageDef> {
		
		@Override
		default void accept(MessageDef def) {
			try {
				def.accept(this);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		void accept(SimpleMessageDef def) throws Exception;
		void accept(UnionMessageDef def) throws Exception;
		void accept(TraitDef def) throws Exception;
	}
	
	public interface VFunction<R> extends Function<MessageDef, R> {
		
		@Override
		default R apply(MessageDef def) {
			try {
				return def.accept(this);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		R apply(SimpleMessageDef def);
		R apply(UnionMessageDef def);
		R apply(TraitDef def);
	}
		
	public interface VBiConsumer<P> extends BiConsumer<MessageDef, P> {
		
		@Override
		default void accept(MessageDef def, P param) {
			try {
				def.accept(this, param);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		void accept(SimpleMessageDef def, P param) throws Exception;
		void accept(UnionMessageDef def, P param) throws Exception;
		void accept(TraitDef def, P param) throws Exception;

	}
}
