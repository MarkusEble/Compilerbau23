package compiler.machines;

import compiler.State;
import compiler.StateMachine;

public class CharacterliteralMachine extends StateMachine {

    @Override
    public void initStateTable() {
        State start = new State("start", false);
        start.addTransition('\'', "inner");
        addState(start);

        // handle sequences, escaping by \
        State inner = new State("inner", false);
        inner.addTransitionRange(' ', '[', "afterChar");
        inner.addTransitionRange(']', '~', "afterChar");
        inner.addTransition('\\', "escaped");
        addState(inner);

        // handle escape sequences
        State escaped = new State("escaped", false);
        escaped.addTransition('t', "afterChar");
        escaped.addTransition('b', "afterChar");
        escaped.addTransition('n', "afterChar");
        escaped.addTransition('r', "afterChar");
        escaped.addTransition('f', "afterChar");
        escaped.addTransition('\'', "afterChar");
        escaped.addTransition('"', "afterChar");
        escaped.addTransition('\\', "afterChar");
        addState(escaped);

        State afterChar = new State("afterChar", false);
        afterChar.addTransition('\'', "end");
        addState(afterChar);

        State end = new State("end", true);
        addState(end);
    }

    @Override
    public String getStartState() {
        return "start";
    }

    public compiler.TokenIntf.Type getType() {
        return compiler.TokenIntf.Type.CHAR;
    }

}
