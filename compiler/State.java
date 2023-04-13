package compiler;

import java.util.HashMap;
import java.util.Map;

/**
 * single state of a deterministic finite state machine with transitions
 */
public class State implements StateIntf {
	private String m_name;
	private boolean m_isFinal;
	// part of transition function
	private HashMap<String, String> m_transitionMap;

	public State(String name, boolean isFinal) {
		m_name = name;
		m_isFinal = isFinal;
		m_transitionMap = new HashMap<String, String>();
	}

    @Override
	public StateIntf addTransition(char terminal, String targetState) {
		m_transitionMap.put(String.valueOf(terminal), targetState);
		return this;
	}

    @Override
	public StateIntf addTransitionRange(char first, char last, String targetState) {
		for (char c = first; c <= last; c++) {
			addTransition(c, targetState);
		}
		return this;
	}

    @Override
	public String getTransition(char terminal) {
		return m_transitionMap.get(String.valueOf(terminal));
	}

    @Override
	public String getName() {
		return m_name;
	}

    @Override
	public boolean isFinal() {
		return m_isFinal;
	}

	/**
	 * tranform description of this state into dot format
	 */
	public String transitionsAsDot(boolean collapse) {
		if (collapse) {
			return transitionsAsDot(getName(), Utils.collapse(m_transitionMap));
		} else {
			return transitionsAsDot(getName(), m_transitionMap);
		}
	}

	private static String transitionsAsDot(String origin, Map<String, String> transitions) {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, String> entry : transitions.entrySet()) {
			builder.append(
					String.format("  %s -> %s [ label = \"%s\" ];\n", origin, entry.getValue(), entry.getKey()));
		}
		return builder.toString();
	}

}