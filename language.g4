grammar language;
sumExpr: NUMBER (sumOp NUMBER)*;
sumOp: PLUS|MINUS;
cmpExpr: questExpr ((LESS|GREATER|EQUAL) questExpr)*;
LESS: '<';
GREATER: '>';
EQUAL: '==';
NUMBER: [0-9]+;
PLUS: '+';
MINUS: '-';
WS: [ \t\r\n]+ -> skip;

andOrExpr: cmpExpr (andOrOp cmpExpr)*;
andOrOp: AND|OR;
AND: '&&';
OR: '||';

shiftExpr: sumExpr (shiftOp sumExpr)*;
shiftOp: SHIFTLEFT | SHIFTRIGHT;
SHIFTLEFT: '<<';
SHIFTRRIGHT: '>>';
