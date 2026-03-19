# 🏨 Hotel Management System

A student project for hotel management with CRUD operations, built with pure Java, Swing and H2 database.

## Technologies

- Java 21
- H2 Database (in-memory)
- Java Swing

## Features

- Room type management
- Room management
- Guest management
- Reservation management
- Search and filtering

## Requirements

- Java JDK 21+

## Getting Started

### 1. Clone the repository
```
git clone <url>
```

### 2. Download the required library and place it in the `lib/` folder

| Library | Download |
|---|---|
| H2 Database | https://repo1.maven.org/maven2/com/h2database/h2/2.2.224/h2-2.2.224.jar |

### 3. Run the project

Open the project in VS Code or IntelliJ and run `App.java`

> The database is created automatically on every startup — no additional configuration needed.

## Project Structure

```
src/
├── resources/
│   └── schema.sql            ← database structure and initial data
├── db/
│   └── DatabaseManager.java  ← database connection
├── dao/                      ← CRUD operations
├── ui/                       ← Swing components
└── App.java
```

## Database Schema

The project uses an H2 in-memory database with 4 tables:

- `room_types` — room categories with pricing
- `rooms` — individual rooms with status
- `guests` — guest information
- `reservations` — booking records

## Team

| Name | Role |
|---|---|
| Христо Балев| Database |
| Жулиян Маринов | Java UI |
| Георги Цанев | Java UI |
