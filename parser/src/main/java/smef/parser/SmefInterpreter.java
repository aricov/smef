package smef.parser;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Objects;

import org.antlr.v4.runtime.tree.TerminalNode;

import smef.ast.FieldDef;
import smef.ast.MessageDef;
import smef.ast.Quantifier;
import smef.ast.SimpleMessageDef;
import smef.ast.Smef;
import smef.ast.SmefFile;
import smef.ast.TraitDef;
import smef.ast.TypeRef;
import smef.ast.UnionMessageDef;
import smef.parser.SmefParser.CommentLineContext;
import smef.parser.SmefParser.DefContext;
import smef.parser.SmefParser.DomainDeclContext;
import smef.parser.SmefParser.FieldDefContext;
import smef.parser.SmefParser.IncludeContext;
import smef.parser.SmefParser.MessageContentContext;
import smef.parser.SmefParser.SimpleDefContext;
import smef.parser.SmefParser.SmefFileContext;
import smef.parser.SmefParser.TraitDefContext;
import smef.parser.SmefParser.UnionDefContext;

public class SmefInterpreter extends SmefParserBaseVisitor<Object> {
	
	@Override
	public SmefFile visitSmefFile(SmefFileContext ctx) {
		String domainName = visitDomainDecl(ctx.domainDecl());
		List<MessageDef> messages = ctx.def().stream().map(def -> visitDef(def)).collect(toList());
		return new SmefFile(domainName, messages);
	}
	
	@Override
	public MessageDef visitDef(DefContext ctx) {
		if ( ctx.traitDef() != null ) {
			return visitTraitDef(ctx.traitDef());
		}
		
		if ( ctx.unionDef() != null ) {
			return visitUnionDef(ctx.unionDef());
		}
		
		if ( ctx.simpleDef() != null ) {
			return visitSimpleDef(ctx.simpleDef());
		}
		return null;
	}
	
	@Override
	public TraitDef visitTraitDef(TraitDefContext ctx) {
		String name = ctx.MessageName().getText();
		List<String> comments = readCommentList(ctx.commentLine() );
		List<TypeRef> traits = visitTraitRefs(ctx.messageContent());
		List<FieldDef> fields = visitFieldDefs(ctx.messageContent());
		return new TraitDef(name, comments, traits, fields);
	}
	
	private List<TypeRef> visitTraitRefs(List<MessageContentContext> ctx) {
		return ctx.stream()
			.map(mc -> mc.include())
			.filter(Objects::nonNull)
			.map(this::visitInclude)
			.collect(toList());
	}
	
	private List<FieldDef> visitFieldDefs(List<MessageContentContext> ctx) {
		return ctx.stream()
				.map(mc -> mc.fieldDef())
				.filter(Objects::nonNull)
				.map(this::visitFieldDef)
				.collect(toList());			
	}
	
	@Override
	public SimpleMessageDef visitSimpleDef(SimpleDefContext ctx) {
		String name = ctx.MessageName().getText();
		List<String> comments = readCommentList(ctx.commentLine() );
		List<TypeRef> traits = visitTraitRefs(ctx.messageContent());
		List<FieldDef> fields = visitFieldDefs(ctx.messageContent());
		return new SimpleMessageDef(name, comments, traits, fields);
	}
	
	
	@Override
	public UnionMessageDef visitUnionDef(UnionDefContext ctx) {
		String name = ctx.MessageName().getText();
		List<String> comments = readCommentList(ctx.commentLine() );
		
		List<TypeRef> traits = visitTraitRefs(ctx.messageContent());
		List<FieldDef> fields = visitFieldDefs(ctx.messageContent());
		List<SimpleMessageDef> members = ctx.simpleDef().stream()
			.map(this::visitSimpleDef)
			.collect(toList());
		return new UnionMessageDef(name, comments, traits, fields, members);
	}
	
	@Override
	public TypeRef visitInclude(IncludeContext ctx) {
		String ref = ctx.typeRef().getText();
		return Smef.parseRef(ref);
	}
	
	@Override
	public FieldDef visitFieldDef(FieldDefContext ctx) {
		String name = ctx.SNAME().getText();
		String type = ctx.typeRef().getText();
		String qunt = ctx.QUANTIFIER() != null ? ctx.QUANTIFIER().getText() : "";
		List<String> comments = readCommentList(ctx.commentLine());
		return new FieldDef(name, Quantifier.forSymbol(qunt), Smef.parseRef(type), comments);
	}
	
	@Override
	public String visitDomainDecl(DomainDeclContext ctx) {
		return ctx.SNAME().getText();
	}

	private List<String> readCommentList(List<CommentLineContext> commentLines) {
		return commentLines.stream()
			.map(CommentLineContext::COMMENT_TEXT)
			.filter(Objects::nonNull)
			.map(TerminalNode::getText)
			.map(String::trim)
			.collect(toList())
			;
	}

}
