import compiler.StateMachine;
import compiler.machines.IntegerMachine;

import java.io.OutputStreamWriter;

public class TestIntegerMachine {

    public static void main(final String[] args) throws Exception {
        final String[] testsOk = {
                "0",
                "+0",
                "-0",
                "1",
                "12",
                "12",
                "101",
                "-121",
                "-101",
                "12390309483840534089535",
                "+653234"
        };
        final String[] testFail = {
                "01",
                "-01",
                "+01",
                "123ab456",
                "a1",
        };

        for (final String s : testsOk) {
            final StateMachine abMachine = new IntegerMachine();
            final OutputStreamWriter outWriter = new OutputStreamWriter(System.out);
            abMachine.process(s, outWriter);
            if (!abMachine.isFinalState()) {
                throw new Exception("expected state machine to ACCEPT: " + s);
            }
        }

        System.out.println("\n\nNOW FAIL\n\n");

        for (final String s : testFail) {
            final StateMachine abMachine = new IntegerMachine();
            final OutputStreamWriter outWriter = new OutputStreamWriter(System.out);
            abMachine.process(s, outWriter);
            if (abMachine.isFinalState()) {
                throw new Exception("expected state machine to ACCEPT: " + s);
            }
        }


    }

}
