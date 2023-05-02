package test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

import compiler.InputReader;

public class TestSuite implements TestSuiteIntf {

    @Override
    public void execute(InputReader testCaseSequence, TestCaseIntf testCase) throws Exception {
        // parse test content
        java.util.Vector<test.TestCaseContent> testCaseContentArr = parseTestSuite(testCaseSequence);

        // execute all test cases
        for (test.TestCaseContent testCaseContent : testCaseContentArr) {
            executeTestCase(testCaseContent.getInput(), testCaseContent.getExpectedOutput(), testCase);
        }        
    }
    
    @Override
    public void executeTestCase(String input, String expectedOutput, TestCaseIntf testCase) throws Exception {
		String result;
		try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
            testCase.executeTest(input, outStreamWriter);
            result = outStream.toString("UTF-8");
		} catch (Exception e) {
			result = "exception: \"";
			result += e.getMessage();
			result += "\"\n";
		}
		if (result.equals(expectedOutput)) {
			System.out.println("TEST SUCCEEDED");
			System.out.print(input);
			System.out.println("ACTUAL OUTPUT");			
			System.out.print(result);
		} else {
			System.out.println("TEST FAILED");
			System.out.print(input);
			System.out.println("EXPECTED OUTPUT");			
			System.out.print(expectedOutput);
			System.out.println("ACTUAL OUTPUT");			
			System.out.print(result);
			throw new Exception("TestFailure");
		}        
    }

    private java.util.Vector<test.TestCaseContent> parseTestSuite(compiler.InputReader inputReader) throws Exception {
        java.util.Vector<test.TestCaseContent> testCaseContentArr = new java.util.Vector<test.TestCaseContent>();
        while (inputReader.lookAheadChar() != 0 ) {
            testCaseContentArr.addElement(parseTestCase(inputReader));
        }
        return testCaseContentArr;
    }

    private test.TestCaseContent parseTestCase(compiler.InputReader inputReader) throws Exception {
        parseDollarIn(inputReader);
        String input = parseInput(inputReader);
        parseDollarOut(inputReader);
        String expectedOutput = parseExpectedOutput(inputReader);
        test.TestCaseContent testCaseContent = new test.TestCaseContent(input, expectedOutput);
        return testCaseContent;
    }

    private void parseDollarIn(compiler.InputReader inputReader) throws Exception {
		inputReader.expect('$');
		inputReader.expect('I');
		inputReader.expect('N');
		inputReader.expect('\n');
    }

    private String parseInput(compiler.InputReader inputReader) throws Exception {
        String input = new String();
        while (inputReader.lookAheadChar() != '$' && inputReader.lookAheadChar() != 0) {
            input += inputReader.lookAheadChar();
            inputReader.advance();
        }
        return input;
    }

    private void parseDollarOut(compiler.InputReader inputReader) throws Exception {
		inputReader.expect('$');
		inputReader.expect('O');
		inputReader.expect('U');
		inputReader.expect('T');
		inputReader.expect('\n');
    }
    
    private String parseExpectedOutput(compiler.InputReader inputReader) throws Exception {
        String expectedOutput = new String();
        while (inputReader.lookAheadChar() != '$' && inputReader.lookAheadChar() != 0) {
            expectedOutput += inputReader.lookAheadChar();
            inputReader.advance();
        }
        return expectedOutput;
    }

}
