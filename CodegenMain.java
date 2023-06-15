import java.io.OutputStreamWriter;

public class CodegenMain {

    public static void main(String[] args) throws Exception {
        String program = compiler.InputReader.fileToString("Statement.txt");
        compiler.CompileEnv env = new compiler.CompileEnv(program, false);
        env.compile();
        env.dump(System.out);
        OutputStreamWriter outStream = new OutputStreamWriter(System.out);
        env.execute(outStream);
    }
}
