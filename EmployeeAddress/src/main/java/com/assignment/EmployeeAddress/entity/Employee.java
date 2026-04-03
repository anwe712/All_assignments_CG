package com.assignment.EmployeeAddress.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "gender")
    private String gender;
    @Column(name = "designation")
    private String designation;
    @Column(name = "salary")
    double salary;
    @Column(name = "DOJ")
    private LocalDate dateOfJoining;

    //mapping inside emp
    //one to many with address
    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL)
    private List<Address> addresses ;


}
