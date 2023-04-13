package compiler;

import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * finish state machine
 */
public abstract class StateMachine implements StateMachineIntf, Cloneable {
	private InputReader m_input; // input to process
	private String m_state; // current state
	private HashMap<String, State> m_stateMap; 	// set of states
	protected boolean m_traceFinished = false;

	@Override
	public StateIntf addState(State state) {
		m_stateMap.put(state.getName(), state);
		return state;
	}

	@Override
	public void init(String input) {
		m_input = new InputReader(input);
		m_stateMap = new HashMap<String, State>();
		initStateTable();
		m_state = getStartState();
	}

	@Override
	public void step() {
		// look for transition on (current state, current input)
		char curChar = m_input.currentChar();
		State curState = m_stateMap.get(m_state);
		String nextStateString = curState.getTransition(curChar);
        if (nextStateString == null) {
        	// no transition => error
        	m_state = "error";
        } else {
        	// execute transition
        	State nextState = m_stateMap.get(nextStateString);
			if (nextState == null) {
				throw new NullPointerException("expected state '" + nextStateString + "' not registered " +
						"(forgot calling StateMachine#addState?)");
			}
			m_state = nextState.getName();
        }
        m_input.advance();
	}

	@Override
	public void process(String input, OutputStreamWriter outStream) throws Exception {
		init(input);
		traceHead(outStream);
		outStream.write('\n');

		// iterate until finished
		while (!isFinished()) {
			// dump state
			trace(outStream);
			outStream.write('\n');
			// execute next step
			step();
		}
		// dump final state
		trace(outStream);
		outStream.write('\n');
		if (isFinalState()) {
			outStream.write("ACCEPT\n");
		} else {
			outStream.write("FAIL\n");		
		}
		outStream.flush();
	}

	@Override
	public boolean isFinalState() {
		State state = m_stateMap.get(m_state);
		return (state != null) && state.isFinal();
	}

	@Override
	public boolean isFinished() {
		return m_input.currentChar() == 0 || m_state.equals("error");
	}

	/**
	 * dump the current machine state
	 */
	public void trace(OutputStreamWriter outStream) throws Exception {
		// trace finished state only once
		if (m_traceFinished) {
			traceBlank(outStream);
		} else {
			traceState(outStream);
		}
		if (isFinished()) {
			m_traceFinished = true;
		}
	}
	
	/**
	 * trace the current state
	 */
	private void traceState(OutputStreamWriter outStream) throws Exception {
		// dump input
		m_input.traceState(outStream);
		outStream.write(" | ");
		// dump state with padding
		outStream.write(m_state);
		for (int i = m_state.length(); i < 10; i++) {
			outStream.write (' ');
		}
		
	}

	/**
	 * trace blanks instead of actual state (since machine is finished)
	 */
	private void traceBlank(OutputStreamWriter outStream) throws Exception {
		// dump input
		m_input.traceBlank(outStream);
		outStream.write("   ");
		// dump padding for state
		for (int i = 0; i < 10; i++) {
			outStream.write (' ');
		}		
	}
	
	private void traceHead(OutputStreamWriter outStream) throws Exception {
		// dump input
		m_input.traceHead(outStream);
		outStream.write(" | ");
		// dump padding for state
		outStream.write("STATE");
		for (int i = 5; i < 10; i++) {
			outStream.write (' ');
		}		
	}

	public String asDot() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("digraph StateMachine {" + System.lineSeparator());
		stringBuilder.append("  rankdir=LR;" + System.lineSeparator());
		stringBuilder.append("  size=\"8,5\";" + System.lineSeparator());
		stringBuilder.append("  node [shape = doublecircle];");
		for (String finalState : getFinalStates()) {
			stringBuilder.append(" " + finalState + ";");
		}
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("  node [shape = circle];" + System.lineSeparator());
		for (State state : m_stateMap.values()) {
			stringBuilder.append(state.transitionsAsDot(true));
		}
		stringBuilder.append("}" + System.lineSeparator());
		return stringBuilder.toString();
	}

	private Set<String> getFinalStates() {
		Set<String> result = new HashSet<>();
		String previousState = m_state;
		for (String state : m_stateMap.keySet()) {
			if (m_stateMap.get(state).isFinal()) {
				result.add(state);
			}
		}
		m_state = previousState;
		return result;
	}

	/**
	 * clone in case of non-deterministic decision
	 */
	public Object clone() throws CloneNotSupportedException {
		StateMachine theClone = (StateMachine)super.clone();
		theClone.m_input = (InputReader)m_input.clone();
		theClone.m_state = new String(m_state);
		theClone.m_traceFinished = false;
		return theClone;
	}

}
