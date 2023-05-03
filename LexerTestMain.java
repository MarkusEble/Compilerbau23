import java.io.OutputStreamWriter;

public class LexerTestMain {

    public static void main(String[] args) throws Exception {
        // open input file
        String testSuiteContent = compiler.InputReader.fileToString("LexerTestInput.txt");
        /*compiler.InputReader inputReader = new compiler.InputReader(testSuiteContent);

        // parse test content
        java.util.Vector<test.TestCaseContent> testCaseContentArr = parseTestSuite(inputReader);

        // output test content
        OutputStreamWriter outStream = new OutputStreamWriter(System.out, "UTF-8");
        for (test.TestCaseContent testCaseContent : testCaseContentArr) {
            testCaseContent.toStream(outStream);
        }
        outStream.flush();*/

        compiler.InputReader inputReader = new compiler.InputReader(testSuiteContent);
        test.TestSuite testSuite = new test.TestSuite();
        testSuite.execute(inputReader, new LexerTest());
    }

    public static java.util.Vector<test.TestCaseContent> parseTestSuite(compiler.InputReader inputReader) throws Exception {
        java.util.Vector<test.TestCaseContent> testCaseContentArr = new java.util.Vector<test.TestCaseContent>();
        while (inputReader.lookAheadChar() != 0 ) {
            testCaseContentArr.addElement(parseTestCase(inputReader));
        }
        return testCaseContentArr;
    }

    public static test.TestCaseContent parseTestCase(compiler.InputReader inputReader) throws Exception {
        parseDollarIn(inputReader);
        String input = parseInput(inputReader);
        parseDollarOut(inputReader);
        String expectedOutput = parseExpectedOutput(inputReader);
        test.TestCaseContent testCaseContent = new test.TestCaseContent(input, expectedOutput);
        return testCaseContent;
    }

    public static void parseDollarIn(compiler.InputReader inputReader) throws Exception {
		inputReader.expect('$');
		inputReader.expect('I');
		inputReader.expect('N');
		inputReader.expect('\n');
    }

    public static String parseInput(compiler.InputReader inputReader) throws Exception {
        String input = new String();
        while (inputReader.lookAheadChar() != '$' && inputReader.lookAheadChar() != 0) {
            input += inputReader.lookAheadChar();
            inputReader.advance();
        }
        return input;
    }

    public static void parseDollarOut(compiler.InputReader inputReader) throws Exception {
		inputReader.expect('$');
		inputReader.expect('O');
		inputReader.expect('U');
		inputReader.expect('T');
		inputReader.expect('\n');
    }
    
    public static String parseExpectedOutput(compiler.InputReader inputReader) throws Exception {
        String expectedOutput = new String();
        while (inputReader.lookAheadChar() != '$' && inputReader.lookAheadChar() != 0) {
            expectedOutput += inputReader.lookAheadChar();
            inputReader.advance();
        }
        return expectedOutput;
    }

}
