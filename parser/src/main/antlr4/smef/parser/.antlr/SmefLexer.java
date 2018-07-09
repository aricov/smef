// Generated from c:\src\smef\parser\src\main\antlr4\smef\parser\Smef.g4 by ANTLR 4.7.1
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
		UNION_BEGIN=8, UNION_END=9, DOT=10, QUALIFIER=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"MessageName", "SNAME", "QNAME", "NAME_INSIDE", "DOMAIN", "INCLUDE", "MESSAGE", 
		"TRAIT", "UNION_BEGIN", "UNION_END", "DOT", "QUALIFIER", "WS"
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


	public SmefLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Smef.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16d\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\5\7\5)\n\5\f\5\16\5,\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\2\2\17\3\3\5\4\7\5\t"+
		"\2\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16\3\2\7\3\2C\\\3\2c|\7"+
		"\2&&\62;C\\aac|\4\2,,AA\5\2\13\f\17\17\"\"\2c\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2"+
		"\2\5 \3\2\2\2\7#\3\2\2\2\t*\3\2\2\2\13-\3\2\2\2\r\65\3\2\2\2\17>\3\2\2"+
		"\2\21G\3\2\2\2\23N\3\2\2\2\25U\3\2\2\2\27\\\3\2\2\2\31^\3\2\2\2\33`\3"+
		"\2\2\2\35\36\t\2\2\2\36\37\5\t\5\2\37\4\3\2\2\2 !\t\3\2\2!\"\5\t\5\2\""+
		"\6\3\2\2\2#$\5\5\3\2$%\5\27\f\2%&\5\3\2\2&\b\3\2\2\2\')\t\4\2\2(\'\3\2"+
		"\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\n\3\2\2\2,*\3\2\2\2-.\7%\2\2./\7f"+
		"\2\2/\60\7q\2\2\60\61\7o\2\2\61\62\7c\2\2\62\63\7k\2\2\63\64\7p\2\2\64"+
		"\f\3\2\2\2\65\66\7%\2\2\66\67\7k\2\2\678\7p\2\289\7e\2\29:\7n\2\2:;\7"+
		"w\2\2;<\7f\2\2<=\7g\2\2=\16\3\2\2\2>?\7%\2\2?@\7o\2\2@A\7g\2\2AB\7u\2"+
		"\2BC\7u\2\2CD\7c\2\2DE\7i\2\2EF\7g\2\2F\20\3\2\2\2GH\7%\2\2HI\7v\2\2I"+
		"J\7t\2\2JK\7c\2\2KL\7k\2\2LM\7v\2\2M\22\3\2\2\2NO\7%\2\2OP\7w\2\2PQ\7"+
		"p\2\2QR\7k\2\2RS\7q\2\2ST\7p\2\2T\24\3\2\2\2UV\7\61\2\2VW\7w\2\2WX\7p"+
		"\2\2XY\7k\2\2YZ\7q\2\2Z[\7p\2\2[\26\3\2\2\2\\]\7\60\2\2]\30\3\2\2\2^_"+
		"\t\5\2\2_\32\3\2\2\2`a\t\6\2\2ab\3\2\2\2bc\b\16\2\2c\34\3\2\2\2\4\2*\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}