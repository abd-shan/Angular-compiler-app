package generator;

import ast.program.AngularApp;
import ast.program.ComponentFile;
import ast.html.Node;
import ast.html.element.ElementNode;
import ast.html.element.InterpolationNode;
import ast.html.element.TextNode;
import ast.html.attribute.*;
import ast.ts.expressions.*;
import ast.ts.statements.DeclareAndAssignAttribute;
import ast.ts.statements.Method;
import ast.ts.statements.TsStatement;
import ast.ts.stmt.ExprStatement;
import symbolTable.RouterSymbolTable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class HtmlGenerator {

    private static final String OUTPUT_DIR = "output";
    Map<String, List<Map<String, TsExpression>>> data;
    AngularApp angularApp;
    RouterSymbolTable routerTable;

    public HtmlGenerator(AngularApp angularApp, RouterSymbolTable routerTable) {
        this.angularApp = angularApp;
        this.routerTable = routerTable;
        data = extractObjectArrays();

        List<ComponentFile> files = angularApp.getComponentFiles();
        ensureOutputDir();


//        List<TsStatement> statements = files.get(1).getTsCode().getStatements();
//        System.out.println("statements "+statements);
//       Method method= (Method) statements.get(3);
//        System.out.println("method "+method);
//        List<TsStatement> methodStatements = method.getBody().getStatements();
//        System.out.println("methodStatements "+methodStatements);
//        ExprStatement exprStatement = (ExprStatement) methodStatements.getFirst();
//        System.out.println("exprStatement "+exprStatement);
//       TsExpression expression= exprStatement.getExpression();
//        System.out.println( "expression  "+expression);// prints : expression  this.router.navigate(["/product", productId])


//        Map<String, Set<String>> routers = routerTable.getRoutes();
//        System.out.println(routers);//  {products=[ProductListComponent], product/:id=[ProductDetailComponent], add=[AddEditProductComponent], edit/:id=[AddEditProductComponent]}


//        Map<String, List<Map<String, TsExpression>>> objects= extractObjectArrays();
//        System.out.println(objects); // prints : {products=[{id=1, name="HP Laptop", description="Brand new HP Laptop with Intel i7 processor", image="https://images.pexels.com/photos/7974/pexels-photo.jpg", price=3500}, {id=2, name="iPhone", description="iPhone 14 Pro with advanced camera system", image="https://images.pexels.com/photos/7974/pexels-photo.jpg", price=4500}, {id=3, name="AirPods", description="Wireless Apple AirPods", image="https://images.pexels.com/photos/7974/pexels-photo.jpg", price=800}], products$=[]}

//        ElementNode elementNode = (ElementNode) files.get(1).getTemplate().getNodes().getFirst();
//        System.out.println("elementNode" + elementNode);
//        ElementNode node = (ElementNode) elementNode.getChildren().get(1);
//        System.out.println("node" + node);
//        List<Node> children = node.getChildren();
//        System.out.println("children" + children);
//        ElementNode child = (ElementNode) children.getFirst();
//        System.out.println("child" + child);
//        List<HtmlAttribute> childAtts = child.getAttributes();
//        System.out.println("childAtts" + childAtts);
//        NgForAttribute childAtt = (NgForAttribute) childAtts.get(1);
//        System.out.println("childAtt " + childAtt);


//            List<HtmlAttribute> standardAttributes =  node.getAttributes(); // arraylist<ElementNode>
//            System.out.println("standardAttributes" + standardAttributes);
//            StandardAttribute standardAttribute = (StandardAttribute) standardAttributes.getFirst();
//            System.out.println("standardAttribute" + standardAttribute);
//            List<Node> children = node.getChildren(); // arraylist<ElementNode>
//            System.out.println("children" + children);
//            ElementNode child = (ElementNode) children.getFirst();
//            System.out.println("child" + child);
//            String tag = child.getTagName();
//            System.out.println("tag" + tag);
//            List<Node> childChilds = child.getChildren();
//            InterpolationNode childChild= (InterpolationNode) childChilds.getFirst();
//            System.out.println("childChild" + childChild);
//            String expressions = childChild.getExpression();
//            System.out.println("expressions" + expressions);


        for (ComponentFile file : files) {
            createHtmlTemplate(file);
        }

    }


    private void createHtmlTemplate(ComponentFile file) {
        String className = file.getClassName();
        File htmlFile = new File(OUTPUT_DIR, className + ".html");

        try (FileWriter writer = new FileWriter(htmlFile, false)) {
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html lang=\"en\">\n");
            writer.write("<head>\n");
            writer.write("  <meta charset=\"UTF-8\">\n");
            writer.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            writer.write("  <title>" + className + " Component</title>\n");

            String styles = file.getStyles();
            if (styles != null && !styles.isBlank()) {
                writer.write("  <style>\n");
                writer.write(styles);
                writer.write("\n  </style>\n");
            }

            writer.write("</head>\n");
            writer.write("<body>\n");

            Map<String, TsExpression> attributes = extractAttributes(file);

            List<Node> nodes = file.getTemplate().getNodes();
            Set<String> ngForObjects = new HashSet<>();
            for (Node node : nodes) {
                writer.write(generateHtmlFromNode(node, attributes));
                writer.write("\n");
                ngForObjects.addAll(extractNgForObjects(node));
            }

            writer.write("  <!-- " + className + " template -->\n");
            writer.write("<script>\n");

            // ✅ Always generate get functions
            Map<String, List<Map<String, TsExpression>>> objects = extractObjectArrays();
            String jsFunctions = generateGetFunctions(objects);
            writer.write(jsFunctions);

            // ✅ Generate render functions if needed
            if (!ngForObjects.isEmpty()) {
                Map<String, List<Map<String, TsExpression>>> filtered = new HashMap<>();
                for (String obj : ngForObjects) {
                    if (objects.containsKey(obj)) {
                        filtered.put(obj, objects.get(obj));
                    }
                }
                String renderFunctions = generateRenderFunctions(ngForElements);
                writer.write(renderFunctions);
            }

            // ✅ NEW: Generate routing functions from methods
            String routingFunctions = generateRoutingFunctions(file);
            writer.write(routingFunctions);

            writer.write("</script>\n");
            writer.write("</body>\n");
            writer.write("</html>\n");

            System.out.println("Created template file: " + htmlFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error creating file: " + htmlFile.getAbsolutePath());
            e.printStackTrace();
        }
    }


    String ngforParentId;

    List<ElementNode> ngForElements = new ArrayList<>();


    private String generateHtmlFromNode(Node node, Map<String, TsExpression> attributes) {
        if (node instanceof TextNode textNode) {
            return textNode.getText();
        } else if (node instanceof InterpolationNode interpolation) {
            String exprName = interpolation.getExpression();
            TsExpression value = attributes.get(exprName);
            return value != null ? value.toString() : "{{" + exprName + "}}";
        } else if (node instanceof ElementNode element) {
            StringBuilder html = new StringBuilder();

            boolean childHasNgFor = element.getChildren().stream()
                    .filter(c -> c instanceof ElementNode)
                    .map(c -> (ElementNode) c)
                    .flatMap(e -> e.getAttributes().stream())
                    .anyMatch(attr -> attr instanceof NgForAttribute);

            html.append("<").append(element.getTagName());

            for (HtmlAttribute attr : element.getAttributes()) {
                if (attr instanceof StandardAttribute standard) {
                    String name = standard.getName();
                    String value = standard.getValue();

                    if ("routerLink".equals(name)) {
                        // routerLink="/products" → lookup in routerTable
                        String route = value.startsWith("/") ? value.substring(1) : value;
                        Set<String> components = routerTable.getRoutes().get(route);
                        if (components != null && !components.isEmpty()) {
                            // Use the first component name from the set
                            String component = components.iterator().next();
                            html.append(" href=\"").append(component).append(".html\"");
                        }
                    } else if ("routerLinkActive".equals(name)) {
                        // skip routerLinkActive completely
                        continue;
                    } else {
                        html.append(" ").append(name)
                                .append("=\"").append(value).append("\"");
                    }
                }
            }

            if (childHasNgFor) {
                ngforParentId = "ngfor-parent-" + new Random().nextInt(500);
                html.append(" id=\"").append(ngforParentId).append("\"");
            }

            html.append(">");

            for (Node child : element.getChildren()) {
                if (child instanceof ElementNode e && e.getAttributes().stream().anyMatch(a -> a instanceof NgForAttribute)) {
                    ngForElements.add(e);
                    continue;
                }
                html.append(generateHtmlFromNode(child, attributes));
            }

            html.append("</").append(element.getTagName()).append(">");
            return html.toString();
        }
        return "";
    }


    private String generateGetFunctions(Map<String, List<Map<String, TsExpression>>> objects) {
        StringBuilder js = new StringBuilder();

        for (Map.Entry<String, List<Map<String, TsExpression>>> entry : objects.entrySet()) {
            String key = entry.getKey();

            // skip keys ending with $
            if (key.endsWith("$")) continue;

            List<Map<String, TsExpression>> items = entry.getValue();

//            js.append("function get").append(key).append("() {\n");
            js.append("function get").append(capitalize(key)).append("() {\n");
            js.append("  return JSON.parse(localStorage.getItem(\"").append(key).append("\")) || [\n");

            for (int i = 0; i < items.size(); i++) {
                Map<String, TsExpression> obj = items.get(i);
                js.append("    { ");
                int j = 0;
                for (Map.Entry<String, TsExpression> field : obj.entrySet()) {
                    js.append(field.getKey()).append(": ").append(field.getValue());
                    if (j < obj.size() - 1) js.append(", ");
                    j++;
                }
                js.append(" }");
                if (i < items.size() - 1) js.append(",");
                js.append("\n");
            }

            js.append("  ];\n");
            js.append("}\n\n");
        }

        return js.toString();
    }


    private Set<String> extractNgForObjects(Node node) {
        Set<String> result = new HashSet<>();

        if (node instanceof ElementNode element) {
            for (HtmlAttribute attr : element.getAttributes()) {
                if (attr instanceof NgForAttribute ngFor) {
                    // Example: "*ngFor=\"let product of products\"" -> extract "products"
                    String expression = ngFor.getExpression();
                    if (expression != null && expression.contains(" of ")) {
                        String[] parts = expression.split(" of ");
                        if (parts.length == 2) {
                            result.add(parts[1].trim());
                        }
                    }
                }
            }
            // Recurse children
            for (Node child : element.getChildren()) {
                result.addAll(extractNgForObjects(child));
            }
        }
        return result;
    }


    private String generateRenderFunctions(List<ElementNode> ngForElements) {
        StringBuilder js = new StringBuilder();

        for (ElementNode ngForElement : ngForElements) {
            // Find the ngFor attribute
            NgForAttribute ngFor = (NgForAttribute) ngForElement.getAttributes().stream()
                    .filter(a -> a instanceof NgForAttribute)
                    .findFirst()
                    .orElse(null);
            if (ngFor == null) continue;

            String expr = ngFor.getExpression(); // "let product of products"
            String[] parts = expr.split(" of ");
            if (parts.length != 2) continue;

            String itemVar = parts[0].replace("let", "").trim(); // e.g., "product"
            String arrayVar = parts[1].trim();                   // e.g., "products"

            String parentId = ngforParentId; // The parent container's ID

            js.append("function render").append(capitalize(arrayVar)).append("() {\n");
            js.append("  const ").append(arrayVar).append(" = get").append(capitalize(arrayVar)).append("();\n");
            js.append("  const grid = document.getElementById(\"").append(parentId).append("\");\n");
            js.append("  grid.innerHTML = \"\";\n");
            js.append("  ").append(arrayVar).append(".forEach(").append(itemVar).append(" => {\n");
            js.append("    const card = document.createElement(\"div\");\n");

            // Generate inner HTML for the ngFor element
            String cardHtml = generateInnerHtmlForNgFor(ngForElement, itemVar);
            js.append("    card.innerHTML = `").append(cardHtml).append("`;\n");
            js.append("    grid.appendChild(card);\n");
            js.append("  });\n");
            js.append("}\n\n");
            js.append("render").append(capitalize(arrayVar)).append("()\n");
        }

        return js.toString();
    }

    private String generateInnerHtmlForNgFor(ElementNode node, String itemVar) {
        StringBuilder html = new StringBuilder();

        // Open tag
        html.append("<").append(node.getTagName());
        for (HtmlAttribute attr : node.getAttributes()) {
            if (attr instanceof StandardAttribute std) {
                html.append(" ").append(std.getName()).append("=\"").append(std.getValue()).append("\"");
            } else if ("[src]".equals(attr.getName()) || "[alt]".equals(attr.getName())) {
                // Convert [src]="product.image" -> src="${product.image}"
                String value = attr.getValue().replace(itemVar + ".", "");
                html.append(" ").append(attr.getName().substring(1, attr.getName().length() - 1))
                        .append("=\"${").append(itemVar).append(".").append(value).append("}\"");
            } else if ("(click)".equals(attr.getName())) {
                // Example: (click)="viewDetails(product.id, product.name)"
                String expr = attr.getValue().trim();

                // Replace every occurrence of "product.xxx" with "${product.xxx}"
                String call = expr.replaceAll(itemVar + "\\.(\\w+)", "\\${" + itemVar + ".$1}");

                html.append(" onclick=\"").append(call).append("\"");
            }


        }
        html.append(">");

        // Children
        for (Node child : node.getChildren()) {
            if (child instanceof TextNode textNode) {
                html.append(textNode.getText());
            } else if (child instanceof InterpolationNode interpolation) {
                String expr = interpolation.getExpression().replace(itemVar + ".", "");
                html.append("${").append(itemVar).append(".").append(expr).append("}");
            } else if (child instanceof ElementNode childElem) {
                html.append(generateInnerHtmlForNgFor(childElem, itemVar));
            }
        }

        html.append("</").append(node.getTagName()).append(">");
        return html.toString();
    }


private String generateRoutingFunctions(ComponentFile file) {
    StringBuilder js = new StringBuilder();

    for (TsStatement stmt : file.getTsCode().getStatements()) {
        if (stmt instanceof Method method) {
            List<TsStatement> bodyStatements = method.getBody().getStatements();
            if (bodyStatements.isEmpty()) continue;

            TsStatement first = bodyStatements.getFirst();
            if (first instanceof ExprStatement exprStmt) {
                TsExpression expr = exprStmt.getExpression();

                // Only care about this.router.navigate([...])
                String exprText = expr.toString();
                if (exprText.startsWith("this.router.navigate")) {

                    // Extract route from the navigate call
                    String inside = exprText.substring(exprText.indexOf("[") + 1, exprText.lastIndexOf("]"));
                    String[] parts = inside.split(",");
                    String route = parts[0].replace("\"", "").replace("'", "").trim();
                    String paramVar = parts.length > 1 ? parts[1].trim() : null;

                    // Remove leading slash
                    route = route.startsWith("/") ? route.substring(1) : route;

                    // Try both: exact route and route + "/:id"
                    String matchedRoute = null;
                    if (routerTable.getRoutes().containsKey(route)) {
                        matchedRoute = route;
                    } else if (routerTable.getRoutes().containsKey(route + "/:id")) {
                        matchedRoute = route + "/:id";
                    }

                    if (matchedRoute == null) continue;

                    Set<String> comps = routerTable.getRoutes().get(matchedRoute);
                    if (comps == null || comps.isEmpty()) continue;

                    String targetComponent = comps.iterator().next() + ".html";

                    // Generate JS function
                    js.append("function ").append(method.getName()).append("(");
                    if (!method.getParameters().isEmpty()) {
                        js.append(method.getParameters().get(0).getName());
                    }
                    js.append(") {\n");

                    if (paramVar != null) {
                        js.append("  window.location.href = \"")
                                .append(targetComponent)
                                .append("?id=\" + ").append(paramVar).append(";\n");
                    } else {
                        js.append("  window.location.href = \"")
                                .append(targetComponent).append("\";\n");
                    }

                    js.append("}\n\n");
                }
            }
        }
    }

    return js.toString();
}



    private String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }


    private void ensureOutputDir() {
        File out = new File(OUTPUT_DIR);
        if (!out.exists() && !out.mkdirs()) {
            System.err.println("Could not create output directory: " + OUTPUT_DIR);
        }
    }

    private Map<String, TsExpression> extractAttributes(ComponentFile file) {
        Map<String, TsExpression> attributeMap = new LinkedHashMap<>();

        List<TsStatement> statements = file.getTsCode().getStatements();
        for (TsStatement statement : statements) {
            if (statement instanceof DeclareAndAssignAttribute declare) {
                attributeMap.put(declare.getName(), declare.getExpression());
            }
        }

        return attributeMap;
    }


    private Map<String, List<Map<String, TsExpression>>> extractObjectArrays() {
        Map<String, List<Map<String, TsExpression>>> result = new LinkedHashMap<>();

        List<TsStatement> statements = angularApp.getStateFiles()
                .getFirst()
                .getServiceClasses()
                .getFirst()
                .getTsCode()
                .getStatements();

        for (TsStatement stmt : statements) {
            if (stmt instanceof DeclareAndAssignAttribute statement) {
                String name = statement.getName();

                List<Map<String, TsExpression>> objectList = new ArrayList<>();

                if (statement.getExpression() instanceof PrimaryExpression pe1 &&
                        pe1.getAtom() instanceof NewExpression newExpr &&
                        !newExpr.getArguments().isEmpty() &&
                        newExpr.getArguments().getFirst() instanceof PrimaryExpression pe2 &&
                        pe2.getAtom() instanceof ArrayLiteral array) {

                    for (TsExpression expr : array.getElements()) {
                        if (expr instanceof PrimaryExpression pe &&
                                pe.getAtom() instanceof ObjectLiteral obj) {

                            Map<String, TsExpression> propertyMap = new LinkedHashMap<>();
                            for (KeyValuePair kv : obj.getProperties()) {
                                propertyMap.put(kv.getKey(), kv.getValue());
                            }
                            objectList.add(propertyMap);
                        }
                    }
                }

                result.put(name, objectList);
            }
        }

        return result;
    }


}
