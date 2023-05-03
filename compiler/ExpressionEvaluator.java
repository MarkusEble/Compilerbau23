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
        int result = 0;
        if(m_lexer.lookAhead().m_type == TokenIntf.Type.LPAREN) {
            m_lexer.advance();
            result = getQuestionMarkExpr();
            m_lexer.expect(TokenIntf.Type.RPAREN);
        }else if(m_lexer.lookAhead().m_type == TokenIntf.Type.INTEGER){
            result = Integer.valueOf(m_lexer.lookAhead().m_value);
            m_lexer.advance();
        }else{
            m_lexer.throwCompilerException("Unexpected Token", "LPAREN or INTEGER");
        }
        return result;
    }
    
    int getUnaryExpr() throws Exception {
        return getParantheseExpr();
    }
    
    int getMulDivExpr() throws Exception {
        int result = getUnaryExpr();
        while (m_lexer.lookAhead().m_type == TokenIntf.Type.MUL ||
            m_lexer.lookAhead().m_type == TokenIntf.Type.DIV) {
            if (m_lexer.lookAhead().m_type == TokenIntf.Type.MUL) {
                m_lexer.advance();
                result *= getUnaryExpr();
            } else {
                m_lexer.advance();
                result /= getUnaryExpr();
            }
        }
        return result;
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
        // |, &
        int result = getPlusMinusExpr();
        while(m_lexer.lookAhead().m_type == compiler.TokenIntf.Type.BITAND ||
            m_lexer.lookAhead().m_type == compiler.TokenIntf.Type.BITOR){
                if(m_lexer.lookAhead().m_type == compiler.TokenIntf.Type.BITAND){
                    m_lexer.advance();
                    result &= getPlusMinusExpr();
                }else {
                    m_lexer.advance();
                    result|=getPlusMinusExpr();
                }
            }
        return result;
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
        return getAndOrExpr();
    }
}
