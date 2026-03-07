# JDBC Assignment

## Objective

This assignment focuses on implementing **JDBC operations using the DAO (Data Access Object) pattern** in Java. Students will create a simple Student Management system that interacts with a PostgreSQL database.

---

# Database Table

Create the following table in PostgreSQL:

```sql
CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    marks INT
);
```

---

# 1. Model Class – `Student.java`

Package: `com.assignment.model`

```java
package com.assignment.model;

public class Student {

    private int id;
    private String name;
    private String email;
    private int marks;

    public Student() {}

    public Student(String name, String email, int marks) {
        this.name = name;
        this.email = email;
        this.marks = marks;
    }

    public Student(int id, String name, String email, int marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.marks = marks;
    }

    // Getters and Setters
}
```

---

# 2. DB Utility Class – `DBUtil.java`

Package: `com.assignment.util`

```java
package com.assignment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL =
        "jdbc:postgresql://localhost:5432/testdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

---

# 3. DAO Layer – `StudentDAO.java`

Students must implement the following interface.

Package: `com.assignment.dao`

```java
package com.assignment.dao;

import com.assignment.model.Student;
import java.util.List;

public interface StudentDAO {

    void addStudent(Student student);

    Student getStudentById(int id);

    List<Student> getAllStudents();

    void updateStudent(Student student);

    void deleteStudent(int id);
}
```

---

# 4. DAO Implementation (Important Task)

Students must create an implementation class for `StudentDAO`.

Requirements:

* Use **PreparedStatement** for executing SQL queries.
* Handle  **SQL exceptions properly** .
* Close database resources using  **try-with-resources** .
* Implement all CRUD operations.

Example method for adding a student:

```java
public void addStudent(Student student) {

    String sql = "INSERT INTO student(name, email, marks) VALUES (?, ?, ?)";

    try (Connection con = DBUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setInt(3, student.getMarks());

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```

---

# Task

Create an **implementation class** that implements `StudentDAO` and provide the implementation for the following methods:

* `addStudent(Student student)`
* `getStudentById(int id)`
* `getAllStudents()`
* `updateStudent(Student student)`
* `deleteStudent(int id)`

The implementation must follow proper  **JDBC practices and resource management** .
