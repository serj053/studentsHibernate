package org.example.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int duration;

    @Column(name = "type", columnDefinition = """
            ENUM('DESIGN',
                'PROGRAMMING',
                'MARKETING',
                'MANAGEMENT',
                'BUSINESS')""", nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseType type;
    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "students_count")
    private int studentsCount;
    private int price;
    @Column(name = "price_per_hour")
    private float pricePerHour;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "Subscriptions",
//            joinColumns = {@JoinColumn(name = "course_id")},
//            inverseJoinColumns = {@JoinColumn(name = "student_id")})
//    List<Student> students;

    public Course() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}

