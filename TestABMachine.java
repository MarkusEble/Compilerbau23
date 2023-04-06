public class TestABMachine {

  public static void main(String[] args) throws Exception {
    System.out.println("AABBBB");
    compiler.StateMachine abMachine = new compiler.machines.ABMachine();
    java.io.OutputStreamWriter outWriter = new java.io.OutputStreamWriter(System.out);
    abMachine.process("AABBBB", outWriter);
  }
}
