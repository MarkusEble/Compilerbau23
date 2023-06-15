package compiler;

import java.io.OutputStreamWriter;

public abstract class InstrIntf {
	private static int m_nextId = 0;
    protected int m_value = 0;
	public int m_id;

	protected InstrIntf() {
		m_id = m_nextId;
		m_nextId++;
	}

	/**
	 * execute this instruction
	 */
	abstract public void execute(ExecutionEnvIntf env);
	/**
	 * trace this instruction
	 */
	abstract public void trace(OutputStreamWriter os) throws Exception;
	/**
	 * return the result value of the instruction
	 */
	public int getValue() {
	    return m_value;
	}

}
