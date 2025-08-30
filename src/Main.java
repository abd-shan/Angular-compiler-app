import gen.AngularLexer;
import gen.AngularParser;
import generator.HtmlGenerator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import ast.program.AngularApp;
import semantic.TemplateSemanticAnalyzer;
import semantic.TypeScriptSemanticAnalyzer;
import semantic.ImportSemanticAnalyzer;
import visitors.AngularVisitor;
import java.io.IOException;
import java.util.List;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

	public static AngularVisitor visitor;

	public static void main(String[] args) throws IOException {

		String source = "tests/test7.txt";
		CharStream cs = fromFileName(source);
		AngularLexer lexer = new AngularLexer(cs);
		CommonTokenStream token = new CommonTokenStream(lexer);
		AngularParser parser = new AngularParser(token);
		ParseTree tree = parser.angularApp();



		visitor = new AngularVisitor(cs);
		AngularApp program = (AngularApp) visitor.visit(tree);


		System.out.println(program);


		var tsTable = visitor.getTsSymbolTable();
		var templateTable = visitor.getTemplateSymbolTable();
		var routerTable = visitor.getRouterSymbolTable();
		var importTable = visitor.getImportSymbolTable();

		// run semantic analyzers
		TemplateSemanticAnalyzer tAnalyzer = new TemplateSemanticAnalyzer(tsTable, templateTable);
		tAnalyzer.analyze();

		TypeScriptSemanticAnalyzer tsAnalyzer = new TypeScriptSemanticAnalyzer(tsTable);
		tsAnalyzer.analyze();

		ImportSemanticAnalyzer importAnalyzer = new ImportSemanticAnalyzer(importTable);
		importAnalyzer.analyze();

		// merge errors from all analyzers
		List<String> errors = new java.util.ArrayList<>(tsAnalyzer.getErrors());
		errors.addAll(tAnalyzer.getErrors());
		errors.addAll(importAnalyzer.getErrors());



		System.out.println("\n\n\n======================== SEMANTIC CHECK ========================\n\n\n");
		if (errors.isEmpty()) {
			System.out.println("No semantic errors found ^_^");


			System.out.println("\n\n\n<<<<<<<<<<<<<<<<<<<<<<<<< TS SYMBOL TABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n\n");
			System.out.println(tsTable);

			System.out.println("\n\n\n<<<<<<<<<<<<<<<<<<<<<<<<< TEMPLATE/BINDING SYMBOL TABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n\n");
			System.out.println(templateTable);

			System.out.println("\n\n\n<<<<<<<<<<<<<<<<<<<<<<<<< ROUTER SYMBOL TABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n\n");
			System.out.println(routerTable);

			importTable.printTable();


			HtmlGenerator htmlGenerator = new HtmlGenerator(program, routerTable);

		} else {


			System.out.println("Semantic errors: 0_0");
			for (String e : errors) System.out.println("- " + e);



		}
	}
}