package compiler;

public interface MultiLineInputReaderIntf {

    // read current info
    int getLine();
    int getCol();   
    boolean isEmpty();
    char currentChar();
    String currentLine();
    /** 
     * return complete remaining input
     */
    String getRemaining();

    // processing

    /**
     * move reader to the next character
     */
    void advance();
    
    /**
     * move reader cnt characters ahead and return the text in between
     */
    String advanceAndGet(int cnt);

    // helper for error messages

    // get code snippet; critical part market with ^
    String getMarkedCodeSnippet(int startLine, int startCol, int endLine, int endCol);

    String getMarkedCodeSnippetCurrentPos();
}
