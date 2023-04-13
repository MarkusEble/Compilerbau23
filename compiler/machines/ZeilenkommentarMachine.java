package compiler.machines;

public class ZeilenkommentarMachine extends compiler.StateMachine{
    @Override
    public void initStateTable() {
        compiler.State startState = new compiler.State("start", false);
        startState.addTransition('/',"oneSlash");
        addState(startState);

        compiler.State oneSlashState = new compiler.State("oneSlash", false);
        oneSlashState.addTransition('/', "commentState");
        addState(oneSlashState);

        compiler.State commentState = new compiler.State("commentState", false);
        commentState.addTransition('\n', "end");
        commentState.addTransition(' ', "commentState");
        commentState.addTransition('-', "commentState");
        commentState.addTransition('_', "commentState");
        commentState.addTransition('*', "commentState");
        commentState.addTransition('+', "commentState");
        commentState.addTransition('-', "commentState");
        commentState.addTransition('=', "commentState");
        commentState.addTransition('/', "commentState");
        commentState.addTransition('\\', "commentState");
        commentState.addTransition('(', "commentState");
        commentState.addTransition(')', "commentState");
        commentState.addTransition('.', "commentState");
        commentState.addTransition(',', "commentState");
        commentState.addTransitionRange('0','9', "commentState");
        commentState.addTransitionRange('a','z', "commentState");
        commentState.addTransitionRange('A','Z', "commentState");
        addState(commentState);



/*        compiler.State backSlashState = new compiler.State("backSlash", false);
        backSlashState.addTransition('n', "end");
        backSlashState.addTransition(' ', "twoSlash");
        backSlashState.addTransitionRange('0','9', "twoSlash");
        backSlashState.addTransitionRange('a','m', "twoSlash");
        backSlashState.addTransitionRange('o','z', "twoSlash");
        backSlashState.addTransitionRange('A','Z', "twoSlash");
        addState(backSlashState);*/

        compiler.State endState = new compiler.State("end", true);
        addState(endState);

    }

    @Override
    public String getStartState() {
        return "start";
    }

    public compiler.TokenIntf.Type getType() {
        return compiler.TokenIntf.Type.LINECOMMENT;
    }
}
