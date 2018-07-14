lexer grammar SmefLexer;

MessageName: [A-Z] NAME_INSIDE;

SNAME: [a-z] NAME_INSIDE;

QNAME: SNAME DOT MessageName;

fragment NAME_INSIDE: [a-zA-Z0-9_$]*;

DOMAIN: '#domain';
INCLUDE: '#include';
MESSAGE: '#message';
TRAIT: '#trait';
UNION_BEGIN: '#union';
UNION_END: '/union';
COMMENT_START: '##' -> pushMode(COMMENT_LINE);
DOT: '.';
QUANTIFIER: [*?];

WS: [ \t\r\n] -> skip;

mode COMMENT_LINE;

COMMENT_END: CR?LF -> popMode;

fragment CR: '\r';

fragment LF: '\n';

COMMENT_TEXT: ~[\r\n]+;
