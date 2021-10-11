grammar Pattern;
patternEntry
    :   temporalClause followedBy  temporalClause ';')* EOF
    ;


temporalClause
    :   graphProcessing
    ;

//.......................................................

graphProcessing
    :    '.g()' (computation | selection | partition|extraction)* (evaluation)
    |    temporalVariable (computation | selection | partition|extraction)* (evaluation)
    ;

computation
    :   '.compute(' computationFunction ')'
    ;

selection
    :   '.select(' selectionFunction ')'
    ;

partition
    :   '.SubGraphByV(' partitionFunction ')'
    |   '.SubGraphByE(' partitionFunction ')'
    ;

extraction
    :   '.extractV(' label? (',' label)* ')'
    |   '.extractE(' label? (',' label)* ')'
    ;

evaluation
    :   '.evaluate(' Operator ',' value ',' fireEvent ')'
    ;

computationFunction
    :   functionName ',' computationReturnVariables ( computationParameters )?
    ;

computationReturnVariables
    :   variable (',' variable)*
    ;

computationParameters
    :   ', [' ( aliasedParameter ',')* aliasedParameter ']'
    ;

aliasedParameter
    :   Litterals '=' operands
    ;

followedBy: '.followedBy('temporalVariable ')';

//.......................................................

selectionFunction
    :   logicalExpression edgeSelection
    |
    ;

edgeSelection
    :   'EDGE[' (logicalExpression | ) ']'
    |
    ;

logicalExpression
    :    booleanAndExpression ( OR booleanAndExpression )*
    ;

booleanAndExpression
    :    unaryExpression ( AND unaryExpression )*
    ;

unaryExpression
    :    NOT? primaryExpression
    ;

primaryExpression
    :    '(' logicalExpression ')'
    |    boolPredicate
    ;

boolPredicate
    :   leftOp=operands Operator rightOp=operands
    ;

operands
    : (label | temporalVariable | value)
    ;

//..............................................

partitionFunction
    :   ((temporalVariable|label) (',' (temporalVariable|label))*)?
    ;

operationFunction
    :   ( '.map' | '.flatmap' | '.reduce' | '.filter' ) '(' functionName (tupleField (',' tupleField)*)? ')'
    |   ('.groupby' | '.Merge') '(' tupleField (',' tupleField)* ')'
    |   '.collect'
    |   oneFieldOperationAlias ('(' tupleField ')')?
    ;

oneFieldOperationAlias
    :   '.avg' | '.max' | '.min' | '.count' | '.select'
    ;

emission
    :   '.emit(' variable ')'
    ;

temporalVariable
    :   variable
    |   variable Timeunit 'ago'
    |   variable 'every'? 'within' Timeunit
    ;

functionName
    :   Litterals
    ;

label
    :   Litterals
    ;

value
    :   '\''Litterals '\''
    ;

variable
    :   '$' Litterals
    ;

fireEvent
    :   '"' Litterals '"'
    ;

tupleField
    :   Litterals ('.' Litterals)*
    ;

//lexer

Operator : ('<'| '>'| '==' | '<=' | '>=') ;

//BinBoolOperator : 'and' | 'or' ;
NOT : 'not' ;
AND : 'and' ;grammar Pattern;


//UnaryBoolOperator: 'not' ;

DOT: '.';

Litterals : ( [a-z] | [A-Z] | Number | DOT )+ ;

Timeunit : (Number+ ('-ms' | '-s' | '-m' | '-h'))+ ;

Number : [0-9] ;


//for windows  [\t \r \n]+ -> skip, for linux [ \t\n]+ -> skip;
Skip : [ \t\r\n]+ -> skip;
OR : 'or' ;


//UnaryBoolOperator: 'not' ;

DOT: '.';

Litterals : ( [a-z] | [A-Z] | Number | DOT )+ ;

Timeunit : (Number+ ('-ms' | '-s' | '-m' | '-h'))+ ;

Number : [0-9] ;


//for windows  [\t \r \n]+ -> skip, for linux [ \t\n]+ -> skip;
Skip : [ \t\r\n]+ -> skip;