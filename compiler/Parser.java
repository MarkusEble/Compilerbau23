package compiler;
import compiler.TokenIntf.Type;
import compiler.ast.*;

public class Parser {
    private Lexer m_lexer;
    private SymbolTableIntf m_symbolTable;
    private FunctionTableIntf m_functionTable;

    public Parser(Lexer lexer, SymbolTableIntf symbolTable, FunctionTableIntf functionTable) {
        m_lexer = lexer;
        m_symbolTable = symbolTable;
        m_functionTable = functionTable;
    }

    public Parser(Lexer lexer, SymbolTableIntf symbolTable) {
        m_lexer = lexer;
        m_symbolTable = symbolTable;
    }

    public Parser(Lexer lexer) {
        m_lexer = lexer;
        m_symbolTable = null;
    }
    
    public ASTExprNode parseExpression(String val) throws Exception {
        m_lexer.init(val);
        return getQuestionMarkExpr();
    }

    public ASTStmtNode parseStmt(String val) throws Exception {
        m_lexer.init(val);
        return getStmtList();
    }

    ASTExprNode getParantheseExpr() throws Exception {
        // parantheseExpr: INT | ( LPAREN questionmarkExpr RPAREN )
        ASTExprNode node = null;
        if(m_lexer.lookAhead().m_type == TokenIntf.Type.INTEGER){
            node = new ASTIntegerLiteralNode(m_lexer.lookAhead().m_value);
            m_lexer.advance();
        } else if (this.m_lexer.lookAhead().m_type == TokenIntf.Type.IDENT) {
            node = this.getVariableExpr();
            this.m_lexer.advance();
        }else if(this.m_lexer.lookAhead().m_type == Type.CALL) {
            node = this.getFunctionCallExpr();
        }else if(m_lexer.lookAhead().m_type == TokenIntf.Type.LPAREN) {
            m_lexer.expect(TokenIntf.Type.LPAREN);
            ASTExprNode innerNode = getQuestionMarkExpr();
            node = new ASTParantheseExprNode(innerNode);
            m_lexer.expect(TokenIntf.Type.RPAREN);
        }else{
            m_lexer.throwCompilerException("Unexpected Token", "LPAREN or INTEGER");
        }
        return node;
    }
    
    ASTExprNode getUnaryExpr() throws Exception {
        // !, - exp: (-|!)* parantheseExpression
        ASTExprNode result = null;
        if(m_lexer.lookAhead().m_type == TokenIntf.Type.MINUS ||
              m_lexer.lookAhead().m_type == TokenIntf.Type.NOT){
                Token currentToken = m_lexer.lookAhead();
                m_lexer.advance();
                ASTExprNode unary = getUnaryExpr();
                result = new ASTUnaryExprNode(unary, currentToken);
              }
              else {
                result = getParantheseExpr();
              }
        return result;
    }
    
    ASTExprNode getMulDivExpr() throws Exception {
        // return getUnaryExpr();
        // MulDivExpr: UnaryExpr ((MUL|DIV) UnaryExpr)*
        ASTExprNode currentLhs = getUnaryExpr();
        while (m_lexer.lookAhead().m_type == TokenIntf.Type.MUL ||
                m_lexer.lookAhead().m_type == TokenIntf.Type.DIV) {
            Token currentToken = m_lexer.lookAhead();
            m_lexer.advance();
            ASTExprNode currentRhs = getUnaryExpr();
            ASTExprNode currentResult = new ASTMulDivExprNode(currentLhs, currentRhs, currentToken);
            currentLhs = currentResult;
        }
        return currentLhs;
    }
    
    ASTExprNode getPlusMinusExpr() throws Exception {
        // plusMinusExpr: mulDivExpr ((PLUS|MINUS) mulDivExpr)*
        ASTExprNode currentLhs = getMulDivExpr();
        while (m_lexer.lookAhead().m_type == TokenIntf.Type.PLUS ||
                m_lexer.lookAhead().m_type == TokenIntf.Type.MINUS) {
            Token currentToken = m_lexer.lookAhead();
            m_lexer.advance();
            ASTExprNode currentRhs = getMulDivExpr();
            ASTExprNode currentResult = new ASTPlusMinusExprNode(currentLhs, currentRhs, currentToken);
            currentLhs = currentResult;
        }
        return currentLhs;
    }

