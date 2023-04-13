import compiler.machines.DecimalMachine;

public class TestDecimalMachine {

    private static final String[] acceptCases = {
        "0.0",
        "1.5320",
        "0.5320",
        "-1.5320",
        "-0.5320",
        "-10012323.532",
        "10012323.532e5",
        "10012323.532E-5"
    };

    private static final String[] denyCases = {
        "0",
        "01.0",
        "1.",
        "01.5320",
        "01.532",
        "-01.5320",
        "-01.532",
        "10012323.532e-5.5",
        "10012323.532E-5.5",
        "10012323.532E05"
    };
    
    public static void main(String[] args) throws Exception {
        compiler.StateMachine decimalMachine;
        java.io.OutputStreamWriter outWriter = new java.io.OutputStreamWriter(System.out);

        // Accept cases:
        for(final String input : acceptCases) {
            decimalMachine = new DecimalMachine();
            decimalMachine.process(input, outWriter);
            if(!decimalMachine.isFinalState())
                throw new Exception("Machine should have returned ACCEPT with input '" + input + "'");
        }

        // Deny cases:
        for(final String input : denyCases) {
            decimalMachine = new DecimalMachine();
            decimalMachine.process(input, outWriter);
            if(decimalMachine.isFinalState())
                throw new Exception("Machine should have returned FAIL with input '" + input + "'");

        }
    }
}
