// Generated from .\language.g4 by ANTLR 4.7.2
package antlrcompiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link languageParser}.
 */
public interface languageListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link languageParser#sumOp}.
	 * @param ctx the parse tree
	 */
	void enterSumOp(languageParser.SumOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#sumOp}.
	 * @param ctx the parse tree
	 */
	void exitSumOp(languageParser.SumOpContext ctx);
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
}