# Hibernate Assignment

## Question 1: Create Entity Classes

Create the following entity classes using JPA annotations.

### Employee Entity

**Table name:** `employee`

**Fields:**

- `id` (Primary Key, Auto Generated)
- `employeeName`
- `email`
- `gender`
- `password`
- `phone`
- `salary`
- `dateOfBirth`

**Mapping Requirement:**

- Each employee must have **one address**.

---

### Address Entity

**Table name:** `address`

**Fields:**

- `id` (Primary Key, Auto Generated)
- `street`
- `city`
- `state`
- `country`
- `pincode`

**Mapping Requirement:**

- Each address belongs to **one employee**.

---

## Question 2: Implement CRUD Operations

Implement the following operations for **Employee**:

- Insert a new employee along with address.
- Update employee details.
- Delete employee by id.
- Fetch employee by id.
- Fetch all employees.

Implement CRUD operations for **Address**:

- Insert address for an employee.
- Update address details.
- Delete address.
- Fetch address by id.

---

## Question 3: Mapping Operations

Using Hibernate mapping, perform the following:

- Save an employee with address in a **single transaction**.
- Fetch employee with address.
- Update employee **salary** and **address city**.
- Delete employee and check if **address is deleted automatically**.

---

## Question 4: JPQL Queries

Write JPQL queries for the following:

- Fetch employees with salary **greater than 15000**.
- Fetch employees from a **specific city**.
- Fetch employees **born after a given date**.
- Count number of employees **in each city**.

---

## Question 5: Validation

Implement the following validations:

- Email must be **unique**.
- Salary must be **greater than 0**.
- Phone number must contain **exactly 10 digits**.
- Pincode must contain **6 digits**.
