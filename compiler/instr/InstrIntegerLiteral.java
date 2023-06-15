package compiler.instr;

import java.io.OutputStreamWriter;

public class InstrIntegerLiteral extends compiler.InstrIntf {

    public InstrIntegerLiteral(int value) {
        m_value = value;
    }

    public void execute(compiler.ExecutionEnvIntf env) {
    }

    public void trace(OutputStreamWriter os) throws Exception {
        os.write(String.format("%%%d = INTEGER %s\n", m_id, m_value));
    }
}
