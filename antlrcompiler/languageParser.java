// Generated from language.g4 by ANTLR 4.7.2
package antlrcompiler;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class languageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SUMOP=1, MULOP=2, LESS=3, GREATER=4, EQUAL=5, NUMBER=6, PLUS=7, MINUS=8, 
		BITAND=9, BITOR=10, QUESTIONMARK=11, DOUBLECOLON=12, MUL=13, DIV=14, AND=15, 
		OR=16, SHIFTLEFT=17, SHIFTRIGHT=18, WS=19, LPAREN=20, RPAREN=21;
	public static final int
		RULE_questionMarkExpr = 0, RULE_andOrExpr = 1, RULE_andOrOp = 2, RULE_cmpExpr = 3, 
		RULE_cmpOp = 4, RULE_shiftExpr = 5, RULE_shiftOp = 6, RULE_bitAndOrExpr = 7, 
		RULE_bitOp = 8, RULE_sumExpr = 9, RULE_mulDivExpr = 10, RULE_parantheseExpr = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"questionMarkExpr", "andOrExpr", "andOrOp", "cmpExpr", "cmpOp", "shiftExpr", 
			"shiftOp", "bitAndOrExpr", "bitOp", "sumExpr", "mulDivExpr", "parantheseExpr"
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

	@Override
	public String getGrammarFileName() { return "language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public languageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QuestionMarkExprContext extends ParserRuleContext {
		public List<AndOrExprContext> andOrExpr() {
			return getRuleContexts(AndOrExprContext.class);
		}
		public AndOrExprContext andOrExpr(int i) {
			return getRuleContext(AndOrExprContext.class,i);
		}
		public TerminalNode QUESTIONMARK() { return getToken(languageParser.QUESTIONMARK, 0); }
		public TerminalNode DOUBLECOLON() { return getToken(languageParser.DOUBLECOLON, 0); }
		public QuestionMarkExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionMarkExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterQuestionMarkExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitQuestionMarkExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitQuestionMarkExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionMarkExprContext questionMarkExpr() throws RecognitionException {
		QuestionMarkExprContext _localctx = new QuestionMarkExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questionMarkExpr);
		try {
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(24);
				andOrExpr();
				setState(25);
				match(QUESTIONMARK);
				setState(26);
				andOrExpr();
				setState(27);
				match(DOUBLECOLON);
				setState(28);
				andOrExpr();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				andOrExpr();
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

	public static class AndOrExprContext extends ParserRuleContext {
		public List<CmpExprContext> cmpExpr() {
			return getRuleContexts(CmpExprContext.class);
		}
		public CmpExprContext cmpExpr(int i) {
			return getRuleContext(CmpExprContext.class,i);
		}
		public List<AndOrOpContext> andOrOp() {
			return getRuleContexts(AndOrOpContext.class);
		}
		public AndOrOpContext andOrOp(int i) {
			return getRuleContext(AndOrOpContext.class,i);
		}
		public AndOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andOrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterAndOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitAndOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitAndOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndOrExprContext andOrExpr() throws RecognitionException {
		AndOrExprContext _localctx = new AndOrExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_andOrExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			cmpExpr();
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(34);
				andOrOp();
				setState(35);
				cmpExpr();
				}
				}
				setState(41);
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

	public static class AndOrOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(languageParser.AND, 0); }
		public TerminalNode OR() { return getToken(languageParser.OR, 0); }
		public AndOrOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andOrOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterAndOrOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitAndOrOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitAndOrOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndOrOpContext andOrOp() throws RecognitionException {
		AndOrOpContext _localctx = new AndOrOpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_andOrOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
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

	public static class CmpExprContext extends ParserRuleContext {
		public List<ShiftExprContext> shiftExpr() {
			return getRuleContexts(ShiftExprContext.class);
		}
		public ShiftExprContext shiftExpr(int i) {
			return getRuleContext(ShiftExprContext.class,i);
		}
		public List<CmpOpContext> cmpOp() {
			return getRuleContexts(CmpOpContext.class);
		}
		public CmpOpContext cmpOp(int i) {
			return getRuleContext(CmpOpContext.class,i);
		}
		public CmpExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmpExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterCmpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitCmpExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitCmpExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmpExprContext cmpExpr() throws RecognitionException {
		CmpExprContext _localctx = new CmpExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmpExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			shiftExpr();
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << EQUAL))) != 0)) {
				{
				{
				setState(45);
				cmpOp();
				setState(46);
				shiftExpr();
				}
				}
				setState(52);
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

	public static class CmpOpContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(languageParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(languageParser.GREATER, 0); }
		public TerminalNode EQUAL() { return getToken(languageParser.EQUAL, 0); }
		public CmpOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmpOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterCmpOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitCmpOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitCmpOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmpOpContext cmpOp() throws RecognitionException {
		CmpOpContext _localctx = new CmpOpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmpOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << EQUAL))) != 0)) ) {
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

	public static class ShiftExprContext extends ParserRuleContext {
		public List<BitAndOrExprContext> bitAndOrExpr() {
			return getRuleContexts(BitAndOrExprContext.class);
		}
		public BitAndOrExprContext bitAndOrExpr(int i) {
			return getRuleContext(BitAndOrExprContext.class,i);
		}
		public List<ShiftOpContext> shiftOp() {
			return getRuleContexts(ShiftOpContext.class);
		}
		public ShiftOpContext shiftOp(int i) {
			return getRuleContext(ShiftOpContext.class,i);
		}
		public ShiftExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterShiftExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitShiftExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitShiftExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftExprContext shiftExpr() throws RecognitionException {
		ShiftExprContext _localctx = new ShiftExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_shiftExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			bitAndOrExpr();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SHIFTLEFT || _la==SHIFTRIGHT) {
				{
				{
				setState(56);
				shiftOp();
				setState(57);
				bitAndOrExpr();
				}
				}
				setState(63);
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

	public static class ShiftOpContext extends ParserRuleContext {
		public TerminalNode SHIFTLEFT() { return getToken(languageParser.SHIFTLEFT, 0); }
		public TerminalNode SHIFTRIGHT() { return getToken(languageParser.SHIFTRIGHT, 0); }
		public ShiftOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterShiftOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitShiftOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitShiftOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftOpContext shiftOp() throws RecognitionException {
		ShiftOpContext _localctx = new ShiftOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_shiftOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !(_la==SHIFTLEFT || _la==SHIFTRIGHT) ) {
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

	public static class BitAndOrExprContext extends ParserRuleContext {
		public List<SumExprContext> sumExpr() {
			return getRuleContexts(SumExprContext.class);
		}
		public SumExprContext sumExpr(int i) {
			return getRuleContext(SumExprContext.class,i);
		}
		public List<BitOpContext> bitOp() {
			return getRuleContexts(BitOpContext.class);
		}
		public BitOpContext bitOp(int i) {
			return getRuleContext(BitOpContext.class,i);
		}
		public BitAndOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitAndOrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterBitAndOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitBitAndOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitBitAndOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitAndOrExprContext bitAndOrExpr() throws RecognitionException {
		BitAndOrExprContext _localctx = new BitAndOrExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bitAndOrExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			sumExpr();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITAND || _la==BITOR) {
				{
				{
				setState(67);
				bitOp();
				setState(68);
				sumExpr();
				}
				}
				setState(74);
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

	public static class BitOpContext extends ParserRuleContext {
		public TerminalNode BITAND() { return getToken(languageParser.BITAND, 0); }
		public TerminalNode BITOR() { return getToken(languageParser.BITOR, 0); }
		public BitOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterBitOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitBitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitBitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitOpContext bitOp() throws RecognitionException {
		BitOpContext _localctx = new BitOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bitOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !(_la==BITAND || _la==BITOR) ) {
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

	public static class SumExprContext extends ParserRuleContext {
		public List<MulDivExprContext> mulDivExpr() {
			return getRuleContexts(MulDivExprContext.class);
		}
		public MulDivExprContext mulDivExpr(int i) {
			return getRuleContext(MulDivExprContext.class,i);
		}
		public List<TerminalNode> SUMOP() { return getTokens(languageParser.SUMOP); }
		public TerminalNode SUMOP(int i) {
			return getToken(languageParser.SUMOP, i);
		}
		public SumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterSumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitSumExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitSumExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SumExprContext sumExpr() throws RecognitionException {
		SumExprContext _localctx = new SumExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sumExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			mulDivExpr();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SUMOP) {
				{
				{
				setState(78);
				match(SUMOP);
				setState(79);
				mulDivExpr();
				}
				}
				setState(84);
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

	public static class MulDivExprContext extends ParserRuleContext {
		public List<ParantheseExprContext> parantheseExpr() {
			return getRuleContexts(ParantheseExprContext.class);
		}
		public ParantheseExprContext parantheseExpr(int i) {
			return getRuleContext(ParantheseExprContext.class,i);
		}
		public List<TerminalNode> MULOP() { return getTokens(languageParser.MULOP); }
		public TerminalNode MULOP(int i) {
			return getToken(languageParser.MULOP, i);
		}
		public MulDivExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulDivExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterMulDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitMulDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitMulDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulDivExprContext mulDivExpr() throws RecognitionException {
		MulDivExprContext _localctx = new MulDivExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_mulDivExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			parantheseExpr();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULOP) {
				{
				{
				setState(86);
				match(MULOP);
				setState(87);
				parantheseExpr();
				}
				}
				setState(92);
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

	public static class ParantheseExprContext extends ParserRuleContext {
		public ParantheseExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parantheseExpr; }
	 
		public ParantheseExprContext() { }
		public void copyFrom(ParantheseExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WithParantheseContext extends ParantheseExprContext {
		public TerminalNode LPAREN() { return getToken(languageParser.LPAREN, 0); }
		public SumExprContext sumExpr() {
			return getRuleContext(SumExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(languageParser.RPAREN, 0); }
		public WithParantheseContext(ParantheseExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterWithParanthese(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitWithParanthese(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitWithParanthese(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberOnlyContext extends ParantheseExprContext {
		public TerminalNode NUMBER() { return getToken(languageParser.NUMBER, 0); }
		public NumberOnlyContext(ParantheseExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).enterNumberOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof languageListener ) ((languageListener)listener).exitNumberOnly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof languageVisitor ) return ((languageVisitor<? extends T>)visitor).visitNumberOnly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParantheseExprContext parantheseExpr() throws RecognitionException {
		ParantheseExprContext _localctx = new ParantheseExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parantheseExpr);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new NumberOnlyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(NUMBER);
				}
				break;
			case LPAREN:
				_localctx = new WithParantheseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(LPAREN);
				setState(95);
				sumExpr();
				setState(96);
				match(RPAREN);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27g\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\"\n\2\3\3\3\3\3\3\3\3\7"+
		"\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\5\3\5\3\5\3\5\7\5\63\n\5\f\5\16\5\66"+
		"\13\5\3\6\3\6\3\7\3\7\3\7\3\7\7\7>\n\7\f\7\16\7A\13\7\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\7\tI\n\t\f\t\16\tL\13\t\3\n\3\n\3\13\3\13\3\13\7\13S\n\13\f\13"+
		"\16\13V\13\13\3\f\3\f\3\f\7\f[\n\f\f\f\16\f^\13\f\3\r\3\r\3\r\3\r\3\r"+
		"\5\re\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\6\3\2\21\22\3\2\5"+
		"\7\3\2\23\24\3\2\13\f\2b\2!\3\2\2\2\4#\3\2\2\2\6,\3\2\2\2\b.\3\2\2\2\n"+
		"\67\3\2\2\2\f9\3\2\2\2\16B\3\2\2\2\20D\3\2\2\2\22M\3\2\2\2\24O\3\2\2\2"+
		"\26W\3\2\2\2\30d\3\2\2\2\32\33\5\4\3\2\33\34\7\r\2\2\34\35\5\4\3\2\35"+
		"\36\7\16\2\2\36\37\5\4\3\2\37\"\3\2\2\2 \"\5\4\3\2!\32\3\2\2\2! \3\2\2"+
		"\2\"\3\3\2\2\2#)\5\b\5\2$%\5\6\4\2%&\5\b\5\2&(\3\2\2\2\'$\3\2\2\2(+\3"+
		"\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2\2+)\3\2\2\2,-\t\2\2\2-\7\3\2\2\2"+
		".\64\5\f\7\2/\60\5\n\6\2\60\61\5\f\7\2\61\63\3\2\2\2\62/\3\2\2\2\63\66"+
		"\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\t\3\2\2\2\66\64\3\2\2\2\678\t"+
		"\3\2\28\13\3\2\2\29?\5\20\t\2:;\5\16\b\2;<\5\20\t\2<>\3\2\2\2=:\3\2\2"+
		"\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\r\3\2\2\2A?\3\2\2\2BC\t\4\2\2C\17\3"+
		"\2\2\2DJ\5\24\13\2EF\5\22\n\2FG\5\24\13\2GI\3\2\2\2HE\3\2\2\2IL\3\2\2"+
		"\2JH\3\2\2\2JK\3\2\2\2K\21\3\2\2\2LJ\3\2\2\2MN\t\5\2\2N\23\3\2\2\2OT\5"+
		"\26\f\2PQ\7\3\2\2QS\5\26\f\2RP\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U"+
		"\25\3\2\2\2VT\3\2\2\2W\\\5\30\r\2XY\7\4\2\2Y[\5\30\r\2ZX\3\2\2\2[^\3\2"+
		"\2\2\\Z\3\2\2\2\\]\3\2\2\2]\27\3\2\2\2^\\\3\2\2\2_e\7\b\2\2`a\7\26\2\2"+
		"ab\5\24\13\2bc\7\27\2\2ce\3\2\2\2d_\3\2\2\2d`\3\2\2\2e\31\3\2\2\2\n!)"+
		"\64?JT\\d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}