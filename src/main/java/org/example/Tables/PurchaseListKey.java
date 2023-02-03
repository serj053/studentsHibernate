package org.example.Tables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class PurchaseListKey implements Serializable {
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "course_name")
    private String courseName;
}
