# Mobile Repairing System

A desktop-based Java application designed for **mobile repair shopkeepers** to manage customer data, track repair orders, and generate bills efficiently.

## 📋 Features

- Customer and device repair record management
- Bill generation and printing
- MySQL database integration
- Easy database creation with `CreateDatabase.java`
- Simple, intuitive interface

## 🖥️ System Requirements

- **Operating System**: Windows/Linux/macOS
- **Java Version**: Java SE 11 or higher
- **Database**: MySQL Server 5.7 or above
- **JDBC Driver**: MySQL Connector/J
- **Build Tool (optional)**: Maven or any Java IDE (e.g., IntelliJ, Eclipse, NetBeans)

## 🗃️ Database Details

- **Database Name**: `mshop_db`
- **Tables**:
  - `repairs` – stores repair records (device info, issue, cost, status)

You can generate the database structure by running the Java file:

```bash
javac CreateDatabase.java
java CreateDatabase.java
```

You can run the main project by running the Java file:

```bash
javac mshop.java
java mshop.java
