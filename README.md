# Angular Compiler Application

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-11%2B-orange.svg)](https://www.oracle.com/java/)
[![ANTLR4](https://img.shields.io/badge/ANTLR4-4.13.0-blue.svg)](https://www.antlr.org/)
[![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen.svg)](https://github.com/abd-shan/Angular-compiler-app)
[![Contributions Welcome](https://img.shields.io/badge/Contributions-Welcome-brightgreen.svg)](CONTRIBUTING.md)
[![Issues](https://img.shields.io/github/issues/abd-shan/Angular-compiler-app)](https://github.com/abd-shan/Angular-compiler-app/issues)
[![Stars](https://img.shields.io/github/stars/abd-shan/Angular-compiler-app)](https://github.com/abd-shan/Angular-compiler-app/stargazers)

A comprehensive Angular compiler built with Java and ANTLR4 that parses Angular applications, performs semantic analysis, and generates executable HTML/JavaScript code.

## 🚀 Features

### Core Functionality
- **Angular Syntax Parsing**: Full support for Angular component syntax, templates, and TypeScript
- **Semantic Analysis**: Advanced error detection with 10+ semantic error types
- **Code Generation**: Professional HTML/JavaScript output with modern web standards
- **Multi-File Support**: Handles complete Angular applications with multiple components
- **State Management**: Built-in support for Angular services and state management patterns

### Supported Angular Features
- ✅ **Components**: Full component syntax with decorators, selectors, and metadata
- ✅ **Templates**: HTML templates with Angular directives and bindings
- ✅ **TypeScript**: Complete TypeScript syntax support including types, interfaces, and generics
- ✅ **Directives**: `*ngFor`, `*ngIf`, property binding, event binding, two-way binding
- ✅ **Routing**: Angular Router configuration and navigation
- ✅ **Services**: Injectable services with dependency injection
- ✅ **State Management**: RxJS observables, subjects, and state patterns
- ✅ **Forms**: Template-driven forms with `ngModel`
- ✅ **Styling**: Inline CSS and external stylesheets

## 📋 Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Input/Output Examples](#inputoutput-examples)
- [Semantic Error Detection](#semantic-error-detection)
- [Code Generation](#code-generation)
- [Project Structure](#project-structure)
- [Architecture](#architecture)
- [Contributing](#contributing)

## 🚀 Quick Start

```bash
# Clone the repository
git clone https://github.com/abd-shan/Angular-compiler-app.git
cd Angular-compiler-app

# Compile and run
javac -cp "lib/antlr-4.13.0-complete.jar:." src/**/*.java
java -cp "lib/antlr-4.13.0-complete.jar:.:src" Main tests/test7.txt

# Check the output
ls output/
```

## 🛠 Installation

### Prerequisites
- **Java 11 or higher** - [Download Java](https://www.oracle.com/java/technologies/downloads/)
- **ANTLR4 runtime** - Included in the project
- **Git** - [Download Git](https://git-scm.com/downloads)

### Option 1: Manual Setup
1. Clone the repository:
```bash
git clone https://github.com/abd-shan/Angular-compiler-app.git
cd Angular-compiler-app
```

2. Compile the project:
```bash
javac -cp "lib/antlr-4.13.0-complete.jar:." src/**/*.java
```

### Option 2: Maven Setup
```bash
# Clone the repository
git clone https://github.com/abd-shan/Angular-compiler-app.git
cd Angular-compiler-app

# Compile with Maven
mvn clean compile

# Run with Maven
mvn exec:java -Dexec.mainClass="Main"
```

## 🎯 Usage

### Basic Usage
```bash
# Compile and run
javac -cp "lib/antlr-4.13.0-complete.jar:." src/**/*.java
java -cp "lib/antlr-4.13.0-complete.jar:.:src" Main
```

### Input Files
Place your Angular source files in the `tests/` directory. The compiler will process:
- Component files (`.ts` with `@Component` decorator)
- Service files (`.ts` with `@Injectable` decorator)
- Route configuration files
- State management files

### Output
Generated files are placed in the `output/` directory:
- `ComponentName.html` - Executable HTML templates
- `ServiceName.js` - JavaScript service implementations

## 📝 Input/Output Examples

### Input: Angular Component
```typescript
@Component({
  selector: 'app-product-list',
  standalone: true,
  styles: [`
    .product-card {
      border: 1px solid #ddd;
      padding: 15px;
      margin: 10px 0;
    }
  `],
  template: `
    <div class="products-grid">
      <div class="product-card" *ngFor="let product of products">
        <h3>{{ product.name }}</h3>
        <p>{{ product.description }}</p>
        <button (click)="viewDetails(product.id)">View Details</button>
      </div>
    </div>
  `
})
export class ProductListComponent {
  products: any[] = [];
  
  viewDetails(productId: number) {
    this.router.navigate(['/product', productId]);
  }
}
```

### Output: Generated HTML
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ProductListComponent Component</title>
  <style>
    .product-card {
      border: 1px solid #ddd;
      padding: 15px;
      margin: 10px 0;
    }
  </style>
</head>
<body>
  <div class="products-grid" id="ngfor-parent-123">
    <!-- Dynamic content generated by JavaScript -->
  </div>
  
  <script src="ProductService.js"></script>
  <script>
    function renderProducts() {
      const products = getProducts();
      const grid = document.getElementById("ngfor-parent-123");
      grid.innerHTML = "";
      products.forEach(product => {
        const card = document.createElement("div");
        card.innerHTML = `
          <h3>${product.name}</h3>
          <p>${product.description}</p>
          <button onclick="viewDetails(${product.id})">View Details</button>
        `;
        grid.appendChild(card);
      });
    }
    
    function viewDetails(productId) {
      window.location.href = "ProductDetailComponent.html?id=" + productId;
    }
    
    renderProducts();
  </script>
</body>
</html>
```

## 🔍 Semantic Error Detection

The compiler performs comprehensive semantic analysis and detects **10+ types of errors**:

### 1. Template Semantic Errors
- **Undefined Methods**: Methods called in templates that don't exist in component class
- **Undefined Identifiers**: Variables used in bindings that aren't declared
- **Invalid ngFor Collections**: Collections referenced in `*ngFor` that don't exist
- **Invalid ngIf Variables**: Variables used in `*ngIf` that aren't defined
- **Method Parameter Errors**: Parameters passed to methods that aren't declared

### 2. TypeScript Semantic Errors
- **Undefined this.member**: Accessing class members that don't exist
- **Type Mismatches**: Incompatible type assignments
- **Scope Violations**: Variables used outside their declared scope

### 3. Import Semantic Errors
- **Duplicate Imports**: Same symbol imported multiple times in same scope
- **Missing Imports**: Symbols used but not imported
- **Invalid Import Paths**: Non-existent module paths

### 4. Route Semantic Errors
- **Undefined Route Components**: Components referenced in routes but not imported
- **Invalid Route Paths**: Malformed route configurations

### Example Error Output
```
======================== SEMANTIC CHECK ========================

Semantic errors: 0_0
- [Component: ProductListComponent] Undefined method 'viewDetails' referenced in template event. (at line 15, column 45)
- [Component: ProductListComponent] Undefined collection 'products' used in *ngFor. (at line 12, column 8)
- [TS Scope: ProductListComponent] Undefined member 'router' accessed via 'this.' Did you mean 'products'? (line 25, col 12)
```

## 🏗 Code Generation

### Professional HTML Generation
- **Modern HTML5**: Semantic markup with proper DOCTYPE and meta tags
- **Responsive Design**: Mobile-first CSS with viewport meta tags
- **Accessibility**: ARIA attributes and semantic HTML elements
- **Performance**: Optimized JavaScript with efficient DOM manipulation

### JavaScript Features
- **ES6+ Syntax**: Modern JavaScript with arrow functions, template literals
- **Local Storage**: Persistent data storage for state management
- **Dynamic Rendering**: Runtime DOM manipulation for `*ngFor` and `*ngIf`
- **Routing**: Client-side navigation with URL parameter handling
- **Event Handling**: Proper event binding and delegation

### Generated Code Quality
- **Clean Code**: Well-formatted, readable output
- **Error Handling**: Graceful error handling and fallbacks
- **Browser Compatibility**: Cross-browser compatible JavaScript
- **Performance Optimized**: Efficient algorithms and minimal DOM queries

## 📁 Project Structure

```
Angular-compiler-app/
├── src/
│   ├── Main.java                    # Entry point
│   ├── visitors/
│   │   └── AngularVisitor.java      # ANTLR visitor implementation
│   ├── semantic/                    # Semantic analyzers
│   │   ├── TemplateSemanticAnalyzer.java
│   │   ├── TypeScriptSemanticAnalyzer.java
│   │   ├── ImportSemanticAnalyzer.java
│   │   └── RouteSemanticChecker.java
│   ├── generator/
│   │   └── HtmlGenerator.java       # Code generation
│   ├── ast/                         # Abstract Syntax Tree nodes
│   │   ├── component/               # Component-related AST nodes
│   │   ├── html/                    # HTML template AST nodes
│   │   ├── ts/                      # TypeScript AST nodes
│   │   ├── state/                   # State management AST nodes
│   │   └── router/                  # Routing AST nodes
│   ├── symbolTable/                 # Symbol table implementation
│   └── helper/                      # Utility classes
├── antlr/                           # ANTLR grammar files
│   ├── AngularLexer.g4
│   └── AngularParser.g4
├── tests/                           # Test input files
├── output/                          # Generated output files
└── lib/
    └── antlr-4.13.0-complete.jar   # ANTLR runtime
```

## 🏛 Architecture

### Compilation Pipeline
1. **Lexical Analysis**: ANTLR4 lexer tokenizes Angular source code
2. **Syntax Analysis**: Parser builds Abstract Syntax Tree (AST)
3. **Semantic Analysis**: Multiple analyzers check for semantic errors
4. **Symbol Table**: Maintains scope and symbol information
5. **Code Generation**: Generates executable HTML/JavaScript

### Key Components

#### AngularVisitor
- Implements ANTLR4 visitor pattern
- Builds comprehensive AST from parsed Angular code
- Manages symbol tables for different scopes
- Handles all Angular syntax constructs

#### Semantic Analyzers
- **TemplateSemanticAnalyzer**: Validates template bindings and directives
- **TypeScriptSemanticAnalyzer**: Checks TypeScript semantics and type safety
- **ImportSemanticAnalyzer**: Validates import statements and dependencies
- **RouteSemanticChecker**: Ensures route configurations are valid

#### HtmlGenerator
- Converts AST to executable HTML/JavaScript
- Handles dynamic content generation
- Implements Angular directive functionality
- Generates modern, responsive web applications

### Symbol Table System
- **Hierarchical Scopes**: Component, method, and block-level scopes
- **Symbol Types**: Variables, methods, classes, interfaces, imports
- **Cross-Reference**: Links between templates and TypeScript code
- **Error Reporting**: Precise error locations with line/column information

## 🧪 Testing

### Test Files
The `tests/` directory contains various test cases:
- `test1.txt` - Basic component with template
- `test2.txt` - Component with ngFor and ngIf directives
- `test3.txt` - Component with event bindings
- `test4.txt` - Component with imports and complex template
- `test7.txt` - Complete Angular application with routing

### Running Tests
```bash
# Test with specific input file
java -cp "lib/antlr-4.13.0-complete.jar:.:src" Main tests/test7.txt
```

## 🚀 Advanced Features

### State Management
- **RxJS Integration**: Support for observables and subjects
- **Injectable Services**: Dependency injection patterns
- **State Interfaces**: Type-safe state definitions
- **Reducers**: State management with reducer patterns

### Routing
- **Route Configuration**: Full Angular Router support
- **Parameter Handling**: Dynamic route parameters
- **Navigation**: Programmatic navigation with `router.navigate()`
- **Route Guards**: Support for route protection patterns

### Forms
- **Template-Driven Forms**: `ngModel` two-way binding
- **Form Validation**: Built-in validation support
- **Form Submission**: Event handling for form submission

## 🔧 Configuration

### Grammar Customization
The ANTLR grammar files can be modified to support additional Angular features:
- `antlr/AngularLexer.g4` - Token definitions
- `antlr/AngularParser.g4` - Grammar rules

### Output Customization
Modify `HtmlGenerator.java` to customize:
- HTML template structure
- JavaScript generation patterns
- CSS styling approaches
- Browser compatibility features

## 🤝 Contributing

### Development Setup
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

### Code Style
- Follow Java naming conventions
- Add comprehensive comments
- Include error handling
- Write unit tests for new features

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Acknowledgments

- **ANTLR4**: Powerful parser generator framework
- **Angular Team**: For the excellent Angular framework
- **Java Community**: For robust tooling and libraries

---

**Built with ❤️ using Java, ANTLR4, and modern web technologies**
