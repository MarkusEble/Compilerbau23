package compiler.machines;

import compiler.State;
import compiler.StateMachine;

public class IntegerMachine extends StateMachine {

    @Override
    public void initStateTable() {
        final State startState = new State("start", false);
        startState.addTransitionRange('1', '9', "end");
        startState.addTransition('0', "zero_end");
        startState.addTransition('+', "sign");
        startState.addTransition('-', "sign");
        this.addState(startState);

        final State signState = new State("sign", false);
        signState.addTransition('0', "zero_end");
        signState.addTransitionRange('1', '9', "end");
        this.addState(signState);

        final State endState = new State("end", true);
        endState.addTransitionRange('0', '9', "end");
        this.addState(endState);

        final State zeroEndState = new State("zero_end", true);
        this.addState(zeroEndState);
    }

    @Override
    public String getStartState() {
        return "start";
    }

    public compiler.TokenIntf.Type getType() {
        return compiler.TokenIntf.Type.INTEGER;
    }
}
