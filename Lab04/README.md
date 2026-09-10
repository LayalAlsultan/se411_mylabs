# Lab 04 - SE411 JavaFX Application

## Overview
This is a JavaFX application developed for SE411 coursework at Penn State University. The project demonstrates building a modern GUI application using Java 20 and JavaFX with Maven build automation.

## Project Details
- **Version:** 0.0.1-SNAPSHOT
- **Java Target:** Java 20
- **Build Tool:** Maven 3.6+
- **GUI Framework:** JavaFX 20.0.2

## Features
- Modern JavaFX GUI application
- Maven build system with site generation
- Comprehensive project documentation
- Team and license information

## Prerequisites
- Java Development Kit (JDK) 20 or later
- Maven 3.6.0 or later

## Building the Project

### Compile the Project
```bash
mvn clean compile
```

### Run the Application
```bash
mvn javafx:run
```

### Generate Site Documentation
```bash
mvn clean site
mvn site:stage
```

### Build JAR Package
```bash
mvn clean package
```

## Project Structure
```
lab04p/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── psu/edu/se411/
│   │   │       └── MainClass.java
│   │   └── resources/
│   ├── test/
│   │   ├── java/
│   │   └── resources/
│   └── site/
│       └── site.xml (site configuration)
├── pom.xml (Maven configuration)
└── target/
    ├── classes/
    └── site/ (generated documentation)
```

## Main Components

### MainClass
The entry point of the application. Extends `javafx.application.Application` and sets up the primary stage with a basic JavaFX window.

**Location:** `src/main/java/psu/edu/se411/MainClass.java`

## Dependencies
- **javafx-controls** (20.0.2) - JavaFX GUI controls
- **javafx-fxml** (20.0.2) - FXML markup language support

## Site Documentation
The project includes comprehensive Maven site documentation with:
- API documentation (JavaDoc)
- Project information and team details
- Dependency management
- Build plugin information
- License information
- Test reports (when tests are available)

Access the generated site after running `mvn clean site` at:
`target/site/index.html`

## Build Plugins
- **javafx-maven-plugin** - Enables running JavaFX applications with Maven
- **maven-javadoc-plugin** - Generates API documentation
- **maven-surefire-report-plugin** - Generates test reports
- **maven-site-plugin** - Generates project website
- **maven-project-info-reports-plugin** - Generates project information reports

## Organization
**Organization Name:** SE411-Tech-Company

## Developer
- **Name:** Layal Alsultan
- **Email:** layal.alsultan@domain.com

## License
This project is licensed under the Apache License 2.0. See LICENSE file or [https://www.apache.org/licenses/LICENSE-2.0](https://www.apache.org/licenses/LICENSE-2.0) for details.

## Next Steps
1. Add more JavaFX components and scenes to MainClass
2. Create additional classes in the `psu.edu.se411` package
3. Add unit tests to `src/test/java/`
4. Add JavaDoc comments to improve API documentation
5. Customize site theme with CSS in `src/site/resources/`

---
For more information about JavaFX, visit [openjfx.io](https://openjfx.io)
For Maven documentation, visit [maven.apache.org](https://maven.apache.org)
