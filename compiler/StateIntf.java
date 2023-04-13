package compiler;

/**
 * single state of a deterministic finite state machine with transitions
 */
public interface StateIntf {

	// methods for construction

	// State(String name, boolean isFinal)

	/**
	 * add transition triggerd by <terminal> form this state to <targetState>
	 */
	public StateIntf addTransition(char terminal, String targetState);

	/**
	 * add transition triggerd by all terminals in range [first, last] from this
	 * state to <targetState>
	 */
	public StateIntf addTransitionRange(char first, char last, String targetState);

	// methods to use during input processing

	/**
	 * get target state name for transition triggered by <terminal>
	 */
	public String getTransition(char terminal);

	public String getName();

	public boolean isFinal();
}