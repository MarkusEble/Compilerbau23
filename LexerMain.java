import java.io.OutputStreamWriter;

public class LexerMain {

    public static void main(String[] args) throws Exception {
        compiler.Lexer lexer = new compiler.Lexer();
        OutputStreamWriter outStream = new OutputStreamWriter(System.out, "UTF-8");

        lexer.processInput("12 45 3.4", outStream);
        lexer.processInput("1AB-2", outStream);
    }

}
