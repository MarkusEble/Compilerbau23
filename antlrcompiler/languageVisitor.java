// Generated from .\language.g4 by ANTLR 4.7.2
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
	 * Visit a parse tree produced by {@link languageParser#sumExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumExpr(languageParser.SumExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#sumOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumOp(languageParser.SumOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#cmpExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExpr(languageParser.CmpExprContext ctx);
}