public class TestKeywordMachine {

    public static void main(String[] args) throws Exception {
        compiler.StateMachine keyWordMachine = new compiler.machines.KeywordMachine("If", compiler.TokenIntf.Type.IF); //Keyword that should be accepted
        java.io.OutputStreamWriter outWriter = new java.io.OutputStreamWriter(System.out);
        keyWordMachine.process("If", outWriter);
    }
}
