import compiler.StateMachine;
import compiler.machines.CharacterliteralMachine;

import java.io.OutputStreamWriter;

public class TestCharacterliteralMachine {

    public void test( String input ) throws Exception {
        final StateMachine characterliteralMachine = new CharacterliteralMachine();
        final OutputStreamWriter outWriter = new OutputStreamWriter(System.out);
        characterliteralMachine.process( input, outWriter);
    }

}
