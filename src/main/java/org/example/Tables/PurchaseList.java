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
    protected PurchaseListKey id;
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    protected Student studentid;
    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    protected Course courseid;
    protected int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;


    public PurchaseList() {

    }

    public PurchaseList(PurchaseListKey id) {
        this.id = id;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
    }
}
