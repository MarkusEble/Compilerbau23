package compiler.instr;

import java.io.OutputStreamWriter;

import compiler.ExecutionEnvIntf;

public class InstrPrint extends compiler.InstrIntf {
    private compiler.InstrIntf m_expr;

    public InstrPrint(compiler.InstrIntf instrExpr) {
        m_expr = instrExpr;
    }
    
    @Override
    public void execute(ExecutionEnvIntf env) {
        try {
            env.getOutputStream().write(Integer.toString(m_expr.getValue()));
            env.getOutputStream().write("\n");
            env.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void trace(OutputStreamWriter os) throws Exception {
        os.write(String.format("PRINT %%%d\n", m_expr.m_id));
    }
    
}
