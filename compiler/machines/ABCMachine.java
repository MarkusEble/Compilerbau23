package compiler.machines;

public class ABCMachine extends compiler.StateMachine {

    @Override
    public void initStateTable() {
        compiler.State startState = new compiler.State("start", false);
        startState.addTransition('A', "after_a");
        addState(startState);
        compiler.State afterAState = new compiler.State("after_a", false);
        afterAState.addTransition('B', "after_a");
        afterAState.addTransition('C', "end");
        addState(afterAState);
        compiler.State endState = new compiler.State("end", true);
        addState(endState);
    }

    @Override
    public String getStartState() {
        return "start";
    }

    public compiler.TokenIntf.Type getType() {
        return compiler.TokenIntf.Type.EOF;
    }
    
}
