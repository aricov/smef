package smef.ast;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class SmefFile {

	public final String domain;
	
	public final List<MessageDef> messages;

	public SmefFile(String name, List<MessageDef> messages) {
		this.domain = name;
		this.messages = Collections.unmodifiableList(messages);
	}
	
	public Stream<SmefUnit> units() {
		return messages.stream().map(def -> new SmefUnit(domain, def));
	}
	
}
