package main;

import com.assignment.daoo.StudentDAO;
import com.assignment.dao.impl.StudentDAOImpl;
import com.assignment.model.Student;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();

        Student s1 = new Student("Anu", "anu@mail.com", 90);
        dao.addStudent(s1);

        Student student = dao.getStudentById(1);
        System.out.println(student.getName());

        List<Student> list = dao.getAllStudents();

        for(Student s : list){
            System.out.println(s.getId()+" "+s.getName()+" "+s.getMarks());
        }

        student.setMarks(95);
        dao.updateStudent(student);

        dao.deleteStudent(3);
    }
}