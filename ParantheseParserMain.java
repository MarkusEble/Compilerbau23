import java.io.OutputStreamWriter;

public class ParantheseParserMain {

    public static void main(String[] args) throws Exception {
        compiler.Lexer lexer = new compiler.Lexer();
        OutputStreamWriter outStream = new OutputStreamWriter(System.out, "UTF-8");

        lexer.init("(())");
        parseS(lexer);
        if (lexer.lookAhead().m_type == compiler.TokenIntf.Type.EOF) {
            outStream.write("ACCEPTED");
        } else {
            outStream.write("FAILED");
        }
        outStream.flush();
    }

    public static void parseS(compiler.Lexer lexer) throws Exception {
        compiler.Token currentToken = lexer.lookAhead();
        if (currentToken.m_type == TokenIntf.Type.LPAREN) {
            // S : (S)
            lexer.expect(TokenIntf.Type.LPAREN);
            parseS(lexer);
            lexer.expect(TokenIntf.Type.RPAREN);
        } else if (currentToken.m_type == TokenIntf.Type.RPAREN || currentToken.m_type == TokenIntf.Type.EOF) {
            // S : epsilon
        } else {
            lexer.throwCompilerException("invalid paranthese expression", "");
        }
    }
}
