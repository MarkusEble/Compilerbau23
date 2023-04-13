package compiler;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import compiler.machines.CharacterliteralMachine;
import compiler.machines.DecimalMachine;
import compiler.machines.IntegerMachine;
import compiler.machines.KeywordMachine;
import compiler.machines.ZeilenkommentarMachine;
import compiler.machines.WhitespaceMachine;

public class Lexer implements LexerIntf {

    static class MachineInfo {

        public StateMachineIntf m_machine;
        public int m_acceptPos;

        public MachineInfo(StateMachineIntf machine) {
            m_machine = machine;
            m_acceptPos = 0;
        }

        public void init(String input) {
            m_acceptPos = 0;
            m_machine.init(input);
        }
    }

    protected Vector<MachineInfo> m_machineList;
    protected MultiLineInputReader m_input;
    protected Token m_currentToken;

    public Lexer() {
        m_machineList = new Vector<MachineInfo>();
        addLexerMachines();
    }

    private void addLexerMachines() {
        addMachine(new IntegerMachine());
        addMachine(new DecimalMachine());
        //addMachine(new StringLiteralMachine());
        addMachine(new CharacterliteralMachine());
        addKeywordMachine("*", TokenIntf.Type.MUL);
        addKeywordMachine("/", TokenIntf.Type.DIV);
        addKeywordMachine("+", TokenIntf.Type.PLUS);
        addKeywordMachine("-", TokenIntf.Type.MINUS);
        addKeywordMachine("&", TokenIntf.Type.BITAND);
        addKeywordMachine("|", TokenIntf.Type.BITOR);
        addKeywordMachine("<<", TokenIntf.Type.SHIFTLEFT);
        addKeywordMachine(">>", TokenIntf.Type.SHIFTRIGHT);
        addKeywordMachine("==", TokenIntf.Type.EQUAL);
        addKeywordMachine("<", TokenIntf.Type.LESS);
        addKeywordMachine(">", TokenIntf.Type.GREATER);
        addKeywordMachine("!", TokenIntf.Type.NOT);
        addKeywordMachine("&&", TokenIntf.Type.AND);
        addKeywordMachine("||", TokenIntf.Type.OR);
        addKeywordMachine("?", TokenIntf.Type.QUESTIONMARK);
        addKeywordMachine(":", TokenIntf.Type.DOUBLECOLON);
        addKeywordMachine("(", TokenIntf.Type.LPAREN);
        addKeywordMachine(")", TokenIntf.Type.RPAREN);
        addKeywordMachine("{", TokenIntf.Type.LBRACE);
        addKeywordMachine("}", TokenIntf.Type.RBRACE);
        addMachine(new ZeilenkommentarMachine());
        addMachine(new WhitespaceMachine());
        addKeywordMachine(";", TokenIntf.Type.SEMICOLON);
        addKeywordMachine(",", TokenIntf.Type.COMMA);
        addKeywordMachine("=", TokenIntf.Type.ASSIGN);

        addKeywordMachine("DECLARE", TokenIntf.Type.DECLARE);
        addKeywordMachine("PRINT", TokenIntf.Type.PRINT);
        addKeywordMachine("IF", TokenIntf.Type.IF);
        addKeywordMachine("ELSE", TokenIntf.Type.ELSE);
        addKeywordMachine("WHILE", TokenIntf.Type.WHILE);
        addKeywordMachine("DO", TokenIntf.Type.DO);
        addKeywordMachine("FOR", TokenIntf.Type.FOR);
        addKeywordMachine("LOOP", TokenIntf.Type.LOOP);
        addKeywordMachine("BREAK", TokenIntf.Type.BREAK);
        addKeywordMachine("SWITCH", TokenIntf.Type.SWITCH);
        addKeywordMachine("CASE", TokenIntf.Type.CASE);
        addKeywordMachine("EXECUTE", TokenIntf.Type.EXECUTE);
        addKeywordMachine("TIMES", TokenIntf.Type.TIMES);
        addKeywordMachine("FUNCTION", TokenIntf.Type.FUNCTION);
        addKeywordMachine("CALL", TokenIntf.Type.CALL);
        addKeywordMachine("RETURN", TokenIntf.Type.RETURN);
        addKeywordMachine("BLOCK", TokenIntf.Type.BLOCK);
        addKeywordMachine("DEFAULT", TokenIntf.Type.DEFAULT);
        
        addMachine(new compiler.machines.IdentifierMachine());
    }

    public void addMachine(StateMachineIntf machine) {
        m_machineList.add(new MachineInfo(machine));
    }

    public void addKeywordMachine(String keyword, TokenIntf.Type tokenType) {
        m_machineList.add(new MachineInfo(new KeywordMachine(keyword, tokenType)));
    }

    public void initMachines(String input) {
        for (MachineInfo machine : m_machineList) {
            machine.init(input);
        }
    }

    public Token nextWord() throws Exception {
        // check end of file
        if (m_input.isEmpty()) {
            Token token = new Token();
            token.m_type = Token.Type.EOF;
            token.m_value = new String();
            return token;
        }

        // initialize machines
        initMachines(m_input.getRemaining());

        // read input until all machines stopped
        int counter = 0;
        while(true) {
            boolean isAnyMachineRunning = false;
            counter++;
            for(MachineInfo machineInfo : m_machineList) {
                isAnyMachineRunning |= !machineInfo.m_machine.isFinished();
                if(!machineInfo.m_machine.isFinished()) machineInfo.m_machine.step();
                if(machineInfo.m_machine.isFinalState()) machineInfo.m_acceptPos = counter;
            }
            if(!isAnyMachineRunning) break;
        }

        // select match
        int largestAcceptedPosition = 0;
        MachineInfo winnerMachine = null;
        for(MachineInfo machineInfo : m_machineList)
            if(machineInfo.m_acceptPos > largestAcceptedPosition)
                winnerMachine = machineInfo;

        // create token
        Token token = new Token();
        token.m_type = winnerMachine.m_machine.getType();
        token.m_value = m_input.advanceAndGet(winnerMachine.m_acceptPos);

        return token;
    }

    public void processInput(String input, OutputStreamWriter outStream) throws Exception {
        m_input = new MultiLineInputReader(input);
        // while input available
        while (!m_input.isEmpty()) {
            // get next word
            Token curWord = nextWord();
            // break on failure
            if (curWord.m_type == Token.Type.EOF) {
                outStream.write("ERROR\n");
                outStream.flush();
                break;
            } else if (curWord.m_type == Token.Type.WHITESPACE) {
                continue;
            } else {
                // print word
                outStream.write(curWord.toString());
                outStream.write("\n");
                outStream.flush();
            }
        }
    }
}
