package smef.ast;

import static java.util.Arrays.copyOf;
import static smef.ast.Quantifier.ONE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Smef {

	private Smef() {
	}
	
	public static SmefFile domain(String name, MessageDef... messages) {
		return new SmefFile(name, Arrays.asList(messages));
	}

	public static SimpleMessageDef simple(String name, TraitRefs traits, FieldDef... fields) {
		return new SimpleMessageDef(name, traits, Arrays.asList(fields));
	}

	public static SimpleMessageDef simple(String name, FieldDef... fields) {
		return new SimpleMessageDef(name, TraitRefs.EMPTY, Arrays.asList(fields));
	}

	public static FieldDef field(String name, String type) {
		return new FieldDef(name, ONE, parseRef(type));
	}

	public static FieldDef field(String name, Quantifier q, String type) {
		return new FieldDef(name, q, parseRef(type));
	}
	
	public static TypeRef parseRef(String qname) {
		String[] parts = qname.split("\\.");
		int L = parts.length;
		switch ( L ) {
		case 0: throw new IllegalArgumentException("Empty type ref");
		case 1: return new TypeRef("", parts[0]);
		default: //at least 2
			String type = parts[L - 1];
			String domain = String.join(".", copyOf(parts, L -1));
			return new TypeRef(domain, type);
		}
	}
	
	
	
	public static final FieldDefs fields(FieldDef...fields) {
		return new FieldDefs(fields);
	}
	
	public static TraitDef trait(String name, TraitRefs traits, FieldDef... fields) {
		return new TraitDef(name, traits, Arrays.asList(fields));
	}

	public static TraitDef trait(String name, FieldDef... fields) {
		return trait(name, TraitRefs.EMPTY, fields);
	}
	
	public static UnionMessageDef union(String name, TraitRefs traits, FieldDefs commonFields, SimpleMessageDef... members) {
		return new UnionMessageDef(name, traits, commonFields, Arrays.asList(members));
	}
	
	public static UnionMessageDef union(String name, TraitRefs commonTraits, SimpleMessageDef... members) {
		return union(name, commonTraits, FieldDefs.EMPTY, members);
	}

	public static UnionMessageDef union(String name, FieldDefs commonFields, SimpleMessageDef... members) {
		return union(name, TraitRefs.EMPTY, commonFields, members);
	}

	public static UnionMessageDef union(String name, SimpleMessageDef... members) {
		return union(name, TraitRefs.EMPTY, FieldDefs.EMPTY, members);
	}
	
	public static SimpleMessageDef member(String name, TraitRefs traits, FieldDef... fields) {
		return new SimpleMessageDef(name, traits, Arrays.asList(fields));
	}

	public static SimpleMessageDef member(String name, FieldDef... fields) {
		return new SimpleMessageDef(name, Collections.emptyList(), Arrays.asList(fields));
	}

	
	public static TraitRefs is(TypeRef...traits) {
		return new TraitRefs(traits);
	}
	
	public static TypeRef a(String domain, String name) {
		return new TypeRef(domain, name);
	}
	
	
	@SuppressWarnings("serial")
	public static class FieldDefs extends ArrayList<FieldDef> {

		private static final FieldDefs EMPTY = new FieldDefs();
		
		private FieldDefs(FieldDef...defs) {
			super(defs.length);
			Arrays.stream(defs).forEach(this::add);
		}
		
	}
	
	@SuppressWarnings("serial")
	public static class TraitRefs extends ArrayList<TypeRef> {
		
		private static final TraitRefs EMPTY = new TraitRefs();
		
		private TraitRefs(TypeRef...refs) {
			super(refs.length);
			Arrays.stream(refs).forEach(this::add);
		}
		
	}
	
}
