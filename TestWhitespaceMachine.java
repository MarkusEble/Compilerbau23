import compiler.StateMachine;
import compiler.machines.WhitespaceMachine;

import java.io.OutputStreamWriter;

public class TestWhitespaceMachine {

  public static void main(String[] args) throws Exception {
    StateMachine whitespaceMachine = new WhitespaceMachine();
    OutputStreamWriter outWriter = new OutputStreamWriter(System.out);

    final String INPUT = " \n\t\r";
    whitespaceMachine.process(INPUT, outWriter);
  }

}
