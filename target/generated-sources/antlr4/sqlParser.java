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
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, CREATE=12, DATABASE=13, DATABASES=14, TABLE=15, TABLES=16, 
		DROP=17, ALTER=18, RENAME=19, TO=20, SHOW=21, USE=22, RES_INT=23, RES_FLOAT=24, 
		RES_CHAR=25, RES_DATE=26, CONSTRAINT=27, KEY=28, PRIMARY=29, FOREIGN=30, 
		REFERENCES=31, CHECK=32, ADD=33, COLUMN=34, COLUMNS=35, FROM=36, RES_AND=37, 
		RES_OR=38, RES_NOT=39, INSERT=40, INTO=41, VALUES=42, UPDATE=43, SET=44, 
		WHERE=45, DELETE=46, SELECT=47, ORDER=48, BY=49, ASC=50, DESC=51, INT=52, 
		ID=53, NUM=54, CHAR=55, DATE=56, WHITESPACE=57, COMMENT=58;
	public static final String[] tokenNames = {
		"<INVALID>", "'<='", "'<>'", "'('", "')'", "'*'", "'>='", "';'", "'<'", 
		"','", "'='", "'>'", "CREATE", "DATABASE", "DATABASES", "TABLE", "TABLES", 
		"DROP", "ALTER", "RENAME", "TO", "SHOW", "USE", "RES_INT", "RES_FLOAT", 
		"RES_CHAR", "RES_DATE", "CONSTRAINT", "KEY", "PRIMARY", "FOREIGN", "REFERENCES", 
		"CHECK", "ADD", "COLUMN", "COLUMNS", "FROM", "RES_AND", "RES_OR", "RES_NOT", 
		"INSERT", "INTO", "VALUES", "UPDATE", "SET", "WHERE", "DELETE", "SELECT", 
		"ORDER", "BY", "ASC", "DESC", "INT", "ID", "NUM", "CHAR", "DATE", "WHITESPACE", 
		"COMMENT"
	};
	public static final int
		RULE_sql2003Parser = 0, RULE_sql_executable_statement = 1, RULE_sql_schema_statement = 2, 
		RULE_sql_schema_definition_statement = 3, RULE_sql_schema_manipulation_statement = 4, 
		RULE_sql_data_statement = 5, RULE_schema_definition = 6, RULE_table_definition = 7, 
		RULE_drop_schema_statement = 8, RULE_alter_table_statement = 9, RULE_drop_table_statement = 10, 
		RULE_alter_database_statement = 11, RULE_show_schema_statement = 12, RULE_use_schema_statement = 13, 
		RULE_column = 14, RULE_tipo_literal = 15, RULE_constraint = 16, RULE_constraintType = 17, 
		RULE_idRef = 18, RULE_localIDS = 19, RULE_refIDS = 20, RULE_exp = 21, 
		RULE_rename_table_statement = 22, RULE_accion = 23, RULE_show_table_statement = 24, 
		RULE_show_column_statement = 25, RULE_logic = 26, RULE_logic_not = 27, 
		RULE_relational = 28, RULE_insert_value = 29, RULE_update_value = 30, 
		RULE_delete_value = 31, RULE_select_value = 32, RULE_condition = 33, RULE_comp = 34, 
		RULE_columna = 35, RULE_list_values = 36, RULE_value = 37, RULE_tipo = 38, 
		RULE_literal = 39, RULE_int_literal = 40, RULE_float_literal = 41, RULE_date_literal = 42, 
		RULE_char_literal = 43;
	public static final String[] ruleNames = {
		"sql2003Parser", "sql_executable_statement", "sql_schema_statement", "sql_schema_definition_statement", 
		"sql_schema_manipulation_statement", "sql_data_statement", "schema_definition", 
		"table_definition", "drop_schema_statement", "alter_table_statement", 
		"drop_table_statement", "alter_database_statement", "show_schema_statement", 
		"use_schema_statement", "column", "tipo_literal", "constraint", "constraintType", 
		"idRef", "localIDS", "refIDS", "exp", "rename_table_statement", "accion", 
		"show_table_statement", "show_column_statement", "logic", "logic_not", 
		"relational", "insert_value", "update_value", "delete_value", "select_value", 
		"condition", "comp", "columna", "list_values", "value", "tipo", "literal", 
		"int_literal", "float_literal", "date_literal", "char_literal"
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
			setState(89); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(88); sql_executable_statement();
				}
				}
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CREATE) | (1L << DROP) | (1L << ALTER) | (1L << SHOW) | (1L << USE) | (1L << SELECT))) != 0) );
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
			setState(95);
			switch (_input.LA(1)) {
			case CREATE:
			case DROP:
			case ALTER:
			case SHOW:
			case USE:
				enterOuterAlt(_localctx, 1);
				{
				setState(93); sql_schema_statement();
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); sql_data_statement();
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
			setState(99);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); sql_schema_definition_statement();
				}
				break;
			case DROP:
			case ALTER:
			case SHOW:
			case USE:
				enterOuterAlt(_localctx, 2);
				{
				setState(98); sql_schema_manipulation_statement();
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
			setState(103);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101); schema_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102); table_definition();
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
			setState(114);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105); drop_schema_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106); alter_table_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107); drop_table_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(108); alter_database_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(109); use_schema_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(110); show_schema_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(111); rename_table_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(112); show_table_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(113); show_column_statement();
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
			enterOuterAlt(_localctx, 1);
			{
			setState(116); select_value();
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
			setState(118); match(CREATE);
			setState(119); match(DATABASE);
			setState(120); match(ID);
			setState(121); match(T__4);
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
			setState(123); match(CREATE);
			setState(124); match(TABLE);
			setState(125); match(ID);
			setState(126); match(T__8);
			setState(127); column();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(128); match(T__2);
				setState(129); column();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135); match(T__7);
			setState(136); match(T__4);
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
			setState(138); match(DROP);
			setState(139); match(DATABASE);
			setState(140); match(ID);
			setState(141); match(T__4);
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
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public AccionContext accion() {
			return getRuleContext(AccionContext.class,0);
		}
		public TerminalNode ALTER() { return getToken(sqlParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(sqlParser.TABLE, 0); }
		public Alter_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAlter_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAlter_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAlter_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alter_table_statementContext alter_table_statement() throws RecognitionException {
		Alter_table_statementContext _localctx = new Alter_table_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_alter_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); match(ALTER);
			setState(144); match(TABLE);
			setState(145); match(ID);
			setState(146); accion();
			setState(147); match(T__4);
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
		enterRule(_localctx, 20, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); match(DROP);
			setState(150); match(TABLE);
			setState(151); match(ID);
			setState(152); match(T__4);
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
		enterRule(_localctx, 22, RULE_alter_database_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154); match(ALTER);
			setState(155); match(DATABASE);
			setState(156); match(ID);
			setState(157); match(RENAME);
			setState(158); match(TO);
			setState(159); match(ID);
			setState(160); match(T__4);
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
		enterRule(_localctx, 24, RULE_show_schema_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(SHOW);
			setState(163); match(DATABASES);
			setState(164); match(T__4);
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
		enterRule(_localctx, 26, RULE_use_schema_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166); match(USE);
			setState(167); match(DATABASE);
			setState(168); match(ID);
			setState(169); match(T__4);
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
		enterRule(_localctx, 28, RULE_column);
		try {
			setState(174);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new Column_literalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171); match(ID);
				setState(172); tipo_literal();
				}
				break;
			case CONSTRAINT:
				_localctx = new Column_constraintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(173); constraint();
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
		enterRule(_localctx, 30, RULE_tipo_literal);
		try {
			setState(183);
			switch (_input.LA(1)) {
			case RES_INT:
				_localctx = new Tipo_lit_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176); match(RES_INT);
				}
				break;
			case RES_FLOAT:
				_localctx = new Tipo_lit_floatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177); match(RES_FLOAT);
				}
				break;
			case RES_CHAR:
				_localctx = new Tipo_lit_charContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(178); match(RES_CHAR);
				setState(179); match(T__8);
				setState(180); match(INT);
				setState(181); match(T__7);
				}
				}
				break;
			case RES_DATE:
				_localctx = new Tipo_lit_dateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(182); match(RES_DATE);
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
		enterRule(_localctx, 32, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); match(CONSTRAINT);
			setState(186); constraintType();
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
		enterRule(_localctx, 34, RULE_constraintType);
		try {
			setState(215);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new ConstraintTypePrimaryKeyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(188); match(ID);
				setState(189); match(PRIMARY);
				setState(190); match(KEY);
				setState(191); match(T__8);
				setState(192); localIDS();
				setState(193); match(T__7);
				}
				break;
			case 2:
				_localctx = new ConstraintTypeForeignKeyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(195); match(ID);
				setState(196); match(FOREIGN);
				setState(197); match(KEY);
				setState(198); match(T__8);
				setState(199); localIDS();
				setState(200); match(T__7);
				setState(201); match(REFERENCES);
				setState(202); idRef();
				setState(203); match(T__8);
				setState(204); refIDS();
				setState(205); match(T__7);
				}
				break;
			case 3:
				_localctx = new ConstraintTypeCheckContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(207); match(ID);
				setState(208); match(CHECK);
				setState(209); match(T__8);
				setState(210); match(ID);
				setState(211); exp();
				setState(212); match(ID);
				setState(213); match(T__7);
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
		enterRule(_localctx, 36, RULE_idRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217); match(ID);
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
		enterRule(_localctx, 38, RULE_localIDS);
		try {
			setState(223);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220); match(ID);
				setState(221); match(T__2);
				setState(222); localIDS();
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
		enterRule(_localctx, 40, RULE_refIDS);
		try {
			setState(229);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(225); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(226); match(ID);
				setState(227); match(T__2);
				setState(228); refIDS();
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
		enterRule(_localctx, 42, RULE_exp);
		try {
			setState(234);
			switch (_input.LA(1)) {
			case RES_AND:
			case RES_OR:
				_localctx = new Exp_logicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(231); logic();
				}
				break;
			case RES_NOT:
				_localctx = new Exp_logic_notContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(232); logic_not();
				}
				break;
			case T__10:
			case T__9:
			case T__5:
			case T__3:
			case T__1:
			case T__0:
				_localctx = new Exp_relationalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(233); relational();
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
		enterRule(_localctx, 44, RULE_rename_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); match(ALTER);
			setState(237); match(TABLE);
			setState(238); match(ID);
			setState(239); match(RENAME);
			setState(240); match(TO);
			setState(241); match(ID);
			setState(242); match(T__4);
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

	public static class AccionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(sqlParser.ID, 0); }
		public TerminalNode COLUMN() { return getToken(sqlParser.COLUMN, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode ADD() { return getToken(sqlParser.ADD, 0); }
		public TerminalNode DROP() { return getToken(sqlParser.DROP, 0); }
		public TerminalNode CONSTRAINT() { return getToken(sqlParser.CONSTRAINT, 0); }
		public Tipo_literalContext tipo_literal() {
			return getRuleContext(Tipo_literalContext.class,0);
		}
		public AccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterAccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitAccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitAccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccionContext accion() throws RecognitionException {
		AccionContext _localctx = new AccionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_accion);
		try {
			setState(258);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(244); match(ADD);
				setState(245); match(COLUMN);
				setState(246); match(ID);
				setState(247); tipo_literal();
				{
				setState(248); constraint();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250); match(ADD);
				setState(251); constraint();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(252); match(DROP);
				setState(253); match(COLUMN);
				setState(254); match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(255); match(DROP);
				setState(256); match(CONSTRAINT);
				setState(257); match(ID);
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
		enterRule(_localctx, 48, RULE_show_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260); match(SHOW);
			setState(261); match(TABLES);
			setState(262); match(T__4);
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
		enterRule(_localctx, 50, RULE_show_column_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264); match(SHOW);
			setState(265); match(COLUMNS);
			setState(266); match(FROM);
			setState(267); match(ID);
			setState(268); match(T__4);
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
		enterRule(_localctx, 52, RULE_logic);
		try {
			setState(272);
			switch (_input.LA(1)) {
			case RES_AND:
				_localctx = new Logic_andContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(270); match(RES_AND);
				}
				break;
			case RES_OR:
				_localctx = new Logic_orContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(271); match(RES_OR);
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
		enterRule(_localctx, 54, RULE_logic_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274); match(RES_NOT);
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
		enterRule(_localctx, 56, RULE_relational);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__9) | (1L << T__5) | (1L << T__3) | (1L << T__1) | (1L << T__0))) != 0)) ) {
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
		public TerminalNode VALUES() { return getToken(sqlParser.VALUES, 0); }
		public List<ColumnaContext> columna() {
			return getRuleContexts(ColumnaContext.class);
		}
		public ColumnaContext columna(int i) {
			return getRuleContext(ColumnaContext.class,i);
		}
		public List_valuesContext list_values() {
			return getRuleContext(List_valuesContext.class,0);
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
		enterRule(_localctx, 58, RULE_insert_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278); match(INSERT);
			setState(279); match(INTO);
			setState(293);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(281); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(280); columna();
					}
					}
					setState(283); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				}
				break;
			case T__8:
				{
				{
				setState(285); match(T__8);
				setState(287); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(286); columna();
					}
					}
					setState(289); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(291); match(T__7);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(295); match(VALUES);
			setState(301);
			switch (_input.LA(1)) {
			case NUM:
			case CHAR:
			case DATE:
				{
				setState(296); list_values();
				}
				break;
			case T__8:
				{
				{
				setState(297); match(T__8);
				setState(298); list_values();
				setState(299); match(T__7);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(303); match(T__4);
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
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public TerminalNode UPDATE() { return getToken(sqlParser.UPDATE, 0); }
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<ColumnaContext> columna() {
			return getRuleContexts(ColumnaContext.class);
		}
		public ColumnaContext columna(int i) {
			return getRuleContext(ColumnaContext.class,i);
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
		enterRule(_localctx, 60, RULE_update_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); match(UPDATE);
			setState(306); match(ID);
			setState(307); match(SET);
			setState(312); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(308); columna();
				setState(309); match(T__1);
				setState(310); value();
				}
				}
				setState(314); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(316); match(WHERE);
			setState(317); condition();
			setState(318); match(T__4);
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
		enterRule(_localctx, 62, RULE_delete_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320); match(DELETE);
			setState(321); match(FROM);
			setState(322); match(ID);
			setState(323); match(WHERE);
			setState(324); condition();
			setState(325); match(T__4);
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
		public List<TerminalNode> ID() { return getTokens(sqlParser.ID); }
		public TerminalNode ASC() { return getToken(sqlParser.ASC, 0); }
		public TerminalNode ORDER() { return getToken(sqlParser.ORDER, 0); }
		public TerminalNode WHERE() { return getToken(sqlParser.WHERE, 0); }
		public TerminalNode FROM() { return getToken(sqlParser.FROM, 0); }
		public TerminalNode ID(int i) {
			return getToken(sqlParser.ID, i);
		}
		public TerminalNode SELECT() { return getToken(sqlParser.SELECT, 0); }
		public TerminalNode DESC() { return getToken(sqlParser.DESC, 0); }
		public TerminalNode BY() { return getToken(sqlParser.BY, 0); }
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
		enterRule(_localctx, 64, RULE_select_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327); match(SELECT);
			setState(337);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(328); match(T__6);
				}
				break;
			case ID:
				{
				setState(329); match(ID);
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(330); match(T__2);
					setState(331); match(ID);
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(339); match(FROM);
			setState(340); match(ID);
			setState(341); match(WHERE);
			setState(342); condition();
			setState(346);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(343); match(ORDER);
				setState(344); match(BY);
				setState(345);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(348); match(T__4);
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
		public List<Logic_notContext> logic_not() {
			return getRuleContexts(Logic_notContext.class);
		}
		public CompContext comp(int i) {
			return getRuleContext(CompContext.class,i);
		}
		public List<LogicContext> logic() {
			return getRuleContexts(LogicContext.class);
		}
		public Logic_notContext logic_not(int i) {
			return getRuleContext(Logic_notContext.class,i);
		}
		public List<CompContext> comp() {
			return getRuleContexts(CompContext.class);
		}
		public LogicContext logic(int i) {
			return getRuleContext(LogicContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_la = _input.LA(1);
			if (_la==RES_NOT) {
				{
				setState(350); logic_not();
				}
			}

			setState(353); comp();
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RES_AND || _la==RES_OR) {
				{
				{
				setState(354); logic();
				setState(356);
				_la = _input.LA(1);
				if (_la==RES_NOT) {
					{
					setState(355); logic_not();
					}
				}

				{
				setState(358); comp();
				}
				}
				}
				setState(364);
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

	public static class CompContext extends ParserRuleContext {
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
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365); match(ID);
			setState(366); relational();
			setState(369);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(367); match(ID);
				}
				break;
			case NUM:
			case CHAR:
			case DATE:
				{
				setState(368); literal();
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
		enterRule(_localctx, 70, RULE_columna);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371); match(ID);
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

	public static class List_valuesContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterList_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitList_values(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitList_values(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_valuesContext list_values() throws RecognitionException {
		List_valuesContext _localctx = new List_valuesContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_list_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(373); value();
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(374); match(T__2);
				{
				setState(375); value();
				}
				}
				}
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ValueContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381); tipo();
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

	public static class TipoContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sqlListener ) ((sqlListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sqlVisitor ) return ((sqlVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_tipo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383); literal();
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
		enterRule(_localctx, 78, RULE_literal);
		try {
			setState(389);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(385); int_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(386); float_literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(387); date_literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(388); char_literal();
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
		public TerminalNode NUM() { return getToken(sqlParser.NUM, 0); }
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
		enterRule(_localctx, 80, RULE_int_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391); match(NUM);
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
		public TerminalNode NUM() { return getToken(sqlParser.NUM, 0); }
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
		enterRule(_localctx, 82, RULE_float_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393); match(NUM);
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
		enterRule(_localctx, 84, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395); match(DATE);
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
		enterRule(_localctx, 86, RULE_char_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397); match(CHAR);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u0192\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\6\2\\\n\2\r\2\16\2]\3\3\3\3\5\3b\n\3\3\4\3\4\5\4f\n\4\3"+
		"\5\3\5\5\5j\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6u\n\6\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0085\n\t\f\t\16\t"+
		"\u0088\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u00b1\n\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u00ba\n\21\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00da\n\23\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\5\25\u00e2\n\25\3\26\3\26\3\26\3\26\5\26\u00e8"+
		"\n\26\3\27\3\27\3\27\5\27\u00ed\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u0105\n\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\5\34\u0113\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\6\37\u011c"+
		"\n\37\r\37\16\37\u011d\3\37\3\37\6\37\u0122\n\37\r\37\16\37\u0123\3\37"+
		"\3\37\5\37\u0128\n\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0130\n\37\3"+
		"\37\3\37\3 \3 \3 \3 \3 \3 \3 \6 \u013b\n \r \16 \u013c\3 \3 \3 \3 \3!"+
		"\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\7\"\u014f\n\"\f\"\16\"\u0152\13"+
		"\"\5\"\u0154\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u015d\n\"\3\"\3\"\3#"+
		"\5#\u0162\n#\3#\3#\3#\5#\u0167\n#\3#\3#\7#\u016b\n#\f#\16#\u016e\13#\3"+
		"$\3$\3$\3$\5$\u0174\n$\3%\3%\3&\3&\3&\7&\u017b\n&\f&\16&\u017e\13&\3\'"+
		"\3\'\3(\3(\3)\3)\3)\3)\5)\u0188\n)\3*\3*\3+\3+\3,\3,\3-\3-\3-\2\2.\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTVX\2\4\6\2\3\4\b\b\n\n\f\r\3\2\64\65\u0190\2[\3\2\2\2\4a\3\2\2\2\6e"+
		"\3\2\2\2\bi\3\2\2\2\nt\3\2\2\2\fv\3\2\2\2\16x\3\2\2\2\20}\3\2\2\2\22\u008c"+
		"\3\2\2\2\24\u0091\3\2\2\2\26\u0097\3\2\2\2\30\u009c\3\2\2\2\32\u00a4\3"+
		"\2\2\2\34\u00a8\3\2\2\2\36\u00b0\3\2\2\2 \u00b9\3\2\2\2\"\u00bb\3\2\2"+
		"\2$\u00d9\3\2\2\2&\u00db\3\2\2\2(\u00e1\3\2\2\2*\u00e7\3\2\2\2,\u00ec"+
		"\3\2\2\2.\u00ee\3\2\2\2\60\u0104\3\2\2\2\62\u0106\3\2\2\2\64\u010a\3\2"+
		"\2\2\66\u0112\3\2\2\28\u0114\3\2\2\2:\u0116\3\2\2\2<\u0118\3\2\2\2>\u0133"+
		"\3\2\2\2@\u0142\3\2\2\2B\u0149\3\2\2\2D\u0161\3\2\2\2F\u016f\3\2\2\2H"+
		"\u0175\3\2\2\2J\u0177\3\2\2\2L\u017f\3\2\2\2N\u0181\3\2\2\2P\u0187\3\2"+
		"\2\2R\u0189\3\2\2\2T\u018b\3\2\2\2V\u018d\3\2\2\2X\u018f\3\2\2\2Z\\\5"+
		"\4\3\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^\3\3\2\2\2_b\5\6\4\2`"+
		"b\5\f\7\2a_\3\2\2\2a`\3\2\2\2b\5\3\2\2\2cf\5\b\5\2df\5\n\6\2ec\3\2\2\2"+
		"ed\3\2\2\2f\7\3\2\2\2gj\5\16\b\2hj\5\20\t\2ig\3\2\2\2ih\3\2\2\2j\t\3\2"+
		"\2\2ku\5\22\n\2lu\5\24\13\2mu\5\26\f\2nu\5\30\r\2ou\5\34\17\2pu\5\32\16"+
		"\2qu\5.\30\2ru\5\62\32\2su\5\64\33\2tk\3\2\2\2tl\3\2\2\2tm\3\2\2\2tn\3"+
		"\2\2\2to\3\2\2\2tp\3\2\2\2tq\3\2\2\2tr\3\2\2\2ts\3\2\2\2u\13\3\2\2\2v"+
		"w\5B\"\2w\r\3\2\2\2xy\7\16\2\2yz\7\17\2\2z{\7\67\2\2{|\7\t\2\2|\17\3\2"+
		"\2\2}~\7\16\2\2~\177\7\21\2\2\177\u0080\7\67\2\2\u0080\u0081\7\5\2\2\u0081"+
		"\u0086\5\36\20\2\u0082\u0083\7\13\2\2\u0083\u0085\5\36\20\2\u0084\u0082"+
		"\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\6\2\2\u008a\u008b\7\t"+
		"\2\2\u008b\21\3\2\2\2\u008c\u008d\7\23\2\2\u008d\u008e\7\17\2\2\u008e"+
		"\u008f\7\67\2\2\u008f\u0090\7\t\2\2\u0090\23\3\2\2\2\u0091\u0092\7\24"+
		"\2\2\u0092\u0093\7\21\2\2\u0093\u0094\7\67\2\2\u0094\u0095\5\60\31\2\u0095"+
		"\u0096\7\t\2\2\u0096\25\3\2\2\2\u0097\u0098\7\23\2\2\u0098\u0099\7\21"+
		"\2\2\u0099\u009a\7\67\2\2\u009a\u009b\7\t\2\2\u009b\27\3\2\2\2\u009c\u009d"+
		"\7\24\2\2\u009d\u009e\7\17\2\2\u009e\u009f\7\67\2\2\u009f\u00a0\7\25\2"+
		"\2\u00a0\u00a1\7\26\2\2\u00a1\u00a2\7\67\2\2\u00a2\u00a3\7\t\2\2\u00a3"+
		"\31\3\2\2\2\u00a4\u00a5\7\27\2\2\u00a5\u00a6\7\20\2\2\u00a6\u00a7\7\t"+
		"\2\2\u00a7\33\3\2\2\2\u00a8\u00a9\7\30\2\2\u00a9\u00aa\7\17\2\2\u00aa"+
		"\u00ab\7\67\2\2\u00ab\u00ac\7\t\2\2\u00ac\35\3\2\2\2\u00ad\u00ae\7\67"+
		"\2\2\u00ae\u00b1\5 \21\2\u00af\u00b1\5\"\22\2\u00b0\u00ad\3\2\2\2\u00b0"+
		"\u00af\3\2\2\2\u00b1\37\3\2\2\2\u00b2\u00ba\7\31\2\2\u00b3\u00ba\7\32"+
		"\2\2\u00b4\u00b5\7\33\2\2\u00b5\u00b6\7\5\2\2\u00b6\u00b7\7\66\2\2\u00b7"+
		"\u00ba\7\6\2\2\u00b8\u00ba\7\34\2\2\u00b9\u00b2\3\2\2\2\u00b9\u00b3\3"+
		"\2\2\2\u00b9\u00b4\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba!\3\2\2\2\u00bb\u00bc"+
		"\7\35\2\2\u00bc\u00bd\5$\23\2\u00bd#\3\2\2\2\u00be\u00bf\7\67\2\2\u00bf"+
		"\u00c0\7\37\2\2\u00c0\u00c1\7\36\2\2\u00c1\u00c2\7\5\2\2\u00c2\u00c3\5"+
		"(\25\2\u00c3\u00c4\7\6\2\2\u00c4\u00da\3\2\2\2\u00c5\u00c6\7\67\2\2\u00c6"+
		"\u00c7\7 \2\2\u00c7\u00c8\7\36\2\2\u00c8\u00c9\7\5\2\2\u00c9\u00ca\5("+
		"\25\2\u00ca\u00cb\7\6\2\2\u00cb\u00cc\7!\2\2\u00cc\u00cd\5&\24\2\u00cd"+
		"\u00ce\7\5\2\2\u00ce\u00cf\5*\26\2\u00cf\u00d0\7\6\2\2\u00d0\u00da\3\2"+
		"\2\2\u00d1\u00d2\7\67\2\2\u00d2\u00d3\7\"\2\2\u00d3\u00d4\7\5\2\2\u00d4"+
		"\u00d5\7\67\2\2\u00d5\u00d6\5,\27\2\u00d6\u00d7\7\67\2\2\u00d7\u00d8\7"+
		"\6\2\2\u00d8\u00da\3\2\2\2\u00d9\u00be\3\2\2\2\u00d9\u00c5\3\2\2\2\u00d9"+
		"\u00d1\3\2\2\2\u00da%\3\2\2\2\u00db\u00dc\7\67\2\2\u00dc\'\3\2\2\2\u00dd"+
		"\u00e2\7\67\2\2\u00de\u00df\7\67\2\2\u00df\u00e0\7\13\2\2\u00e0\u00e2"+
		"\5(\25\2\u00e1\u00dd\3\2\2\2\u00e1\u00de\3\2\2\2\u00e2)\3\2\2\2\u00e3"+
		"\u00e8\7\67\2\2\u00e4\u00e5\7\67\2\2\u00e5\u00e6\7\13\2\2\u00e6\u00e8"+
		"\5*\26\2\u00e7\u00e3\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e8+\3\2\2\2\u00e9"+
		"\u00ed\5\66\34\2\u00ea\u00ed\58\35\2\u00eb\u00ed\5:\36\2\u00ec\u00e9\3"+
		"\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed-\3\2\2\2\u00ee\u00ef"+
		"\7\24\2\2\u00ef\u00f0\7\21\2\2\u00f0\u00f1\7\67\2\2\u00f1\u00f2\7\25\2"+
		"\2\u00f2\u00f3\7\26\2\2\u00f3\u00f4\7\67\2\2\u00f4\u00f5\7\t\2\2\u00f5"+
		"/\3\2\2\2\u00f6\u00f7\7#\2\2\u00f7\u00f8\7$\2\2\u00f8\u00f9\7\67\2\2\u00f9"+
		"\u00fa\5 \21\2\u00fa\u00fb\5\"\22\2\u00fb\u0105\3\2\2\2\u00fc\u00fd\7"+
		"#\2\2\u00fd\u0105\5\"\22\2\u00fe\u00ff\7\23\2\2\u00ff\u0100\7$\2\2\u0100"+
		"\u0105\7\67\2\2\u0101\u0102\7\23\2\2\u0102\u0103\7\35\2\2\u0103\u0105"+
		"\7\67\2\2\u0104\u00f6\3\2\2\2\u0104\u00fc\3\2\2\2\u0104\u00fe\3\2\2\2"+
		"\u0104\u0101\3\2\2\2\u0105\61\3\2\2\2\u0106\u0107\7\27\2\2\u0107\u0108"+
		"\7\22\2\2\u0108\u0109\7\t\2\2\u0109\63\3\2\2\2\u010a\u010b\7\27\2\2\u010b"+
		"\u010c\7%\2\2\u010c\u010d\7&\2\2\u010d\u010e\7\67\2\2\u010e\u010f\7\t"+
		"\2\2\u010f\65\3\2\2\2\u0110\u0113\7\'\2\2\u0111\u0113\7(\2\2\u0112\u0110"+
		"\3\2\2\2\u0112\u0111\3\2\2\2\u0113\67\3\2\2\2\u0114\u0115\7)\2\2\u0115"+
		"9\3\2\2\2\u0116\u0117\t\2\2\2\u0117;\3\2\2\2\u0118\u0119\7*\2\2\u0119"+
		"\u0127\7+\2\2\u011a\u011c\5H%\2\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2"+
		"\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0128\3\2\2\2\u011f\u0121"+
		"\7\5\2\2\u0120\u0122\5H%\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\7\6"+
		"\2\2\u0126\u0128\3\2\2\2\u0127\u011b\3\2\2\2\u0127\u011f\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012f\7,\2\2\u012a\u0130\5J&\2\u012b\u012c\7\5\2"+
		"\2\u012c\u012d\5J&\2\u012d\u012e\7\6\2\2\u012e\u0130\3\2\2\2\u012f\u012a"+
		"\3\2\2\2\u012f\u012b\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\7\t\2\2\u0132"+
		"=\3\2\2\2\u0133\u0134\7-\2\2\u0134\u0135\7\67\2\2\u0135\u013a\7.\2\2\u0136"+
		"\u0137\5H%\2\u0137\u0138\7\f\2\2\u0138\u0139\5L\'\2\u0139\u013b\3\2\2"+
		"\2\u013a\u0136\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d"+
		"\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\7/\2\2\u013f\u0140\5D#\2\u0140"+
		"\u0141\7\t\2\2\u0141?\3\2\2\2\u0142\u0143\7\60\2\2\u0143\u0144\7&\2\2"+
		"\u0144\u0145\7\67\2\2\u0145\u0146\7/\2\2\u0146\u0147\5D#\2\u0147\u0148"+
		"\7\t\2\2\u0148A\3\2\2\2\u0149\u0153\7\61\2\2\u014a\u0154\7\7\2\2\u014b"+
		"\u0150\7\67\2\2\u014c\u014d\7\13\2\2\u014d\u014f\7\67\2\2\u014e\u014c"+
		"\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151"+
		"\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u014a\3\2\2\2\u0153\u014b\3\2"+
		"\2\2\u0154\u0155\3\2\2\2\u0155\u0156\7&\2\2\u0156\u0157\7\67\2\2\u0157"+
		"\u0158\7/\2\2\u0158\u015c\5D#\2\u0159\u015a\7\62\2\2\u015a\u015b\7\63"+
		"\2\2\u015b\u015d\t\3\2\2\u015c\u0159\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015f\7\t\2\2\u015fC\3\2\2\2\u0160\u0162\58\35\2"+
		"\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u016c"+
		"\5F$\2\u0164\u0166\5\66\34\2\u0165\u0167\58\35\2\u0166\u0165\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\5F$\2\u0169\u016b\3\2\2"+
		"\2\u016a\u0164\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d"+
		"\3\2\2\2\u016dE\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\7\67\2\2\u0170"+
		"\u0173\5:\36\2\u0171\u0174\7\67\2\2\u0172\u0174\5P)\2\u0173\u0171\3\2"+
		"\2\2\u0173\u0172\3\2\2\2\u0174G\3\2\2\2\u0175\u0176\7\67\2\2\u0176I\3"+
		"\2\2\2\u0177\u017c\5L\'\2\u0178\u0179\7\13\2\2\u0179\u017b\5L\'\2\u017a"+
		"\u0178\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2"+
		"\2\2\u017dK\3\2\2\2\u017e\u017c\3\2\2\2\u017f\u0180\5N(\2\u0180M\3\2\2"+
		"\2\u0181\u0182\5P)\2\u0182O\3\2\2\2\u0183\u0188\5R*\2\u0184\u0188\5T+"+
		"\2\u0185\u0188\5V,\2\u0186\u0188\5X-\2\u0187\u0183\3\2\2\2\u0187\u0184"+
		"\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0186\3\2\2\2\u0188Q\3\2\2\2\u0189"+
		"\u018a\78\2\2\u018aS\3\2\2\2\u018b\u018c\78\2\2\u018cU\3\2\2\2\u018d\u018e"+
		"\7:\2\2\u018eW\3\2\2\2\u018f\u0190\79\2\2\u0190Y\3\2\2\2\36]aeit\u0086"+
		"\u00b0\u00b9\u00d9\u00e1\u00e7\u00ec\u0104\u0112\u011d\u0123\u0127\u012f"+
		"\u013c\u0150\u0153\u015c\u0161\u0166\u016c\u0173\u017c\u0187";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}