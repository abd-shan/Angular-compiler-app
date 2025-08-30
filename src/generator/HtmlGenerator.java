package generator;

import ast.program.AngularApp;
import ast.program.ComponentFile;
import ast.html.Node;
import ast.html.element.ElementNode;
import ast.html.element.InterpolationNode;
import ast.html.element.TextNode;
import ast.html.attribute.*;
import ast.program.StateFile;
import ast.state.StateServiceClass;
import ast.ts.expressions.*;
import ast.ts.statements.DeclareAndAssignAttribute;
import ast.ts.statements.Method;
import ast.ts.statements.MethodParam;
import ast.ts.statements.TsStatement;
import ast.ts.stmt.ExprStatement;
import symbolTable.RouterSymbolTable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class HtmlGenerator {

    private static final String OUTPUT_DIR = "output";
    Map<String, List<Map<String, TsExpression>>> data;
    AngularApp angularApp;
    RouterSymbolTable routerTable;
    StateServiceClass serviceClass;

    public HtmlGenerator(AngularApp angularApp, RouterSymbolTable routerTable) {
        this.angularApp = angularApp;
        this.routerTable = routerTable;
        data = extractObjectArrays();
        serviceClass = angularApp.getStateFiles().getFirst().getServiceClasses().getFirst();

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

//        ElementNode elementNode = (ElementNode) files.get(2).getTemplate().getNodes().getFirst();
//        System.out.println("elementNode "+elementNode);
//        ElementNode elementNode2 = (ElementNode) elementNode.getChildren().get(1);
//        System.out.println("elementNode2 "+elementNode2);
//        ElementNode child= (ElementNode) elementNode2.getChildren().get(4);
//        System.out.println("child "+child);
//        StandardAttribute standardAttribute = (StandardAttribute) child.getAttributes().get(0);
//        System.out.println("standardAttribute "+standardAttribute);
//        AngularEventBinding angularEventBinding = (AngularEventBinding) child.getAttributes().get(1);
//        System.out.println("angularEventBinding "+angularEventBinding);


//        NgIfAttribute ngIfAttribute = (NgIfAttribute) elementNode2.getAttributes().get(1);
//        System.out.println("ngIfAttribute "+ngIfAttribute);
//        String expression = ngIfAttribute.getExpression();
//        System.out.println("expression "+expression);


//         serviceClass = stateFile.getServiceClasses().getFirst();
//        serviceClass.getClassName();
//        System.out.println("serviceClass.getClassName() " + serviceClass.getClassName());
//        serviceClass.getTsCode();
//        System.out.println("serviceClass.getTsCode() " + serviceClass.getTsCode());

        createJsFile();

        for (ComponentFile file : files) {
            createHtmlTemplate(file);
        }

    }


    private void createJsFile() {
        File htmlFile = new File(OUTPUT_DIR, serviceClass.getClassName() + ".js");

        try (FileWriter writer = new FileWriter(htmlFile, false)) {

            Map<String, List<Map<String, TsExpression>>> objects = extractObjectArrays();
            String jsFunctions = generateGetFunctions(objects);
            writer.write(jsFunctions);

            // Generate functions from service class methods that don't contain 'this'
            String serviceFunctions = generateServiceFunctions();
            writer.write(serviceFunctions);

        } catch (IOException e) {
            throw new RuntimeException(e);
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
            writer.write("<script src=\"" + serviceClass.getClassName() + ".js\"></script>\n");
            writer.write("<script>\n");

            // ✅ NEW: Add URL param parsing only for /:id routes
            if (isIdRoutedComponent(file.getClassName())) {
                writer.write("const params = new URLSearchParams(window.location.search);\n");
                writer.write("const id = Number(params.get(\"id\"));\n\n");
            }

// ✅ Always generate get functions
            Map<String, List<Map<String, TsExpression>>> objects = extractObjectArrays();
//            String jsFunctions = generateGetFunctions(objects);
//            writer.write(jsFunctions);

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

// ✅ Generate routing functions from methods
            String routingFunctions = generateRoutingFunctions(file);
            writer.write(routingFunctions);


            String ngifElements = generateNgIfFunctions();
            writer.write(ngifElements);


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
    String ngifParentId;
    List<ElementNode> ngIfElements = new ArrayList<>();


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
                    .anyMatch(c -> c instanceof ElementNode e &&
                            e.getAttributes().stream().anyMatch(a -> a instanceof NgForAttribute));

            boolean childHasNgIf = element.getChildren().stream()
                    .anyMatch(c -> c instanceof ElementNode e &&
                            e.getAttributes().stream().anyMatch(a -> a instanceof NgIfAttribute));

            html.append("<").append(element.getTagName());

            for (HtmlAttribute attr : element.getAttributes()) {
                if (attr instanceof StandardAttribute standard) {
                    String name = standard.getName();
                    String value = standard.getValue();

                    if ("routerLink".equals(name)) {
                        String route = value.startsWith("/") ? value.substring(1) : value;
                        Set<String> components = routerTable.getRoutes().get(route);
                        if (components != null && !components.isEmpty()) {
                            String component = components.iterator().next();
                            html.append(" href=\"").append(component).append(".html\"");
                        }
                    } else if ("routerLinkActive".equals(name)) {
                        continue; // skip
                    } else {
                        html.append(" ").append(name)
                                .append("=\"").append(value).append("\"");
                    }
                }
                // ✅ Handle Angular Event Binding
                else if (attr instanceof AngularEventBinding eventBinding) {
                    String eventName = eventBinding.getEvent();    // e.g., "click"
                    String handler = eventBinding.getHandler();    // e.g., "goBack()"
                    html.append(" on").append(eventName)
                            .append("=\"").append(handler).append("\"");
                }
            }

            if (childHasNgFor) {
                ngforParentId = "ngfor-parent-" + new Random().nextInt(500);
                html.append(" id=\"").append(ngforParentId).append("\"");
            }
            if (childHasNgIf) {
                ngifParentId = "ngif-parent-" + new Random().nextInt(500);
                html.append(" id=\"").append(ngifParentId).append("\"");
            }

            html.append(">");

            ngForElements = new ArrayList<>();
            ngIfElements = new ArrayList<>();
            for (Node child : element.getChildren()) {
                if (child instanceof ElementNode e) {
                    if (e.getAttributes().stream().anyMatch(a -> a instanceof NgForAttribute)) {
                        ngForElements.add(e);
                        continue; // skip ngFor element
                    }
                    if (e.getAttributes().stream().anyMatch(a -> a instanceof NgIfAttribute)) {
                        ngIfElements.add(e);
                        continue; // skip ngIf element
                    }
                }
                html.append(generateHtmlFromNode(child, attributes));
            }

            html.append("</").append(element.getTagName()).append(">");
            return html.toString();
        }
        return "";
    }


    String nameOfGot;

    private String generateGetFunctions(Map<String, List<Map<String, TsExpression>>> objects) {
        StringBuilder js = new StringBuilder();

        for (Map.Entry<String, List<Map<String, TsExpression>>> entry : objects.entrySet()) {
            String key = entry.getKey();

            // skip keys ending with $
            if (key.endsWith("$")) continue;

            List<Map<String, TsExpression>> items = entry.getValue();

            // --------------------
            // Plural getter
            // --------------------
            String pluralFuncName = "get" + capitalize(key);
            js.append("function ").append(pluralFuncName).append("() {\n");
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
            js.append("}\n");

            // --------------------
            // Singular getter
            // --------------------
            // Naive singularization: remove trailing 's' if present
            String singular = key.endsWith("s") ? key.substring(0, key.length() - 1) : key;
            String singularFuncName = "get" + capitalize(singular);
            this.nameOfGot = capitalize(singular);
            String itemVar = singular.substring(0, 1); // first letter (p for product, c for category...)

//            js.append("function ").append(singularFuncName).append("(id) {\n");
//            js.append("  return ").append(pluralFuncName)
//                    .append("().find(").append(itemVar)
//                    .append(" => ").append(itemVar).append(".id === id);\n");
//            js.append("}\n\n");
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

    Set<String> ngifIds = new HashSet<>();

    private String generateNgIfFunctions() {
        StringBuilder js = new StringBuilder();

        for (ElementNode ngIfElement : ngIfElements) {
            NgIfAttribute ngIf = (NgIfAttribute) ngIfElement.getAttributes().stream()
                    .filter(a -> a instanceof NgIfAttribute)
                    .findFirst()
                    .orElse(null);
            if (ngIf == null) continue;

            String expr = ngIf.getExpression(); // e.g. "product" or "!product"

            if (!ngifIds.contains(ngifParentId)) {

                js.append("const ").append(expr).append(" = ").append("get").append(nameOfGot).append("(id);\n");
                js.append("  const parent = document.getElementById(\"").append(ngifParentId).append("\");\n");
                js.append("  parent.innerHTML = \"\";\n");
                ngifIds.add(ngifParentId);
            }
            js.append("  if (").append(expr).append(") {\n");
            String innerHtml = generateInnerHtmlForNgFor(ngIfElement, expr.replace("!", "").trim());
            js.append("    parent.innerHTML = `").append(innerHtml).append("`;\n");
            js.append("  }\n");
        }

        return js.toString();
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


    private boolean isIdRoutedComponent(String className) {
        for (Map.Entry<String, Set<String>> entry : routerTable.getRoutes().entrySet()) {
            String path = entry.getKey();
            if (path.contains("/:id")) {
                for (String comp : entry.getValue()) {
                    if (comp.equals(className)) {
                        return true;
                    }
                }
            }
        }
        return false;
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

    private String generateServiceFunctions() {
        StringBuilder js = new StringBuilder();

        List<TsStatement> statements = serviceClass.getTsCode().getStatements();

        for (TsStatement stmt : statements) {
            if (stmt instanceof Method method) {
                String methodBody = method.getBody().toString();
                if (!methodBody.contains("this")) {
                    js.append("function ").append(method.getName()).append("(");

                    List<MethodParam> params = method.getParameters();
                    for (int i = 0; i < params.size(); i++) {
                        MethodParam param = params.get(i);
                        js.append(param.getName());
                        if (i < params.size() - 1) {
                            js.append(", ");
                        }
                    }

                    js.append(") {\n");

                    String body = methodBody;
                    body = body.trim();
                    String[] lines = body.split("\n");
                    for (String line : lines) {
                        if (!line.trim().isEmpty()) {
                            js.append("  ").append(line.trim()).append("\n");
                        }
                    }

                    js.append("}\n\n");
                } else {

                    js.append("function ").append(method.getName()).append("(");

                    // Add parameters
                    List<MethodParam> params = method.getParameters();
                    for (int i = 0; i < params.size(); i++) {
                        MethodParam param = params.get(i);
                        js.append(param.getName());
                        if (i < params.size() - 1) {
                            js.append(", ");
                        }
                    }

                    js.append(") {\n");

                    String body = methodBody;
                    body = body.trim();
                    String[] lines = body.split("\n");


                    String toUpdate = "";
                    String attribute = "";

                    boolean ok = true;
                    boolean fixed = false;

                    for (String line : lines) {
                        // Case 1: Replace "this.xxxxx.value" with "getXxxxx()"
                        if (line.contains("this.") && line.contains(".value")) {
                            String variable = line.substring(line.indexOf("this.") + 5, line.indexOf(".value"));
                            toUpdate = variable;
                            attribute = variable;
                            line = line.replace("this." + variable + ".value", "get" + capitalize(variable) + "()");
                        }

                        // Case 2: Replace "{:" with "{"
                        if (line.contains("{:")) {
                            line = line.replace("{:", "{");
                        }

                        if (line.contains("this.") && line.contains(".next([")) {
                            String variable = line.substring(line.indexOf("this.") + 5, line.indexOf(".next("));

                            int argsStart = line.indexOf("[") + 1;
                            int argsEnd = line.indexOf("]");
                            String args = line.substring(argsStart, argsEnd);

                            String[] argsArray = args.split(",");
                            fixed = true;
                            if (argsArray.length == 1) {
                                continue;
                            }
                            String secondArg = argsArray.length > 1 ? argsArray[1].trim() : "";

                            line = line.replace("this." + variable + ".next([" + args + "])", variable + ".push(" + secondArg + ")");
                        }
                        if (line.contains("this.") && line.contains(".next(")) {
                            int start = line.indexOf("this.") + 5;
                            int end = line.indexOf(".next(");
                            String variable = line.substring(start, end);

                            int argStart = line.indexOf("(", end) + 1;
                            int argEnd = line.lastIndexOf(")");
                            String argument = line.substring(argStart, argEnd).trim();

                            // Replace the line with the new JS assignment
                            line = "const updated" + capitalize(variable) + " = " + argument;
                            toUpdate = "updated" + capitalize(variable);
                            fixed = true;
                        }

                        js.append(line).append("\n");
                    }

                    if (ok && fixed) {
                        js.append("  localStorage.setItem(\"").append(attribute).append("\", JSON.stringify(").append(toUpdate).append("));\n");
                    }
                    js.append("}\n");
                }


            }
        }

        return js.toString();
    }

/*
    private String generateServiceFunctions() {
        StringBuilder js = new StringBuilder();

        List<TsStatement> statements = serviceClass.getTsCode().getStatements();

        boolean last = false;
        int methodCount = 0;
        int methodIndex = 0;

        // First, count how many methods are in the service class
        for (TsStatement stmt : statements) {
            if (stmt instanceof Method) {
                methodCount++;
            }
        }

        for (TsStatement stmt : statements) {
            if (stmt instanceof Method method) {
                methodIndex++;

                // Check if method body contains 'this'
                String methodBody = method.getBody().toString();
                if (methodBody.contains("this")) {
                    // Generate JavaScript function for methods containing 'this'
                    js.append("function ").append(method.getName()).append("(");

                    // Add parameters
                    List<MethodParam> params = method.getParameters();
                    for (int i = 0; i < params.size(); i++) {
                        MethodParam param = params.get(i);
                        js.append(param.getName());
                        if (i < params.size() - 1) {
                            js.append(", ");
                        }
                    }

                    js.append(") {\n");

                    // Process method body
                    String body = methodBody.trim();
                    String[] lines = body.split("\n");
                    String firstConstName = extractFirstConstName(methodBody); // Extract first const from the method body

                    boolean addedLocalStorage = false; // Flag to track if localStorage was already added in the method body

                    // Process each line of the method body
                    for (String line : lines) {
                        if (line.contains("this.")) {
                            // Replace this.xxx.value with getXxx() (fix case-sensitive issues)
                            line = line.replaceAll("this\\.(\\w+)\\.value", "get$1()");

                            // Replace this.methodName() with methodName()
                            line = line.replaceAll("this\\.(\\w+)\\(\\)", "$1()");

                            // Replace getproducts with getProducts (case-sensitive fix)
                            line = line.replaceAll("getproducts", "getProducts");

                            // Handle next([something]) case - replace with localStorage.setItem
                            if (line.contains("this.") && line.contains("next([")) {
                                // If it's a next([something]), replace it with localStorage.setItem
                                line = line.replaceAll("this\\.(\\w+)\\.next\\(\\[.*?\\]\\);", "localStorage.setItem(\"$1\", JSON.stringify($1));");

                                // After replacing, we flag that we've already added localStorage.setItem
                                addedLocalStorage = true;
                            }
                        }

                        // Add the processed line with indentation
                        js.append("  ").append(line.trim()).append("\n");
                    }

                    // Add localStorage.setItem at the end of the function for the first const
                    if (firstConstName != null && !addedLocalStorage && methodIndex != methodCount) {
                        js.append("  localStorage.setItem(\"").append(firstConstName).append("\", JSON.stringify(").append(firstConstName).append("));\n");
                    }

                    js.append("}\n\n");
                }
            }
        }

        return js.toString();
    }
*/

/*
  private String generateServiceFunctions() {
        StringBuilder js = new StringBuilder();

        List<TsStatement> statements = serviceClass.getTsCode().getStatements();

        boolean last = false;
        int methodCount = 0;
        int methodIndex = 0;

        // First, count how many methods are in the service class
        for (TsStatement stmt : statements) {
            if (stmt instanceof Method) {
                methodCount++;
            }
        }

        for (TsStatement stmt : statements) {
            if (stmt instanceof Method method) {
                methodIndex++;

                // Check if method body contains 'this'
                String methodBody = method.getBody().toString();
                if (methodBody.contains("this")) {
                    // Generate JavaScript function for methods containing 'this'
                    js.append("function ").append(method.getName()).append("(");

                    // Add parameters
                    List<MethodParam> params = method.getParameters();
                    for (int i = 0; i < params.size(); i++) {
                        MethodParam param = params.get(i);
                        js.append(param.getName());
                        if (i < params.size() - 1) {
                            js.append(", ");
                        }
                    }

                    js.append(") {\n");

                    // Process method body
                    String body = methodBody.trim();
                    String[] lines = body.split("\n");
                    String firstConstName = extractFirstConstName(methodBody); // Extract first const from the method body

                    boolean addedLocalStorage = false; // Flag to track if localStorage was already added in the method body

                    // Process each line of the method body
                    for (String line : lines) {
                        if (line.contains("this.")) {
                            // Replace this.xxx.value with getXxx() (fix case-sensitive issues)
                            line = line.replaceAll("this\\.(\\w+)\\.value", "get$1()");

                            // Replace this.methodName() with methodName()
                            line = line.replaceAll("this\\.(\\w+)\\(\\)", "$1()");

                            // Replace getproducts with getProducts (case-sensitive fix)
                            line = line.replaceAll("getproducts", "getProducts");

                            // Handle next([something]) case - replace with localStorage.setItem
                            if (line.contains("this.") && line.contains("next([")) {
                                // If it's a next([something]), replace it with localStorage.setItem
                                line = line.replaceAll("this\\.(\\w+)\\.next\\(\\[.*?\\]\\);", "localStorage.setItem(\"$1\", JSON.stringify($1));");

                                // After replacing, we flag that we've already added localStorage.setItem
                                addedLocalStorage = true;
                            }
                        }

                        // Handle deleteProduct case specifically: update the line and replace with localStorage logic
                        if (line.contains("this.products.next") && !line.contains("[")) {
                            line = line.replaceAll("this\\.products\\.next\\(.*\\)", "localStorage.setItem(\"products\", JSON.stringify(updatedProducts))");
                            addedLocalStorage = true;
                        }

                        // Change {: to {
                        line = line.replaceAll("\\{:\\s*", "{");

                        // Add the processed line with indentation
                        js.append("  ").append(line.trim()).append("\n");
                    }

                    // Add localStorage.setItem at the end of the function for the first const
                    if (firstConstName != null && !addedLocalStorage && methodIndex != methodCount) {
                        js.append("  localStorage.setItem(\"").append(firstConstName).append("\", JSON.stringify(").append(firstConstName).append("));\n");
                    }

                    js.append("}\n\n");
                }
            }
        }

        return js.toString();
    }
*/


    private String extractFirstConstName(String methodBody) {
        // Regex to match const declarations
        Pattern pattern = Pattern.compile("const\\s+(\\w+)\\s*=.*");
        Matcher matcher = pattern.matcher(methodBody);

        if (matcher.find()) {
            return matcher.group(1);  // Return the name of the first const
        }

        return null;  // Return null if no const found
    }


}
