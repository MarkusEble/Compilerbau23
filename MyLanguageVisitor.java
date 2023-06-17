import java.util.Iterator;
import java.util.List;


import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class MyLanguageVisitor extends antlrcompiler.languageBaseVisitor<compiler.ast.ASTNode> {

    @Override public compiler.ast.ASTNode visitSumExpr(antlrcompiler.languageParser.SumExprContext ctx) {
        // plusMinusExpr: mulDivExpr ((PLUS|MINUS) mulDivExpr)*
        List<antlrcompiler.languageParser.MulDivExprContext> mulExprList = ctx.mulDivExpr();
        Iterator<antlrcompiler.languageParser.MulDivExprContext> mulExprListIter = mulExprList.iterator();
        List<TerminalNode> opList = ctx.SUMOP();
        Iterator<TerminalNode> opListIter = opList.iterator();

        compiler.ast.ASTExprNode currentLhs = (compiler.ast.ASTExprNode)visit(mulExprListIter.next()); 

        while (mulExprListIter.hasNext()) {
            antlrcompiler.languageParser.MulDivExprContext next = mulExprListIter.next();
            compiler.ast.ASTExprNode currentRhs = (compiler.ast.ASTExprNode)visit(next);
            TerminalNode op = opListIter.next();
            compiler.Token token = new compiler.Token();
            token.m_type = (op.getText().equals("+")) ? compiler.TokenIntf.Type.PLUS : compiler.TokenIntf.Type.MINUS;
            currentLhs = new compiler.ast.ASTPlusMinusExprNode(currentLhs, currentRhs, token);
        }
        return currentLhs;
         
   }

   @Override public compiler.ast.ASTNode visitMulDivExpr(antlrcompiler.languageParser.MulDivExprContext ctx) {
    // plusMinusExpr: mulDivExpr ((PLUS|MINUS) mulDivExpr)*
    List<antlrcompiler.languageParser.ParantheseExprContext> parantheseExprList = ctx.parantheseExpr();
    Iterator<antlrcompiler.languageParser.ParantheseExprContext> parantheseExprListIter = parantheseExprList.iterator();
    List<TerminalNode> opList = ctx.MULOP();
    Iterator<TerminalNode> opListIter = opList.iterator();

    compiler.ast.ASTExprNode currentLhs = (compiler.ast.ASTExprNode)visit(parantheseExprListIter.next()); 

    while (parantheseExprListIter.hasNext()) {
        antlrcompiler.languageParser.ParantheseExprContext next = parantheseExprListIter.next();
        compiler.ast.ASTExprNode currentRhs = (compiler.ast.ASTExprNode)visit(next);
        TerminalNode op = opListIter.next();
        compiler.Token token = new compiler.Token();
        token.m_type = (op.getText().equals("*")) ? compiler.TokenIntf.Type.MUL : compiler.TokenIntf.Type.DIV;
        currentLhs = new compiler.ast.ASTMulDivExprNode(currentLhs, currentRhs, token);
    }
    return currentLhs;
     
}

@Override
public compiler.ast.ASTNode visitNumberOnly(antlrcompiler.languageParser.NumberOnlyContext ctx) {
    TerminalNode numberNode = ctx.NUMBER();
    String numberText = numberNode.getText();
    return new compiler.ast.ASTIntegerLiteralNode(numberText);
}

@Override
public compiler.ast.ASTNode visitWithParanthese(antlrcompiler.languageParser.WithParantheseContext ctx) {
    return visit(ctx.sumExpr());
}
 
}
