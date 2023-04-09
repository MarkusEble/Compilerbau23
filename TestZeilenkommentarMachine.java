import compiler.StateMachine;
import compiler.machines.ZeilenkommentarMachine;

import java.io.OutputStreamWriter;

public class TestZeilenkommentarMachine {

    public static void main(String[] args) throws Exception {
        System.out.println("Zeilenumbrüche entstehen duch \\n im Test String :)");
        StateMachine zeilenkkommentarMachine = new ZeilenkommentarMachine();
        java.io.OutputStreamWriter outWriter = new OutputStreamWriter(System.out);
        zeilenkkommentarMachine.process("// Test + (test) = 0.25 * test \\ \n", outWriter);
    }
}
