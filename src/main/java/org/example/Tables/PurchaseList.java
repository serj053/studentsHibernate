package org.example.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "purchaselist")
public class PurchaseList  implements Serializable {
    @EmbeddedId
    private PurchaseListKey id;
    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;
    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;
    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @ManyToOne(cascade = {CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name = "student_name", insertable = false, updatable = false, referencedColumnName = "id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_name", insertable = false, updatable = false, referencedColumnName = "id")
    private Course course;

    public PurchaseList() {

    }

    public PurchaseList(PurchaseListKey id, String studentName,
                        String courseName, int price, Date subscriptionDate) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.price = price;
        this.subscriptionDate = subscriptionDate;
    }


}
