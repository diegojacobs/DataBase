// Generated from sql.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, CREATE=14, DATABASE=15, DATABASES=16, 
		TABLE=17, TABLES=18, DROP=19, ALTER=20, RENAME=21, TO=22, SHOW=23, USE=24, 
		RES_INT=25, RES_FLOAT=26, RES_CHAR=27, RES_DATE=28, CONSTRAINT=29, KEY=30, 
		PRIMARY=31, FOREIGN=32, REFERENCES=33, CHECK=34, ADD=35, COLUMN=36, COLUMNS=37, 
		FROM=38, RES_AND=39, RES_OR=40, RES_NOT=41, INSERT=42, INTO=43, VALUES=44, 
		UPDATE=45, SET=46, WHERE=47, DELETE=48, SELECT=49, ORDER=50, BY=51, ASC=52, 
		DESC=53, INT=54, ID=55, DATE=56, CHAR=57, WHITESPACE=58, COMMENT=59;
	public static final String[] tokenNames = {
		"<INVALID>", "'>='", "';'", "'<'", "'='", "'>'", "'<='", "'<>'", "'('", 
		"')'", "'*'", "','", "'-'", "'.'", "CREATE", "DATABASE", "DATABASES", 
		"TABLE", "TABLES", "DROP", "ALTER", "RENAME", "TO", "SHOW", "USE", "RES_INT", 
		"RES_FLOAT", "RES_CHAR", "RES_DATE", "CONSTRAINT", "KEY", "PRIMARY", "FOREIGN", 
		"REFERENCES", "CHECK", "ADD", "COLUMN", "COLUMNS", "FROM", "RES_AND", 
		"RES_OR", "RES_NOT", "INSERT", "INTO", "VALUES", "UPDATE", "SET", "WHERE", 
		"DELETE", "SELECT", "ORDER", "BY", "ASC", "DESC", "INT", "ID", "DATE", 
		"CHAR", "WHITESPACE", "COMMENT"
	};
	public static final int
		RULE_sql2003Parser = 0, RULE_sql_executable_statement = 1, RULE_sql_schema_statement = 2, 
		RULE_sql_schema_definition_statement = 3, RULE_sql_schema_manipulation_statement = 4, 
		RULE_sql_data_statement = 5, RULE_schema_definition = 6, RULE_table_definition = 7, 
		RULE_drop_schema_statement = 8, RULE_alter_table_statement = 9, RULE_idTable = 10, 
		RULE_idColumn = 11, RULE_idConstraint = 12, RULE_drop_table_statement = 13, 
		RULE_alter_database_statement = 14, RULE_show_schema_statement = 15, RULE_use_schema_statement = 16, 
		RULE_column = 17, RULE_tipo_literal = 18, RULE_constraint = 19, RULE_constraintType = 20, 
		RULE_idRef = 21, RULE_localIDS = 22, RULE_refIDS = 23, RULE_exp = 24, 
		RULE_rename_table_statement = 25, RULE_show_table_statement = 26, RULE_show_column_statement = 27, 
		RULE_logic = 28, RULE_logic_not = 29, RULE_relational = 30, RULE_insert_value = 31, 
		RULE_update_value = 32, RULE_asignacion = 33, RULE_delete_value = 34, 
		RULE_select_value = 35, RULE_order = 36, RULE_condition = 37, RULE_comp = 38, 
		RULE_columns = 39, RULE_columna = 40, RULE_list = 41, RULE_literal = 42, 
		RULE_int_literal = 43, RULE_float_literal = 44, RULE_date_literal = 45, 
		RULE_char_literal = 46;
	public static final String[] ruleNames = {
		"sql2003Parser", "sql_executable_statement", "sql_schema_statement", "sql_schema_definition_statement", 
		"sql_schema_manipulation_statement", "sql_data_statement", "schema_definition", 
		"table_definition", "drop_schema_statement", "alter_table_statement", 
		"idTable", "idColumn", "idConstraint", "drop_table_statement", "alter_database_statement", 
		"show_schema_statement", "use_schema_statement", "column", "tipo_literal", 
		"constraint", "constraintType", "idRef", "localIDS", "refIDS", "exp", 
		"rename_table_statement", "show_table_statement", "show_column_statement", 
		"logic", "logic_not", "relational", "insert_value", "update_value", "asignacion", 
		"delete_value", "select_value", "order", "condition", "comp", "columns", 
		"columna", "list", "literal", "int_literal", "float_literal", "date_literal", 
		"char_literal"
	};

	@Override
	public String getGrammarFileName() { return "sql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public sqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Sql2003ParserContext extends ParserRuleContext {
		public List<Sql_executable_statementContext> sql_executable_statement() {
			return getRuleContexts(Sql_executable_statementContext.class);
		}
		public Sql_executable_statementContext sql_executable_statement(int i) {
			return getRuleContext(Sql_executable_statementContext.class,i);
		}
		public Sql2003ParserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql2003Parser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql2003Parser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql2003Parser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql2003Parser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql2003ParserContext sql2003Parser() throws RecognitionException {
		Sql2003ParserContext _localctx = new Sql2003ParserContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sql2003Parser);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94); sql_executable_statement();
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CREATE) | (1L << DROP) | (1L << ALTER) | (1L << SHOW) | (1L << USE) | (1L << INSERT) | (1L << UPDATE) | (1L << DELETE) | (1L << SELECT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_executable_statementContext extends ParserRuleContext {
		public Sql_schema_statementContext sql_schema_statement() {
			return getRuleContext(Sql_schema_statementContext.class,0);
		}
		public Sql_data_statementContext sql_data_statement() {
			return getRuleContext(Sql_data_statementContext.class,0);
		}
		public Sql_executable_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_executable_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql_executable_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql_executable_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql_executable_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_executable_statementContext sql_executable_statement() throws RecognitionException {
		Sql_executable_statementContext _localctx = new Sql_executable_statementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sql_executable_statement);
		try {
			setState(101);
			switch (_input.LA(1)) {
			case CREATE:
			case DROP:
			case ALTER:
			case SHOW:
			case USE:
				enterOuterAlt(_localctx, 1);
				{
				setState(99); sql_schema_statement();
				}
				break;
			case INSERT:
			case UPDATE:
			case DELETE:
			case SELECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(100); sql_data_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_schema_statementContext extends ParserRuleContext {
		public Sql_schema_manipulation_statementContext sql_schema_manipulation_statement() {
			return getRuleContext(Sql_schema_manipulation_statementContext.class,0);
		}
		public Sql_schema_definition_statementContext sql_schema_definition_statement() {
			return getRuleContext(Sql_schema_definition_statementContext.class,0);
		}
		public Sql_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_schema_statementContext sql_schema_statement() throws RecognitionException {
		Sql_schema_statementContext _localctx = new Sql_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sql_schema_statement);
		try {
			setState(105);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(103); sql_schema_definition_statement();
				}
				break;
			case DROP:
			case ALTER:
			case SHOW:
			case USE:
				enterOuterAlt(_localctx, 2);
				{
				setState(104); sql_schema_manipulation_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_schema_definition_statementContext extends ParserRuleContext {
		public Table_definitionContext table_definition() {
			return getRuleContext(Table_definitionContext.class,0);
		}
		public Schema_definitionContext schema_definition() {
			return getRuleContext(Schema_definitionContext.class,0);
		}
		public Sql_schema_definition_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_schema_definition_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql_schema_definition_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql_schema_definition_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql_schema_definition_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_schema_definition_statementContext sql_schema_definition_statement() throws RecognitionException {
		Sql_schema_definition_statementContext _localctx = new Sql_schema_definition_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sql_schema_definition_statement);
		try {
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107); schema_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108); table_definition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_schema_manipulation_statementContext extends ParserRuleContext {
		public Drop_table_statementContext drop_table_statement() {
			return getRuleContext(Drop_table_statementContext.class,0);
		}
		public Drop_schema_statementContext drop_schema_statement() {
			return getRuleContext(Drop_schema_statementContext.class,0);
		}
		public Show_schema_statementContext show_schema_statement() {
			return getRuleContext(Show_schema_statementContext.class,0);
		}
		public Alter_table_statementContext alter_table_statement() {
			return getRuleContext(Alter_table_statementContext.class,0);
		}
		public Alter_database_statementContext alter_database_statement() {
			return getRuleContext(Alter_database_statementContext.class,0);
		}
		public Rename_table_statementContext rename_table_statement() {
			return getRuleContext(Rename_table_statementContext.class,0);
		}
		public Show_table_statementContext show_table_statement() {
			return getRuleContext(Show_table_statementContext.class,0);
		}
		public Use_schema_statementContext use_schema_statement() {
			return getRuleContext(Use_schema_statementContext.class,0);
		}
		public Show_column_statementContext show_column_statement() {
			return getRuleContext(Show_column_statementContext.class,0);
		}
		public Sql_schema_manipulation_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_schema_manipulation_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql_schema_manipulation_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql_schema_manipulation_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql_schema_manipulation_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_schema_manipulation_statementContext sql_schema_manipulation_statement() throws RecognitionException {
		Sql_schema_manipulation_statementContext _localctx = new Sql_schema_manipulation_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sql_schema_manipulation_statement);
		try {
			setState(120);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111); drop_schema_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112); alter_table_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113); drop_table_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(114); alter_database_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(115); use_schema_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(116); show_schema_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(117); rename_table_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(118); show_table_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(119); show_column_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_data_statementContext extends ParserRuleContext {
		public Delete_valueContext delete_value() {
			return getRuleContext(Delete_valueContext.class,0);
		}
		public Insert_valueContext insert_value() {
			return getRuleContext(Insert_valueContext.class,0);
		}
		public Update_valueContext update_value() {
			return getRuleContext(Update_valueContext.class,0);
		}
		public Select_valueContext select_value() {
			return getRuleContext(Select_valueContext.class,0);
		}
		public Sql_data_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_data_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSql_data_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSql_data_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSql_data_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_data_statementContext sql_data_statement() throws RecognitionException {
		Sql_data_statementContext _localctx = new Sql_data_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sql_data_statement);
		try {
			setState(126);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(122); select_value();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 2);
				{
				setState(123); insert_value();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 3);
				{
				setState(124); delete_value();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(125); update_value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_definitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode DATABASE() { return getToken(sqlParser.DATABASE, 0); }
		public TerminalNode CREATE() { return getToken(sqlParser.CREATE, 0); }
		public Schema_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSchema_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSchema_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSchema_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Schema_definitionContext schema_definition() throws RecognitionException {
		Schema_definitionContext _localctx = new Schema_definitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_schema_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(CREATE);
			setState(129); match(DATABASE);
			setState(130); match(ID);
			setState(131); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_definitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public TerminalNode CREATE() { return getToken(sqlParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(sqlParser.TABLE, 0); }
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public Table_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTable_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTable_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTable_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_definitionContext table_definition() throws RecognitionException {
		Table_definitionContext _localctx = new Table_definitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_table_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); match(CREATE);
			setState(134); match(TABLE);
			setState(135); match(ID);
			setState(136); match(T__5);
			setState(137); column();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(138); match(T__2);
				setState(139); column();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145); match(T__4);
			setState(146); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_schema_statementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode DATABASE() { return getToken(sqlParser.DATABASE, 0); }
		public TerminalNode DROP() { return getToken(sqlParser.DROP, 0); }
		public Drop_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDrop_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDrop_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDrop_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_schema_statementContext drop_schema_statement() throws RecognitionException {
		Drop_schema_statementContext _localctx = new Drop_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_drop_schema_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); match(DROP);
			setState(149); match(DATABASE);
			setState(150); match(ID);
			setState(151); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_table_statementContext extends ParserRuleContext {
		public Alter_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_statement; }
	 
		public Alter_table_statementContext() { }
		public void copyFrom(Alter_table_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AlterAddColumnContext extends Alter_table_statementContext {
		public IdTableContext idTable() {
			return getRuleContext(IdTableContext.class,0);
		}
		public TerminalNode COLUMN() { return getToken(sqlParser.COLUMN, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode ADD() { return getToken(sqlParser.ADD, 0); }
		public TerminalNode ALTER() { return getToken(sqlParser.ALTER, 0); }
		public Tipo_literalContext tipo_literal() {
			return getRuleContext(Tipo_literalContext.class,0);
		}
		public IdColumnContext idColumn() {
			return getRuleContext(IdColumnContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(sqlParser.TABLE, 0); }
		public AlterAddColumnContext(Alter_table_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAlterAddColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAlterAddColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAlterAddColumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlterDropColumnContext extends Alter_table_statementContext {
		public IdTableContext idTable() {
			return getRuleContext(IdTableContext.class,0);
		}
		public TerminalNode COLUMN() { return getToken(sqlParser.COLUMN, 0); }
		public TerminalNode DROP() { return getToken(sqlParser.DROP, 0); }
		public TerminalNode ALTER() { return getToken(sqlParser.ALTER, 0); }
		public IdColumnContext idColumn() {
			return getRuleContext(IdColumnContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(sqlParser.TABLE, 0); }
		public AlterDropColumnContext(Alter_table_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAlterDropColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAlterDropColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAlterDropColumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlterDropConstraintContext extends Alter_table_statementContext {
		public IdTableContext idTable() {
			return getRuleContext(IdTableContext.class,0);
		}
		public IdConstraintContext idConstraint() {
			return getRuleContext(IdConstraintContext.class,0);
		}
		public TerminalNode DROP() { return getToken(sqlParser.DROP, 0); }
		public TerminalNode CONSTRAINT() { return getToken(sqlParser.CONSTRAINT, 0); }
		public TerminalNode ALTER() { return getToken(sqlParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(sqlParser.TABLE, 0); }
		public AlterDropConstraintContext(Alter_table_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAlterDropConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAlterDropConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAlterDropConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlterAddConstraintContext extends Alter_table_statementContext {
		public IdTableContext idTable() {
			return getRuleContext(IdTableContext.class,0);
		}
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode ADD() { return getToken(sqlParser.ADD, 0); }
		public TerminalNode ALTER() { return getToken(sqlParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(sqlParser.TABLE, 0); }
		public AlterAddConstraintContext(Alter_table_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAlterAddConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAlterAddConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAlterAddConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alter_table_statementContext alter_table_statement() throws RecognitionException {
		Alter_table_statementContext _localctx = new Alter_table_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_alter_table_statement);
		try {
			setState(186);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AlterAddColumnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(153); match(ALTER);
				setState(154); match(TABLE);
				setState(155); idTable();
				setState(156); match(ADD);
				setState(157); match(COLUMN);
				setState(158); idColumn();
				setState(159); tipo_literal();
				setState(160); constraint();
				setState(161); match(T__11);
				}
				break;
			case 2:
				_localctx = new AlterAddConstraintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(163); match(ALTER);
				setState(164); match(TABLE);
				setState(165); idTable();
				setState(166); match(ADD);
				setState(167); constraint();
				setState(168); match(T__11);
				}
				break;
			case 3:
				_localctx = new AlterDropColumnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(170); match(ALTER);
				setState(171); match(TABLE);
				setState(172); idTable();
				setState(173); match(DROP);
				setState(174); match(COLUMN);
				setState(175); idColumn();
				setState(176); match(T__11);
				}
				break;
			case 4:
				_localctx = new AlterDropConstraintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(178); match(ALTER);
				setState(179); match(TABLE);
				setState(180); idTable();
				setState(181); match(DROP);
				setState(182); match(CONSTRAINT);
				setState(183); idConstraint();
				setState(184); match(T__11);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdTableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public IdTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterIdTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitIdTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitIdTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdTableContext idTable() throws RecognitionException {
		IdTableContext _localctx = new IdTableContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_idTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdColumnContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public IdColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idColumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterIdColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitIdColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitIdColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdColumnContext idColumn() throws RecognitionException {
		IdColumnContext _localctx = new IdColumnContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_idColumn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdConstraintContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public IdConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterIdConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitIdConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitIdConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdConstraintContext idConstraint() throws RecognitionException {
		IdConstraintContext _localctx = new IdConstraintContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_idConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_table_statementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode DROP() { return getToken(sqlParser.DROP, 0); }
		public TerminalNode TABLE() { return getToken(sqlParser.TABLE, 0); }
		public Drop_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDrop_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDrop_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDrop_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_table_statementContext drop_table_statement() throws RecognitionException {
		Drop_table_statementContext _localctx = new Drop_table_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(DROP);
			setState(195); match(TABLE);
			setState(196); match(ID);
			setState(197); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_database_statementContext extends ParserRuleContext {
		public TerminalNode RENAME() { return getToken(sqlParser.RENAME, 0); }
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode DATABASE() { return getToken(sqlParser.DATABASE, 0); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public TerminalNode TO() { return getToken(sqlParser.TO, 0); }
		public TerminalNode ALTER() { return getToken(sqlParser.ALTER, 0); }
		public Alter_database_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_database_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAlter_database_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAlter_database_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAlter_database_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alter_database_statementContext alter_database_statement() throws RecognitionException {
		Alter_database_statementContext _localctx = new Alter_database_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_alter_database_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(ALTER);
			setState(200); match(DATABASE);
			setState(201); match(ID);
			setState(202); match(RENAME);
			setState(203); match(TO);
			setState(204); match(ID);
			setState(205); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_schema_statementContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(sqlParser.SHOW, 0); }
		public TerminalNode DATABASES() { return getToken(sqlParser.DATABASES, 0); }
		public Show_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterShow_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitShow_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitShow_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_schema_statementContext show_schema_statement() throws RecognitionException {
		Show_schema_statementContext _localctx = new Show_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_show_schema_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); match(SHOW);
			setState(208); match(DATABASES);
			setState(209); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Use_schema_statementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode DATABASE() { return getToken(sqlParser.DATABASE, 0); }
		public TerminalNode USE() { return getToken(sqlParser.USE, 0); }
		public Use_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterUse_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitUse_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitUse_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Use_schema_statementContext use_schema_statement() throws RecognitionException {
		Use_schema_statementContext _localctx = new Use_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_use_schema_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); match(USE);
			setState(212); match(DATABASE);
			setState(213); match(ID);
			setState(214); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnContext extends ParserRuleContext {
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
	 
		public ColumnContext() { }
		public void copyFrom(ColumnContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Column_constraintContext extends ColumnContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public Column_constraintContext(ColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterColumn_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitColumn_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitColumn_constraint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Column_literalContext extends ColumnContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public Tipo_literalContext tipo_literal() {
			return getRuleContext(Tipo_literalContext.class,0);
		}
		public Column_literalContext(ColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterColumn_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitColumn_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitColumn_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_column);
		try {
			setState(219);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new Column_literalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(216); match(ID);
				setState(217); tipo_literal();
				}
				break;
			case CONSTRAINT:
				_localctx = new Column_constraintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(218); constraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_literalContext extends ParserRuleContext {
		public Tipo_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_literal; }
	 
		public Tipo_literalContext() { }
		public void copyFrom(Tipo_literalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Tipo_lit_floatContext extends Tipo_literalContext {
		public TerminalNode RES_FLOAT() { return getToken(sqlParser.RES_FLOAT, 0); }
		public Tipo_lit_floatContext(Tipo_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTipo_lit_float(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTipo_lit_float(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTipo_lit_float(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Tipo_lit_dateContext extends Tipo_literalContext {
		public TerminalNode RES_DATE() { return getToken(sqlParser.RES_DATE, 0); }
		public Tipo_lit_dateContext(Tipo_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTipo_lit_date(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTipo_lit_date(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTipo_lit_date(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Tipo_lit_charContext extends Tipo_literalContext {
		public TerminalNode RES_CHAR() { return getToken(sqlParser.RES_CHAR, 0); }
		public TerminalNode INT() { return getToken(sqlParser.INT, 0); }
		public Tipo_lit_charContext(Tipo_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTipo_lit_char(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTipo_lit_char(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTipo_lit_char(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Tipo_lit_intContext extends Tipo_literalContext {
		public TerminalNode RES_INT() { return getToken(sqlParser.RES_INT, 0); }
		public Tipo_lit_intContext(Tipo_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTipo_lit_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTipo_lit_int(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTipo_lit_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_literalContext tipo_literal() throws RecognitionException {
		Tipo_literalContext _localctx = new Tipo_literalContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_tipo_literal);
		try {
			setState(228);
			switch (_input.LA(1)) {
			case RES_INT:
				_localctx = new Tipo_lit_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(221); match(RES_INT);
				}
				break;
			case RES_FLOAT:
				_localctx = new Tipo_lit_floatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(222); match(RES_FLOAT);
				}
				break;
			case RES_CHAR:
				_localctx = new Tipo_lit_charContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(223); match(RES_CHAR);
				setState(224); match(T__5);
				setState(225); match(INT);
				setState(226); match(T__4);
				}
				}
				break;
			case RES_DATE:
				_localctx = new Tipo_lit_dateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(227); match(RES_DATE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintContext extends ParserRuleContext {
		public TerminalNode CONSTRAINT() { return getToken(sqlParser.CONSTRAINT, 0); }
		public ConstraintTypeContext constraintType() {
			return getRuleContext(ConstraintTypeContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); match(CONSTRAINT);
			setState(231); constraintType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintTypeContext extends ParserRuleContext {
		public ConstraintTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintType; }
	 
		public ConstraintTypeContext() { }
		public void copyFrom(ConstraintTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstraintTypePrimaryKeyContext extends ConstraintTypeContext {
		public TerminalNode PRIMARY() { return getToken(sqlParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(sqlParser.KEY, 0); }
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public LocalIDSContext localIDS() {
			return getRuleContext(LocalIDSContext.class,0);
		}
		public ConstraintTypePrimaryKeyContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraintTypePrimaryKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraintTypePrimaryKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraintTypePrimaryKey(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstraintTypeForeignKeyContext extends ConstraintTypeContext {
		public TerminalNode KEY() { return getToken(sqlParser.KEY, 0); }
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public IdRefContext idRef() {
			return getRuleContext(IdRefContext.class,0);
		}
		public RefIDSContext refIDS() {
			return getRuleContext(RefIDSContext.class,0);
		}
		public TerminalNode REFERENCES() { return getToken(sqlParser.REFERENCES, 0); }
		public TerminalNode FOREIGN() { return getToken(sqlParser.FOREIGN, 0); }
		public LocalIDSContext localIDS() {
			return getRuleContext(LocalIDSContext.class,0);
		}
		public ConstraintTypeForeignKeyContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraintTypeForeignKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraintTypeForeignKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraintTypeForeignKey(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstraintTypeCheckContext extends ConstraintTypeContext {
		public TerminalNode CHECK() { return getToken(sqlParser.CHECK, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public ConstraintTypeCheckContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConstraintTypeCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConstraintTypeCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConstraintTypeCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintTypeContext constraintType() throws RecognitionException {
		ConstraintTypeContext _localctx = new ConstraintTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constraintType);
		try {
			setState(260);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new ConstraintTypePrimaryKeyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(233); match(ID);
				setState(234); match(PRIMARY);
				setState(235); match(KEY);
				setState(236); match(T__5);
				setState(237); localIDS();
				setState(238); match(T__4);
				}
				break;
			case 2:
				_localctx = new ConstraintTypeForeignKeyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(240); match(ID);
				setState(241); match(FOREIGN);
				setState(242); match(KEY);
				setState(243); match(T__5);
				setState(244); localIDS();
				setState(245); match(T__4);
				setState(246); match(REFERENCES);
				setState(247); idRef();
				setState(248); match(T__5);
				setState(249); refIDS();
				setState(250); match(T__4);
				}
				break;
			case 3:
				_localctx = new ConstraintTypeCheckContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(252); match(ID);
				setState(253); match(CHECK);
				setState(254); match(T__5);
				setState(255); match(ID);
				setState(256); exp();
				setState(257); match(ID);
				setState(258); match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdRefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public IdRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterIdRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitIdRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitIdRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdRefContext idRef() throws RecognitionException {
		IdRefContext _localctx = new IdRefContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_idRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalIDSContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public LocalIDSContext localIDS() {
			return getRuleContext(LocalIDSContext.class,0);
		}
		public LocalIDSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localIDS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLocalIDS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLocalIDS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLocalIDS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalIDSContext localIDS() throws RecognitionException {
		LocalIDSContext _localctx = new LocalIDSContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_localIDS);
		try {
			setState(268);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(264); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(265); match(ID);
				setState(266); match(T__2);
				setState(267); localIDS();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RefIDSContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public RefIDSContext refIDS() {
			return getRuleContext(RefIDSContext.class,0);
		}
		public RefIDSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refIDS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterRefIDS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitRefIDS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitRefIDS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefIDSContext refIDS() throws RecognitionException {
		RefIDSContext _localctx = new RefIDSContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_refIDS);
		try {
			setState(274);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(270); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(271); match(ID);
				setState(272); match(T__2);
				setState(273); refIDS();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Exp_logicContext extends ExpContext {
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public Exp_logicContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExp_logic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExp_logic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExp_logic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_logic_notContext extends ExpContext {
		public Logic_notContext logic_not() {
			return getRuleContext(Logic_notContext.class,0);
		}
		public Exp_logic_notContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExp_logic_not(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExp_logic_not(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExp_logic_not(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_relationalContext extends ExpContext {
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public Exp_relationalContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterExp_relational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitExp_relational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitExp_relational(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_exp);
		try {
			setState(279);
			switch (_input.LA(1)) {
			case RES_AND:
			case RES_OR:
				_localctx = new Exp_logicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(276); logic();
				}
				break;
			case RES_NOT:
				_localctx = new Exp_logic_notContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(277); logic_not();
				}
				break;
			case T__12:
			case T__10:
			case T__9:
			case T__8:
			case T__7:
			case T__6:
				_localctx = new Exp_relationalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(278); relational();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rename_table_statementContext extends ParserRuleContext {
		public TerminalNode RENAME() { return getToken(sqlParser.RENAME, 0); }
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public TerminalNode TO() { return getToken(sqlParser.TO, 0); }
		public TerminalNode ALTER() { return getToken(sqlParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(sqlParser.TABLE, 0); }
		public Rename_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rename_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterRename_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitRename_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitRename_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rename_table_statementContext rename_table_statement() throws RecognitionException {
		Rename_table_statementContext _localctx = new Rename_table_statementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_rename_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); match(ALTER);
			setState(282); match(TABLE);
			setState(283); match(ID);
			setState(284); match(RENAME);
			setState(285); match(TO);
			setState(286); match(ID);
			setState(287); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_table_statementContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(sqlParser.SHOW, 0); }
		public TerminalNode TABLES() { return getToken(sqlParser.TABLES, 0); }
		public Show_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterShow_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitShow_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitShow_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_table_statementContext show_table_statement() throws RecognitionException {
		Show_table_statementContext _localctx = new Show_table_statementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_show_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289); match(SHOW);
			setState(290); match(TABLES);
			setState(291); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_column_statementContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(sqlParser.SHOW, 0); }
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode COLUMNS() { return getToken(sqlParser.COLUMNS, 0); }
		public TerminalNode FROM() { return getToken(sqlParser.FROM, 0); }
		public Show_column_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_column_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterShow_column_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitShow_column_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitShow_column_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_column_statementContext show_column_statement() throws RecognitionException {
		Show_column_statementContext _localctx = new Show_column_statementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_show_column_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); match(SHOW);
			setState(294); match(COLUMNS);
			setState(295); match(FROM);
			setState(296); match(ID);
			setState(297); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicContext extends ParserRuleContext {
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
	 
		public LogicContext() { }
		public void copyFrom(LogicContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Logic_andContext extends LogicContext {
		public TerminalNode RES_AND() { return getToken(sqlParser.RES_AND, 0); }
		public Logic_andContext(LogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLogic_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLogic_and(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLogic_and(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Logic_orContext extends LogicContext {
		public TerminalNode RES_OR() { return getToken(sqlParser.RES_OR, 0); }
		public Logic_orContext(LogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLogic_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLogic_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLogic_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicContext logic() throws RecognitionException {
		LogicContext _localctx = new LogicContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_logic);
		try {
			setState(301);
			switch (_input.LA(1)) {
			case RES_AND:
				_localctx = new Logic_andContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(299); match(RES_AND);
				}
				break;
			case RES_OR:
				_localctx = new Logic_orContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(300); match(RES_OR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logic_notContext extends ParserRuleContext {
		public TerminalNode RES_NOT() { return getToken(sqlParser.RES_NOT, 0); }
		public Logic_notContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLogic_not(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLogic_not(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLogic_not(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_notContext logic_not() throws RecognitionException {
		Logic_notContext _localctx = new Logic_notContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_logic_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303); match(RES_NOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalContext extends ParserRuleContext {
		public RelationalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitRelational(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalContext relational() throws RecognitionException {
		RelationalContext _localctx = new RelationalContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_relational);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__10) | (1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__6))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode VALUES() { return getToken(sqlParser.VALUES, 0); }
		public ColumnsContext columns() {
			return getRuleContext(ColumnsContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(sqlParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(sqlParser.INTO, 0); }
		public Insert_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterInsert_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitInsert_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitInsert_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Insert_valueContext insert_value() throws RecognitionException {
		Insert_valueContext _localctx = new Insert_valueContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_insert_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307); match(INSERT);
			setState(308); match(INTO);
			setState(309); match(ID);
			setState(311);
			_la = _input.LA(1);
			if (_la==T__5 || _la==ID) {
				{
				setState(310); columns();
				}
			}

			setState(313); match(VALUES);
			setState(314); list();
			setState(315); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode UPDATE() { return getToken(sqlParser.UPDATE, 0); }
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(sqlParser.WHERE, 0); }
		public TerminalNode SET() { return getToken(sqlParser.SET, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Update_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterUpdate_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitUpdate_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitUpdate_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_valueContext update_value() throws RecognitionException {
		Update_valueContext _localctx = new Update_valueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_update_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317); match(UPDATE);
			setState(318); match(ID);
			setState(319); match(SET);
			setState(320); asignacion();
			setState(323);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(321); match(WHERE);
				setState(322); condition();
				}
			}

			setState(325); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsignacionContext extends ParserRuleContext {
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<ColumnaContext> columna() {
			return getRuleContexts(ColumnaContext.class);
		}
		public ColumnaContext columna(int i) {
			return getRuleContext(ColumnaContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_asignacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327); columna();
			setState(328); match(T__9);
			setState(329); literal();
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(330); match(T__2);
				setState(331); columna();
				setState(332); match(T__9);
				setState(333); literal();
				}
				}
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode DELETE() { return getToken(sqlParser.DELETE, 0); }
		public TerminalNode WHERE() { return getToken(sqlParser.WHERE, 0); }
		public TerminalNode FROM() { return getToken(sqlParser.FROM, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Delete_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDelete_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDelete_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDelete_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Delete_valueContext delete_value() throws RecognitionException {
		Delete_valueContext _localctx = new Delete_valueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_delete_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340); match(DELETE);
			setState(341); match(FROM);
			setState(342); match(ID);
			setState(345);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(343); match(WHERE);
				setState(344); condition();
				}
			}

			setState(347); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_valueContext extends ParserRuleContext {
		public LocalIDSContext localIDS(int i) {
			return getRuleContext(LocalIDSContext.class,i);
		}
		public OrderContext order() {
			return getRuleContext(OrderContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(sqlParser.WHERE, 0); }
		public TerminalNode FROM() { return getToken(sqlParser.FROM, 0); }
		public TerminalNode SELECT() { return getToken(sqlParser.SELECT, 0); }
		public List<LocalIDSContext> localIDS() {
			return getRuleContexts(LocalIDSContext.class);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Select_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterSelect_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitSelect_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitSelect_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_valueContext select_value() throws RecognitionException {
		Select_valueContext _localctx = new Select_valueContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_select_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349); match(SELECT);
			setState(352);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(350); match(T__3);
				}
				break;
			case ID:
				{
				setState(351); localIDS();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(354); match(FROM);
			setState(355); localIDS();
			setState(358);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(356); match(WHERE);
				setState(357); condition();
				}
			}

			setState(361);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(360); order();
				}
			}

			setState(363); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode ASC() { return getToken(sqlParser.ASC, 0); }
		public TerminalNode ORDER() { return getToken(sqlParser.ORDER, 0); }
		public OrderContext order() {
			return getRuleContext(OrderContext.class,0);
		}
		public TerminalNode DESC() { return getToken(sqlParser.DESC, 0); }
		public TerminalNode BY() { return getToken(sqlParser.BY, 0); }
		public OrderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterOrder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitOrder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitOrder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderContext order() throws RecognitionException {
		OrderContext _localctx = new OrderContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_order);
		int _la;
		try {
			setState(379);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(365); match(ORDER);
				setState(366); match(BY);
				setState(367); match(ID);
				setState(369);
				_la = _input.LA(1);
				if (_la==ASC || _la==DESC) {
					{
					setState(368);
					_la = _input.LA(1);
					if ( !(_la==ASC || _la==DESC) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(371); match(ORDER);
				setState(372); match(BY);
				setState(373); match(ID);
				setState(375);
				_la = _input.LA(1);
				if (_la==ASC || _la==DESC) {
					{
					setState(374);
					_la = _input.LA(1);
					if ( !(_la==ASC || _la==DESC) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(377); match(T__2);
				setState(378); order();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionNotContext extends ConditionContext {
		public Logic_notContext logic_not() {
			return getRuleContext(Logic_notContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionNotContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConditionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConditionNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConditionNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionCondContext extends ConditionContext {
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionCondContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConditionCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConditionCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConditionCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionCompContext extends ConditionContext {
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionCompContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterConditionComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitConditionComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitConditionComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_condition);
		int _la;
		try {
			setState(398);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new ConditionCondContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(381); match(T__5);
				setState(382); condition();
				setState(383); match(T__4);
				setState(387);
				_la = _input.LA(1);
				if (_la==RES_AND || _la==RES_OR) {
					{
					setState(384); logic();
					setState(385); condition();
					}
				}

				}
				break;
			case T__1:
			case INT:
			case ID:
			case DATE:
			case CHAR:
				_localctx = new ConditionCompContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(389); comp();
				setState(393);
				_la = _input.LA(1);
				if (_la==RES_AND || _la==RES_OR) {
					{
					setState(390); logic();
					setState(391); condition();
					}
				}

				}
				break;
			case RES_NOT:
				_localctx = new ConditionNotContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(395); logic_not();
				setState(396); condition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompContext extends ParserRuleContext {
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
	 
		public CompContext() { }
		public void copyFrom(CompContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CompIdContext extends CompContext {
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public CompIdContext(CompContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCompId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCompId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCompId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompLitIdContext extends CompContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public CompLitIdContext(CompContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCompLitId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCompLitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCompLitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompLitContext extends CompContext {
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public CompLitContext(CompContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCompLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCompLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCompLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_comp);
		try {
			setState(414);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new CompIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(400); match(ID);
				setState(401); relational();
				setState(404);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(402); match(ID);
					}
					break;
				case T__1:
				case INT:
				case DATE:
				case CHAR:
					{
					setState(403); literal();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new CompLitIdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(406); literal();
				setState(407); relational();
				setState(408); match(ID);
				}
				break;
			case 3:
				_localctx = new CompLitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(410); literal();
				setState(411); relational();
				setState(412); literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnsContext extends ParserRuleContext {
		public List<ColumnaContext> columna() {
			return getRuleContexts(ColumnaContext.class);
		}
		public ColumnaContext columna(int i) {
			return getRuleContext(ColumnaContext.class,i);
		}
		public ColumnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterColumns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitColumns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitColumns(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnsContext columns() throws RecognitionException {
		ColumnsContext _localctx = new ColumnsContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_columns);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(416); columna();
				setState(421);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(417); match(T__2);
					setState(418); columna();
					}
					}
					setState(423);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__5:
				{
				{
				setState(424); match(T__5);
				setState(425); columna();
				setState(430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(426); match(T__2);
					setState(427); columna();
					}
					}
					setState(432);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(433); match(T__4);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public ColumnaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columna; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterColumna(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitColumna(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitColumna(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnaContext columna() throws RecognitionException {
		ColumnaContext _localctx = new ColumnaContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_columna);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListContext extends ParserRuleContext {
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_list);
		int _la;
		try {
			setState(458);
			switch (_input.LA(1)) {
			case T__1:
			case INT:
			case DATE:
			case CHAR:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(439); literal();
				setState(444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(440); match(T__2);
					setState(441); literal();
					}
					}
					setState(446);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(447); match(T__5);
				{
				setState(448); literal();
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(449); match(T__2);
					setState(450); literal();
					}
					}
					setState(455);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(456); match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public Int_literalContext int_literal() {
			return getRuleContext(Int_literalContext.class,0);
		}
		public Date_literalContext date_literal() {
			return getRuleContext(Date_literalContext.class,0);
		}
		public Float_literalContext float_literal() {
			return getRuleContext(Float_literalContext.class,0);
		}
		public Char_literalContext char_literal() {
			return getRuleContext(Char_literalContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_literal);
		try {
			setState(464);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(460); int_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(461); float_literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(462); date_literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(463); char_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_literalContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(sqlParser.INT, 0); }
		public Int_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterInt_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitInt_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitInt_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_literalContext int_literal() throws RecognitionException {
		Int_literalContext _localctx = new Int_literalContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_int_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(466); match(T__1);
				}
			}

			setState(469); match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Float_literalContext extends ParserRuleContext {
		public TerminalNode INT(int i) {
			return getToken(sqlParser.INT, i);
		}
		public List<TerminalNode> INT() { return getTokens(sqlParser.INT); }
		public Float_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_float_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterFloat_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitFloat_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitFloat_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Float_literalContext float_literal() throws RecognitionException {
		Float_literalContext _localctx = new Float_literalContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_float_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(471); match(T__1);
				}
			}

			setState(474); match(INT);
			setState(477);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(475); match(T__0);
				setState(476); match(INT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Date_literalContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(sqlParser.DATE, 0); }
		public Date_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterDate_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitDate_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitDate_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_literalContext date_literal() throws RecognitionException {
		Date_literalContext _localctx = new Date_literalContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479); match(DATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_literalContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(sqlParser.CHAR, 0); }
		public Char_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterChar_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitChar_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitChar_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Char_literalContext char_literal() throws RecognitionException {
		Char_literalContext _localctx = new Char_literalContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_char_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481); match(CHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3=\u01e6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\6\2b\n\2\r\2\16\2c\3\3\3\3\5\3h\n"+
		"\3\3\4\3\4\5\4l\n\4\3\5\3\5\5\5p\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6{\n\6\3\7\3\7\3\7\3\7\5\7\u0081\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\7\t\u008f\n\t\f\t\16\t\u0092\13\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00bd\n\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\5"+
		"\23\u00de\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00e7\n\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u0107\n\26\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u010f\n\30\3"+
		"\31\3\31\3\31\3\31\5\31\u0115\n\31\3\32\3\32\3\32\5\32\u011a\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\5\36\u0130\n\36\3\37\3\37\3 \3 \3!\3!\3!\3!"+
		"\5!\u013a\n!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0146\n\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3#\3#\3#\7#\u0152\n#\f#\16#\u0155\13#\3$\3$\3$\3$\3$\5"+
		"$\u015c\n$\3$\3$\3%\3%\3%\5%\u0163\n%\3%\3%\3%\3%\5%\u0169\n%\3%\5%\u016c"+
		"\n%\3%\3%\3&\3&\3&\3&\5&\u0174\n&\3&\3&\3&\3&\5&\u017a\n&\3&\3&\5&\u017e"+
		"\n&\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0186\n\'\3\'\3\'\3\'\3\'\5\'\u018c\n"+
		"\'\3\'\3\'\3\'\5\'\u0191\n\'\3(\3(\3(\3(\5(\u0197\n(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\5(\u01a1\n(\3)\3)\3)\7)\u01a6\n)\f)\16)\u01a9\13)\3)\3)\3)\3)"+
		"\7)\u01af\n)\f)\16)\u01b2\13)\3)\3)\5)\u01b6\n)\3*\3*\3+\3+\3+\7+\u01bd"+
		"\n+\f+\16+\u01c0\13+\3+\3+\3+\3+\7+\u01c6\n+\f+\16+\u01c9\13+\3+\3+\5"+
		"+\u01cd\n+\3,\3,\3,\3,\5,\u01d3\n,\3-\5-\u01d6\n-\3-\3-\3.\5.\u01db\n"+
		".\3.\3.\3.\5.\u01e0\n.\3/\3/\3\60\3\60\3\60\2\2\61\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^\2\4\4\2\3"+
		"\3\5\t\3\2\66\67\u01f1\2a\3\2\2\2\4g\3\2\2\2\6k\3\2\2\2\bo\3\2\2\2\nz"+
		"\3\2\2\2\f\u0080\3\2\2\2\16\u0082\3\2\2\2\20\u0087\3\2\2\2\22\u0096\3"+
		"\2\2\2\24\u00bc\3\2\2\2\26\u00be\3\2\2\2\30\u00c0\3\2\2\2\32\u00c2\3\2"+
		"\2\2\34\u00c4\3\2\2\2\36\u00c9\3\2\2\2 \u00d1\3\2\2\2\"\u00d5\3\2\2\2"+
		"$\u00dd\3\2\2\2&\u00e6\3\2\2\2(\u00e8\3\2\2\2*\u0106\3\2\2\2,\u0108\3"+
		"\2\2\2.\u010e\3\2\2\2\60\u0114\3\2\2\2\62\u0119\3\2\2\2\64\u011b\3\2\2"+
		"\2\66\u0123\3\2\2\28\u0127\3\2\2\2:\u012f\3\2\2\2<\u0131\3\2\2\2>\u0133"+
		"\3\2\2\2@\u0135\3\2\2\2B\u013f\3\2\2\2D\u0149\3\2\2\2F\u0156\3\2\2\2H"+
		"\u015f\3\2\2\2J\u017d\3\2\2\2L\u0190\3\2\2\2N\u01a0\3\2\2\2P\u01b5\3\2"+
		"\2\2R\u01b7\3\2\2\2T\u01cc\3\2\2\2V\u01d2\3\2\2\2X\u01d5\3\2\2\2Z\u01da"+
		"\3\2\2\2\\\u01e1\3\2\2\2^\u01e3\3\2\2\2`b\5\4\3\2a`\3\2\2\2bc\3\2\2\2"+
		"ca\3\2\2\2cd\3\2\2\2d\3\3\2\2\2eh\5\6\4\2fh\5\f\7\2ge\3\2\2\2gf\3\2\2"+
		"\2h\5\3\2\2\2il\5\b\5\2jl\5\n\6\2ki\3\2\2\2kj\3\2\2\2l\7\3\2\2\2mp\5\16"+
		"\b\2np\5\20\t\2om\3\2\2\2on\3\2\2\2p\t\3\2\2\2q{\5\22\n\2r{\5\24\13\2"+
		"s{\5\34\17\2t{\5\36\20\2u{\5\"\22\2v{\5 \21\2w{\5\64\33\2x{\5\66\34\2"+
		"y{\58\35\2zq\3\2\2\2zr\3\2\2\2zs\3\2\2\2zt\3\2\2\2zu\3\2\2\2zv\3\2\2\2"+
		"zw\3\2\2\2zx\3\2\2\2zy\3\2\2\2{\13\3\2\2\2|\u0081\5H%\2}\u0081\5@!\2~"+
		"\u0081\5F$\2\177\u0081\5B\"\2\u0080|\3\2\2\2\u0080}\3\2\2\2\u0080~\3\2"+
		"\2\2\u0080\177\3\2\2\2\u0081\r\3\2\2\2\u0082\u0083\7\20\2\2\u0083\u0084"+
		"\7\21\2\2\u0084\u0085\79\2\2\u0085\u0086\7\4\2\2\u0086\17\3\2\2\2\u0087"+
		"\u0088\7\20\2\2\u0088\u0089\7\23\2\2\u0089\u008a\79\2\2\u008a\u008b\7"+
		"\n\2\2\u008b\u0090\5$\23\2\u008c\u008d\7\r\2\2\u008d\u008f\5$\23\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7\13\2\2\u0094"+
		"\u0095\7\4\2\2\u0095\21\3\2\2\2\u0096\u0097\7\25\2\2\u0097\u0098\7\21"+
		"\2\2\u0098\u0099\79\2\2\u0099\u009a\7\4\2\2\u009a\23\3\2\2\2\u009b\u009c"+
		"\7\26\2\2\u009c\u009d\7\23\2\2\u009d\u009e\5\26\f\2\u009e\u009f\7%\2\2"+
		"\u009f\u00a0\7&\2\2\u00a0\u00a1\5\30\r\2\u00a1\u00a2\5&\24\2\u00a2\u00a3"+
		"\5(\25\2\u00a3\u00a4\7\4\2\2\u00a4\u00bd\3\2\2\2\u00a5\u00a6\7\26\2\2"+
		"\u00a6\u00a7\7\23\2\2\u00a7\u00a8\5\26\f\2\u00a8\u00a9\7%\2\2\u00a9\u00aa"+
		"\5(\25\2\u00aa\u00ab\7\4\2\2\u00ab\u00bd\3\2\2\2\u00ac\u00ad\7\26\2\2"+
		"\u00ad\u00ae\7\23\2\2\u00ae\u00af\5\26\f\2\u00af\u00b0\7\25\2\2\u00b0"+
		"\u00b1\7&\2\2\u00b1\u00b2\5\30\r\2\u00b2\u00b3\7\4\2\2\u00b3\u00bd\3\2"+
		"\2\2\u00b4\u00b5\7\26\2\2\u00b5\u00b6\7\23\2\2\u00b6\u00b7\5\26\f\2\u00b7"+
		"\u00b8\7\25\2\2\u00b8\u00b9\7\37\2\2\u00b9\u00ba\5\32\16\2\u00ba\u00bb"+
		"\7\4\2\2\u00bb\u00bd\3\2\2\2\u00bc\u009b\3\2\2\2\u00bc\u00a5\3\2\2\2\u00bc"+
		"\u00ac\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bd\25\3\2\2\2\u00be\u00bf\79\2\2"+
		"\u00bf\27\3\2\2\2\u00c0\u00c1\79\2\2\u00c1\31\3\2\2\2\u00c2\u00c3\79\2"+
		"\2\u00c3\33\3\2\2\2\u00c4\u00c5\7\25\2\2\u00c5\u00c6\7\23\2\2\u00c6\u00c7"+
		"\79\2\2\u00c7\u00c8\7\4\2\2\u00c8\35\3\2\2\2\u00c9\u00ca\7\26\2\2\u00ca"+
		"\u00cb\7\21\2\2\u00cb\u00cc\79\2\2\u00cc\u00cd\7\27\2\2\u00cd\u00ce\7"+
		"\30\2\2\u00ce\u00cf\79\2\2\u00cf\u00d0\7\4\2\2\u00d0\37\3\2\2\2\u00d1"+
		"\u00d2\7\31\2\2\u00d2\u00d3\7\22\2\2\u00d3\u00d4\7\4\2\2\u00d4!\3\2\2"+
		"\2\u00d5\u00d6\7\32\2\2\u00d6\u00d7\7\21\2\2\u00d7\u00d8\79\2\2\u00d8"+
		"\u00d9\7\4\2\2\u00d9#\3\2\2\2\u00da\u00db\79\2\2\u00db\u00de\5&\24\2\u00dc"+
		"\u00de\5(\25\2\u00dd\u00da\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de%\3\2\2\2"+
		"\u00df\u00e7\7\33\2\2\u00e0\u00e7\7\34\2\2\u00e1\u00e2\7\35\2\2\u00e2"+
		"\u00e3\7\n\2\2\u00e3\u00e4\78\2\2\u00e4\u00e7\7\13\2\2\u00e5\u00e7\7\36"+
		"\2\2\u00e6\u00df\3\2\2\2\u00e6\u00e0\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e6"+
		"\u00e5\3\2\2\2\u00e7\'\3\2\2\2\u00e8\u00e9\7\37\2\2\u00e9\u00ea\5*\26"+
		"\2\u00ea)\3\2\2\2\u00eb\u00ec\79\2\2\u00ec\u00ed\7!\2\2\u00ed\u00ee\7"+
		" \2\2\u00ee\u00ef\7\n\2\2\u00ef\u00f0\5.\30\2\u00f0\u00f1\7\13\2\2\u00f1"+
		"\u0107\3\2\2\2\u00f2\u00f3\79\2\2\u00f3\u00f4\7\"\2\2\u00f4\u00f5\7 \2"+
		"\2\u00f5\u00f6\7\n\2\2\u00f6\u00f7\5.\30\2\u00f7\u00f8\7\13\2\2\u00f8"+
		"\u00f9\7#\2\2\u00f9\u00fa\5,\27\2\u00fa\u00fb\7\n\2\2\u00fb\u00fc\5\60"+
		"\31\2\u00fc\u00fd\7\13\2\2\u00fd\u0107\3\2\2\2\u00fe\u00ff\79\2\2\u00ff"+
		"\u0100\7$\2\2\u0100\u0101\7\n\2\2\u0101\u0102\79\2\2\u0102\u0103\5\62"+
		"\32\2\u0103\u0104\79\2\2\u0104\u0105\7\13\2\2\u0105\u0107\3\2\2\2\u0106"+
		"\u00eb\3\2\2\2\u0106\u00f2\3\2\2\2\u0106\u00fe\3\2\2\2\u0107+\3\2\2\2"+
		"\u0108\u0109\79\2\2\u0109-\3\2\2\2\u010a\u010f\79\2\2\u010b\u010c\79\2"+
		"\2\u010c\u010d\7\r\2\2\u010d\u010f\5.\30\2\u010e\u010a\3\2\2\2\u010e\u010b"+
		"\3\2\2\2\u010f/\3\2\2\2\u0110\u0115\79\2\2\u0111\u0112\79\2\2\u0112\u0113"+
		"\7\r\2\2\u0113\u0115\5\60\31\2\u0114\u0110\3\2\2\2\u0114\u0111\3\2\2\2"+
		"\u0115\61\3\2\2\2\u0116\u011a\5:\36\2\u0117\u011a\5<\37\2\u0118\u011a"+
		"\5> \2\u0119\u0116\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a"+
		"\63\3\2\2\2\u011b\u011c\7\26\2\2\u011c\u011d\7\23\2\2\u011d\u011e\79\2"+
		"\2\u011e\u011f\7\27\2\2\u011f\u0120\7\30\2\2\u0120\u0121\79\2\2\u0121"+
		"\u0122\7\4\2\2\u0122\65\3\2\2\2\u0123\u0124\7\31\2\2\u0124\u0125\7\24"+
		"\2\2\u0125\u0126\7\4\2\2\u0126\67\3\2\2\2\u0127\u0128\7\31\2\2\u0128\u0129"+
		"\7\'\2\2\u0129\u012a\7(\2\2\u012a\u012b\79\2\2\u012b\u012c\7\4\2\2\u012c"+
		"9\3\2\2\2\u012d\u0130\7)\2\2\u012e\u0130\7*\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u012e\3\2\2\2\u0130;\3\2\2\2\u0131\u0132\7+\2\2\u0132=\3\2\2\2\u0133"+
		"\u0134\t\2\2\2\u0134?\3\2\2\2\u0135\u0136\7,\2\2\u0136\u0137\7-\2\2\u0137"+
		"\u0139\79\2\2\u0138\u013a\5P)\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2\2"+
		"\2\u013a\u013b\3\2\2\2\u013b\u013c\7.\2\2\u013c\u013d\5T+\2\u013d\u013e"+
		"\7\4\2\2\u013eA\3\2\2\2\u013f\u0140\7/\2\2\u0140\u0141\79\2\2\u0141\u0142"+
		"\7\60\2\2\u0142\u0145\5D#\2\u0143\u0144\7\61\2\2\u0144\u0146\5L\'\2\u0145"+
		"\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\7\4"+
		"\2\2\u0148C\3\2\2\2\u0149\u014a\5R*\2\u014a\u014b\7\6\2\2\u014b\u0153"+
		"\5V,\2\u014c\u014d\7\r\2\2\u014d\u014e\5R*\2\u014e\u014f\7\6\2\2\u014f"+
		"\u0150\5V,\2\u0150\u0152\3\2\2\2\u0151\u014c\3\2\2\2\u0152\u0155\3\2\2"+
		"\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154E\3\2\2\2\u0155\u0153"+
		"\3\2\2\2\u0156\u0157\7\62\2\2\u0157\u0158\7(\2\2\u0158\u015b\79\2\2\u0159"+
		"\u015a\7\61\2\2\u015a\u015c\5L\'\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c\u015d\3\2\2\2\u015d\u015e\7\4\2\2\u015eG\3\2\2\2\u015f\u0162"+
		"\7\63\2\2\u0160\u0163\7\f\2\2\u0161\u0163\5.\30\2\u0162\u0160\3\2\2\2"+
		"\u0162\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\7(\2\2\u0165\u0168"+
		"\5.\30\2\u0166\u0167\7\61\2\2\u0167\u0169\5L\'\2\u0168\u0166\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\u016b\3\2\2\2\u016a\u016c\5J&\2\u016b\u016a\3\2\2"+
		"\2\u016b\u016c\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\7\4\2\2\u016eI"+
		"\3\2\2\2\u016f\u0170\7\64\2\2\u0170\u0171\7\65\2\2\u0171\u0173\79\2\2"+
		"\u0172\u0174\t\3\2\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u017e"+
		"\3\2\2\2\u0175\u0176\7\64\2\2\u0176\u0177\7\65\2\2\u0177\u0179\79\2\2"+
		"\u0178\u017a\t\3\2\2\u0179\u0178\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b"+
		"\3\2\2\2\u017b\u017c\7\r\2\2\u017c\u017e\5J&\2\u017d\u016f\3\2\2\2\u017d"+
		"\u0175\3\2\2\2\u017eK\3\2\2\2\u017f\u0180\7\n\2\2\u0180\u0181\5L\'\2\u0181"+
		"\u0185\7\13\2\2\u0182\u0183\5:\36\2\u0183\u0184\5L\'\2\u0184\u0186\3\2"+
		"\2\2\u0185\u0182\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0191\3\2\2\2\u0187"+
		"\u018b\5N(\2\u0188\u0189\5:\36\2\u0189\u018a\5L\'\2\u018a\u018c\3\2\2"+
		"\2\u018b\u0188\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u0191\3\2\2\2\u018d\u018e"+
		"\5<\37\2\u018e\u018f\5L\'\2\u018f\u0191\3\2\2\2\u0190\u017f\3\2\2\2\u0190"+
		"\u0187\3\2\2\2\u0190\u018d\3\2\2\2\u0191M\3\2\2\2\u0192\u0193\79\2\2\u0193"+
		"\u0196\5> \2\u0194\u0197\79\2\2\u0195\u0197\5V,\2\u0196\u0194\3\2\2\2"+
		"\u0196\u0195\3\2\2\2\u0197\u01a1\3\2\2\2\u0198\u0199\5V,\2\u0199\u019a"+
		"\5> \2\u019a\u019b\79\2\2\u019b\u01a1\3\2\2\2\u019c\u019d\5V,\2\u019d"+
		"\u019e\5> \2\u019e\u019f\5V,\2\u019f\u01a1\3\2\2\2\u01a0\u0192\3\2\2\2"+
		"\u01a0\u0198\3\2\2\2\u01a0\u019c\3\2\2\2\u01a1O\3\2\2\2\u01a2\u01a7\5"+
		"R*\2\u01a3\u01a4\7\r\2\2\u01a4\u01a6\5R*\2\u01a5\u01a3\3\2\2\2\u01a6\u01a9"+
		"\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01b6\3\2\2\2\u01a9"+
		"\u01a7\3\2\2\2\u01aa\u01ab\7\n\2\2\u01ab\u01b0\5R*\2\u01ac\u01ad\7\r\2"+
		"\2\u01ad\u01af\5R*\2\u01ae\u01ac\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01ae"+
		"\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3"+
		"\u01b4\7\13\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01a2\3\2\2\2\u01b5\u01aa\3"+
		"\2\2\2\u01b6Q\3\2\2\2\u01b7\u01b8\79\2\2\u01b8S\3\2\2\2\u01b9\u01be\5"+
		"V,\2\u01ba\u01bb\7\r\2\2\u01bb\u01bd\5V,\2\u01bc\u01ba\3\2\2\2\u01bd\u01c0"+
		"\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01cd\3\2\2\2\u01c0"+
		"\u01be\3\2\2\2\u01c1\u01c2\7\n\2\2\u01c2\u01c7\5V,\2\u01c3\u01c4\7\r\2"+
		"\2\u01c4\u01c6\5V,\2\u01c5\u01c3\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7\u01c5"+
		"\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01c7\3\2\2\2\u01ca"+
		"\u01cb\7\13\2\2\u01cb\u01cd\3\2\2\2\u01cc\u01b9\3\2\2\2\u01cc\u01c1\3"+
		"\2\2\2\u01cdU\3\2\2\2\u01ce\u01d3\5X-\2\u01cf\u01d3\5Z.\2\u01d0\u01d3"+
		"\5\\/\2\u01d1\u01d3\5^\60\2\u01d2\u01ce\3\2\2\2\u01d2\u01cf\3\2\2\2\u01d2"+
		"\u01d0\3\2\2\2\u01d2\u01d1\3\2\2\2\u01d3W\3\2\2\2\u01d4\u01d6\7\16\2\2"+
		"\u01d5\u01d4\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d8"+
		"\78\2\2\u01d8Y\3\2\2\2\u01d9\u01db\7\16\2\2\u01da\u01d9\3\2\2\2\u01da"+
		"\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01df\78\2\2\u01dd\u01de\7\17"+
		"\2\2\u01de\u01e0\78\2\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0"+
		"[\3\2\2\2\u01e1\u01e2\7:\2\2\u01e2]\3\2\2\2\u01e3\u01e4\7;\2\2\u01e4_"+
		"\3\2\2\2*cgkoz\u0080\u0090\u00bc\u00dd\u00e6\u0106\u010e\u0114\u0119\u012f"+
		"\u0139\u0145\u0153\u015b\u0162\u0168\u016b\u0173\u0179\u017d\u0185\u018b"+
		"\u0190\u0196\u01a0\u01a7\u01b0\u01b5\u01be\u01c7\u01cc\u01d2\u01d5\u01da"+
		"\u01df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}