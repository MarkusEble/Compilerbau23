package compiler.instr;

import java.io.OutputStreamWriter;

import compiler.ExecutionEnvIntf;

public class InstrPlusMinus extends compiler.InstrIntf {
    private compiler.TokenIntf.Type m_type;
    compiler.InstrIntf m_lhs;
    compiler.InstrIntf m_rhs;

    public InstrPlusMinus(compiler.TokenIntf.Type type, compiler.InstrIntf lhs, compiler.InstrIntf rhs) {
       m_type = type;
       m_lhs = lhs;
       m_rhs = rhs;
    }

    @Override
    public void execute(ExecutionEnvIntf env) {
        if (m_type == compiler.TokenIntf.Type.PLUS) {
            m_value = m_lhs.getValue() + m_rhs.getValue();
        } else {
            m_value = m_lhs.getValue() - m_rhs.getValue();
        }        
    }

    @Override
    public void trace(OutputStreamWriter os) throws Exception {
        os.write(String.format("%%%d = %s %%%d, %%%d\n", m_id, m_type.toString(), m_lhs.m_id, m_rhs.m_id));        
    }
    
}
