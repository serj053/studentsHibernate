package org.example.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    private String name;
    private int duration;

    //@Column(name="enum" )
    @Column(name = "type" , columnDefinition="ENUM('DESIGN',\n" +
            "    'PROGRAMMING',\n" +
            "    'MARKETING',\n" +
            "    'MANAGEMENT',\n" +
            "    'BUSINESS')" ,nullable = false )
    @Enumerated(EnumType.STRING)
    private CourseType type;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
    @Column(name = "students_count")
    private int studentsCount;
    private int price;
    @Column(name = "price_per_hour")
    private float pricePerHour;

    public Course(){}

    public Course(String name, int duration, CourseType type, String description, Teacher teacher, int studentsCount, int price, float pricePerHour) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.type = type;
        this.description = description;
        this.teacher = teacher;
        this.studentsCount = studentsCount;
        this.price = price;
        this.pricePerHour = pricePerHour;
    }
}

