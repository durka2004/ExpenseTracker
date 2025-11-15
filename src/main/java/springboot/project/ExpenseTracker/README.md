# 📊 Expense Tracker – Spring Boot Backend

A backend system for managing personal expenses with categories, monthly summaries, validation, auditing timestamps, and custom exceptions. Users can create categories, add expenses, filter by category, and view monthly totals.



## 🧰 Tech Stack

* Java 21
* Spring Boot 3
* Spring Data JPA
* PostgreSQL
* Hibernate
* Auditing (@CreatedDate, @LastModifiedDate)
* Lombok
* Maven
* Postman for API Testing



## 🚀 Features

* *✅ Categories :* Add new categories (e.g., Food, Travel, Shopping) Fetch all categories Validations for category name
* *✅ Expenses   :* Create expenses with: title description amount category Fetch expenses by ID Filter expenses by category Monthly summary calculation DTO-based request/response Validation using @Valid
* *✅ System-Level Features :* JPA Auditing (createdAt, updatedAt, active flag) Global Exception Handling Custom Exception (ResourceNotFoundException)



## *Layered architecture:*

* Controller
* Service
* Repository
* Entity
* DTO
* Mapper



## 📦 How to Run

1. Clone the repository:
   bash
   git clone https://github.com/durka2004/ExpenseTracker.git
2. Create a PostgreSQL database: (e.g., `CREATE DATABASE expense\_tracker\_db;`)
3. Copy `application-example.properties` (if exists) to `application.properties` and update DB credentials
4. Start the Application:
   bash
   mvn spring-boot:run

## 🧪 Testing using Postman

Sample request for creating an expense:

      {
         "title" : "Dinner",
         "description": "KFC food",
         "amount" : 550,
         "categoryId" : 1
      }

## 📝 Notes

* No sensitive credentials are uploaded.
* Errors handled through a global exception handler.

#### DTOs include validations using:
* &nbsp;	@NotBlank
* &nbsp;	@NotNull
* &nbsp;	@DecimalMin

#### BaseEntity includes:
* &nbsp;	createdAt
* &nbsp;	updatedAt
* &nbsp;	active flag