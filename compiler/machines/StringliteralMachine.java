package compiler.machines;

public class StringliteralMachine extends compiler.StateMachine {
  @Override
  public void initStateTable() {
    compiler.State startState = new compiler.State("start", false);
    startState.addTransition('"', "in_string");
    addState(startState);

    compiler.State afterState = new compiler.State("in_string",false);
    afterState.addTransitionRange('!', '~', "in_string");
    afterState.addTransition('"', "end");
    addState(afterState);

    compiler.State endState = new compiler.State("end", true);
    addState(endState);
  }

  @Override
  public String getStartState() {
    return "start";
  }

  public compiler.TokenIntf.Type getType() {
    return compiler.TokenIntf.Type.STRING;
  }
}