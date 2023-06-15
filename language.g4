grammar language;
sumExpr: NUMBER (sumOp NUMBER)*;
sumOp: PLUS|MINUS;
NUMBER: [0-9]+;
PLUS: '+';
MINUS: '-';

questionMarkExpr: andOrExpr QUESTIONMARK andOrExpr DOUBLECOLON andOrExpr;
QUESTIONMARK: '?';
DOUBLECOLON: ':';

WS: [ \t\r\n]+ -> skip;