    ASTExprNode getBitAndOrExpr() throws Exception {        
        ASTExprNode currentLhs = getPlusMinusExpr();
        while (m_lexer.lookAhead().m_type == TokenIntf.Type.BITAND ||
                m_lexer.lookAhead().m_type == TokenIntf.Type.BITOR) {
            Token currentToken = m_lexer.lookAhead();
            m_lexer.advance();
            ASTExprNode currentRhs = getPlusMinusExpr();
            ASTExprNode currentResult = new ASTBitAndOr(currentLhs, currentRhs, currentToken);
            currentLhs = currentResult;
        }
        return currentLhs;
    }

    ASTExprNode getShiftExpr() throws Exception {
        // shiftExpr: bitAndOr ((<<|>>) bitAndOr)*
        ASTExprNode currentLhs = getBitAndOrExpr();
        while (m_lexer.lookAhead().m_type == TokenIntf.Type.SHIFTLEFT ||
                m_lexer.lookAhead().m_type == TokenIntf.Type.SHIFTRIGHT) {
            Token currentToken = m_lexer.lookAhead();
            m_lexer.advance();
            ASTExprNode currentRhs = getBitAndOrExpr();
            ASTExprNode currentResult = new ASTShiftExprNode(currentLhs, currentRhs, currentToken);
            currentLhs = currentResult;
        }
        return currentLhs;
    }

    ASTExprNode getCompareExpr() throws Exception {
        // plusMinusExpr: mulDivExpr ((PLUS|MINUS) mulDivExpr)*
        ASTExprNode currentLhs = getShiftExpr();
        while (m_lexer.lookAhead().m_type == TokenIntf.Type.LESS ||
                m_lexer.lookAhead().m_type == TokenIntf.Type.GREATER ||
                m_lexer.lookAhead().m_type == TokenIntf.Type.EQUAL
                ) {
            Token currentToken = m_lexer.lookAhead();
            m_lexer.advance();
            ASTExprNode currentRhs = getShiftExpr();
            ASTExprNode currentResult = new ASTCompareExprNode(currentLhs, currentRhs, currentToken);
            currentLhs = currentResult;
        }
        return currentLhs;
    }

    ASTExprNode getAndOrExpr() throws Exception {
        ASTExprNode currentLhs = getCompareExpr();
        while (m_lexer.lookAhead().m_type == TokenIntf.Type.AND || m_lexer.lookAhead().m_type == TokenIntf.Type.OR) {
            final Token currentToken = m_lexer.lookAhead();
            m_lexer.advance();
            final ASTExprNode currentRhs = getCompareExpr();
            currentLhs = new ASTAndOrExprNode(currentLhs, currentRhs, currentToken);
        }
        return currentLhs;
    }

    ASTExprNode getQuestionMarkExpr() throws Exception {
        ASTExprNode andOrResult = getAndOrExpr();
        if (m_lexer.lookAhead().m_type == TokenIntf.Type.QUESTIONMARK) {
            m_lexer.expect(TokenIntf.Type.QUESTIONMARK);
            ASTExprNode value1 = getAndOrExpr();
            m_lexer.expect(TokenIntf.Type.DOUBLECOLON);
            ASTExprNode value2 = getAndOrExpr();
            return new ASTQuestionMarkNode(andOrResult, value1, value2);
        } else {
            return andOrResult;
        }
    }

    ASTExprNode getVariableExpr() throws Exception {
        final Token token = this.m_lexer.lookAhead();
        final Symbol symbol = this.m_symbolTable.getSymbol(token.m_value);
        if (symbol == null) {
            this.m_lexer.throwCompilerException("variable not defined", "");
        }
        return new ASTVariableExprNode(symbol);
    }

