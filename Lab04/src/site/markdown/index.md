# Welcome to SE411 Lab 04

## Modern JavaFX Application with Professional Documentation

This is a comprehensive JavaFX application project developed for SE411 coursework at Penn State University. The project demonstrates modern development practices including professional site documentation, responsive design, and clean code organization.

## 🎨 Modern Design Features

The website features a contemporary design with:

- **Professional Styling** - Modern CSS with gradient backgrounds and smooth animations
- **Responsive Layout** - Works seamlessly on desktop, tablet, and mobile devices  
- **Fluido Skin** - Apache Maven's modern professional skin
- **Custom Theme** - Blue color scheme with accent colors for consistency
- **Smooth Interactions** - Animated buttons, hover effects, and transitions
- **Clean Typography** - Professional typography with optimized readability

## 📚 Site Structure

### Overview
- **Introduction** - Project overview and quick start guide
- **About** - Detailed project information and architecture

### Documentation  
- **JavaDoc** - Complete API documentation for all classes
- **Source Code** - Link to source repository and code

### Project Information
- **Project Summary** - Key project metadata and details
- **Team** - Developer information and contact details
- **Dependencies** - Complete list of project dependencies
- **Dependency Tree** - Hierarchical view of all dependencies
- **Plugins** - Build and site generation plugins used
- **Licenses** - License information and legal details

### Reports
- **Surefire Report** - Test execution results and coverage

## 🚀 Quick Start

### Build the Project
```bash
mvn clean compile
```

### Run the Application
```bash
mvn javafx:run
```

### Generate the Modern Site
```bash
mvn clean site
```

View the generated site at: `target/site/index.html`

## 🛠 Technology Stack

| Component | Version |
|-----------|---------|
| Java | 20 |
| JavaFX | 20.0.2 |
| Maven | 3.6+ |
| Maven Fluido Skin | 1.11.1 |

## 💻 Project Structure

```
lab04p/
├── src/
│   ├── main/java/psu/edu/se411/
│   │   └── MainClass.java
│   ├── site/
│   │   ├── site.xml (site configuration)
│   │   ├── site-decoration.xml
│   │   ├── markdown/
│   │   │   └── about.md (project details)
│   │   └── resources/
│   │       └── css/
│   │           └── custom-style.css (modern styling)
│   └── test/
├── pom.xml (Maven configuration)
├── README.md (project readme)
└── target/site/ (generated documentation)
```

## 🎯 Key Features

### Modern CSS Styling
- Custom color scheme with CSS variables
- Gradient backgrounds and shadow effects
- Smooth animations and transitions
- Fluido skin integration

### Responsive Design
- Mobile-first approach
- Flexible layouts using CSS Grid/Flexbox
- Touch-friendly interactive elements
- Optimized typography for all screen sizes

### Professional Documentation
- Comprehensive README
- Detailed project information
- Team and license pages
- API documentation (JavaDoc)

## 📖 Site CSS Features

The custom stylesheet (`custom-style.css`) provides:

- **Color Scheme**: Professional blue with cyan accents
- **Typography**: Modern sans-serif with optimized line heights
- **Interactive Elements**: Buttons with ripple effects
- **Tables**: Styled with gradients and hover states
- **Navigation**: Sidebar menu with smooth transitions
- **Footer**: Dark footer with company information
- **Code Blocks**: Syntax-friendly styling
- **Animations**: Fade-in, slide-down, and pulse effects

## 🔧 Customization

To customize the site theme:

1. Edit `/src/site/resources/css/custom-style.css`
2. Modify CSS variables in the `:root` selector:
   ```css
   :root {
     --primary-color: #0066cc;    /* Change primary color */
     --primary-dark: #004999;     /* Change dark accent */
     --secondary-color: #00b4d8;  /* Change secondary color */
   }
   ```
3. Regenerate the site: `mvn clean site`

## 📱 Browser Support

- Chrome/Chromium (latest)
- Firefox (latest)
- Safari (latest)
- Edge (latest)
- Mobile browsers (iOS Safari, Chrome Mobile)

## 👨‍💻 Developer

**Layal Alsultan**
- Email: layal.alsultan@domain.com

## 📜 License

This project is licensed under the **Apache License 2.0**.
See the [License page](license.html) for full details.

---

**Organization:** SE411-Tech-Company  
**Last Updated:** September 2026

For more information, visit the [PSU website](https://www.psu.edu)
