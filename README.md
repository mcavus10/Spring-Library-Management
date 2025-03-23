# 📚 Library Management System - Backend (Java + Spring Boot)

This is a simple and educational **Library Management System** backend built using **Java 17**, **Spring Boot**, and **PostgreSQL**. It allows users to manage books, users, and their loan activities (borrowing/returning books).

---

## 🚀 Features

- Manage Users (`CRUD`)
- Manage Books (`CRUD`)
- Manage Book Loans (`CRUD`)
- Layered architecture: Controller, Service, Repository
- DTOs for secure and clean data transfer
- Global Exception Handling
- PostgreSQL Integration
- Validation with `@Valid`
- Lombok-powered boilerplate reduction

---

## 📦 Tech Stack

- Java 17
- Spring Boot (3.4.3)
- Spring Data JPA
- Spring Web
- PostgreSQL
- Maven
- Lombok

---

## 📁 Project Structure

src/ └── main/ ├── java/com.example.mami1/ │ ├── controller/ │ ├── service/ │ ├── repository/ │ ├── model/ │ ├── dto/ │ └── exception/ └── resources/ └── application.properties.example

yaml
Copy
Edit

---

## 🛠️ Getting Started

### ✅ Prerequisites

- Java 17
- Maven
- PostgreSQL

---

### ⚙️ Setup Instructions

1. **Clone the repository**

```bash
git clone https://github.com/yourusername/library-backend.git
cd library-backend
Copy the configuration file

bash
Copy
Edit
cp src/main/resources/application.properties.example src/main/resources/application.properties
Configure your database credentials

Edit src/main/resources/application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
Create the PostgreSQL database

sql
Copy
Edit
CREATE DATABASE library_db;
Build and run the application

bash
Copy
Edit
mvn clean install
mvn spring-boot:run
The app will start on:
📍 http://localhost:8080

🎯 Example Endpoints
📘 Books
GET /api/books

POST /api/books

PUT /api/books/{id}

DELETE /api/books/{id}

👤 Users
GET /api/users

POST /api/users

PUT /api/users/{id}

DELETE /api/users/{id}

🔁 Loans
GET /api/loans

POST /api/loans

PUT /api/loans/{id}

DELETE /api/loans/{id}

🔒 Notes
Default Spring Security login page may show up. For now, Spring Security is included but not configured (can be disabled if needed).

application.properties is ignored in .gitignore for security reasons.

🧪 API Testing
A Postman collection is available for API testing.
You can import it into Postman and test all endpoints.

✅ Tested scenarios include:

Creating users, books, and loans

Updating loan return status

Error handling for invalid input

✅ TODO / Improvements
Add user authentication (Spring Security / JWT)

Pagination & Sorting

Docker support for easy deployment

Unit tests and integration tests