    ASTStmtNode getAssignStmt() throws Exception {
        // assignStmt: IDENTIFIER ASSIGN expr
        // bsp: a = 5 + 2
        Token nextToken = m_lexer.lookAhead();
        m_lexer.expect(TokenIntf.Type.IDENT);

        Symbol symbol = m_symbolTable.getSymbol(nextToken.m_value);
        if (symbol == null) {
            this.m_lexer.throwCompilerException("variable not defined", "");
        }

        m_lexer.expect(TokenIntf.Type.ASSIGN);
        ASTExprNode expression = getQuestionMarkExpr();
        return new ASTAssignStmt(symbol, expression);
    }

    ASTStmtNode getVarDeclareStmt() throws Exception {
        m_lexer.expect(TokenIntf.Type.DECLARE);

        Token identifier = m_lexer.lookAhead();
        declareVar(identifier);
        m_lexer.advance();
        return new ASTDeclareStmt(identifier);
    }

    ASTStmtNode getPrintStmt() throws Exception{
        m_lexer.expect(TokenIntf.Type.PRINT);
        ASTExprNode exprNode = getQuestionMarkExpr();
        return new ASTPrintStmtNode(exprNode);
        
    }

    ASTStmtNode getStmt() throws Exception {
        // stmt: assignStmt // SELECT = {IDENTIFIER}
        if (m_lexer.lookAhead().m_type == TokenIntf.Type.IDENT) {
            return getAssignStmt();
            //    stmt: varDeclareStmt // SELECT = {DECLARE}
        } else if (m_lexer.lookAhead().m_type == TokenIntf.Type.DECLARE) {
            return getVarDeclareStmt();
            //    stmt: printStmt // SELECT = {PRINT}
        } else if (m_lexer.lookAhead().m_type == TokenIntf.Type.PRINT) {
            return getPrintStmt();
            //    stmt: blockStmt // SELECT = {LBRACE}
        } else if (m_lexer.lookAhead().m_type == TokenIntf.Type.LBRACE) {
            return getBlockStmt();
        } else if (m_lexer.lookAhead().m_type == TokenIntf.Type.FOR) {
            return getFor();
        //   stmt: returnStmt // SELECT = {RETURN}
        } else if(m_lexer.lookAhead().m_type == Type.RETURN) {
            return getReturnStmt();
        //   stmt: functionStmt // SELECT = {FUNCTION}
        } else if(m_lexer.lookAhead().m_type == Type.FUNCTION) {
            return getFunctionStmt();
        //   stmt: functionCallStmt // SELECT = {CALL}
        } else if(m_lexer.lookAhead().m_type == Type.CALL) {
            return getFunctionCallStmt();
            //   stmt: functionCallStmt // SELECT = {WHILE}
        } else if (m_lexer.lookAhead().m_type == Token.Type.WHILE) {
			return getWhileStatement();
            //   stmt: functionCallStmt // SELECT = {DOWHILE}
		} else if (m_lexer.lookAhead().m_type == Token.Type.DO) {
            return getDoWhileStatement();
        } else if (m_lexer.lookAhead().m_type == Type.EXECUTE) {
            return getExecuteNTimesStatement();
        //   stmt: loopStmt // SELECT = {LOOP}
        } else if (this.m_lexer.lookAhead().m_type == Type.LOOP) {
            return this.getLoopStatement();
        //   stmt: breakStmt // SELECT = {BREAK}
        } else if (this.m_lexer.lookAhead().m_type == Type.BREAK) {
            return this.getBreakStatement();
        } else if (m_lexer.lookAhead().m_type == TokenIntf.Type.IF) {
            return getIfStmt();
            //    stmt: switchCaseStmt // SELECT = {SWITCH}
        } else if (m_lexer.lookAhead().m_type == TokenIntf.Type.SWITCH) {
            return getSwitchCaseStmt();
        } else {
            m_lexer.throwCompilerException("Unexpected Statement", "");
        }
        return null;
    }

