import gen.AngularLexer;
import gen.AngularParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import program.Program;
import visitors.AngularVisitor;
import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static AngularVisitor visitor;
    public static void main(String[] args) throws IOException {

        String source = "tests/test6.txt";
        CharStream cs = fromFileName(source);
        AngularLexer lexer = new AngularLexer(cs);
        CommonTokenStream token = new CommonTokenStream(lexer);
        AngularParser parser = new AngularParser(token);
        ParseTree tree = parser.program();

        visitor = new AngularVisitor();
        Program program = (Program) visitor.visit(tree);

        if (visitor.errors.size() > 0) {
            System.out.println(visitor.errors);

        }else {
            System.out.println(program);

            System.out.println("\n\n\n<<<<<<<<<<<<<<<<<<<<<<<<< SYMBOL TABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n\n");

            System.out.println(visitor.symbolTable);

            System.out.println("\n\n\n<<<<<<<<<<<<<<<<<<<<<<<<< HTML SYMBOL TABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n\n");

            System.out.println(visitor.htmlSymbolTable);


            visitor.componentTable.printTable();
        }    }
}