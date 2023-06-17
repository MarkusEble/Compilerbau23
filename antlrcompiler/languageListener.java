// Generated from language.g4 by ANTLR 4.7.2
package antlrcompiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link languageParser}.
 */
public interface languageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link languageParser#questionMarkExpr}.
	 * @param ctx the parse tree
	 */
	void enterQuestionMarkExpr(languageParser.QuestionMarkExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#questionMarkExpr}.
	 * @param ctx the parse tree
	 */
	void exitQuestionMarkExpr(languageParser.QuestionMarkExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#andOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndOrExpr(languageParser.AndOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#andOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndOrExpr(languageParser.AndOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#andOrOp}.
	 * @param ctx the parse tree
	 */
	void enterAndOrOp(languageParser.AndOrOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#andOrOp}.
	 * @param ctx the parse tree
	 */
	void exitAndOrOp(languageParser.AndOrOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#cmpExpr}.
	 * @param ctx the parse tree
	 */
	void enterCmpExpr(languageParser.CmpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#cmpExpr}.
	 * @param ctx the parse tree
	 */
	void exitCmpExpr(languageParser.CmpExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#cmpOp}.
	 * @param ctx the parse tree
	 */
	void enterCmpOp(languageParser.CmpOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#cmpOp}.
	 * @param ctx the parse tree
	 */
	void exitCmpOp(languageParser.CmpOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#shiftExpr}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpr(languageParser.ShiftExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#shiftExpr}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpr(languageParser.ShiftExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#shiftOp}.
	 * @param ctx the parse tree
	 */
	void enterShiftOp(languageParser.ShiftOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#shiftOp}.
	 * @param ctx the parse tree
	 */
	void exitShiftOp(languageParser.ShiftOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#bitAndOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterBitAndOrExpr(languageParser.BitAndOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#bitAndOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitBitAndOrExpr(languageParser.BitAndOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#bitOp}.
	 * @param ctx the parse tree
	 */
	void enterBitOp(languageParser.BitOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#bitOp}.
	 * @param ctx the parse tree
	 */
	void exitBitOp(languageParser.BitOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#sumExpr}.
	 * @param ctx the parse tree
	 */
	void enterSumExpr(languageParser.SumExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#sumExpr}.
	 * @param ctx the parse tree
	 */
	void exitSumExpr(languageParser.SumExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#mulDivExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(languageParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#mulDivExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(languageParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberOnly}
	 * labeled alternative in {@link languageParser#parantheseExpr}.
	 * @param ctx the parse tree
	 */
	void enterNumberOnly(languageParser.NumberOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberOnly}
	 * labeled alternative in {@link languageParser#parantheseExpr}.
	 * @param ctx the parse tree
	 */
	void exitNumberOnly(languageParser.NumberOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code withParanthese}
	 * labeled alternative in {@link languageParser#parantheseExpr}.
	 * @param ctx the parse tree
	 */
	void enterWithParanthese(languageParser.WithParantheseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code withParanthese}
	 * labeled alternative in {@link languageParser#parantheseExpr}.
	 * @param ctx the parse tree
	 */
	void exitWithParanthese(languageParser.WithParantheseContext ctx);
}