public class TestCharacterliteralMachine {

    public void test( String input ) throws Exception {
        compiler.StateMachine characterliteralMachine = new compiler.machines.CharacterliteralMachine();
        java.io.OutputStreamWriter outWriter = new java.io.OutputStreamWriter(System.out);
        characterliteralMachine.process( input, outWriter);
    }

}
