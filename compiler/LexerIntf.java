package compiler;

import java.io.OutputStreamWriter;

public interface LexerIntf {

    // construction

    /**
     * adds a state machine to recognize a keyword with a given token type
     */
    public void addKeywordMachine(String keyword, TokenIntf.Type tokenType);

    /**
     *  add a state machine to recognize input tokens
     */
    public void addMachine(StateMachineIntf machine);


    // processing

    /**
     * initialize all state machines with the given input string
     */
    public void initMachines(String input);

    /**
     * extract next token from input
     */
    public Token nextWord() throws Exception;

    /**
     * process an input string and print all identified tokens to outStream
     */
    public void processInput(String input, OutputStreamWriter outStream) throws Exception;
    
}
