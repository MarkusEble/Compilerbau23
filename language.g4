grammar language;
sumExpr: NUMBER (sumOp NUMBER)*;
sumOp: PLUS|MINUS;
questionMarkExpr: andOrExpr QUESTIONMARK andOrExpr DOUBLECOLON andOrExpr;

mulDivExpr: NUMBER (mulDivOp NUMBER)*;
mulDivOp: MUL|DIV;
cmpExpr: questExpr ((LESS|GREATER|EQUAL) questExpr)*;
andOrExpr: cmpExpr (andOrOp cmpExpr)*;
andOrOp: AND|OR;
shiftExpr: sumExpr (shiftOp sumExpr)*;
shiftOp: SHIFTLEFT | SHIFTRIGHT;

LESS: '<';
GREATER: '>';
EQUAL: '==';
NUMBER: [0-9]+;
PLUS: '+';
MINUS: '-';
QUESTIONMARK: '?';
DOUBLECOLON: ':';

MUL: '*';
DIV: '/';
WS: [ \t\r\n]+ -> skip;

AND: '&&';
OR: '||';

SHIFTLEFT: '<<';
SHIFTRRIGHT: '>>';