    ASTStmtNode getStmtList() throws Exception {
        // stmtlist: stmt stmtlist // SELECT = {IDENTIFIER, DECLARE, PRINT}
        // stmtlist: eps // SELECT = FOLLOW(stmtlist) = {EOF, RBRACE, CASE}
        // stmtlist: (stmt)* // TERMINATE on EOF, RBRACE, CASE
        ASTStmtListNode stmtList = new ASTStmtListNode();
        while (
            m_lexer.lookAhead().m_type != TokenIntf.Type.EOF &&
            m_lexer.lookAhead().m_type != TokenIntf.Type.RBRACE &&
                    m_lexer.lookAhead().m_type != TokenIntf.Type.CASE
        ) {
            ASTStmtNode currentStmt = getStmt();
            stmtList.addStatement(currentStmt);
            if (currentStmt.semicolAfter()) {
                m_lexer.expect(TokenIntf.Type.SEMICOLON);
            }
        }
        return stmtList;
    }

    ASTStmtNode getBlockStmt() throws Exception {
      // blockStmt: LBRACE stmtlist RBRACE
      // SELECT(blockStmt) = FIRST(blockStmt) = { LBRACE }
      m_lexer.expect(TokenIntf.Type.LBRACE);
      ASTStmtNode stmtListNode = getStmtList();
      m_lexer.expect(TokenIntf.Type.RBRACE);
      return new ASTBlockStmtNode(stmtListNode);
    }

    ASTStmtNode getFor() throws Exception {
        // for_stmt: FOR LPAREN stmt SEMICOLON expr SEMICOLON stmt RPAREN LBRACE stmtList RBRACE
        m_lexer.expect(Type.FOR);
        m_lexer.expect(Type.LPAREN);
        ASTStmtNode iteratorStmt = getStmt();
        m_lexer.expect(Type.SEMICOLON);
        ASTExprNode conditionExpr = getQuestionMarkExpr();
        m_lexer.expect(Type.SEMICOLON);
        ASTStmtNode iteratorOperationStmt = getStmt();
        m_lexer.expect(Type.RPAREN);
        m_lexer.expect(Type.LBRACE);
        ASTStmtNode body = getStmtList();
        m_lexer.expect(Type.RBRACE);
        return new ASTForStmtNode(iteratorStmt, conditionExpr, iteratorOperationStmt, body);
    }

    ASTStmtNode getFunctionCallStmt() throws Exception {
        // functioncallstmt: functioncallexpr
        ASTExprNode expr = getFunctionCallExpr();
        return new ASTFunctionCallStmtNode(expr);
    }

    ASTExprNode getFunctionCallExpr() throws Exception {
        // functioncallExpr: CALL IDENTIFIER LPAREN argumentList RPAREN
        m_lexer.expect(Type.CALL);
        Token functionIdentifier = m_lexer.lookAhead();
        m_lexer.expect(Type.IDENT);
        m_lexer.expect(Type.LPAREN);
        ASTArgumentListNode arguments = getArgumentList();
        m_lexer.expect(Type.RPAREN);

        FunctionInfo funcInfo = m_functionTable.getFunction(functionIdentifier.m_value);
        if(funcInfo == null) {
            m_lexer.throwCompilerException("Function " + functionIdentifier.m_value + " is not defined!", null);
        }
        if(funcInfo.varNames.size() != arguments.getArguments().size()) {
            m_lexer.throwCompilerException("Invalid number of Arguments",
                 "Function " + funcInfo.m_name + " expects " + funcInfo.varNames.size() + " arguments! Got " + arguments.getArguments().size()
            );
        }

        return new ASTFunctionCallExprNode(funcInfo, arguments);
    }

    ASTArgumentListNode getArgumentList() throws Exception {
        // argumentList: expr (COMMA expr)*  WHILE lookahead = { COMMA }
        // argumentList: eps    SELECT = { RPAREN }
        ASTArgumentListNode arguments = new ASTArgumentListNode();
        if(m_lexer.lookAhead().m_type == Type.RPAREN) {
            return arguments;
        }
        arguments.addArgument(getQuestionMarkExpr());
        while(m_lexer.lookAhead().m_type == Type.COMMA) {
            m_lexer.expect(Type.COMMA);
            arguments.addArgument(getQuestionMarkExpr());
        }
        return arguments;
    }

