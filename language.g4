grammar language;
sumExpr: NUMBER (sumOp NUMBER)*;
sumOp: PLUS|MINUS;
cmpExpr: questExpr ((LESS|GREATER|EQUAL) questExpr)*;

ifStmt: IF LPAREN cmpExpr RPAREN blockStmt (elseStmt)?;
elseStmt: ELSE (blockStmt | ifStmt);

LPAREN: '(';
RPAREN: ')';
IF: 'if';
ELSE: 'else';
LESS: '<';
GREATER: '>';
EQUAL: '==';
NUMBER: [0-9]+;
PLUS: '+';
MINUS: '-';
WS: [ \t\r\n]+ -> skip;