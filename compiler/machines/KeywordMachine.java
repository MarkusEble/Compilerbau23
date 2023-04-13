package compiler.machines;

import compiler.State;
import compiler.StateMachine;

public class KeywordMachine extends StateMachine{

    private final String keyword;
    private compiler.TokenIntf.Type m_type;


    public KeywordMachine(String keyword, compiler.TokenIntf.Type type) {
        this.keyword = keyword;
        this.m_type = type;
    }

    @Override
    public void initStateTable() {
        final State startState = new State("start", false);
        startState.addTransition(keyword.charAt(0), String.valueOf(keyword.charAt(0)));
        this.addState(startState);

        for (int i = 0; i < keyword.length(); i++) {
            final String name = keyword.substring(0, i + 1);
            final State state = new State(name,  i == keyword.length() - 1);
            if (!state.isFinal()) {
                state.addTransition(keyword.charAt(i + 1), name + keyword.charAt(i + 1));
            }
            this.addState(state);
        }
    }

    @Override
    public String getStartState() {
        return "start";
    }

    public compiler.TokenIntf.Type getType() {
        return m_type;
    }
}
