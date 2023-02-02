package org.example.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float salary;
    private int age;
    public Teacher(){

    }
    public Teacher(String name, float salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

}
