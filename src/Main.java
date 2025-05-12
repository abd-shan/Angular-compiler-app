//import gen.AngularParser;
//import org.antlr.v4.runtime.CharStream;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ParseTree;
//import program.Program;
//import ts.Method;
//import visitors.AngularVisitor;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Map;
//
//import static org.antlr.v4.runtime.CharStreams.fromFileName;
//
public class Main {
    public static void main(String[] args)
//            throws IOException
    {
//
//        String source = "tests/test1.txt";
//        CharStream cs = fromFileName(source);
//        AngularLexer lexer = new AngularLexer(cs);
//        CommonTokenStream token = new CommonTokenStream(lexer);
//        AngularParser parser = new AngularParser(token);
//        ParseTree tree = parser.program();
//
//        Program program = (Program) new AngularVisitor().visit(tree);
//
//        System.out.println(program);
//
//        System.out.println("\n\n\n<<<<<<<<<<<<<<<<<<<<<<<<< SYMBOL TABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n\n");
//
//
//        System.out.println(symbolTable(program));
//
//
    }
//
//
//   static String symbolTable(Program program) {
//
//        ArrayList<Symbol> symbols = new ArrayList<>();
//
//        Map<String, Listable> attributes=  program.typeScript.attributes;
//
//        for (var att:attributes.keySet()){
//        symbols.add(new Symbol(att, attributes.get(att).toString(),"global"));
//        }
//
//
//       Map<String, Listable> constructorVariables=program.typeScript.constructor.getVariables();
//
//        for (var att:constructorVariables.keySet()){
//            symbols.add(new Symbol(att, constructorVariables.get(att).toString(),"constructor"));
//        }
//
//
//
//       LinkedList<Method> methods=program.typeScript.methods;
//
//        for (Method m:methods){
//            Map<String, Listable> variables = m.getVariables();
//                    for (var v:variables.keySet()){
//                        symbols.add(new Symbol(v,variables.get(v).toString(),m.getName()));
//                    }
//        }
//
//
//
//
//        return symbols.toString();
//
//    }
//
//
//
}
//
//class Symbol{
//    String name;
//    String type;
//    String scope;
//    public Symbol(String name, String type, String scope) {
//        this.name = name;
//        this.type = type;
//        this.scope = scope;
//    }
//
//    @Override
//    public String toString() {
//        return "\nname='" + name + '\'' +"                                     "+
//                ", type='" + type + '\'' +"                                     "+
//                ", scope='" + scope + '\'' +"                                     "+
//                "\n";
//    }
//}