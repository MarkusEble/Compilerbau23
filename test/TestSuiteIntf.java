package test;


public interface TestSuiteIntf {

	// execute a suite of test cases read from input reader
	void execute(compiler.InputReader testCaseSequence, TestCaseIntf testCase) throws Exception;

	// execute a single test case with input and expected output
	void executeTestCase(String input, String expectedOutput, TestCaseIntf testCase) throws Exception;
}
