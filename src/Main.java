
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class Main 
{
    public static void main( String[] args) throws Exception 
    {
    	// Create DataBase
    	ANTLRInputStream input = new ANTLRInputStream("create database prueba;");
    	
    	// Create Table
    	//ANTLRInputStream input = new ANTLRInputStream("use database prueba; create table baronRojo (nombre int, dpi char(10), edad char(4), constraint pk primary KEY (nombre, dpi));");
    	
    	// Create Table con Constraints
        //ANTLRInputStream input = new ANTLRInputStream("use database prueba; create table baronRojoCayala (nombre int, dpi char(10), CONSTRAINT pk PRIMARY KEY(nombre, dpi), CONSTRAINT fk FOREIGN KEY(nombre) REFERENCES baronRojo (nombre, dpi), CONSTRAINT fk2 FOREIGN KEY(dpi) REFERENCES baronRojo (edad), CONSTRAINT ch CHECK(nombre > dpi) );");  	
   	
    	// Rename Table
    	//ANTLRInputStream input = new ANTLRInputStream("use database prueba; alter table baronRojo rename to baronAzul;");
    	
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