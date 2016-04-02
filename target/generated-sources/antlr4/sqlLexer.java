// Generated from sql.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sqlLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'"
	};
	public static final String[] ruleNames = {
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "A", "B", "C", "D", "E", "F", "G", "H", 
		"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", 
		"W", "X", "Y", "Z", "CREATE", "DATABASE", "DATABASES", "TABLE", "TABLES", 
		"DROP", "ALTER", "RENAME", "TO", "SHOW", "USE", "RES_INT", "RES_FLOAT", 
		"RES_CHAR", "RES_DATE", "CONSTRAINT", "KEY", "PRIMARY", "FOREIGN", "REFERENCES", 
		"CHECK", "ADD", "COLUMN", "COLUMNS", "FROM", "RES_AND", "RES_OR", "RES_NOT", 
		"INSERT", "INTO", "VALUES", "UPDATE", "SET", "WHERE", "DELETE", "SELECT", 
		"ORDER", "BY", "ASC", "DESC", "LETTER", "DIGIT", "ASCII", "TWO_DIGITS", 
		"THREE_DIGITS", "FOUR_DIGITS", "YEAR", "MONTH", "DAY", "INT", "ID", "DATE", 
		"CHAR", "WHITESPACE", "COMMENT"
	};


	public sqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "sql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2=\u0262\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\3"+
		"\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)"+
		"\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/"+
		"\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\3"+
		"8\38\38\38\38\38\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3:\3;\3"+
		";\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3"+
		"=\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3A\3A\3A\3"+
		"A\3A\3B\3B\3B\3B\3C\3C\3C\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F\3"+
		"F\3F\3G\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3J\3J\3J\3"+
		"J\3J\3J\3K\3K\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3M\3"+
		"N\3N\3N\3O\3O\3O\3O\3P\3P\3P\3P\3P\3Q\3Q\3R\3R\3S\3S\3S\3S\3S\5S\u020a"+
		"\nS\3T\3T\3T\3U\3U\3U\3V\3V\3V\3W\3W\3X\3X\5X\u0219\nX\3Y\3Y\5Y\u021d"+
		"\nY\3Z\3Z\7Z\u0221\nZ\fZ\16Z\u0224\13Z\3[\3[\3[\7[\u0229\n[\f[\16[\u022c"+
		"\13[\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3]\3]\3]\7]\u0239\n]\f]\16]\u023c"+
		"\13]\3]\3]\3^\6^\u0241\n^\r^\16^\u0242\3^\3^\3_\3_\3_\3_\7_\u024b\n_\f"+
		"_\16_\u024e\13_\3_\5_\u0251\n_\3_\3_\3_\3_\3_\7_\u0258\n_\f_\16_\u025b"+
		"\13_\3_\3_\5_\u025f\n_\3_\3_\3\u0259\2`\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61"+
		"\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\20S\21U\22W\23"+
		"Y\24[\25]\26_\27a\30c\31e\32g\33i\34k\35m\36o\37q s!u\"w#y${%}&\177\'"+
		"\u0081(\u0083)\u0085*\u0087+\u0089,\u008b-\u008d.\u008f/\u0091\60\u0093"+
		"\61\u0095\62\u0097\63\u0099\64\u009b\65\u009d\66\u009f\67\u00a1\2\u00a3"+
		"\2\u00a5\2\u00a7\2\u00a9\2\u00ab\2\u00ad\2\u00af\2\u00b1\2\u00b38\u00b5"+
		"9\u00b7:\u00b9;\u00bb<\u00bd=\3\2 \4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2"+
		"GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4"+
		"\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXx"+
		"x\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\4\2C\\c|\5\2\13\f$$^^\5\2\13\f\16"+
		"\17\"\"\4\2\f\f\17\17\u024c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2Q\3\2\2\2\2S\3\2"+
		"\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2"+
		"\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m"+
		"\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2"+
		"\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2"+
		"\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d"+
		"\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2"+
		"\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f"+
		"\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2"+
		"\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2\2\3\u00bf\3\2\2\2\5\u00c2\3\2\2\2\7\u00c4"+
		"\3\2\2\2\t\u00c6\3\2\2\2\13\u00c8\3\2\2\2\r\u00ca\3\2\2\2\17\u00cd\3\2"+
		"\2\2\21\u00d0\3\2\2\2\23\u00d2\3\2\2\2\25\u00d4\3\2\2\2\27\u00d6\3\2\2"+
		"\2\31\u00d8\3\2\2\2\33\u00da\3\2\2\2\35\u00dc\3\2\2\2\37\u00de\3\2\2\2"+
		"!\u00e0\3\2\2\2#\u00e2\3\2\2\2%\u00e4\3\2\2\2\'\u00e6\3\2\2\2)\u00e8\3"+
		"\2\2\2+\u00ea\3\2\2\2-\u00ec\3\2\2\2/\u00ee\3\2\2\2\61\u00f0\3\2\2\2\63"+
		"\u00f2\3\2\2\2\65\u00f4\3\2\2\2\67\u00f6\3\2\2\29\u00f8\3\2\2\2;\u00fa"+
		"\3\2\2\2=\u00fc\3\2\2\2?\u00fe\3\2\2\2A\u0100\3\2\2\2C\u0102\3\2\2\2E"+
		"\u0104\3\2\2\2G\u0106\3\2\2\2I\u0108\3\2\2\2K\u010a\3\2\2\2M\u010c\3\2"+
		"\2\2O\u010e\3\2\2\2Q\u0110\3\2\2\2S\u0117\3\2\2\2U\u0120\3\2\2\2W\u012a"+
		"\3\2\2\2Y\u0130\3\2\2\2[\u0137\3\2\2\2]\u013c\3\2\2\2_\u0142\3\2\2\2a"+
		"\u0149\3\2\2\2c\u014c\3\2\2\2e\u0151\3\2\2\2g\u0155\3\2\2\2i\u0159\3\2"+
		"\2\2k\u015f\3\2\2\2m\u0164\3\2\2\2o\u0169\3\2\2\2q\u0174\3\2\2\2s\u0178"+
		"\3\2\2\2u\u0180\3\2\2\2w\u0188\3\2\2\2y\u0193\3\2\2\2{\u0199\3\2\2\2}"+
		"\u019d\3\2\2\2\177\u01a4\3\2\2\2\u0081\u01ac\3\2\2\2\u0083\u01b1\3\2\2"+
		"\2\u0085\u01b5\3\2\2\2\u0087\u01b8\3\2\2\2\u0089\u01bc\3\2\2\2\u008b\u01c3"+
		"\3\2\2\2\u008d\u01c8\3\2\2\2\u008f\u01cf\3\2\2\2\u0091\u01d6\3\2\2\2\u0093"+
		"\u01da\3\2\2\2\u0095\u01e0\3\2\2\2\u0097\u01e7\3\2\2\2\u0099\u01ee\3\2"+
		"\2\2\u009b\u01f4\3\2\2\2\u009d\u01f7\3\2\2\2\u009f\u01fb\3\2\2\2\u00a1"+
		"\u0200\3\2\2\2\u00a3\u0202\3\2\2\2\u00a5\u0209\3\2\2\2\u00a7\u020b\3\2"+
		"\2\2\u00a9\u020e\3\2\2\2\u00ab\u0211\3\2\2\2\u00ad\u0214\3\2\2\2\u00af"+
		"\u0218\3\2\2\2\u00b1\u021c\3\2\2\2\u00b3\u021e\3\2\2\2\u00b5\u0225\3\2"+
		"\2\2\u00b7\u022d\3\2\2\2\u00b9\u0235\3\2\2\2\u00bb\u0240\3\2\2\2\u00bd"+
		"\u025e\3\2\2\2\u00bf\u00c0\7@\2\2\u00c0\u00c1\7?\2\2\u00c1\4\3\2\2\2\u00c2"+
		"\u00c3\7=\2\2\u00c3\6\3\2\2\2\u00c4\u00c5\7>\2\2\u00c5\b\3\2\2\2\u00c6"+
		"\u00c7\7?\2\2\u00c7\n\3\2\2\2\u00c8\u00c9\7@\2\2\u00c9\f\3\2\2\2\u00ca"+
		"\u00cb\7>\2\2\u00cb\u00cc\7?\2\2\u00cc\16\3\2\2\2\u00cd\u00ce\7>\2\2\u00ce"+
		"\u00cf\7@\2\2\u00cf\20\3\2\2\2\u00d0\u00d1\7*\2\2\u00d1\22\3\2\2\2\u00d2"+
		"\u00d3\7+\2\2\u00d3\24\3\2\2\2\u00d4\u00d5\7,\2\2\u00d5\26\3\2\2\2\u00d6"+
		"\u00d7\7.\2\2\u00d7\30\3\2\2\2\u00d8\u00d9\7/\2\2\u00d9\32\3\2\2\2\u00da"+
		"\u00db\7\60\2\2\u00db\34\3\2\2\2\u00dc\u00dd\t\2\2\2\u00dd\36\3\2\2\2"+
		"\u00de\u00df\t\3\2\2\u00df \3\2\2\2\u00e0\u00e1\t\4\2\2\u00e1\"\3\2\2"+
		"\2\u00e2\u00e3\t\5\2\2\u00e3$\3\2\2\2\u00e4\u00e5\t\6\2\2\u00e5&\3\2\2"+
		"\2\u00e6\u00e7\t\7\2\2\u00e7(\3\2\2\2\u00e8\u00e9\t\b\2\2\u00e9*\3\2\2"+
		"\2\u00ea\u00eb\t\t\2\2\u00eb,\3\2\2\2\u00ec\u00ed\t\n\2\2\u00ed.\3\2\2"+
		"\2\u00ee\u00ef\t\13\2\2\u00ef\60\3\2\2\2\u00f0\u00f1\t\f\2\2\u00f1\62"+
		"\3\2\2\2\u00f2\u00f3\t\r\2\2\u00f3\64\3\2\2\2\u00f4\u00f5\t\16\2\2\u00f5"+
		"\66\3\2\2\2\u00f6\u00f7\t\17\2\2\u00f78\3\2\2\2\u00f8\u00f9\t\20\2\2\u00f9"+
		":\3\2\2\2\u00fa\u00fb\t\21\2\2\u00fb<\3\2\2\2\u00fc\u00fd\t\22\2\2\u00fd"+
		">\3\2\2\2\u00fe\u00ff\t\23\2\2\u00ff@\3\2\2\2\u0100\u0101\t\24\2\2\u0101"+
		"B\3\2\2\2\u0102\u0103\t\25\2\2\u0103D\3\2\2\2\u0104\u0105\t\26\2\2\u0105"+
		"F\3\2\2\2\u0106\u0107\t\27\2\2\u0107H\3\2\2\2\u0108\u0109\t\30\2\2\u0109"+
		"J\3\2\2\2\u010a\u010b\t\31\2\2\u010bL\3\2\2\2\u010c\u010d\t\32\2\2\u010d"+
		"N\3\2\2\2\u010e\u010f\t\33\2\2\u010fP\3\2\2\2\u0110\u0111\5!\21\2\u0111"+
		"\u0112\5? \2\u0112\u0113\5%\23\2\u0113\u0114\5\35\17\2\u0114\u0115\5C"+
		"\"\2\u0115\u0116\5%\23\2\u0116R\3\2\2\2\u0117\u0118\5#\22\2\u0118\u0119"+
		"\5\35\17\2\u0119\u011a\5C\"\2\u011a\u011b\5\35\17\2\u011b\u011c\5\37\20"+
		"\2\u011c\u011d\5\35\17\2\u011d\u011e\5A!\2\u011e\u011f\5%\23\2\u011fT"+
		"\3\2\2\2\u0120\u0121\5#\22\2\u0121\u0122\5\35\17\2\u0122\u0123\5C\"\2"+
		"\u0123\u0124\5\35\17\2\u0124\u0125\5\37\20\2\u0125\u0126\5\35\17\2\u0126"+
		"\u0127\5A!\2\u0127\u0128\5%\23\2\u0128\u0129\5A!\2\u0129V\3\2\2\2\u012a"+
		"\u012b\5C\"\2\u012b\u012c\5\35\17\2\u012c\u012d\5\37\20\2\u012d\u012e"+
		"\5\63\32\2\u012e\u012f\5%\23\2\u012fX\3\2\2\2\u0130\u0131\5C\"\2\u0131"+
		"\u0132\5\35\17\2\u0132\u0133\5\37\20\2\u0133\u0134\5\63\32\2\u0134\u0135"+
		"\5%\23\2\u0135\u0136\5A!\2\u0136Z\3\2\2\2\u0137\u0138\5#\22\2\u0138\u0139"+
		"\5? \2\u0139\u013a\59\35\2\u013a\u013b\5;\36\2\u013b\\\3\2\2\2\u013c\u013d"+
		"\5\35\17\2\u013d\u013e\5\63\32\2\u013e\u013f\5C\"\2\u013f\u0140\5%\23"+
		"\2\u0140\u0141\5? \2\u0141^\3\2\2\2\u0142\u0143\5? \2\u0143\u0144\5%\23"+
		"\2\u0144\u0145\5\67\34\2\u0145\u0146\5\35\17\2\u0146\u0147\5\65\33\2\u0147"+
		"\u0148\5%\23\2\u0148`\3\2\2\2\u0149\u014a\5C\"\2\u014a\u014b\59\35\2\u014b"+
		"b\3\2\2\2\u014c\u014d\5A!\2\u014d\u014e\5+\26\2\u014e\u014f\59\35\2\u014f"+
		"\u0150\5I%\2\u0150d\3\2\2\2\u0151\u0152\5E#\2\u0152\u0153\5A!\2\u0153"+
		"\u0154\5%\23\2\u0154f\3\2\2\2\u0155\u0156\5-\27\2\u0156\u0157\5\67\34"+
		"\2\u0157\u0158\5C\"\2\u0158h\3\2\2\2\u0159\u015a\5\'\24\2\u015a\u015b"+
		"\5\63\32\2\u015b\u015c\59\35\2\u015c\u015d\5\35\17\2\u015d\u015e\5C\""+
		"\2\u015ej\3\2\2\2\u015f\u0160\5!\21\2\u0160\u0161\5+\26\2\u0161\u0162"+
		"\5\35\17\2\u0162\u0163\5? \2\u0163l\3\2\2\2\u0164\u0165\5#\22\2\u0165"+
		"\u0166\5\35\17\2\u0166\u0167\5C\"\2\u0167\u0168\5%\23\2\u0168n\3\2\2\2"+
		"\u0169\u016a\5!\21\2\u016a\u016b\59\35\2\u016b\u016c\5\67\34\2\u016c\u016d"+
		"\5A!\2\u016d\u016e\5C\"\2\u016e\u016f\5? \2\u016f\u0170\5\35\17\2\u0170"+
		"\u0171\5-\27\2\u0171\u0172\5\67\34\2\u0172\u0173\5C\"\2\u0173p\3\2\2\2"+
		"\u0174\u0175\5\61\31\2\u0175\u0176\5%\23\2\u0176\u0177\5M\'\2\u0177r\3"+
		"\2\2\2\u0178\u0179\5;\36\2\u0179\u017a\5? \2\u017a\u017b\5-\27\2\u017b"+
		"\u017c\5\65\33\2\u017c\u017d\5\35\17\2\u017d\u017e\5? \2\u017e\u017f\5"+
		"M\'\2\u017ft\3\2\2\2\u0180\u0181\5\'\24\2\u0181\u0182\59\35\2\u0182\u0183"+
		"\5? \2\u0183\u0184\5%\23\2\u0184\u0185\5-\27\2\u0185\u0186\5)\25\2\u0186"+
		"\u0187\5\67\34\2\u0187v\3\2\2\2\u0188\u0189\5? \2\u0189\u018a\5%\23\2"+
		"\u018a\u018b\5\'\24\2\u018b\u018c\5%\23\2\u018c\u018d\5? \2\u018d\u018e"+
		"\5%\23\2\u018e\u018f\5\67\34\2\u018f\u0190\5!\21\2\u0190\u0191\5%\23\2"+
		"\u0191\u0192\5A!\2\u0192x\3\2\2\2\u0193\u0194\5!\21\2\u0194\u0195\5+\26"+
		"\2\u0195\u0196\5%\23\2\u0196\u0197\5!\21\2\u0197\u0198\5\61\31\2\u0198"+
		"z\3\2\2\2\u0199\u019a\5\35\17\2\u019a\u019b\5#\22\2\u019b\u019c\5#\22"+
		"\2\u019c|\3\2\2\2\u019d\u019e\5!\21\2\u019e\u019f\59\35\2\u019f\u01a0"+
		"\5\63\32\2\u01a0\u01a1\5E#\2\u01a1\u01a2\5\65\33\2\u01a2\u01a3\5\67\34"+
		"\2\u01a3~\3\2\2\2\u01a4\u01a5\5!\21\2\u01a5\u01a6\59\35\2\u01a6\u01a7"+
		"\5\63\32\2\u01a7\u01a8\5E#\2\u01a8\u01a9\5\65\33\2\u01a9\u01aa\5\67\34"+
		"\2\u01aa\u01ab\5A!\2\u01ab\u0080\3\2\2\2\u01ac\u01ad\5\'\24\2\u01ad\u01ae"+
		"\5? \2\u01ae\u01af\59\35\2\u01af\u01b0\5\65\33\2\u01b0\u0082\3\2\2\2\u01b1"+
		"\u01b2\5\35\17\2\u01b2\u01b3\5\67\34\2\u01b3\u01b4\5#\22\2\u01b4\u0084"+
		"\3\2\2\2\u01b5\u01b6\59\35\2\u01b6\u01b7\5? \2\u01b7\u0086\3\2\2\2\u01b8"+
		"\u01b9\5\67\34\2\u01b9\u01ba\59\35\2\u01ba\u01bb\5C\"\2\u01bb\u0088\3"+
		"\2\2\2\u01bc\u01bd\5-\27\2\u01bd\u01be\5\67\34\2\u01be\u01bf\5A!\2\u01bf"+
		"\u01c0\5%\23\2\u01c0\u01c1\5? \2\u01c1\u01c2\5C\"\2\u01c2\u008a\3\2\2"+
		"\2\u01c3\u01c4\5-\27\2\u01c4\u01c5\5\67\34\2\u01c5\u01c6\5C\"\2\u01c6"+
		"\u01c7\59\35\2\u01c7\u008c\3\2\2\2\u01c8\u01c9\5G$\2\u01c9\u01ca\5\35"+
		"\17\2\u01ca\u01cb\5\63\32\2\u01cb\u01cc\5E#\2\u01cc\u01cd\5%\23\2\u01cd"+
		"\u01ce\5A!\2\u01ce\u008e\3\2\2\2\u01cf\u01d0\5E#\2\u01d0\u01d1\5;\36\2"+
		"\u01d1\u01d2\5#\22\2\u01d2\u01d3\5\35\17\2\u01d3\u01d4\5C\"\2\u01d4\u01d5"+
		"\5%\23\2\u01d5\u0090\3\2\2\2\u01d6\u01d7\5A!\2\u01d7\u01d8\5%\23\2\u01d8"+
		"\u01d9\5C\"\2\u01d9\u0092\3\2\2\2\u01da\u01db\5I%\2\u01db\u01dc\5+\26"+
		"\2\u01dc\u01dd\5%\23\2\u01dd\u01de\5? \2\u01de\u01df\5%\23\2\u01df\u0094"+
		"\3\2\2\2\u01e0\u01e1\5#\22\2\u01e1\u01e2\5%\23\2\u01e2\u01e3\5\63\32\2"+
		"\u01e3\u01e4\5%\23\2\u01e4\u01e5\5C\"\2\u01e5\u01e6\5%\23\2\u01e6\u0096"+
		"\3\2\2\2\u01e7\u01e8\5A!\2\u01e8\u01e9\5%\23\2\u01e9\u01ea\5\63\32\2\u01ea"+
		"\u01eb\5%\23\2\u01eb\u01ec\5!\21\2\u01ec\u01ed\5C\"\2\u01ed\u0098\3\2"+
		"\2\2\u01ee\u01ef\59\35\2\u01ef\u01f0\5? \2\u01f0\u01f1\5#\22\2\u01f1\u01f2"+
		"\5%\23\2\u01f2\u01f3\5? \2\u01f3\u009a\3\2\2\2\u01f4\u01f5\5\37\20\2\u01f5"+
		"\u01f6\5M\'\2\u01f6\u009c\3\2\2\2\u01f7\u01f8\5\35\17\2\u01f8\u01f9\5"+
		"A!\2\u01f9\u01fa\5!\21\2\u01fa\u009e\3\2\2\2\u01fb\u01fc\5#\22\2\u01fc"+
		"\u01fd\5%\23\2\u01fd\u01fe\5A!\2\u01fe\u01ff\5!\21\2\u01ff\u00a0\3\2\2"+
		"\2\u0200\u0201\t\34\2\2\u0201\u00a2\3\2\2\2\u0202\u0203\4\62;\2\u0203"+
		"\u00a4\3\2\2\2\u0204\u0205\4\"(\2\u0205\u020a\4*\u0080\2\u0206\u020a\5"+
		"\u00a3R\2\u0207\u020a\5\u00a1Q\2\u0208\u020a\t\35\2\2\u0209\u0204\3\2"+
		"\2\2\u0209\u0206\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u0208\3\2\2\2\u020a"+
		"\u00a6\3\2\2\2\u020b\u020c\5\u00a3R\2\u020c\u020d\5\u00a3R\2\u020d\u00a8"+
		"\3\2\2\2\u020e\u020f\5\u00a3R\2\u020f\u0210\5\u00a7T\2\u0210\u00aa\3\2"+
		"\2\2\u0211\u0212\5\u00a3R\2\u0212\u0213\5\u00a9U\2\u0213\u00ac\3\2\2\2"+
		"\u0214\u0215\5\u00abV\2\u0215\u00ae\3\2\2\2\u0216\u0219\5\u00a3R\2\u0217"+
		"\u0219\5\u00a7T\2\u0218\u0216\3\2\2\2\u0218\u0217\3\2\2\2\u0219\u00b0"+
		"\3\2\2\2\u021a\u021d\5\u00a3R\2\u021b\u021d\5\u00a7T\2\u021c\u021a\3\2"+
		"\2\2\u021c\u021b\3\2\2\2\u021d\u00b2\3\2\2\2\u021e\u0222\5\u00a3R\2\u021f"+
		"\u0221\5\u00a3R\2\u0220\u021f\3\2\2\2\u0221\u0224\3\2\2\2\u0222\u0220"+
		"\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u00b4\3\2\2\2\u0224\u0222\3\2\2\2\u0225"+
		"\u022a\5\u00a1Q\2\u0226\u0229\5\u00a1Q\2\u0227\u0229\5\u00a3R\2\u0228"+
		"\u0226\3\2\2\2\u0228\u0227\3\2\2\2\u0229\u022c\3\2\2\2\u022a\u0228\3\2"+
		"\2\2\u022a\u022b\3\2\2\2\u022b\u00b6\3\2\2\2\u022c\u022a\3\2\2\2\u022d"+
		"\u022e\7)\2\2\u022e\u022f\5\u00adW\2\u022f\u0230\7/\2\2\u0230\u0231\5"+
		"\u00afX\2\u0231\u0232\7/\2\2\u0232\u0233\5\u00b1Y\2\u0233\u0234\7)\2\2"+
		"\u0234\u00b8\3\2\2\2\u0235\u0236\7)\2\2\u0236\u023a\5\u00a5S\2\u0237\u0239"+
		"\5\u00a5S\2\u0238\u0237\3\2\2\2\u0239\u023c\3\2\2\2\u023a\u0238\3\2\2"+
		"\2\u023a\u023b\3\2\2\2\u023b\u023d\3\2\2\2\u023c\u023a\3\2\2\2\u023d\u023e"+
		"\7)\2\2\u023e\u00ba\3\2\2\2\u023f\u0241\t\36\2\2\u0240\u023f\3\2\2\2\u0241"+
		"\u0242\3\2\2\2\u0242\u0240\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0244\3\2"+
		"\2\2\u0244\u0245\b^\2\2\u0245\u00bc\3\2\2\2\u0246\u0247\7\61\2\2\u0247"+
		"\u0248\7\61\2\2\u0248\u024c\3\2\2\2\u0249\u024b\n\37\2\2\u024a\u0249\3"+
		"\2\2\2\u024b\u024e\3\2\2\2\u024c\u024a\3\2\2\2\u024c\u024d\3\2\2\2\u024d"+
		"\u0250\3\2\2\2\u024e\u024c\3\2\2\2\u024f\u0251\7\17\2\2\u0250\u024f\3"+
		"\2\2\2\u0250\u0251\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u025f\7\f\2\2\u0253"+
		"\u0254\7\61\2\2\u0254\u0255\7,\2\2\u0255\u0259\3\2\2\2\u0256\u0258\13"+
		"\2\2\2\u0257\u0256\3\2\2\2\u0258\u025b\3\2\2\2\u0259\u025a\3\2\2\2\u0259"+
		"\u0257\3\2\2\2\u025a\u025c\3\2\2\2\u025b\u0259\3\2\2\2\u025c\u025d\7,"+
		"\2\2\u025d\u025f\7\61\2\2\u025e\u0246\3\2\2\2\u025e\u0253\3\2\2\2\u025f"+
		"\u0260\3\2\2\2\u0260\u0261\b_\2\2\u0261\u00be\3\2\2\2\17\2\u0209\u0218"+
		"\u021c\u0222\u0228\u022a\u023a\u0242\u024c\u0250\u0259\u025e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}