    ASTStmtNode getFunctionBodyStmt() throws Exception {
        // functionBody: LBRACE stmtlist RBRACE
        m_lexer.expect(TokenIntf.Type.LBRACE);
      ASTStmtNode stmtListNode = getStmtList();
      m_lexer.expect(TokenIntf.Type.RBRACE);
      return new ASTFunctionBodyStmtNode(stmtListNode);
    }

    ASTStmtNode getFunctionStmt() throws Exception {
        // functionStmt: FUNCTION INDENTIFIER LPAREN parameterList RPAREN blockStmt
        m_lexer.expect(Type.FUNCTION);
        Token functionIdentifier = m_lexer.lookAhead();
        m_lexer.expect(Type.IDENT);

        FunctionInfo functionInfo = declareFunction(functionIdentifier);

        m_lexer.expect(Type.LPAREN);
        ASTParameterListNode parameters = getParameterList();
        m_lexer.expect(Type.RPAREN);
        ASTStmtNode functionBody = getFunctionBodyStmt();

        functionInfo.varNames = parameters.getParametersAsStringList();

        return new ASTFunctionStmtNode(functionInfo, parameters, functionBody);
    }

    ASTParameterListNode getParameterList() throws Exception {
        // parameterList: IDENTIFIER (COMMA IDENTIFIER)*	SELECT(parameterList) = { IDENTIFIER }
        // parameterList: eps		SELECT(parameterList2) = FOLLOW(parameterList) = { RPAREN }
        ASTParameterListNode parameterList = new ASTParameterListNode();
        if(m_lexer.lookAhead().m_type == Type.RPAREN) {
            return parameterList;
        }
        Token currentIdentifier = m_lexer.lookAhead();
        m_lexer.expect(Type.IDENT);
        parameterList.addParameter(declareVar(currentIdentifier));
        while(m_lexer.lookAhead().m_type == Type.COMMA) {
            m_lexer.expect(Type.COMMA);
            currentIdentifier = m_lexer.lookAhead();
            m_lexer.expect(Type.IDENT);
            parameterList.addParameter(declareVar(currentIdentifier));
        }
        return parameterList;
    }

    ASTStmtNode getReturnStmt() throws Exception {
        // returnStmt: RETURN expression
        m_lexer.expect(Type.RETURN);
        ASTExprNode expression = getQuestionMarkExpr();
        return new ASTReturnStmt(expression);
    }

    Symbol declareVar(Token identifier) throws Exception {
        if (m_symbolTable.getSymbol(identifier.m_value) != null) {
            m_lexer.throwCompilerException("Identifier already declared previously", "");
            return null;
        }
        return m_symbolTable.createSymbol(identifier.m_value);
    }

    FunctionInfo declareFunction(Token identifier) throws Exception {
        if(m_functionTable.getFunction(identifier.m_value) != null) {
            m_lexer.throwCompilerException("Function already declared previously", "");
            return null;
        }
        m_functionTable.createFunction(identifier.m_value, null, null);
        return m_functionTable.getFunction(identifier.m_value);
    }

 	ASTStmtNode getWhileStatement() throws Exception {
        m_lexer.expect(TokenIntf.Type.WHILE);
        m_lexer.expect(TokenIntf.Type.LPAREN);
        ASTExprNode exprNode = getQuestionMarkExpr();
        m_lexer.expect(TokenIntf.Type.RPAREN);
        ASTStmtNode blockstmt = getBlockStmt();
        return new ASTWhileStmtNode(exprNode, blockstmt);
    }

    ASTStmtNode getDoWhileStatement() throws Exception {
        m_lexer.expect(TokenIntf.Type.DO);
        ASTStmtNode blockstmt = getBlockStmt();
        m_lexer.expect(TokenIntf.Type.WHILE);
        m_lexer.expect(TokenIntf.Type.LPAREN);
        ASTExprNode exprNode = getQuestionMarkExpr();
        m_lexer.expect(TokenIntf.Type.RPAREN);
        m_lexer.expect(TokenIntf.Type.SEMICOLON);
        return new ASTDoWhileStmtNode(exprNode, blockstmt);
    }

