package compiler.machines;

public class StringliteralMachine extends compiler.StateMachine {
  @Override
  public void initStateTable() {
    compiler.State startState = new compiler.State("start", false);
    startState.addTransition('"', "in_string");
    addState(startState);

    compiler.State afterState = new compiler.State("in_string",false);
    String asciiString = "";
    for (int i = 0; i <= 127; i++) {
        asciiString += (char)i;
    }
    for(int i = 0; i < asciiString.length(); i++){
        char c = asciiString.charAt(i);
        afterState.addTransition(c, "in_string");
    }
    addState(afterState);

    afterState.addTransition('"', "end");
    compiler.State endState = new compiler.State("end", true);
    addState(endState);
  }

  @Override
  public String getStartState() {
    return "start";
  }
}