package compiler.machines;

import compiler.State;

public class DecimalMachine extends compiler.StateMachine {
    
    @Override
    public void initStateTable() {
        // First integer
        State startState = new State("startState", false);
        State firstNegativeSignState = new State("firstNegativeSignState", false);
        State firstNumberState = new State("firstNumberState", false);
        State firstZeroState = new State("firstZeroState", false);
        startState.addTransition('-', "firstNegativeSignState");
        startState.addTransitionRange('1', '9', "firstNumberState");
        startState.addTransition('0', "firstZeroState");
        firstNegativeSignState.addTransitionRange('1', '9', "firstNumberState");
        firstNegativeSignState.addTransition('0', "firstZeroState");
        firstNumberState.addTransitionRange('0', '9', "firstNumberState");

        addState(startState);
        addState(firstNegativeSignState);
        addState(firstNumberState);
        addState(firstZeroState);

        // decimal
        State commaState = new State("commaState", false);
        State decimalState = new State("decimalState", true);
        firstZeroState.addTransition('.', "commaState");
        firstNumberState.addTransition('.', "commaState");
        commaState.addTransitionRange('0', '9', "decimalState");
        decimalState.addTransitionRange('0', '9', "decimalState");

        addState(commaState);
        addState(decimalState);

        // exponent
        decimalState.addTransition('E', "startExponentInteger");
        decimalState.addTransition('e', "startExponentInteger");

        State startExponentInteger = new State("startExponentInteger", false);
        State exponentNegativeSignState = new State("exponentNegativeSignState", false);
        State exponentNumberState = new State("exponentNumberState", true);
        State exponentZeroState = new State("exponentZeroState", true);
        startExponentInteger.addTransition('-', "exponentNegativeSignState");
        startExponentInteger.addTransitionRange('1', '9', "exponentNumberState");
        startExponentInteger.addTransition('0', "exponentZeroState");
        exponentNegativeSignState.addTransitionRange('1', '9', "exponentNumberState");
        exponentNegativeSignState.addTransition('0', "exponentZeroState");
        exponentNumberState.addTransitionRange('0', '9', "exponentNumberState");

        addState(startExponentInteger);
        addState(exponentNegativeSignState);
        addState(exponentNumberState);
        addState(exponentZeroState);
    }

    @Override
    public String getStartState() {
        return "startState";
    }
    
}