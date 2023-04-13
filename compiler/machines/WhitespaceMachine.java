package compiler.machines;

import compiler.State;

public class WhitespaceMachine extends compiler.StateMachine {

    /*
     9 = horizontal tab
    10 = new line
    11 = vertical tab
    12 = new page
    13 = carriage return
    32 = space
     */
    public static final char [] WHITESPACE_CHARACTERS = {9, 10, 11, 12, 13, 32};

    public void initStateTable() {
        State startState = new State("start", false);
        for(char c : WHITESPACE_CHARACTERS) startState.addTransition(c, "whiteSpace");
        startState.addTransitionRange('!', '~', "error"); // all ASCII characters from 33 to 126
        addState(startState);

        State whiteSpaceState = new State("whiteSpace", true);
        for(char c : WHITESPACE_CHARACTERS) whiteSpaceState.addTransition(c, "whiteSpace");
        whiteSpaceState.addTransitionRange('!', '~', "error"); // all ASCII characters from 33 to 126
        addState(whiteSpaceState);

        State errorState = new State("error", false);
        errorState.addTransitionRange('!', '~', "error"); // all ASCII characters from 33 to 126
        addState(errorState);
    }

    @Override
    public String getStartState() {
        return "start";
    }

    public compiler.TokenIntf.Type getType() {
        return compiler.TokenIntf.Type.WHITESPACE;
    }
}
