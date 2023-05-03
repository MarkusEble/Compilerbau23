package test;

import java.io.OutputStreamWriter;

public class TestCaseContent {
    private String m_input;
    private String m_expectedOutput;

    public TestCaseContent(String input, String expectedOutput) {
        m_input = input;
        m_expectedOutput = expectedOutput;
    }

    public void toStream(OutputStreamWriter outStream) throws Exception {
        outStream.write("Input:\n");
        outStream.write(m_input);
        outStream.write("Expected Output:\n");
        outStream.write(m_expectedOutput);
    }

    public String getInput() {
        return m_input;
    }

    public String getExpectedOutput() {
        return m_expectedOutput;
    }
}
