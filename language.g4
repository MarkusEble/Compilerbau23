grammar language;
bitAndOrExpr:plusMinExp operator plusMinExp;
operator: BITAND | BITOR;
BITAND: '&';
BITOR:'|';

sumExpr: NUMBER (sumOp NUMBER)*;
sumOp: PLUS|MINUS;
NUMBER: [0-9]+;
PLUS: '+';
MINUS: '-';
shiftExpr: sumExpr (shiftOp sumExpr)*;
shiftOp: SHIFTLEFT | SHIFTRIGHT;
SHIFTLEFT: '<<';
SHIFTRRIGHT: '>>';
WS: [ \t\r\n]+ -> skip;