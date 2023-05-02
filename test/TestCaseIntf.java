package test;
import java.io.OutputStreamWriter;

public interface TestCaseIntf {
	
	// executes test case on 
	void executeTest(String input, OutputStreamWriter outputWriter) throws Exception;
}