    private ASTStmtNode getLoopStatement() throws Exception {
        // loopStmt: LOOP blockStmt ENDLOOP
        m_lexer.expect(Type.LOOP);
        final ASTStmtNode block = getBlockStmt();
        m_lexer.expect(Type.ENDLOOP);
        return new ASTLoopStmtNode(block);
    }

    private ASTStmtNode getBreakStatement() throws Exception {
        // breakStmt: BREAK
        this.m_lexer.expect(Type.BREAK);
        return ASTBreakStmtNode.STATEMENT_NODE;
    }

    ASTStmtNode getExecuteNTimesStatement() throws Exception {
        // executeNTimes: EXECUTE expression TIMES blockStmt
        m_lexer.expect(Type.EXECUTE);
        ASTExprNode n = getQuestionMarkExpr();
        m_lexer.expect(Type.TIMES);
        ASTStmtNode block = getBlockStmt();
        return new ASTExecuteNTimes(n, block);
    }

    ASTStmtNode getIfStmt() throws Exception {
        // ifStmt := IF LBRACE stmt RBRACE blockStmt // SELECT(ifStmt) = { IF }
        m_lexer.expect(Type.IF);
        m_lexer.expect(Type.LPAREN);
        ASTExprNode condition = getQuestionMarkExpr();
        m_lexer.expect(Type.RPAREN);
        ASTStmtNode codeTrue = getBlockStmt();

        if (m_lexer.lookAhead().m_type == Type.ELSE) {
            m_lexer.advance();
            // ifStmt := IF LBRACE stmt RBRACE blockStmt ELSE blockStmt // SELECT(blockStmt) = { LBRACE }
            if (m_lexer.lookAhead().m_type == Type.LBRACE) {
                ASTStmtNode codeFalse = getBlockStmt();
                return new ASTIfStmt(condition, codeTrue, codeFalse);
            }
            // ifStmt := IF LBRACE stmt RBRACE blockStmt ELSE ifStmt // SELECT(ifStmt) = { IF }
            if (m_lexer.lookAhead().m_type == Type.IF) {
                ASTStmtNode elseIf = getIfStmt();
                return new ASTIfStmt(condition, codeTrue, elseIf);
            }
        }

        return new ASTIfStmt(condition, codeTrue, null);
    }

    ASTStmtNode getSwitchCaseStmt() throws Exception {
        //switch_case_stmt: 'SWITCH' 'LPAREN' expr 'RPAREN' 'LBRACE' case_list 'RBRACE'
        m_lexer.expect(TokenIntf.Type.SWITCH);
        m_lexer.expect(TokenIntf.Type.LPAREN);
        ASTExprNode exprNode = getQuestionMarkExpr();
        m_lexer.expect(TokenIntf.Type.RPAREN);
        m_lexer.expect(TokenIntf.Type.LBRACE);
        ASTCaseListNode caseListNode = getCaseList();
        m_lexer.expect(TokenIntf.Type.RBRACE);
        return new ASTSwitchCaseStmtNode(exprNode, caseListNode);
    }

    ASTCaseListNode getCaseList() throws Exception {
        //case_list: case_stmt | case_stmt case_list
        ASTCaseListNode caseList = new ASTCaseListNode();
        while (m_lexer.lookAhead().m_type != TokenIntf.Type.RBRACE) {
            ASTCaseNode currentCase = getCaseStmt();
            caseList.addStatement(currentCase);
        }
        return caseList;
    }

    ASTCaseNode getCaseStmt() throws Exception {
        //case_stmt: 'CASE' number ':' stmt_list
        ASTIntegerLiteralNode number = null;
        m_lexer.expect(TokenIntf.Type.CASE);
        if(m_lexer.lookAhead().m_type == Type.INTEGER){
            number = new ASTIntegerLiteralNode(m_lexer.lookAhead().m_value);
        }
        m_lexer.expect(TokenIntf.Type.INTEGER);
        m_lexer.expect(TokenIntf.Type.DOUBLECOLON);
        ASTStmtNode stmtListNode = getStmtList();
        return new ASTCaseNode(number, stmtListNode);
    }

}
