package compiler;

public interface LexerParserIntf {

    /**
     * initialize the lexer with the given input
     */
    public void init(String input) throws Exception;

    /**
     * returns the token on the current read position of the lexer
     */
    public Token lookAhead();

    /**
     * advances the lexer by one token
     * consumes the current token from input and reads the next one
     * skips whitespace and comments
     */
    public void advance() throws Exception;

    /**
     * compares the current token to the expected token
     * token is consumed in case of match
     * throws in case of mismatch
     */
    public void expect(Token.Type tokenType) throws Exception;

    /**
     * compares the current token to the provided token
     * token is consumed in case of match
     * no change in case of mismatch
     * returns true in case of match
     */
    public boolean accept(Token.Type tokenType) throws Exception;
    
    /**
     * throws a compiler exception with the given reason and expected input
     * adds current code location to the exception
     */
    public void throwCompilerException(String reason, String expected) throws Exception;
}
