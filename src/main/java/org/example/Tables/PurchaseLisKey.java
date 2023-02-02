package org.example.Tables;

import jakarta.persistence.Column;

import java.io.Serializable;

public class PurchaseLisKey implements Serializable {
    @Column(name = "student_name")
    private int studentName;
    @Column(name = "course_name")
    private int courseName;
}
