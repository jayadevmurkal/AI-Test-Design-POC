# Framework Generator V3 Architecture

## Overview

Framework Generator V3 automatically generates a complete Selenium
automation framework using Java, Maven, TestNG, Page Object Model,
Extent Reports, logging utilities, and configuration management.

---

## High-Level Architecture

```text
FrameworkGeneratorApplication
            │
            ▼
FrameworkGeneratorV3
            │
            ▼
Individual Generators
            │
            ▼
FrameworkProject
            │
            ▼
FrameworkWriterV3
            │
            ▼
Generated Maven Framework
```

---

## Core Components

| Component | Responsibility |
|------------|----------------|
| FrameworkGeneratorApplication | Entry point |
| FrameworkGeneratorV3 | Controls framework generation |
| FrameworkProject | Stores generated files |
| FrameworkWriterV3 | Writes generated files |
| BasePageGeneratorV3 | Generates BasePage.java |
| BaseTestGeneratorV3 | Generates BaseTest.java |
| ConfigGeneratorV3 | Generates configuration files |
| PageGeneratorV3 | Generates page classes |
| TestGeneratorV3 | Generates test classes |
| PomGeneratorV3 | Generates pom.xml |
| TestNGGeneratorV3 | Generates testng.xml |

---

## Generated Project Structure

```text
generated-output
│
├── pom.xml
├── README.md
├── testng.xml
│
└── src
    ├── main
    │   ├── java
    │   │   ├── config
    │   │   ├── framework
    │   │   └── pages
    │   │
    │   └── resources
    │
    └── test
        └── java
            └── tests
```

---

## Execution Flow

```text
mvn clean compile
        │
        ▼
Run FrameworkGeneratorApplication
        │
        ▼
Generate framework
        │
        ▼
mvn clean test
        │
        ▼
BUILD SUCCESS
```