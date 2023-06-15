grammar language;
sumExpr: NUMBER (sumOp NUMBER)*;
sumOp: PLUS|MINUS;
mulDivExpr: NUMBER (mulDivOp NUMBER)*;
mulDivOp: MUL|DIV;
NUMBER: [0-9]+;
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
WS: [ \t\r\n]+ -> skip;