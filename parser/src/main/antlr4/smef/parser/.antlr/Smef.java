// Generated from c:\src\smef\parser\src\main\antlr4\smef\parser\Smef.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Smef extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MessageName=1, SNAME=2, QNAME=3, DOMAIN=4, INCLUDE=5, MESSAGE=6, TRAIT=7, 
		UNION_BEGIN=8, UNION_END=9, COMMENT_START=10, DOT=11, QUANTIFIER=12, WS=13, 
		COMMENT_END=14, COMMENT_TEXT=15;
	public static final int
		RULE_smefFile = 0, RULE_domainDecl = 1, RULE_def = 2, RULE_traitDef = 3, 
		RULE_simpleDef = 4, RULE_unionDef = 5, RULE_messageContent = 6, RULE_fieldDef = 7, 
		RULE_typeRef = 8, RULE_include = 9, RULE_commentLine = 10;
	public static final String[] ruleNames = {
		"smefFile", "domainDecl", "def", "traitDef", "simpleDef", "unionDef", 
		"messageContent", "fieldDef", "typeRef", "include", "commentLine"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'#domain'", "'#include'", "'#message'", "'#trait'", 
		"'#union'", "'/union'", "'##'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "MessageName", "SNAME", "QNAME", "DOMAIN", "INCLUDE", "MESSAGE", 
		"TRAIT", "UNION_BEGIN", "UNION_END", "COMMENT_START", "DOT", "QUANTIFIER", 
		"WS", "COMMENT_END", "COMMENT_TEXT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Smef.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Smef(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SmefFileContext extends ParserRuleContext {
		public DefContext defs;
		public DomainDeclContext domainDecl() {
			return getRuleContext(DomainDeclContext.class,0);
		}
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public SmefFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_smefFile; }
	}

	public final SmefFileContext smefFile() throws RecognitionException {
		SmefFileContext _localctx = new SmefFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_smefFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			domainDecl();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MESSAGE) | (1L << TRAIT) | (1L << UNION_BEGIN) | (1L << COMMENT_START))) != 0)) {
				{
				{
				setState(23);
				((SmefFileContext)_localctx).defs = def();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DomainDeclContext extends ParserRuleContext {
		public Token name;
		public TerminalNode DOMAIN() { return getToken(Smef.DOMAIN, 0); }
		public TerminalNode SNAME() { return getToken(Smef.SNAME, 0); }
		public DomainDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domainDecl; }
	}

	public final DomainDeclContext domainDecl() throws RecognitionException {
		DomainDeclContext _localctx = new DomainDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_domainDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(DOMAIN);
			setState(30);
			((DomainDeclContext)_localctx).name = match(SNAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefContext extends ParserRuleContext {
		public SimpleDefContext simpleDef() {
			return getRuleContext(SimpleDefContext.class,0);
		}
		public UnionDefContext unionDef() {
			return getRuleContext(UnionDefContext.class,0);
		}
		public TraitDefContext traitDef() {
			return getRuleContext(TraitDefContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_def);
		try {
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				simpleDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				unionDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				traitDef();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TraitDefContext extends ParserRuleContext {
		public TerminalNode TRAIT() { return getToken(Smef.TRAIT, 0); }
		public TerminalNode MessageName() { return getToken(Smef.MessageName, 0); }
		public List<CommentLineContext> commentLine() {
			return getRuleContexts(CommentLineContext.class);
		}
		public CommentLineContext commentLine(int i) {
			return getRuleContext(CommentLineContext.class,i);
		}
		public List<MessageContentContext> messageContent() {
			return getRuleContexts(MessageContentContext.class);
		}
		public MessageContentContext messageContent(int i) {
			return getRuleContext(MessageContentContext.class,i);
		}
		public TraitDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitDef; }
	}

	public final TraitDefContext traitDef() throws RecognitionException {
		TraitDefContext _localctx = new TraitDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_traitDef);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT_START) {
				{
				{
				setState(37);
				commentLine();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			match(TRAIT);
			setState(44);
			match(MessageName);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45);
					messageContent();
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleDefContext extends ParserRuleContext {
		public TerminalNode MESSAGE() { return getToken(Smef.MESSAGE, 0); }
		public TerminalNode MessageName() { return getToken(Smef.MessageName, 0); }
		public List<CommentLineContext> commentLine() {
			return getRuleContexts(CommentLineContext.class);
		}
		public CommentLineContext commentLine(int i) {
			return getRuleContext(CommentLineContext.class,i);
		}
		public List<MessageContentContext> messageContent() {
			return getRuleContexts(MessageContentContext.class);
		}
		public MessageContentContext messageContent(int i) {
			return getRuleContext(MessageContentContext.class,i);
		}
		public SimpleDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleDef; }
	}

	public final SimpleDefContext simpleDef() throws RecognitionException {
		SimpleDefContext _localctx = new SimpleDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_simpleDef);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT_START) {
				{
				{
				setState(51);
				commentLine();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(MESSAGE);
			setState(58);
			match(MessageName);
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(59);
					messageContent();
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionDefContext extends ParserRuleContext {
		public TerminalNode UNION_BEGIN() { return getToken(Smef.UNION_BEGIN, 0); }
		public TerminalNode MessageName() { return getToken(Smef.MessageName, 0); }
		public TerminalNode UNION_END() { return getToken(Smef.UNION_END, 0); }
		public List<CommentLineContext> commentLine() {
			return getRuleContexts(CommentLineContext.class);
		}
		public CommentLineContext commentLine(int i) {
			return getRuleContext(CommentLineContext.class,i);
		}
		public List<MessageContentContext> messageContent() {
			return getRuleContexts(MessageContentContext.class);
		}
		public MessageContentContext messageContent(int i) {
			return getRuleContext(MessageContentContext.class,i);
		}
		public List<SimpleDefContext> simpleDef() {
			return getRuleContexts(SimpleDefContext.class);
		}
		public SimpleDefContext simpleDef(int i) {
			return getRuleContext(SimpleDefContext.class,i);
		}
		public UnionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionDef; }
	}

	public final UnionDefContext unionDef() throws RecognitionException {
		UnionDefContext _localctx = new UnionDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unionDef);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT_START) {
				{
				{
				setState(65);
				commentLine();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(UNION_BEGIN);
			setState(72);
			match(MessageName);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(73);
					messageContent();
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				simpleDef();
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MESSAGE || _la==COMMENT_START );
			setState(84);
			match(UNION_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageContentContext extends ParserRuleContext {
		public FieldDefContext fieldDef() {
			return getRuleContext(FieldDefContext.class,0);
		}
		public IncludeContext include() {
			return getRuleContext(IncludeContext.class,0);
		}
		public MessageContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageContent; }
	}

	public final MessageContentContext messageContent() throws RecognitionException {
		MessageContentContext _localctx = new MessageContentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_messageContent);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SNAME:
			case COMMENT_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				fieldDef();
				}
				break;
			case INCLUDE:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				include();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDefContext extends ParserRuleContext {
		public TerminalNode SNAME() { return getToken(Smef.SNAME, 0); }
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public List<CommentLineContext> commentLine() {
			return getRuleContexts(CommentLineContext.class);
		}
		public CommentLineContext commentLine(int i) {
			return getRuleContext(CommentLineContext.class,i);
		}
		public TerminalNode QUANTIFIER() { return getToken(Smef.QUANTIFIER, 0); }
		public FieldDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDef; }
	}

	public final FieldDefContext fieldDef() throws RecognitionException {
		FieldDefContext _localctx = new FieldDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT_START) {
				{
				{
				setState(90);
				commentLine();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			match(SNAME);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUANTIFIER) {
				{
				setState(97);
				match(QUANTIFIER);
				}
			}

			setState(100);
			typeRef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeRefContext extends ParserRuleContext {
		public TerminalNode SNAME() { return getToken(Smef.SNAME, 0); }
		public TerminalNode MessageName() { return getToken(Smef.MessageName, 0); }
		public TerminalNode QNAME() { return getToken(Smef.QNAME, 0); }
		public TypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRef; }
	}

	public final TypeRefContext typeRef() throws RecognitionException {
		TypeRefContext _localctx = new TypeRefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MessageName) | (1L << SNAME) | (1L << QNAME))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludeContext extends ParserRuleContext {
		public TerminalNode INCLUDE() { return getToken(Smef.INCLUDE, 0); }
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(INCLUDE);
			setState(105);
			typeRef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentLineContext extends ParserRuleContext {
		public TerminalNode COMMENT_START() { return getToken(Smef.COMMENT_START, 0); }
		public TerminalNode COMMENT_END() { return getToken(Smef.COMMENT_END, 0); }
		public TerminalNode COMMENT_TEXT() { return getToken(Smef.COMMENT_TEXT, 0); }
		public CommentLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commentLine; }
	}

	public final CommentLineContext commentLine() throws RecognitionException {
		CommentLineContext _localctx = new CommentLineContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_commentLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(COMMENT_START);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_TEXT) {
				{
				setState(108);
				match(COMMENT_TEXT);
				}
			}

			setState(111);
			match(COMMENT_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21t\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\3\3\3\3\3\3\4\3\4\3\4\5\4"+
		"&\n\4\3\5\7\5)\n\5\f\5\16\5,\13\5\3\5\3\5\3\5\7\5\61\n\5\f\5\16\5\64\13"+
		"\5\3\6\7\6\67\n\6\f\6\16\6:\13\6\3\6\3\6\3\6\7\6?\n\6\f\6\16\6B\13\6\3"+
		"\7\7\7E\n\7\f\7\16\7H\13\7\3\7\3\7\3\7\7\7M\n\7\f\7\16\7P\13\7\3\7\6\7"+
		"S\n\7\r\7\16\7T\3\7\3\7\3\b\3\b\5\b[\n\b\3\t\7\t^\n\t\f\t\16\ta\13\t\3"+
		"\t\3\t\5\te\n\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\5\fp\n\f\3\f\3"+
		"\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\3\3\2\3\5\2v\2\30\3\2\2\2\4"+
		"\37\3\2\2\2\6%\3\2\2\2\b*\3\2\2\2\n8\3\2\2\2\fF\3\2\2\2\16Z\3\2\2\2\20"+
		"_\3\2\2\2\22h\3\2\2\2\24j\3\2\2\2\26m\3\2\2\2\30\34\5\4\3\2\31\33\5\6"+
		"\4\2\32\31\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\3\3\2"+
		"\2\2\36\34\3\2\2\2\37 \7\6\2\2 !\7\4\2\2!\5\3\2\2\2\"&\5\n\6\2#&\5\f\7"+
		"\2$&\5\b\5\2%\"\3\2\2\2%#\3\2\2\2%$\3\2\2\2&\7\3\2\2\2\')\5\26\f\2(\'"+
		"\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7\t\2\2."+
		"\62\7\3\2\2/\61\5\16\b\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63"+
		"\3\2\2\2\63\t\3\2\2\2\64\62\3\2\2\2\65\67\5\26\f\2\66\65\3\2\2\2\67:\3"+
		"\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\b\2\2<@\7\3\2\2="+
		"?\5\16\b\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\13\3\2\2\2B@\3\2\2"+
		"\2CE\5\26\f\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2"+
		"\2\2IJ\7\n\2\2JN\7\3\2\2KM\5\16\b\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3"+
		"\2\2\2OR\3\2\2\2PN\3\2\2\2QS\5\n\6\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3"+
		"\2\2\2UV\3\2\2\2VW\7\13\2\2W\r\3\2\2\2X[\5\20\t\2Y[\5\24\13\2ZX\3\2\2"+
		"\2ZY\3\2\2\2[\17\3\2\2\2\\^\5\26\f\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`"+
		"\3\2\2\2`b\3\2\2\2a_\3\2\2\2bd\7\4\2\2ce\7\16\2\2dc\3\2\2\2de\3\2\2\2"+
		"ef\3\2\2\2fg\5\22\n\2g\21\3\2\2\2hi\t\2\2\2i\23\3\2\2\2jk\7\7\2\2kl\5"+
		"\22\n\2l\25\3\2\2\2mo\7\f\2\2np\7\21\2\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2"+
		"qr\7\20\2\2r\27\3\2\2\2\17\34%*\628@FNTZ_do";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}