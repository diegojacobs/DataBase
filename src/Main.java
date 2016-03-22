
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class Main 
{
    public static void main( String[] args) throws Exception 
    {

        ANTLRInputStream input = new ANTLRInputStream("uSe datAbAsE prueba; uSe datAbAsE prueba2; uSe datAbAsE prueba3; uSe datAbAsE prueba4; uSe datAbAsE prueba5;");

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