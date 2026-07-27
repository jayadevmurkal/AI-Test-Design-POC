# AI Test Design Framework Generator V2.0

## 🚀 Overview

AI Test Design Framework Generator V2.0 is an AI-powered Selenium framework generator that automatically converts structured AI-generated test designs into a complete Selenium automation framework following the Page Object Model (POM) architecture.

The generated framework is production-ready and includes all essential components required to execute Selenium automation with minimal manual effort.

## 🎯 Objectives

- Reduce Selenium framework development time
- Convert AI-generated test cases into executable automation
- Standardize automation framework structure
- Improve maintainability using modular generators
- Accelerate QA Automation implementation

## 🛠 Technology Stack

- Java 17
- Selenium 4
- TestNG
- Maven
- Jackson
- WebDriverManager
- Extent Reports

## 📂 Generated Project Structure

```
generated-output/
│
├── README.md
├── pom.xml
├── testng.xml
├── .gitignore
│
├── reports/
├── logs/
│
└── src/
    ├── main/
    │   ├── java/
    │   │   ├── framework/
    │   │   ├── pages/
    │   │   ├── config/
    │   │   └── utils/
    │   └── resources/
    │
    └── test/
        └── java/
            └── tests/
```

## ✨ Features

- AI Generated Selenium Test Classes
- Page Object Model (POM)
- Base Framework
- Driver Factory
- Base Page
- Base Test
- Config Reader
- Framework Version Generator
- Wait Utility
- Screenshot Utility
- Logger Utility
- Extent Report Integration
- Maven Ready
- TestNG Ready
- Automatic Project Structure Generation
- Modular Generator Architecture

## Framework Flow

```
AI JSON
   │
   |
AIResponseReaderV2
   │
   |
GeneratedTestSuite Model
   │
   |
Generator Classes
   │
   |
Generated Selenium Framework
   │
   |
Execute TestNG Tests
   │
   |
Extent HTML Report
```

## ▶ Execute Generated Framework

```
mvn clean test
```

## 📊 Reports

After execution the report will be available at:

```
reports/ExtentReport.html
```

Screenshots (if captured):

```
reports/screenshots/
```

## 📦 Framework Version

- Version : 2.0
- Status  : Stable
- Architecture : Page Object Model (POM)
- Framework Type : AI Generated Selenium Automation Framework

## 🔮 Future Roadmap (V2.1)

- Dynamic Multi-Page Generation
- API Automation Generation
- Data Driven Framework
- Parallel Execution
- Playwright Framework Generation
- Jenkins Pipeline Generator
- GitHub Actions Integration
- Docker Support
- AI Locator Healing

## Author

Jayadev M.M

Senior QA Engineer
Manual Testing | Selenium | Java | TestNG | AI Framework Development
