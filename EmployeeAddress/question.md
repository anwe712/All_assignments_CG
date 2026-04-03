# Spring Boot Assignment

## One-to-One Mapping

---

## Section 1: Entity Design

Create two entities:

- Employee
- Address

### Employee Fields:

- id (Primary Key)
- name
- email
- phone
- gender
- designation
- salary
- dateOfJoining

### Address Fields:

- id (Primary Key)
- street
- city
- state
- country
- pincode

---

## Section 2: Relationship Mapping

Establish a **One-to-One relationship** between Employee and Address.

### Requirements:

- Each Employee must have exactly one Address
- Properly configure the mapping using JPA annotations

---

## Section 3: Validation

Apply the following validation rules:

- **name** → must not be blank
- **email** → must be in a valid format
- **phone** → must contain exactly 10 digits
- **salary** → must be greater than 0
- **pincode** → must contain exactly 6 digits

---

## Section 4: Repository Layer

Create repository interfaces for:

- Employee
- Address

---

## Section 5: Service Layer

Implement the following service methods:

- Save an Employee along with Address
- Retrieve all Employees with their Address
- Retrieve an Employee by ID
- Update Employee and Address details
- Delete an Employee

---

## Section 6: Controller (REST APIs)

Develop RESTful APIs for the following operations:

- **POST** → Create Employee with Address
- **GET** → Retrieve all Employees
- **GET** → Retrieve Employee by ID
- **PUT** → Update Employee and Address
- **DELETE** → Delete Employee

---

## Section 7: Exception Handling

Create a custom exception:

- EmployeeNotFoundException

### Handle the following scenarios:

- Employee not found
- Validation errors

Implement global exception handling for consistent error responses.

---

## Section 8: Testing

- Test all APIs using Postman
- Ensure all endpoints work correctly with proper request and response handling

---

## Core Dependencies (Must-Have)

These are non-negotiable for your assignment:

- **Spring Web**→ For building REST APIs (Controller layer)
- **Spring Data JPA**→ Handles database operations and ORM (Entities & Repositories)
- **Hibernate Validator**→ For validation rules (@NotBlank, @Email, etc.)
- **MySQL Driver** *(or H2 for easier setup)*
  → Connects application to the database

---
