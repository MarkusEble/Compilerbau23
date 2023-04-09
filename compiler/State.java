package compiler;

import java.util.HashMap;
import java.util.Map;

/**
 * single state of a deterministic finite state machine with transitions
 */
public class State {

    private final String name;
    private final boolean isFinal;

    private final HashMap<String, String> transitionMap = new HashMap<>();

    public State(String name) {
        this(name, false);
    }

    public State(String name, boolean isFinal) {
        this.name = name;
        this.isFinal = isFinal;
    }

    /**
     * add transition triggered by <terminal> form this state to <targetState>
     */
    public State addTransition(char terminal, String targetState) {
        this.transitionMap.put(String.valueOf(terminal), targetState);
        return this;
    }

    public State addMultipleTransitions(final String targetState, final char... terminals) {
        for (final char terminal : terminals) {
            this.addTransition(terminal, targetState);
        }
        return this;
    }

    /**
     * add transition triggered by all terminals in range [first, last] from this
     * state to <targetState>
     */
    public State addTransitionRange(char first, char last, String targetState) {
        for (char c = first; c <= last; c++) {
            this.addTransition(c, targetState);
        }
        return this;
    }

    /**
     * get target state name for transition triggered by <terminal>
     */
    public String getTransition(char terminal) {
        return this.transitionMap.get(String.valueOf(terminal));
    }

    public String getName() {
        return this.name;
    }

    public boolean isFinal() {
        return this.isFinal;
    }

    /**
     * transform description of this state into dot format
     */
    public String transitionsAsDot(boolean collapse) {
        if (collapse) {
            return transitionsAsDot(getName(), Utils.collapse(transitionMap));
        } else {
            return transitionsAsDot(getName(), this.transitionMap);
        }
    }

    private static String transitionsAsDot(String origin, Map<String, String> transitions) {
        final StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : transitions.entrySet()) {
            builder.append(String.format("  %s -> %s [ label = \"%s\" ];\n", origin, entry.getValue(), entry.getKey()));
        }
        return builder.toString();
    }

}