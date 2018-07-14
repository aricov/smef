// Generated from c:\src\smef\parser\src\main\antlr4\smef\parser\SmefLexer.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmefLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MessageName=1, SNAME=2, QNAME=3, DOMAIN=4, INCLUDE=5, MESSAGE=6, TRAIT=7, 
		UNION_BEGIN=8, UNION_END=9, COMMENT_START=10, DOT=11, QUANTIFIER=12, WS=13, 
		COMMENT_END=14, COMMENT_TEXT=15;
	public static final int
		COMMENT_LINE=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "COMMENT_LINE"
	};

	public static final String[] ruleNames = {
		"MessageName", "SNAME", "QNAME", "NAME_INSIDE", "DOMAIN", "INCLUDE", "MESSAGE", 
		"TRAIT", "UNION_BEGIN", "UNION_END", "COMMENT_START", "DOT", "QUANTIFIER", 
		"WS", "COMMENT_END", "CR", "LF", "COMMENT_TEXT"
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


	public SmefLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SmefLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u0084\b\1\b\1"+
		"\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
		"\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"+
		"\22\t\22\4\23\t\23\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\7\5\64"+
		"\n\5\f\5\16\5\67\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\20"+
		"\5\20v\n\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\6\23\u0081\n"+
		"\23\r\23\16\23\u0082\2\2\24\4\3\6\4\b\5\n\2\f\6\16\7\20\b\22\t\24\n\26"+
		"\13\30\f\32\r\34\16\36\17 \20\"\2$\2&\21\4\2\3\b\3\2C\\\3\2c|\7\2&&\62"+
		";C\\aac|\4\2,,AA\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0082\2\4\3\2\2\2"+
		"\2\6\3\2\2\2\2\b\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3"+
		"\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2"+
		"\2\2\36\3\2\2\2\3 \3\2\2\2\3&\3\2\2\2\4(\3\2\2\2\6+\3\2\2\2\b.\3\2\2\2"+
		"\n\65\3\2\2\2\f8\3\2\2\2\16@\3\2\2\2\20I\3\2\2\2\22R\3\2\2\2\24Y\3\2\2"+
		"\2\26`\3\2\2\2\30g\3\2\2\2\32l\3\2\2\2\34n\3\2\2\2\36p\3\2\2\2 u\3\2\2"+
		"\2\"{\3\2\2\2$}\3\2\2\2&\u0080\3\2\2\2()\t\2\2\2)*\5\n\5\2*\5\3\2\2\2"+
		"+,\t\3\2\2,-\5\n\5\2-\7\3\2\2\2./\5\6\3\2/\60\5\32\r\2\60\61\5\4\2\2\61"+
		"\t\3\2\2\2\62\64\t\4\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65"+
		"\66\3\2\2\2\66\13\3\2\2\2\67\65\3\2\2\289\7%\2\29:\7f\2\2:;\7q\2\2;<\7"+
		"o\2\2<=\7c\2\2=>\7k\2\2>?\7p\2\2?\r\3\2\2\2@A\7%\2\2AB\7k\2\2BC\7p\2\2"+
		"CD\7e\2\2DE\7n\2\2EF\7w\2\2FG\7f\2\2GH\7g\2\2H\17\3\2\2\2IJ\7%\2\2JK\7"+
		"o\2\2KL\7g\2\2LM\7u\2\2MN\7u\2\2NO\7c\2\2OP\7i\2\2PQ\7g\2\2Q\21\3\2\2"+
		"\2RS\7%\2\2ST\7v\2\2TU\7t\2\2UV\7c\2\2VW\7k\2\2WX\7v\2\2X\23\3\2\2\2Y"+
		"Z\7%\2\2Z[\7w\2\2[\\\7p\2\2\\]\7k\2\2]^\7q\2\2^_\7p\2\2_\25\3\2\2\2`a"+
		"\7\61\2\2ab\7w\2\2bc\7p\2\2cd\7k\2\2de\7q\2\2ef\7p\2\2f\27\3\2\2\2gh\7"+
		"%\2\2hi\7%\2\2ij\3\2\2\2jk\b\f\2\2k\31\3\2\2\2lm\7\60\2\2m\33\3\2\2\2"+
		"no\t\5\2\2o\35\3\2\2\2pq\t\6\2\2qr\3\2\2\2rs\b\17\3\2s\37\3\2\2\2tv\5"+
		"\"\21\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\5$\22\2xy\3\2\2\2yz\b\20\4\2z"+
		"!\3\2\2\2{|\7\17\2\2|#\3\2\2\2}~\7\f\2\2~%\3\2\2\2\177\u0081\n\7\2\2\u0080"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\'\3\2\2\2\7\2\3\65u\u0082\5\7\3\2\b\2\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}