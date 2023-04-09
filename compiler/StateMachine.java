package compiler;

import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * finish state machine
 */
public abstract class StateMachine implements Cloneable {
    private final Map<String, State> stateMap = new HashMap<>();     // set of states

    private InputReader input; // input to process
    private String state; // current state
    protected boolean traceFinished = false;

    public abstract void initStateTable();

    public abstract String getStartState();

    public void addState(State state) {
        this.stateMap.put(state.getName(), state);
    }

    public void addStates(State... states) {
        for (final State state : states) {
            this.stateMap.put(state.getName(), state);
        }
    }

    public void init(String input) {
        this.initStateTable();
        this.input = new InputReader(input);
        this.state = this.getStartState();
    }

    public void step() {
        // look for transition on (current state, current input)
        final char curChar = this.input.currentChar();
        this.input.advance();

        final State curState = this.stateMap.get(this.state);
        final String nextStateString = curState.getTransition(curChar);

		// no transition => error
        if (nextStateString == null) {
            this.state = "error";
            return;
        }

		// execute transition
        final State nextState = this.stateMap.get(nextStateString);
        if (nextState == null) {
            throw new NullPointerException("expected state '" + nextStateString + "' not registered " +
                    "(forgot calling StateMachine#addState?)");
        }
        this.state = nextState.getName();
    }

    public void process(String input, OutputStreamWriter outStream) throws Exception {
        this.init(input);
        this.traceHead(outStream);
        outStream.write('\n');

        // iterate until finished
        while (!isFinished()) {
            // dump state
            this.trace(outStream);
            outStream.write('\n');
            // execute next step
            this.step();
        }

		// dump final state
        this.trace(outStream);
        outStream.write('\n');
        if (this.isFinalState()) {
            outStream.write("ACCEPT\n");
        } else {
            outStream.write("FAIL\n");
        }
        outStream.flush();
    }

    public boolean isFinalState() {
        final State state = this.stateMap.get(this.state);
        return (state != null) && state.isFinal();
    }

    public boolean isFinished() {
        return this.input.currentChar() == 0 || this.state.equals("error");
    }

    /**
     * dump the current machine state
     */
    public void trace(OutputStreamWriter outStream) throws Exception {
        // trace finished state only once
        if (this.traceFinished) {
            this.traceBlank(outStream);
        } else {
            this.traceState(outStream);
        }
        if (this.isFinished()) {
            this.traceFinished = true;
        }
    }

    /**
     * trace the current state
     */
    private void traceState(OutputStreamWriter outStream) throws Exception {
        // dump input
        this.input.traceState(outStream);
        outStream.write(" | ");
        // dump state with padding
        outStream.write(this.state);
        for (int i = this.state.length(); i < 10; i++) {
            outStream.write(' ');
        }

    }

    /**
     * trace blanks instead of actual state (since machine is finished)
     */
    private void traceBlank(OutputStreamWriter outStream) throws Exception {
        // dump input
        this.input.traceBlank(outStream);
        outStream.write("   ");
        // dump padding for state
        for (int i = 0; i < 10; i++) {
            outStream.write(' ');
        }
    }

    private void traceHead(OutputStreamWriter outStream) throws Exception {
        // dump input
        this.input.traceHead(outStream);
        outStream.write(" | ");
        // dump padding for state
        outStream.write("STATE");
        for (int i = 5; i < 10; i++) {
            outStream.write(' ');
        }
    }

    public String asDot() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("digraph StateMachine {").append(System.lineSeparator());
        stringBuilder.append("  rankdir=LR;").append(System.lineSeparator());
        stringBuilder.append("  size=\"8,5\";").append(System.lineSeparator());
        stringBuilder.append("  node [shape = doublecircle];");
        for (final String finalState : getFinalStates()) {
            stringBuilder.append(" ").append(finalState).append(";");
        }
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("  node [shape = circle];").append(System.lineSeparator());
        for (final State state : this.stateMap.values()) {
            stringBuilder.append(state.transitionsAsDot(true));
        }
        stringBuilder.append("}").append(System.lineSeparator());
        return stringBuilder.toString();
    }

    private Set<String> getFinalStates() {
		return this.stateMap.entrySet().stream()
				.filter(stringStateEntry -> stringStateEntry.getValue().isFinal())
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
    }

    /**
     * clone in case of non-deterministic decision
     */
    public Object clone() throws CloneNotSupportedException {
        final StateMachine theClone = (StateMachine) super.clone();
        if (this.input != null) {
            theClone.input = (InputReader) this.input.clone();
        }
        theClone.state = this.state;
        theClone.traceFinished = false;
        return theClone;
    }

}
