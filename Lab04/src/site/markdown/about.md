# About This Project

## Project Purpose
Lab 04 is a practical exercise in SE411 (Software Engineering) coursework, focusing on building modern GUI applications using JavaFX and Maven build automation.

## Educational Goals
- Learn JavaFX GUI framework fundamentals
- Understand Maven project structure and build lifecycle
- Practice code organization and package management
- Implement proper project documentation
- Explore Maven site generation and reporting

## Technical Stack

### Language & JVM
- **Java:** Version 20
- **Target Platform:** Java Virtual Machine (JVM)

### Frameworks & Libraries
- **JavaFX:** 20.0.2
  - javafx-controls: GUI components
  - javafx-fxml: XML-based UI markup support

### Build & Project Management
- **Maven:** Build automation and dependency management
- **Plugins:**
  - javafx-maven-plugin: JavaFX application execution
  - maven-javadoc-plugin: API documentation generation
  - maven-surefire-plugin: Unit test execution
  - maven-site-plugin: Website generation

## Architecture

### Package Structure
```
psu.edu.se411
└── MainClass (Application entry point)
```

The project follows a hierarchical package naming convention:
- `psu` - Organization identifier
- `edu` - Educational context
- `se411` - Course identifier

### Main Entry Point
**MainClass** - The primary application class that:
- Extends `javafx.application.Application`
- Implements the `start()` method to configure the primary stage
- Sets up the initial window and scene

## Development Environment
The project is configured for development in:
- Eclipse IDE (used with this project)
- Any IDE that supports Maven and JavaFX (NetBeans, IntelliJ IDEA, VS Code)

## Best Practices Implemented
1. **Project Structure** - Standard Maven directory layout
2. **Dependency Management** - Using Maven for centralized dependency control
3. **Documentation** - Comprehensive README and site documentation
4. **Build Automation** - Maven plugins for compilation, testing, and reporting
5. **Version Control Ready** - Proper .gitignore patterns (should be added)

## Future Enhancements
- Add unit tests with JUnit
- Implement FXML-based UI layouts
- Add CSS styling for modern appearance
- Integrate logging framework (SLF4J/Log4j)
- Add code quality analysis (Spotbugs, Checkstyle)

## Resources
- [JavaFX Documentation](https://openjfx.io)
- [Maven Getting Started Guide](https://maven.apache.org/guides/getting-started/index.html)
- [Penn State University](https://www.psu.edu)

---
**Last Updated:** September 2026
