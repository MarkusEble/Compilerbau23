package compiler;

public interface CompileEnvIntf {
	/**
	 *  add instruction at end of current block
	 */
	public void addInstr(InstrIntf instr);
	
	/**
	 *  create new instruction block
	 */
	public InstrBlock createBlock();
	public InstrBlock createBlock(String name);
	
	/**
	 *  set current instruction block
	 */
	public void setCurrentBlock(InstrBlock instrBlock);
	
	/**
	 *  get current instruction block
	 */
	public InstrBlock getCurrentBlock();

	/**
	 *  get symbol table
	 */
	public SymbolTable getSymbolTable();

	/**
	 *  get function table
	 */
	public FunctionTable getFunctionTable();

	void pushLoopStack(InstrBlock instrBlock);

	InstrBlock peekLoopStack();

	InstrBlock popLoopStack();

	Symbol createUniqueSymbol(String prefix);

}
