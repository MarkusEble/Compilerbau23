public class TestZeilenkommentarMachine {

    public static void main(String[] args) throws Exception {
        System.out.println("Zeilenumbrüche entstehen duch \\n im Test String :)");
        compiler.StateMachine zeilenkkommentarMachine = new compiler.machines.ZeilenkommentarMachine();
        java.io.OutputStreamWriter outWriter = new java.io.OutputStreamWriter(System.out);
        zeilenkkommentarMachine.process("// Test + (test) = 0.25 * test \\ \n", outWriter);
    }
}
