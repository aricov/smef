grammar Smef;

smefFile : domainDecl defs=def*;

domainDecl: DOMAIN name=SNAME;

def : simpleDef
    | unionDef
    | traitDef;

traitDef: TRAIT MessageName messageContent*;

simpleDef: MESSAGE MessageName messageContent*;

unionDef: UNION_BEGIN MessageName messageContent* simpleDef+ UNION_END;

messageContent: fieldDef | include;

fieldDef: SNAME QUANTIFIER? typeRef;

typeRef: SNAME
		| MessageName
		| QNAME;

include: INCLUDE typeRef;

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
DOT: '.';
QUANTIFIER: [*?];

WS: [ \t\r\n] -> skip;
