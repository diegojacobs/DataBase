
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class Main 
{
    public static void main( String[] args) throws Exception 
    {

        ANTLRInputStream input = new ANTLRInputStream("CREATE database prueba;");

        sqlLexer lexer = new sqlLexer(input);
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        sqlParser parser = new sqlParser(tokens);
        ParseTree tree = parser.sql2003Parser(); // begin parsing at rule 'sql2003Parser'
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        
        sqlBaseVisitor<String> semantic_checker = new sqlBaseVisitor();
        
        semantic_checker.visit(tree);
        System.out.println(semantic_checker.getErrores());
    }
}