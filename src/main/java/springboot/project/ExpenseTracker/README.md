📊 Expense Tracker – Spring Boot + PostgreSQL

A simple and efficient Expense Tracking REST API built with Spring Boot, Spring Data JPA, and PostgreSQL.
This project allows users to create categories, add expenses, fetch expense summaries, and track spending with clean API design, proper validations, and JPA auditing.

🚀 Features

Add custom Categories

Add Expenses linked to categories

Validate inputs using Jakarta Validation

Get expense details by ID

Fetch expenses by Category

Monthly expense summary (Auto-calculation)

Global exception handling

Auto timestamps using JPA Auditing

Uses DTOs and Mapper for clean architecture

🛠 Tech Stack

Java 17+

Spring Boot 3.x

Spring Web

Spring Data JPA + Hibernate

PostgreSQL

Lombok

Jakarta Validation

📂 Project Structure
src/main/java/com/example/expensetracker
│
├── config
│   └── JpaAuditingConfig.java
│
├── controller
│   ├── ExpenseController.java
│   └── CategoryController.java
│
├── dto
│   ├── ExpenseRequestDto.java
│   ├── ExpenseResponseDto.java
│   └── CategoryDto.java
│
├── entity
│   ├── BaseEntity.java
│   ├── Expense.java
│   └── Category.java
│
├── exception
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
│
├── mapper
│   └── ExpenseMapper.java
│
├── repository
│   ├── ExpenseRepository.java
│   └── CategoryRepository.java
│
└── service
├── ExpenseService.java
├── ExpenseServiceImpl.java
└── CategoryService.java

⚙️ Setup Instructions
1️⃣ Clone the project
git clone https://github.com/durka-2004/expense-tracker.git
cd expense-tracker

2️⃣ Configure PostgreSQL in application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/expensetracker
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3️⃣ Run the application
mvn spring-boot:run


Server starts at:

http://localhost:8080

🧾 API Endpoints
Category APIs
Method	Endpoint	Description
POST	/categories	Create a new category
GET	/categories	Fetch all categories
Expense APIs
Method	Endpoint	Description
POST	/expenses	Create an expense
GET	/expenses/{id}	Get expense by ID
GET	/expenses/category/{id}	Get expenses by category
GET	/expenses/summary?year=2025&month=2	Monthly summary
🔗 Sample API Calls
➕ Create Category
{
"name": "Food"
}

➕ Create Expense
{
"title": "Dinner at KFC",
"description": "Food with friends",
"amount": 350.50,
"categoryId": 1
}

📅 Monthly Summary
GET /expenses/summary?year=2025&month=2

🧪 Validation & Error Handling

Missing fields → 400 BAD REQUEST

Invalid category/expense → 404 NOT FOUND

All validation errors returned in field → message format

Example:

{
"title": "Title is required",
"amount": "Amount must be positive"
}

📦 JPA Auditing

Every entity includes:

createdAt

updatedAt

active (default true)

Enabled via:

@EnableJpaAuditing

🤝 Contributing

Feel free to fork this project and submit pull requests!