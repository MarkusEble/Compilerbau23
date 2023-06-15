package compiler.instr;

import compiler.ExecutionEnvIntf;
import compiler.InstrIntf;
import compiler.Symbol;
import compiler.TokenIntf;

import java.io.OutputStreamWriter;

public class InstrAssignStmt extends InstrIntf {
    private final Symbol m_var;
    final InstrIntf m_expression;


    public InstrAssignStmt(Symbol var, InstrIntf expression) {
        m_var = var;
        m_expression = expression;
    }

    @Override
    public void execute(ExecutionEnvIntf env) {
        m_var.m_number = m_expression.getValue();
    }

    @Override
    public void trace(OutputStreamWriter os) throws Exception {
        os.write(String.format("ASSIGN %s = %%%d\n", m_var.m_name, m_expression.m_id));        
    }
}
