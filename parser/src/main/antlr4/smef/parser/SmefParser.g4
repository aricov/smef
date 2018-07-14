parser grammar SmefParser;

options {
	tokenVocab=SmefLexer;
}

smefFile : domainDecl defs=def*;

domainDecl: DOMAIN name=SNAME;

def : simpleDef
    | unionDef
    | traitDef;

traitDef: comments=commentLine* TRAIT MessageName messageContent*;

simpleDef: comments=commentLine* MESSAGE MessageName messageContent*;

unionDef: commentLine* UNION_BEGIN MessageName messageContent* simpleDef+ UNION_END;

messageContent: fieldDef | include;

fieldDef: commentLine* SNAME QUANTIFIER? typeRef;

typeRef: SNAME
		| MessageName
		| QNAME;

include: INCLUDE typeRef;

commentLine: COMMENT_START COMMENT_TEXT? COMMENT_END;
