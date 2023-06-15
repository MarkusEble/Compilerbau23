package compiler.ast;

import compiler.*;
import compiler.instr.*;

import java.io.OutputStreamWriter;

public class ASTExecuteNTimes extends ASTStmtNode {

    public final ASTExprNode n;
    public final ASTStmtNode block;

    public ASTExecuteNTimes(ASTExprNode n, ASTStmtNode block) {
        this.n = n;
        this.block = block;
    }

    @Override
    public void print(OutputStreamWriter outStream, String indent) throws Exception {
        outStream.write(indent + "EXECUTE ");
        n.print(outStream, indent);
        outStream.write(indent + " TIMES {\n");
        block.print(outStream, indent + "  ");
        outStream.write(indent + "}");
    }

    @Override
    public void execute() {
        for (int i = 0; i < n.eval(); i++) {
            block.execute();
        }
    }

    @Override
    public InstrIntf codegen(CompileEnvIntf env) {
        // Create helper variable name
        Symbol counterSymbol = env.createUniqueSymbol("counter");

        // Define Blocks
        InstrBlock initBlock = env.createBlock("init");
        InstrBlock bodyBlock = env.createBlock("body");
        InstrBlock exitBlock = env.createBlock("exit");

        // Codegen
        // init:
        env.addInstr(new InstrJump(initBlock));
        env.setCurrentBlock(initBlock);
        // eval n -> %1
        InstrIntf nInstr = n.codegen(env);
        // store %1 -> counter
        env.addInstr(new InstrAssignStmt(counterSymbol, nInstr));
        // cmp %1 < 1 -> %2
        InstrIntf literalOneInit = new InstrIntegerLiteral(1);
        env.addInstr(literalOneInit);
        InstrIntf conditionInit = new InstrCompare(TokenIntf.Type.LESS, nInstr, literalOneInit);
        env.addInstr(conditionInit);
        // jmpc %2 exit body
        env.addInstr(new InstrJumpCond(conditionInit, exitBlock, bodyBlock));

        // body:
        env.setCurrentBlock(bodyBlock);
        // execute block
        block.codegen(env);
        // load counter -> %3
        InstrIntf counter = new InstrVariable(counterSymbol.m_name);
        env.addInstr(counter);
        // dec %3 -> %4
        InstrIntf literalOneBody = new InstrIntegerLiteral(1);
        env.addInstr(literalOneBody);
        InstrIntf decCounter = new InstrPlusMinus(TokenIntf.Type.MINUS, counter, literalOneBody);
        env.addInstr(decCounter);
        // store %4 -> counter
        env.addInstr(new InstrAssignStmt(counterSymbol, decCounter));
        // cmp %4 < 1 -> %5
        InstrIntf conditionBody = new InstrCompare(TokenIntf.Type.LESS, decCounter, literalOneBody);
        env.addInstr(conditionBody);
        // jmpc %5 exit body
        env.addInstr(new InstrJumpCond(conditionBody, exitBlock, bodyBlock));

        //exit:
        env.setCurrentBlock(exitBlock);

        return null;
    }
}
