// Generated from language.g4 by ANTLR 4.7.2
package antlrcompiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link languageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface languageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link languageParser#questionMarkExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionMarkExpr(languageParser.QuestionMarkExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#andOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOrExpr(languageParser.AndOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#andOrOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOrOp(languageParser.AndOrOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#cmpExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExpr(languageParser.CmpExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#cmpOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpOp(languageParser.CmpOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#shiftExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpr(languageParser.ShiftExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#shiftOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftOp(languageParser.ShiftOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#bitAndOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitAndOrExpr(languageParser.BitAndOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#bitOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitOp(languageParser.BitOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#sumExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumExpr(languageParser.SumExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#mulDivExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(languageParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberOnly}
	 * labeled alternative in {@link languageParser#parantheseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberOnly(languageParser.NumberOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withParanthese}
	 * labeled alternative in {@link languageParser#parantheseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithParanthese(languageParser.WithParantheseContext ctx);
}