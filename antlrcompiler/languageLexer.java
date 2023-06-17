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
		SUMOP=1, MULOP=2, LESS=3, GREATER=4, EQUAL=5, NUMBER=6, PLUS=7, MINUS=8, 
		BITAND=9, BITOR=10, QUESTIONMARK=11, DOUBLECOLON=12, MUL=13, DIV=14, AND=15, 
		OR=16, SHIFTLEFT=17, SHIFTRIGHT=18, WS=19, LPAREN=20, RPAREN=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SUMOP", "MULOP", "LESS", "GREATER", "EQUAL", "NUMBER", "PLUS", "MINUS", 
			"BITAND", "BITOR", "QUESTIONMARK", "DOUBLECOLON", "MUL", "DIV", "AND", 
			"OR", "SHIFTLEFT", "SHIFTRIGHT", "WS", "LPAREN", "RPAREN"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'<'", "'>'", "'=='", null, "'+'", "'-'", "'&'", "'|'", 
			"'?'", "':'", "'*'", "'/'", "'&&'", "'||'", "'<<'", "'>>'", null, "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SUMOP", "MULOP", "LESS", "GREATER", "EQUAL", "NUMBER", "PLUS", 
			"MINUS", "BITAND", "BITOR", "QUESTIONMARK", "DOUBLECOLON", "MUL", "DIV", 
			"AND", "OR", "SHIFTLEFT", "SHIFTRIGHT", "WS", "LPAREN", "RPAREN"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27h\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\5\2\60\n\2\3\3\3\3\5"+
		"\3\64\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\6\7>\n\7\r\7\16\7?\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\6\24_\n\24\r\24"+
		"\16\24`\3\24\3\24\3\25\3\25\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27\3\2\4\3\2\62;\5\2\13\f\17\17\"\"\2k\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\3/\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2"+
		"\139\3\2\2\2\r=\3\2\2\2\17A\3\2\2\2\21C\3\2\2\2\23E\3\2\2\2\25G\3\2\2"+
		"\2\27I\3\2\2\2\31K\3\2\2\2\33M\3\2\2\2\35O\3\2\2\2\37Q\3\2\2\2!T\3\2\2"+
		"\2#W\3\2\2\2%Z\3\2\2\2\'^\3\2\2\2)d\3\2\2\2+f\3\2\2\2-\60\5\17\b\2.\60"+
		"\5\21\t\2/-\3\2\2\2/.\3\2\2\2\60\4\3\2\2\2\61\64\5\33\16\2\62\64\5\35"+
		"\17\2\63\61\3\2\2\2\63\62\3\2\2\2\64\6\3\2\2\2\65\66\7>\2\2\66\b\3\2\2"+
		"\2\678\7@\2\28\n\3\2\2\29:\7?\2\2:;\7?\2\2;\f\3\2\2\2<>\t\2\2\2=<\3\2"+
		"\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\16\3\2\2\2AB\7-\2\2B\20\3\2\2\2CD"+
		"\7/\2\2D\22\3\2\2\2EF\7(\2\2F\24\3\2\2\2GH\7~\2\2H\26\3\2\2\2IJ\7A\2\2"+
		"J\30\3\2\2\2KL\7<\2\2L\32\3\2\2\2MN\7,\2\2N\34\3\2\2\2OP\7\61\2\2P\36"+
		"\3\2\2\2QR\7(\2\2RS\7(\2\2S \3\2\2\2TU\7~\2\2UV\7~\2\2V\"\3\2\2\2WX\7"+
		">\2\2XY\7>\2\2Y$\3\2\2\2Z[\7@\2\2[\\\7@\2\2\\&\3\2\2\2]_\t\3\2\2^]\3\2"+
		"\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\b\24\2\2c(\3\2\2\2de\7"+
		"*\2\2e*\3\2\2\2fg\7+\2\2g,\3\2\2\2\7\2/\63?`\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}