// Generated from language.g4 by ANTLR 4.7.2
package antlrcompiler;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class languageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LESS=1, GREATER=2, EQUAL=3, NUMBER=4, PLUS=5, MINUS=6, BITAND=7, BITOR=8, 
		QUESTIONMARK=9, DOUBLECOLON=10, MUL=11, DIV=12, AND=13, OR=14, SHIFTLEFT=15, 
		SHIFTRIGHT=16, WS=17, LPAREN=18, RPAREN=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LESS", "GREATER", "EQUAL", "NUMBER", "PLUS", "MINUS", "BITAND", "BITOR", 
			"QUESTIONMARK", "DOUBLECOLON", "MUL", "DIV", "AND", "OR", "SHIFTLEFT", 
			"SHIFTRIGHT", "WS", "LPAREN", "RPAREN"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<'", "'>'", "'=='", null, "'+'", "'-'", "'&'", "'|'", "'?'", 
			"':'", "'*'", "'/'", "'&&'", "'||'", "'<<'", "'>>'", null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LESS", "GREATER", "EQUAL", "NUMBER", "PLUS", "MINUS", "BITAND", 
			"BITOR", "QUESTIONMARK", "DOUBLECOLON", "MUL", "DIV", "AND", "OR", "SHIFTLEFT", 
			"SHIFTRIGHT", "WS", "LPAREN", "RPAREN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public languageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "language.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\\\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\6\5\62\n\5\r\5\16"+
		"\5\63\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\6"+
		"\22S\n\22\r\22\16\22T\3\22\3\22\3\23\3\23\3\24\3\24\2\2\25\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25\3\2\4\3\2\62;\5\2\13\f\17\17\"\"\2]\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\3)\3\2\2\2\5+\3\2\2\2\7-\3\2\2\2\t\61\3\2\2\2\13\65\3\2\2\2\r\67"+
		"\3\2\2\2\179\3\2\2\2\21;\3\2\2\2\23=\3\2\2\2\25?\3\2\2\2\27A\3\2\2\2\31"+
		"C\3\2\2\2\33E\3\2\2\2\35H\3\2\2\2\37K\3\2\2\2!N\3\2\2\2#R\3\2\2\2%X\3"+
		"\2\2\2\'Z\3\2\2\2)*\7>\2\2*\4\3\2\2\2+,\7@\2\2,\6\3\2\2\2-.\7?\2\2./\7"+
		"?\2\2/\b\3\2\2\2\60\62\t\2\2\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2"+
		"\2\63\64\3\2\2\2\64\n\3\2\2\2\65\66\7-\2\2\66\f\3\2\2\2\678\7/\2\28\16"+
		"\3\2\2\29:\7(\2\2:\20\3\2\2\2;<\7~\2\2<\22\3\2\2\2=>\7A\2\2>\24\3\2\2"+
		"\2?@\7<\2\2@\26\3\2\2\2AB\7,\2\2B\30\3\2\2\2CD\7\61\2\2D\32\3\2\2\2EF"+
		"\7(\2\2FG\7(\2\2G\34\3\2\2\2HI\7~\2\2IJ\7~\2\2J\36\3\2\2\2KL\7>\2\2LM"+
		"\7>\2\2M \3\2\2\2NO\7@\2\2OP\7@\2\2P\"\3\2\2\2QS\t\3\2\2RQ\3\2\2\2ST\3"+
		"\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\b\22\2\2W$\3\2\2\2XY\7*\2\2Y&\3"+
		"\2\2\2Z[\7+\2\2[(\3\2\2\2\5\2\63T\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}