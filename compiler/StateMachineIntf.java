package compiler;

import java.io.OutputStreamWriter;

/**
 * interface for finish state machine
 */

public interface StateMachineIntf {

	// methods for construction of specific state machine
	/**
	 * initialize state transition table
	 * this method has to be overwritten by the implementer of a final state machine
	 */
	public void initStateTable();

	/**
	 * adds a state to the final state machine
	 */
	public StateIntf addState(State state);

	// methods for input processing

	/**
	 * get start state
	 * this method has to be overwritten by the implementer of a final state machine
	 */
	public abstract String getStartState();
	
	/**
	 * initialize processing of input
	 */
	public void init(String input);
	
	/**
	 * process next input character
	 * implements the state transition function f of the machine model
	 * may consume input
	 */
	public void step() throws Exception;

	/**
	 * process input until finished and dump results to outStream
	 */
	public void process(String input, OutputStreamWriter outStream) throws Exception;

	// methods to evaluate results of processing

    /**
	 * is processing finished?
	 */
	public boolean isFinished();

	/**
	 * is machine in final state?
	 */
	public boolean isFinalState();

	/**
	 * token type recognized by this machine
	 */
	public TokenIntf.Type getType();
}
