package compiler;

public class ExpressionEvaluator {
    private Lexer m_lexer;
    
    public ExpressionEvaluator(Lexer lexer) {
        m_lexer = lexer;
    }
    
    public int eval(String val) throws Exception {
        m_lexer.init(val);
        return getQuestionMarkExpr();
    }
    
    int getParantheseExpr() throws Exception {
        Token curToken = m_lexer.lookAhead();
        m_lexer.expect(Token.Type.INTEGER);
        return Integer.valueOf(curToken.m_value);
    }
    
    int getUnaryExpr() throws Exception {
        return getParantheseExpr();
    }
    
    int getMulDivExpr() throws Exception {
        return getUnaryExpr();
    }
    
    int getPlusMinusExpr() throws Exception {
        // sum : product (PLUS|MINUS product)*
        int result = getMulDivExpr();
        while (m_lexer.lookAhead().m_type == compiler.TokenIntf.Type.PLUS ||
            m_lexer.lookAhead().m_type == compiler.TokenIntf.Type.MINUS) {
            if (m_lexer.lookAhead().m_type == compiler.TokenIntf.Type.PLUS) {
                m_lexer.advance();
                result += getMulDivExpr();
            } else {
                m_lexer.advance();
                result -= getMulDivExpr();
            }
          }
        return result;
    }

    int getBitAndOrExpr() throws Exception {
        return getPlusMinusExpr();
    }

    int getShiftExpr() throws Exception {
        // bitshift = andOr (<<|>> andOr)*
        int result = getBitAndOrExpr();
        compiler.TokenIntf.Type nextToken = m_lexer.lookAhead().m_type;
        
        while(nextToken == compiler.TokenIntf.Type.SHIFTLEFT || nextToken == compiler.TokenIntf.Type.SHIFTRIGHT){
            if(nextToken == compiler.TokenIntf.Type.SHIFTLEFT){
                m_lexer.advance();
                result <<=  getBitAndOrExpr();
            } else {
                m_lexer.advance();
                result >>=  getBitAndOrExpr();
            }
            nextToken = m_lexer.lookAhead().m_type;
        } 
        return result;
    }

    int getCompareExpr() throws Exception {
        return getShiftExpr();
    }

    int getAndOrExpr() throws Exception {
        return getCompareExpr();
    }

    int getQuestionMarkExpr() throws Exception {
        int value1, value2;
        int andOrResult = getAndOrExpr();

        // Retrieve first value
        m_lexer.advance();
        if (m_lexer.m_currentToken.m_type == TokenIntf.Type.QUESTIONMARK) {
            m_lexer.advance();
            value1 = Integer.parseInt(m_lexer.m_currentToken.m_value);
        } else throw new Exception("expected ?");

        // Retrieve second value m_lexer.advance();
        if (m_lexer.m_currentToken.m_type == TokenIntf.Type.DOUBLECOLON) {
            m_lexer.advance();
            value2 = Integer.parseInt(m_lexer.m_currentToken.m_value);
        } else throw new Exception("expected :");

        // Decide and return
        m_lexer.advance();
        return andOrResult == 1 ? value1 : value2;
    }
}
