import compiler.Token;
import compiler.TokenIntf;

import java.io.OutputStreamWriter;

public class ParantheseParserMain {

    public static void main(String[] args) throws Exception {
        compiler.Lexer lexer = new compiler.Lexer();
        OutputStreamWriter outStream = new OutputStreamWriter(System.out, "UTF-8");

        lexer.init("((()))");
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
<<<<<<< HEAD
         if (currentToken.m_type == TokenIntf.Type.LPAREN) {
             lexer.expect(TokenIntf.Type.LPAREN);
             parseS(lexer);
             lexer.expect(TokenIntf.Type.RPAREN);
             // S : (S)
        } else if (currentToken.m_type == TokenIntf.Type.RPAREN || currentToken.m_type == TokenIntf.Type.EOF) {
=======
        if (currentToken.m_type == compiler.TokenIntf.Type.LPAREN) {
            // S : (S)
            lexer.expect(compiler.TokenIntf.Type.LPAREN);
            parseS(lexer);
            lexer.expect(compiler.TokenIntf.Type.RPAREN);
        } else if (currentToken.m_type == compiler.TokenIntf.Type.RPAREN || currentToken.m_type == compiler.TokenIntf.Type.EOF) {
>>>>>>> 5c44ba4c4ed6136259a72d2c0264a10061c22593
            // S : epsilon
        } else {
            lexer.throwCompilerException("invalid paranthese expression", "");
        }
    }

}
