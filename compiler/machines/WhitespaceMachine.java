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
        startState.addTransitionRange(WHITESPACE_CHARACTERS[0], WHITESPACE_CHARACTERS[WHITESPACE_CHARACTERS.length-1], "whiteSpace");
        startState.addTransitionRange('!', '~', "error"); // all ASCII characters from 33 to 126
        addState(startState);

        State whiteSpaceState = new State("whiteSpace", true);
        whiteSpaceState.addTransitionRange(WHITESPACE_CHARACTERS[0], WHITESPACE_CHARACTERS[WHITESPACE_CHARACTERS.length-1], "whiteSpace");
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
   
}
