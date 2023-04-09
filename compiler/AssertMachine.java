package compiler;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class AssertMachine {

    public static final OutputStreamWriter NULL_STEAM_WRITER = new OutputStreamWriter(new NullOutputStream());

    public static class NullOutputStream extends OutputStream {
        @Override
        public void write(int b) {
            // :)
        }
    }

    private static void assertFinalState(final StateMachine machine,
                                         final String string,
                                         final boolean isFinalState) throws Exception {
        machine.process(string, AssertMachine.NULL_STEAM_WRITER);
        if (isFinalState != machine.isFinalState()) {
            throw new IllegalStateException(String.format("[%s] expected machine to %s for input '%s'",
                    machine.getClass().getSimpleName(), (isFinalState ? "ACCEPT" : "FAIL"), string));
        }
    }

    public static void assertAccept(final StateMachine machine, final String input) throws Exception {
        AssertMachine.assertFinalState(machine, input, true);
    }

    public static void assertAllAccept(final StateMachine machine, final String...inputs) throws Exception {
        for (final String input : inputs) {
            AssertMachine.assertFinalState(machine, input, true);
        }
    }

    public static void assertFail(final StateMachine machine, final String input) throws Exception {
        AssertMachine.assertFinalState(machine, input, false);
    }

    public static void assertAllFail(final StateMachine machine, final String...inputs) throws Exception {
        for (final String input : inputs) {
            AssertMachine.assertFinalState(machine, input, false);
        }
    }

    public static void assertAllMultiAcceptFail(final StateMachine machine,
                                                final String[] assertAccept,
                                                final String[] assertFail) throws Exception {
        AssertMachine.assertAllAccept(machine, assertAccept);
        AssertMachine.assertAllFail(machine, assertFail);
    }

}
