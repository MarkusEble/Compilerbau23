package compiler;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class CompileEnv implements CompileEnvIntf {
    private SymbolTable m_symbolTable;
    private FunctionTable m_functionTable;
    private Lexer m_lexer;
    private Parser m_parser;
    compiler.ast.ASTStmtNode m_root;
    private InstrBlock m_entry;
    private InstrBlock m_currentBlock;
    private ArrayList<InstrBlock> m_blockList;
    private final boolean m_trace;
    private int m_nextBlockId = 0;
    private Stack<InstrBlock> loopStack;

    private long uniqueSymbolCounter = 0;


    // cool kids would use a dedicated compile env config class for that...
    public CompileEnv(String input, boolean trace) throws Exception {
        m_trace = trace;
        m_symbolTable = new SymbolTable();
        m_functionTable = new FunctionTable();
        m_lexer = new Lexer();
        m_lexer.init(input);
        m_parser = new Parser(m_lexer, this.m_symbolTable, m_functionTable);
        m_blockList = new ArrayList<InstrBlock>();
        loopStack = new Stack<InstrBlock>();
    }
    
    public InstrBlock popLoopStack(){
        return this.loopStack.pop();
    }

    @Override
    public Symbol createUniqueSymbol(String prefix) {
        return m_symbolTable.createSymbol("$" + prefix + "_" + uniqueSymbolCounter++);
    }

    public void pushLoopStack(InstrBlock instrBlock){
        this.loopStack.push(instrBlock);
    }

    public InstrBlock peekLoopStack(){
        return this.loopStack.peek();
    }

    public void compile() throws Exception {
        m_entry = new InstrBlock("entry");
        m_blockList.add(m_entry);
        m_currentBlock = m_entry;
        m_root = m_parser.getStmtList();
        m_root.codegen(this);
    }

    public void dumpAst(OutputStream outStream) throws Exception {
        OutputStreamWriter os = new OutputStreamWriter(outStream, "UTF-8");
        m_root.print(os, "");
        os.flush();
    }

    public void dump(OutputStream outStream) throws Exception {
    	OutputStreamWriter os = new OutputStreamWriter(outStream, "UTF-8");
		Iterator<InstrBlock> blockIter = m_blockList.listIterator();
	    while (blockIter.hasNext()) {
	        InstrBlock nextBlock = blockIter.next();
	        nextBlock.dump(os);
	        os.write("\n");
	    }
	    os.flush();
    }

    public void execute(OutputStreamWriter outStream) throws Exception {
        ExecutionEnv env = new ExecutionEnv(m_functionTable, m_symbolTable, outStream, m_trace);
        env.execute(m_entry.getIterator());
    }

    public void addInstr(InstrIntf instr) {
        m_currentBlock.addInstr(instr);
    }

    public InstrBlock createBlock() {
        InstrBlock newBlock = new InstrBlock(Integer.toString(m_nextBlockId));
        m_nextBlockId++;
        m_blockList.add(newBlock);
        return newBlock;
    }

    public InstrBlock createBlock(String name) {
        InstrBlock newBlock = new InstrBlock(name + "_" + Integer.toString(m_nextBlockId));
        m_nextBlockId++;
        m_blockList.add(newBlock);
        return newBlock;
    }

    public void setCurrentBlock(InstrBlock instrBlock) {
        m_currentBlock = instrBlock;
    }

    public InstrBlock getCurrentBlock() {
        return m_currentBlock;
    }

    public SymbolTable getSymbolTable() {
        return m_symbolTable;
    }

    public FunctionTable getFunctionTable() {
        return m_functionTable;
    }
}
