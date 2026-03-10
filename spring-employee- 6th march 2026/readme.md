```markdown
# Spring Core Assignment: Employee Management using Setter Injection (XML)

## Objective
Develop a **Spring Core application** that manages employee details using **Setter Injection** through **XML configuration**.

---

## Requirements

### 1. Create the Following Classes

#### 1.1 Employee Class

Create a class named `Employee` with the following fields:

- `employeeId`
- `employeeName`
- `salary`
- `Department department`

Use **setter methods** to inject the values.

**Example Structure**

```

## Employee

employeeId
employeeName
salary
Department department

```

---

#### 1.2 Department Class

Create a class named `Department` with the following fields:

- `departmentId`
- `departmentName`

Use **setter methods** to assign values.

---

### 2. Configure Beans using XML

Create an XML configuration file named:

```

applicationContext.xml

```

Configure the beans using **Setter Injection**.

Configuration should include:

- `employee` bean  
- `department` bean  
- Reference injection for `employee.department`

*(Students must write the configuration themselves.)*

---

### 3. Main Class

Create a class named:

```

App.java

```

#### Responsibilities

- Load the **Spring container**
- Retrieve the `Employee` bean
- Print employee details

Use:

```

ApplicationContext context

```

---

## Expected Output (Example)

```

Employee ID: 101
Employee Name: John
Salary: 50000
Department ID: 10
Department Name: IT

```

---

## Constraints

Students must use:

- **Spring Core**
- **XML Configuration**
- **Setter Injection**
- **ApplicationContext**
```
