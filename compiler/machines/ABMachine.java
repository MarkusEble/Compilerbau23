package compiler.machines;

public class ABMachine extends compiler.StateMachine {
    
    public void initStateTable() {
        compiler.State startState = new compiler.State("start", false);
        startState.addTransition('A', "start");
        startState.addTransition('B', "expectB");
        addState(startState);
        compiler.State expectBState = new compiler.State("expectB", true);
        expectBState.addTransition('B', "expectB");
        addState(expectBState);
    }

    @Override
    public String getStartState() {
        return "start";
    }
   
}


