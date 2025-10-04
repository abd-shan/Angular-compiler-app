# Security Policy

## Supported Versions

We actively maintain and provide security updates for the following versions:

| Version | Supported          |
| ------- | ------------------ |
| 1.0.x   | :white_check_mark: |
| < 1.0   | :x:                |

## Reporting a Vulnerability

We take security vulnerabilities seriously. If you discover a security vulnerability in the Angular Compiler Application, please report it to us as described below.

### How to Report

**Please do not report security vulnerabilities through public GitHub issues.**


### What to Include

When reporting a security vulnerability, please include:

1. **Description**: A clear description of the vulnerability
2. **Steps to Reproduce**: Detailed steps to reproduce the issue
3. **Impact**: Potential impact of the vulnerability
4. **Environment**: 
   - Java version
   - Operating system
   - ANTLR version
   - Compiler version/commit hash
5. **Proof of Concept**: If possible, include a minimal example demonstrating the vulnerability
6. **Suggested Fix**: If you have ideas for fixing the issue

### Response Timeline

- **Initial Response**: We will acknowledge receipt of your report within 48 hours
- **Status Updates**: We will provide regular updates on our progress
- **Resolution**: We aim to resolve security issues within 30 days of initial report

### Security Best Practices

When using the Angular Compiler Application:

1. **Keep Dependencies Updated**: Regularly update ANTLR4 and Java runtime
2. **Validate Input**: Always validate Angular source code before compilation
3. **Review Generated Code**: Review generated HTML/JavaScript for security issues
4. **Use Latest Version**: Always use the latest stable version
5. **Secure Environment**: Run the compiler in a secure, isolated environment

### Known Security Considerations

#### Input Validation
- The compiler processes Angular source code as input
- Malicious input could potentially cause issues during parsing
- Always validate input files before processing

#### Generated Code
- Generated HTML/JavaScript code should be reviewed for security
- The compiler generates client-side code that runs in browsers
- Consider Content Security Policy (CSP) for generated applications

#### File System Access
- The compiler reads input files and writes output files
- Ensure proper file permissions and access controls
- Be cautious when processing files from untrusted sources

### Security Features

#### Input Sanitization
- The compiler includes basic input validation
- ANTLR4 provides robust parsing that helps prevent injection attacks
- Symbol table validation helps prevent undefined reference attacks

#### Error Handling
- Comprehensive error handling prevents information disclosure
- Error messages are designed to be helpful without revealing sensitive information
- Stack traces are not exposed in production builds

#### Code Generation
- Generated code follows security best practices
- No eval() or similar dangerous constructs are used
- Output is properly escaped and sanitized

### Reporting False Positives

If you believe a security tool has incorrectly flagged our code, please:

1. **Verify**: Double-check that it's actually a false positive
2. **Document**: Provide details about the tool and the specific warning
3. **Report**: Contact us with the information for review

### Security Updates

Security updates will be released as:
- **Patch versions** for critical security fixes
- **Minor versions** for security improvements
- **Major versions** for breaking security changes

### Responsible Disclosure

We follow responsible disclosure practices:

1. **Report Privately**: Security issues are reported privately first
2. **Investigation**: We investigate and develop fixes
3. **Coordination**: We coordinate with reporters on disclosure timing
4. **Public Disclosure**: Issues are disclosed publicly after fixes are available


### Acknowledgments

We thank security researchers who responsibly disclose vulnerabilities. Contributors who report valid security issues will be acknowledged in our security advisories (with permission).

---
