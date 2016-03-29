
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class Main 
{
    public static void main( String[] args) throws Exception 
    {

    	//use database prueba; create table varonRojo (nombre int, edad char(4), constraint pk primary KEY (a, b), constraint fk FOREIGN KEY (a) REFERENCES x (y, z), constraint ck CHECK (p and q));
    	
        ANTLRInputStream input = new ANTLRInputStream("use database prueba; create table varonRojoCayala (nombre int, nombre char(4), dpi int, dpi char(10));");
    	
    	//ANTLRInputStream input = new ANTLRInputStream("create database prueba;");
    	
        sqlLexer lexer = new sqlLexer(input);
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        sqlParser parser = new sqlParser(tokens);
        ParseTree tree = parser.sql2003Parser(); // begin parsing at rule 'sql2003Parser'
        //System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        
        MyVisitor<String> semantic_checker = new MyVisitor();
        
        semantic_checker.visit(tree);
        System.out.println(semantic_checker.erroresToString());
    }
}