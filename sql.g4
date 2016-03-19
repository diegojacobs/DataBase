/*
 * Daniel Orozco 13312
 * Diego Jacobs 13160
 * Kevin Garcia 13
 */

grammar sql;

// LEXER SPECIFICATION

fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');

CREATE : C R E A T E;
DATABASE : D A T A B A S E;
DATABASES : D A T A B A S E S;
TABLE : T A B L E;
TABLES : T A B L E S;
DROP : D R O P;
ALTER : A L T E R;
RENAME : R E N A M E;
TO : T O;
SHOW : S H O W;
USE : U S E;
RES_INT : I N T;
RES_FLOAT : F L O A T;
RES_CHAR : C H A R;
RES_DATE : D A T E;
CONSTRAINT : C O N S T R A I N T;
KEY : K E Y;
PRIMARY : P R I M A R Y;
FOREIGN : F O R E I G N;
REFERENCES : R E F E R E N C E S;
CHECK : C H E C K;
ADD : A D D;
COLUMN : C O L U M N;
COLUMNS : C O L U M N S;
FROM : F R O M;
RES_AND : A N D;
RES_OR : O R;
RES_NOT : N O T;
INSERT : I N S E R T;
INTO : I N T O;
VALUES : V A L U E S;
UPDATE : U P D A T E;
SET : S E T;
WHERE : W H E R E;
DELETE : D E L E T E;
SELECT : S E L E C T;
ORDER : O R D E R;
BY : B Y;
ASC: A S C;
DESC: D E S C;

fragment LETTER : ('a'..'z'|'A'..'Z') ;
fragment DIGIT :'0'..'9' ;
fragment ASCII : (' ' ..'~') | '\\' | '\'' | '\"' | '\t' | '\n' ;
fragment TWO_DIGITS : DIGIT DIGIT ;
fragment THREE_DIGITS : DIGIT TWO_DIGITS ;
fragment FOUR_DIGITS : DIGIT THREE_DIGITS ;
fragment YEAR : FOUR_DIGITS ;
fragment MONTH : DIGIT | TWO_DIGITS ;
fragment DAY : DIGIT | TWO_DIGITS ;

ID : LETTER ( LETTER | DIGIT )* ;
NUM : DIGIT ( DIGIT )* ;
FLOAT: DIGIT ( DIGIT )* ('.' (DIGIT)* )? ;
CHAR : '\'' ASCII '\'' ;
DATE: '\''YEAR '-' MONTH '-' DAY'\'' ;

WHITESPACE : [\t\r\n\f ]+ -> skip ;

COMMENT : ( '//' ~[\r\n]* '\r'? '\n' | '/*' .*? '*/' ) -> skip ;

// PARSER SPECIFICATION

sql2003Parser : ( sql_executable_statement )+ ;

sql_executable_statement : sql_schema_statement #executableSchemaStatement
						 | sql_data_statement #executableDataStatement ;

sql_schema_statement : sql_schema_definition_statement #schemaStatement
					 | sql_schema_manipulation_statement #schemaManipulationStatement ;

sql_schema_definition_statement : schema_definition #schemaDefinitionStatement
								| table_definition #tableDefinitionStatement ;

sql_schema_manipulation_statement :	
			drop_schema_statement #manipulationDropSchema
		|	alter_table_statement #manipulationAlterTable
		|	drop_table_statement  #manipulationDropTable
        |   alter_database_statement #manipulationAlterDataBase
        |   use_schema_statement #manipulationUseSchema
        |   show_schema_statement #manipulationShowSchema
        |   rename_table_statement #manipulationRenameTable
        |   show_table_statement #manipulationShowTable
        |   show_column_statement #manipulationShowColumn ;
        
sql_data_statement : select_value ;

schema_definition: CREATE DATABASE ID ';' ;

table_definition: CREATE TABLE ID '(' (column)+ ')' ';' ;

drop_schema_statement: DROP DATABASE ID ';' ;

alter_table_statement: ALTER TABLE ID accion ';' ;

drop_table_statement: DROP TABLE ID ';' ;

alter_database_statement: ALTER DATABASE ID RENAME TO ID ';' ;

show_schema_statement: SHOW DATABASES ';' ;

use_schema_statement: USE DATABASE ID ';' ;

column: (ID tipo_literal | constraint) ',' ;

tipo_literal: RES_INT | RES_FLOAT | RES_CHAR | RES_DATE ;

constraint: CONSTRAINT constraintType ;

constraintType:
            ID PRIMARY KEY '(' ID (',' ID)*')' #constraintPrimaryKey
        |   ID FOREIGN KEY  '(' ID (',' ID)*')' REFERENCES ID '(' ID (',' ID)*')' #constraintForeignKey
        |   ID CHECK '('ID exp ID ')' #constraintCheck;

exp: logic #expLogic
	 | relational #expRelational;

rename_table_statement: ALTER TABLE ID RENAME TO ID ';' ;

accion:
          ADD COLUMN ID tipo_literal (constraint) #accionAddColumn
        | ADD constraint #accionAddConstraint
        | DROP COLUMN ID #accionDropColumn
        | DROP CONSTRAINT ID #accionDropConstraint;

show_table_statement: SHOW TABLES ';' ;

show_column_statement: SHOW COLUMNS FROM ID ';' ;         
          
logic: RES_AND | RES_OR | RES_NOT ;

relational: '<' | '<=' | '>' | '>=' | '<>' | '=' ;

insert_value: INSERT INTO (column) VALUES (list_values) ';' ;

update_value: UPDATE ID SET column '=' value WHERE condition ';' ;

delete_value: DELETE FROM ID WHERE condition ';' ;

select_value: SELECT ('*' | ID (',' ID)* ) FROM ID WHERE condition  (ORDER BY (ASC | DESC))? ';' ;
              
condition: ID '=' ID ;         
              
list_values : (value (',' (value))* ) ;
         
value: tipo;
              
tipo: literal;

literal:  
        int_literal #literal_int
    |   float_literal #literal_float
    |   date_literal #literal_date
    |   char_literal #literal_char ;

int_literal: NUM;
float_literal: FLOAT;
date_literal: DATE;
char_literal: CHAR;
