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
        addKeywordMachine("*", compiler.TokenIntf.Type.MUL);
        addKeywordMachine("/", compiler.TokenIntf.Type.DIV);
        addKeywordMachine("+", compiler.TokenIntf.Type.PLUS);
        addKeywordMachine("-", compiler.TokenIntf.Type.MINUS);
        addKeywordMachine("&", compiler.TokenIntf.Type.BITAND);
        addKeywordMachine("|", compiler.TokenIntf.Type.BITOR);
        addKeywordMachine("<<", compiler.TokenIntf.Type.SHIFTLEFT);
        addKeywordMachine(">>", compiler.TokenIntf.Type.SHIFTRIGHT);
        addKeywordMachine("==", compiler.TokenIntf.Type.EQUAL);
        addKeywordMachine("<", compiler.TokenIntf.Type.LESS);
        addKeywordMachine(">", compiler.TokenIntf.Type.GREATER);
        addKeywordMachine("!", compiler.TokenIntf.Type.NOT);
        addKeywordMachine("&&", compiler.TokenIntf.Type.AND);
        addKeywordMachine("||", compiler.TokenIntf.Type.OR);
        addKeywordMachine("?", compiler.TokenIntf.Type.QUESTIONMARK);
        addKeywordMachine(":", compiler.TokenIntf.Type.DOUBLECOLON);
        addKeywordMachine("(", compiler.TokenIntf.Type.LPAREN);
        addKeywordMachine(")", compiler.TokenIntf.Type.RPAREN);
        addKeywordMachine("{", compiler.TokenIntf.Type.LBRACE);
        addKeywordMachine("}", compiler.TokenIntf.Type.RBRACE);
        addMachine(new ZeilenkommentarMachine());
        addMachine(new WhitespaceMachine());
        addKeywordMachine(";", compiler.TokenIntf.Type.SEMICOLON);
        addKeywordMachine(",", compiler.TokenIntf.Type.COMMA);
        addKeywordMachine("=", compiler.TokenIntf.Type.ASSIGN);

        addKeywordMachine("DECLARE", compiler.TokenIntf.Type.DECLARE);
        addKeywordMachine("PRINT", compiler.TokenIntf.Type.PRINT);
        addKeywordMachine("IF", compiler.TokenIntf.Type.IF);
        addKeywordMachine("ELSE", compiler.TokenIntf.Type.ELSE);
        addKeywordMachine("WHILE", compiler.TokenIntf.Type.WHILE);
        addKeywordMachine("DO", compiler.TokenIntf.Type.DO);
        addKeywordMachine("FOR", compiler.TokenIntf.Type.FOR);
        addKeywordMachine("LOOP", compiler.TokenIntf.Type.LOOP);
        addKeywordMachine("BREAK", compiler.TokenIntf.Type.BREAK);
        addKeywordMachine("SWITCH", compiler.TokenIntf.Type.SWITCH);
        addKeywordMachine("CASE", compiler.TokenIntf.Type.CASE);
        addKeywordMachine("EXECUTE", compiler.TokenIntf.Type.EXECUTE);
        addKeywordMachine("TIMES", compiler.TokenIntf.Type.TIMES);
        addKeywordMachine("FUNCTION", compiler.TokenIntf.Type.FUNCTION);
        addKeywordMachine("CALL", compiler.TokenIntf.Type.CALL);
        addKeywordMachine("RETURN", compiler.TokenIntf.Type.RETURN);
        addKeywordMachine("BLOCK", compiler.TokenIntf.Type.BLOCK);
        addKeywordMachine("DEFAULT", compiler.TokenIntf.Type.DEFAULT);
        
        // addMachine(new IdentifierMachine());
    }

    public void addMachine(StateMachineIntf machine) {
        m_machineList.add(new MachineInfo(machine));
    }

    public void addKeywordMachine(String keyword, TokenIntf.Type tokenType) {
        m_machineList.add(new MachineInfo(new KeywordMachine(keyword)));
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

        // TODO begin
        // while some machine are in process

        // end while some machines are in process

        // select match
        // throw in case of error

        // set next word [start pos, final pos)
        Token token = new Token();

        // TODO end
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
