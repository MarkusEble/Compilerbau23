import compiler.Lexer;
import compiler.TokenIntf;

import java.io.*;

public class TestSuiteParser {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("data/TestSuiteData.txt"));
        compiler.Lexer lexer = new compiler.Lexer();
        OutputStreamWriter outStream = new OutputStreamWriter(System.out, "UTF-8");

        StringBuilder data = new StringBuilder();
        while (reader.ready()) {
            data.append(reader.readLine());
            data.append("\n");
            System.out.println(data);
        }
        lexer.init(data.toString());

        parseTest(lexer);
        if (lexer.lookAhead().m_type == compiler.TokenIntf.Type.EOF) {
            outStream.write("ACCEPTED");
        } else {
            outStream.write("FAILED");
        }
        outStream.flush();
    }

    public static void parseTest(compiler.Lexer lexer) throws Exception {
        compiler.Token currentToken = lexer.lookAhead();
        if (currentToken.m_type == TokenIntf.Type.INPUT || currentToken.m_type == TokenIntf.Type.EOF ) { // P1: Testsuite
            lexer.expect(TokenIntf.Type.INPUT);
            parseTest(lexer);
        } else  if (currentToken.m_type == TokenIntf.Type.INPUT || currentToken.m_type == TokenIntf.Type.EOF) { // P2: Testsuite
            lexer.expect(TokenIntf.Type.INPUT);
            parseTest(lexer);
        } else if (currentToken.m_type == TokenIntf.Type.INPUT) { // P3: Testcase
            lexer.expect(TokenIntf.Type.INPUT);
            parseTest(lexer);
        } else if (currentToken.m_type == TokenIntf.Type.STRING) { // P4: INPUT
            lexer.expect(TokenIntf.Type.STRING);
            parseTest(lexer);
            lexer.expect(TokenIntf.Type.OUTPUT);
        } else if (currentToken.m_type == TokenIntf.Type.STRING) {
            lexer.expect(TokenIntf.Type.STRING);
            parseTest(lexer);
        }else {
            lexer.throwCompilerException("invalid something", "");
        }
    }
}
