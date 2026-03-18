# 📘 Employee Management System using Hibernate (JPA)

## 🎯 Objective

Develop a Java-based backend application using **Hibernate (JPA)** to manage:

- Employees
- Salary Records
- Performance Reviews

> ⚠️ Proper transaction management is mandatory.

---

# 🧩 Question 1: Employee Management

## 📌 Entity: `Employee`

Map to table **`employee`**

### Fields:

- `id` (Primary Key, Auto-generated)
- `employeeCode` (Unique)
- `name`
- `email`
- `designation`
- `department`
- `joiningDate`
- `active` (boolean)

---

## ⚙️ Operations to Implement:

- ➕ Insert a new employee
- ✏️ Update employee details using `employeeCode`
- ❌ Soft delete employee (set `active = false`)
- 🔍 Fetch employee by:
  - `id`
  - `employeeCode`
- 📋 Fetch all **active employees** using JPQL

---

# 💰 Question 2: Salary Record Management

## 📌 Entity: `SalaryRecord`

Map to table **`salary_record`**

### Fields:

- `id` (Primary Key)
- `employeeCode`
- `baseSalary`
- `bonus`
- `tax`
- `netSalary`
- `salaryMonth` *(Format: YYYY-MM)*

---

## ⚙️ Operations to Implement:

- ➕ Insert salary record
- 🧮 Automatically calculate:
- 

- ✏️ Update salary record
- ❌ Delete salary record
- 🔍 Fetch salary record by:
- `employeeCode`
- `salaryMonth`
- 📋 Fetch all salary records for a given employee

---

## ⚠️ Important Constraint:

> ❌ Do NOT use foreign key mapping
> ✔️ `employeeCode` must be treated as a normal column

---

# ⭐ Question 3: Performance Review Management

## 📌 Entity: `PerformanceReview`

Map to table **`performance_review`**

### Fields:

- `id` (Primary Key)
- `employeeCode`
- `rating` *(1–5)*
- `reviewDate`
- `comments`

---

## ⚙️ Operations to Implement:

- ➕ Insert performance review
- ✏️ Update review
- ❌ Delete review
- 📋 Fetch all reviews of a given employee

---

# ⚡ Additional Requirements

- ✔️ Use **Hibernate (JPA)**
- ✔️ Use **JPQL for queries**
- ✔️ Implement **proper transaction management**
- ✔️ Follow clean project structure (Entity → DAO → Main)
