package compiler.machines;

import compiler.StateMachine;

public class Identifier extends StateMachine{

    @Override
    public void initStateTable() {
        compiler.State startState = new compiler.State("start", false);
        startState.addTransition('_', "endState");
        startState.addTransitionRange('a', 'z', "endState");
        startState.addTransitionRange('A', 'Z', "endState");
        addState(startState);
        compiler.State endState = new compiler.State("endState", true);
        endState.addTransition('_', "endState");
        endState.addTransitionRange('a', 'z', "endState");
        endState.addTransitionRange('A', 'Z', "endState");
        endState.addTransitionRange('0', '9', "endState");
        addState(endState);
    }

    @Override
    public String getStartState() {
        return "start";
    }

    public compiler.TokenIntf.Type getType() {
        return compiler.TokenIntf.Type.IDENT;
    }
        //compiler.StateMachine identifier = new compiler.machines.Identifier();
    //identifier.process("aB5", outWriter);
    //identifier.process("_2cc", outWriter);
    //identifier.process("___", outWriter);
    
}