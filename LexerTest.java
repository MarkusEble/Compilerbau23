import java.io.OutputStreamWriter;

public class LexerTest implements test.TestCaseIntf {

    @Override
    public void executeTest(String input, OutputStreamWriter outputWriter) throws Exception {
        compiler.Lexer lexer = new compiler.Lexer();
        lexer.init(input);
        while (lexer.lookAhead().m_type != compiler.TokenIntf.Type.EOF) {
            compiler.Token curToken = lexer.lookAhead();
            outputWriter.write(curToken.toString() + "\n");
            lexer.advance();
        }
        outputWriter.flush();
    }

}
