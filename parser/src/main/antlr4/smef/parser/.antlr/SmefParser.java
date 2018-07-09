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
public class SmefParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MessageName=1, SNAME=2, QNAME=3, DOMAIN=4, INCLUDE=5, MESSAGE=6, TRAIT=7, 
		UNION_BEGIN=8, UNION_END=9, DOT=10, QUALIFIER=11, WS=12;
	public static final int
		RULE_smefFile = 0, RULE_domainDecl = 1, RULE_def = 2, RULE_traitDef = 3, 
		RULE_simpleDef = 4, RULE_unionDef = 5, RULE_messageContent = 6, RULE_fieldDef = 7, 
		RULE_typeRef = 8, RULE_include = 9;
	public static final String[] ruleNames = {
		"smefFile", "domainDecl", "def", "traitDef", "simpleDef", "unionDef", 
		"messageContent", "fieldDef", "typeRef", "include"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'#domain'", "'#include'", "'#message'", "'#trait'", 
		"'#union'", "'/union'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "MessageName", "SNAME", "QNAME", "DOMAIN", "INCLUDE", "MESSAGE", 
		"TRAIT", "UNION_BEGIN", "UNION_END", "DOT", "QUALIFIER", "WS"
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

	public SmefParser(TokenStream input) {
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
			setState(20);
			domainDecl();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MESSAGE) | (1L << TRAIT) | (1L << UNION_BEGIN))) != 0)) {
				{
				{
				setState(21);
				((SmefFileContext)_localctx).defs = def();
				}
				}
				setState(26);
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
		public TerminalNode DOMAIN() { return getToken(SmefParser.DOMAIN, 0); }
		public TerminalNode SNAME() { return getToken(SmefParser.SNAME, 0); }
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
			setState(27);
			match(DOMAIN);
			setState(28);
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
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MESSAGE:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				simpleDef();
				}
				break;
			case UNION_BEGIN:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				unionDef();
				}
				break;
			case TRAIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				traitDef();
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

	public static class TraitDefContext extends ParserRuleContext {
		public TerminalNode TRAIT() { return getToken(SmefParser.TRAIT, 0); }
		public TerminalNode MessageName() { return getToken(SmefParser.MessageName, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(TRAIT);
			setState(36);
			match(MessageName);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SNAME || _la==INCLUDE) {
				{
				{
				setState(37);
				messageContent();
				}
				}
				setState(42);
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

	public static class SimpleDefContext extends ParserRuleContext {
		public TerminalNode MESSAGE() { return getToken(SmefParser.MESSAGE, 0); }
		public TerminalNode MessageName() { return getToken(SmefParser.MessageName, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(MESSAGE);
			setState(44);
			match(MessageName);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SNAME || _la==INCLUDE) {
				{
				{
				setState(45);
				messageContent();
				}
				}
				setState(50);
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

	public static class UnionDefContext extends ParserRuleContext {
		public TerminalNode UNION_BEGIN() { return getToken(SmefParser.UNION_BEGIN, 0); }
		public TerminalNode MessageName() { return getToken(SmefParser.MessageName, 0); }
		public TerminalNode UNION_END() { return getToken(SmefParser.UNION_END, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(UNION_BEGIN);
			setState(52);
			match(MessageName);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SNAME || _la==INCLUDE) {
				{
				{
				setState(53);
				messageContent();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(59);
				simpleDef();
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MESSAGE );
			setState(64);
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
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				fieldDef();
				}
				break;
			case INCLUDE:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
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
		public TerminalNode SNAME() { return getToken(SmefParser.SNAME, 0); }
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public TerminalNode QUALIFIER() { return getToken(SmefParser.QUALIFIER, 0); }
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
			setState(70);
			match(SNAME);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUALIFIER) {
				{
				setState(71);
				match(QUALIFIER);
				}
			}

			setState(74);
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
		public TerminalNode SNAME() { return getToken(SmefParser.SNAME, 0); }
		public TerminalNode MessageName() { return getToken(SmefParser.MessageName, 0); }
		public TerminalNode QNAME() { return getToken(SmefParser.QNAME, 0); }
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
			setState(76);
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
		public TerminalNode INCLUDE() { return getToken(SmefParser.INCLUDE, 0); }
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
			setState(78);
			match(INCLUDE);
			setState(79);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16T\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\3\3\3\3\3\3\4\3\4\3\4\5\4$\n\4\3"+
		"\5\3\5\3\5\7\5)\n\5\f\5\16\5,\13\5\3\6\3\6\3\6\7\6\61\n\6\f\6\16\6\64"+
		"\13\6\3\7\3\7\3\7\7\79\n\7\f\7\16\7<\13\7\3\7\6\7?\n\7\r\7\16\7@\3\7\3"+
		"\7\3\b\3\b\5\bG\n\b\3\t\3\t\5\tK\n\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\3\3\2\3\5\2R\2\26\3\2\2\2\4\35\3\2"+
		"\2\2\6#\3\2\2\2\b%\3\2\2\2\n-\3\2\2\2\f\65\3\2\2\2\16F\3\2\2\2\20H\3\2"+
		"\2\2\22N\3\2\2\2\24P\3\2\2\2\26\32\5\4\3\2\27\31\5\6\4\2\30\27\3\2\2\2"+
		"\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\3\3\2\2\2\34\32\3\2\2\2"+
		"\35\36\7\6\2\2\36\37\7\4\2\2\37\5\3\2\2\2 $\5\n\6\2!$\5\f\7\2\"$\5\b\5"+
		"\2# \3\2\2\2#!\3\2\2\2#\"\3\2\2\2$\7\3\2\2\2%&\7\t\2\2&*\7\3\2\2\')\5"+
		"\16\b\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\t\3\2\2\2,*\3\2\2\2"+
		"-.\7\b\2\2.\62\7\3\2\2/\61\5\16\b\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3"+
		"\2\2\2\62\63\3\2\2\2\63\13\3\2\2\2\64\62\3\2\2\2\65\66\7\n\2\2\66:\7\3"+
		"\2\2\679\5\16\b\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;>\3\2\2\2"+
		"<:\3\2\2\2=?\5\n\6\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2"+
		"BC\7\13\2\2C\r\3\2\2\2DG\5\20\t\2EG\5\24\13\2FD\3\2\2\2FE\3\2\2\2G\17"+
		"\3\2\2\2HJ\7\4\2\2IK\7\r\2\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\5\22\n\2"+
		"M\21\3\2\2\2NO\t\2\2\2O\23\3\2\2\2PQ\7\7\2\2QR\5\22\n\2R\25\3\2\2\2\n"+
		"\32#*\62:@FJ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}