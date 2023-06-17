grammar language;
questionMarkExpr: (andOrExpr QUESTIONMARK andOrExpr DOUBLECOLON andOrExpr) | andOrExpr;
andOrExpr: cmpExpr (andOrOp cmpExpr)*;
andOrOp: AND|OR;
cmpExpr: shiftExpr ( cmpOp shiftExpr)*;
cmpOp: (LESS|GREATER|EQUAL);
shiftExpr: bitAndOrExpr (shiftOp bitAndOrExpr)*;
shiftOp: SHIFTLEFT | SHIFTRIGHT;
bitAndOrExpr: sumExpr (bitOp sumExpr)*;
bitOp: BITAND | BITOR;
sumExpr: mulDivExpr (SUMOP mulDivExpr)*;
mulDivExpr: parantheseExpr (MULOP parantheseExpr)*;
parantheseExpr:  NUMBER #numberOnly | LPAREN sumExpr RPAREN #withParanthese;

SUMOP: PLUS|MINUS;
MULOP: MUL|DIV;
LESS: '<';
GREATER: '>';
EQUAL: '==';
NUMBER: [0-9]+;
PLUS: '+';
MINUS: '-';

BITAND: '&';
BITOR:'|';

QUESTIONMARK: '?';
DOUBLECOLON: ':';

MUL: '*';
DIV: '/';


AND: '&&';
OR: '||';

SHIFTLEFT: '<<';
SHIFTRIGHT: '>>';
WS: [ \t\r\n]+ -> skip;

LPAREN: '(';
RPAREN: ')';

