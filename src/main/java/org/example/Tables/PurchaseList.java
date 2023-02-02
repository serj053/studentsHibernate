package org.example.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "purchaselist")
public class PurchaseList {
    @EmbeddedId
    private PurchaseLisKey id;
    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;
    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;
    private float price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @ManyToOne
    @JoinColumn(name = "student_name", insertable = false, updatable = false, referencedColumnName = "id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_name", insertable = false, updatable = false, referencedColumnName = "id")
    private Course course;

    public PurchaseList() {

    }

    public PurchaseList(PurchaseLisKey id, String studentName,
                        String courseName, float price, Date subscriptionDate) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.price = price;
        this.subscriptionDate = subscriptionDate;
    }


}
