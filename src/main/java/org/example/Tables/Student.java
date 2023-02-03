package org.example.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@Table(name = "students")
public class Student  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Column(name = "registration_date")
    private Date registrationDate;

    public Student(){

    }
    public Student(String name, int age, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
