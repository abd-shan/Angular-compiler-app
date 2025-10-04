# Contributing to Angular Compiler Application

Thank you for your interest in contributing to the Angular Compiler Application! This document provides guidelines and information for contributors.

## 🚀 Getting Started


### Prerequisites
- Java 11 or higher
- ANTLR4 runtime
- Git
- Basic understanding of compiler design and Angular framework

### Development Setup

1. **Fork and Clone**
   ```bash
   git clone https://github.com/YOUR_USERNAME/Angular-compiler-app.git
   cd Angular-compiler-app
   ```

2. **Set up Development Environment**
   ```bash
   # Compile the project
   javac -cp "lib/antlr-4.13.0-complete.jar:." src/**/*.java
   
   # Test the compilation
   java -cp "lib/antlr-4.13.0-complete.jar:.:src" Main tests/test1.txt
   ```

3. **Create a Branch**
   ```bash
   git checkout -b feature/your-feature-name
   # or
   git checkout -b fix/issue-description
   ```

## 📋 Contribution Guidelines

### Code Style

- **Java Naming Conventions**: Follow standard Java naming conventions
  - Classes: `PascalCase` (e.g., `AngularVisitor`)
  - Methods: `camelCase` (e.g., `visitComponentFile`)
  - Variables: `camelCase` (e.g., `templateSymbolTable`)
  - Constants: `UPPER_SNAKE_CASE` (e.g., `OUTPUT_DIR`)

- **Comments**: Add comprehensive JavaDoc comments for public methods
  ```java
  /**
   * Visits a component file and builds the corresponding AST node.
   * 
   * @param ctx The component file context from ANTLR parser
   * @return ComponentFile AST node representing the parsed component
   */
  public ComponentFile visitComponentFile(AngularParser.ComponentFileContext ctx) {
      // Implementation
  }
  ```

- **Error Handling**: Always include proper error handling and meaningful error messages

### Commit Message Format

Use conventional commit messages:

```
type(scope): description

[optional body]

[optional footer]
```

**Types:**
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, etc.)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

**Examples:**
```
feat(parser): add support for Angular pipes
fix(semantic): resolve undefined method detection in templates
docs(readme): update installation instructions
test(visitor): add unit tests for component parsing
```

### Pull Request Process

1. **Create a Feature Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. **Make Your Changes**
   - Write clean, well-commented code
   - Add tests for new functionality
   - Update documentation if needed

3. **Test Your Changes**
   ```bash
   # Run existing tests
   java -cp "lib/antlr-4.13.0-complete.jar:.:src" Main tests/test1.txt
   java -cp "lib/antlr-4.13.0-complete.jar:.:src" Main tests/test2.txt
   # ... test all test files
   ```

4. **Commit Your Changes**
   ```bash
   git add .
   git commit -m "feat(parser): add support for new Angular directive"
   ```

5. **Push and Create Pull Request**
   ```bash
   git push origin feature/your-feature-name
   ```

6. **Submit Pull Request**
   - Use the provided PR template
   - Describe your changes clearly
   - Reference any related issues
   - Add screenshots if applicable

## 🧪 Testing

### Test Structure
- Place test files in the `tests/` directory
- Use descriptive names: `test-feature-name.txt`
- Include both positive and negative test cases

### Adding New Tests
1. Create a new test file in `tests/`
2. Include various Angular syntax patterns
3. Test edge cases and error conditions
4. Update the README test section if needed

### Test Categories
- **Syntax Tests**: Valid Angular syntax parsing
- **Semantic Tests**: Error detection and validation
- **Generation Tests**: Output quality and correctness
- **Integration Tests**: End-to-end compilation

## 🐛 Bug Reports

When reporting bugs, please include:

1. **Environment Information**
   - Java version
   - Operating system
   - ANTLR version

2. **Steps to Reproduce**
   - Input file content
   - Command used to run the compiler
   - Expected vs actual output

3. **Error Messages**
   - Complete error output
   - Stack traces (if any)

4. **Additional Context**
   - Screenshots if applicable
   - Related issues or discussions

## 💡 Feature Requests

When suggesting new features:

1. **Check Existing Issues**: Search for similar requests
2. **Describe the Problem**: What problem does this solve?
3. **Propose a Solution**: How should it work?
4. **Consider Alternatives**: Are there other approaches?
5. **Provide Examples**: Show expected input/output

## 📚 Documentation

### Updating Documentation
- Keep README.md up to date with new features
- Add JavaDoc comments for new public methods
- Update architecture diagrams if needed
- Include usage examples for new features

### Documentation Standards
- Use clear, concise language
- Include code examples
- Add screenshots for UI changes
- Keep formatting consistent

## 🏗 Architecture Guidelines

### Adding New AST Nodes
1. Create the AST node class in appropriate package
2. Add visitor method in `AngularVisitor`
3. Update semantic analyzers if needed
4. Add code generation support

### Extending Semantic Analysis
1. Identify the error type
2. Create or extend appropriate analyzer
3. Add error reporting with line/column info
4. Include helpful error messages

### Code Generation
1. Follow existing patterns in `HtmlGenerator`
2. Generate clean, readable output
3. Include proper error handling
4. Maintain browser compatibility

## 🔧 Development Tools

### Recommended IDE Setup
- **IntelliJ IDEA** or **Eclipse** with Java support
- **ANTLR4 Plugin** for grammar development
- **Git integration**

### Useful Commands
```bash
# Generate ANTLR files (if grammar changes)
java -cp lib/antlr_4.13.0_complete.jar org.antlr.v4.Tool antlr/AngularLexer.g4
java -cp lib/antlr_4.13.0_complete.jar org.antlr.v4.Tool antlr/AngularParser.g4

# Run specific test
java -cp "lib/antlr-4.13.0-complete.jar:.:src" Main tests/test-name.txt

# Check for compilation errors
javac -cp "lib/antlr-4.13.0-complete.jar:." src/**/*.java
```

## 📞 Getting Help

- **GitHub Issues**: For bugs and feature requests
- **Discussions**: For questions and general discussion
- **Code Review**: All PRs require review before merging

## 🎯 Areas for Contribution

### High Priority
- [ ] Enhanced error messages with suggestions
- [ ] Support for more Angular directives
- [ ] Performance optimizations
- [ ] Additional test coverage

### Medium Priority
- [ ] CLI interface improvements
- [ ] Configuration file support
- [ ] Plugin architecture
- [ ] Better documentation

### Low Priority
- [ ] IDE integration
- [ ] Build system integration
- [ ] Performance benchmarking
- [ ] Advanced optimizations

## 📄 License

By contributing to this project, you agree that your contributions will be licensed under the MIT License.

## 🙏 Recognition

Contributors will be recognized in:
- README.md contributors section
- Release notes
- Project documentation

Thank you for contributing to the Angular Compiler Application! 🚀
