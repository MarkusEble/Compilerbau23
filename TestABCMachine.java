public class TestABCMachine {

  public static void main(String[] args) throws Exception {
    compiler.StateMachine abcMachine = new compiler.machines.ABCMachine();
    java.io.OutputStreamWriter outWriter = new java.io.OutputStreamWriter(System.out);
    abcMachine.process("ABCB", outWriter);
    System.out.print(abcMachine.asDot());
  }
}
