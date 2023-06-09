package compiler.ast;

import java.io.OutputStreamWriter;


public class ASTPrintStmtNode extends ASTStmtNode {

    ASTExprNode expression;

    public ASTPrintStmtNode(ASTExprNode expressionInput) {
        expression = expressionInput;
    }


    @Override
    public void print(OutputStreamWriter outStream, String indent) throws Exception {
       outStream.write(indent  + "\n");
       String newIndent = indent + "  ";
       expression.print(outStream, newIndent);
    }

    @Override
    public void execute() {
        System.out.println(expression.eval());
    }


    public compiler.InstrIntf codegen(compiler.CompileEnvIntf env) {
        compiler.InstrIntf instrExpr = expression.codegen(env);
        compiler.InstrIntf instrPrint = new compiler.instr.InstrPrint(instrExpr);
        env.addInstr(instrPrint);
        return instrPrint;
    }

}