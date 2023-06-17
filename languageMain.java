import java.io.OutputStreamWriter;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class languageMain {

	public static void main(String[] args) throws Exception {
		// create input stream
		CharStream input = CharStreams.fromFileName("language.txt");
		// create lexer
		antlrcompiler.languageLexer lexer = new antlrcompiler.languageLexer(input);
		// create token stream
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// create parser
		antlrcompiler.languageParser parser = new antlrcompiler.languageParser(tokens);
		parser.setBuildParseTree(true);
		// build parse tree
		ParseTree tree = parser.sumExpr();

        OutputStreamWriter outStream = new OutputStreamWriter(System.out, "UTF-8");
        outStream.write("\nAST: \n");
        ParseTreeVisitor<compiler.ast.ASTNode> treeVisitor = new MyLanguageVisitor();
        compiler.ast.ASTExprNode rootNode = (compiler.ast.ASTExprNode)treeVisitor.visit(tree);
        rootNode.print(outStream, new String());
        outStream.flush();
        System.out.println(rootNode.eval());
    }
}
