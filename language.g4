grammar language;
sumExpr: NUMBER (sumOp NUMBER)*;
sumOp: PLUS|MINUS;

mulDivExpr: NUMBER (mulDivOp NUMBER)*;
mulDivOp: MUL|DIV;
cmpExpr: questExpr ((LESS|GREATER|EQUAL) questExpr)*;
LESS: '<';
GREATER: '>';
EQUAL: '==';
NUMBER: [0-9]+;
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
WS: [ \t\r\n]+ -> skip;

andOrExpr: cmpExpr (andOrOp cmpExpr)*;
andOrOp: AND|OR;
AND: '&&';
OR: '||';

shiftExpr: sumExpr (shiftOp sumExpr)*;
shiftOp: SHIFTLEFT | SHIFTRIGHT;
SHIFTLEFT: '<<';
SHIFTRRIGHT: '>>';
