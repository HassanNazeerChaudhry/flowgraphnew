grammar Pattern;

@header{
 package src.shared.antlr4;
}

patternEntry
    : graphModificationEvent
    | temporalPattern
    ;

temporalPattern
    :  temporalClause (followedBy  temporalClause)* ';' EOF
    ;

graphModificationEvent: (modifier change)+ ';' EOF
    ;


temporalClause
    :   graphProcessing extraction (operationFunction)* evaluation
   ;

//.......................................................

graphProcessing
    :    '.g()' (computation | selection | partition)*             #GraphProc
    |    temporalVariable (computation | selection | partition)*   #GraphProcTemp
    ;

computation
    :   '.compute(' computationFunction ')'
    ;


selection
    :   '.select(' selectionFunction ')'
    ;


partition
    :   '.SubGraphByV(' partitionFunction ')'  #PartByV
    |   '.SubGraphByE(' partitionFunction ')'  #PartByE
    ;


extraction
    :   '.extractV(' label? (',' label)* ')' #ExtractByV
    |   '.extractE(' label? (',' label)* ')' #ExtractByE
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

followedBy: '.followedBy('temporalVariable ')'
;



modifier: Edge | Vertex
;

change: Add | Delete | Modify
;

//.......................................................

selectionFunction
    :   logicalExpression edgeSelection
    ;

edgeSelection
    :   'EDGE[' (logicalExpression | ) ']'
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
AND : 'and' ;
OR : 'or' ;

//UnaryBoolOperator: 'not' ;

DOT: '.';

Litterals : ( [a-z] | [A-Z] | Number | DOT )+ ;

Timeunit : (Number+ ('-ms' | '-s' | '-m' | '-h'))+ ;

Number : [0-9] ;


//for windows  [\t \r \n]+ -> skip, for linux [ \t\n]+ -> skip;
Skip : [ \t\r\n]+ -> skip;



