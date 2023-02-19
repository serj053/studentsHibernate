package org.example.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "subscriptions")
public class Subscription  implements Serializable {

    @EmbeddedId
    protected SubscriptionKey id;

    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private Student studentid;

    @ManyToOne
    @JoinColumn(name = "courseId", insertable = false, updatable = false)
    private Course courseid;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public SubscriptionKey getId() {
        return id;
    }

    public void setId(SubscriptionKey id) {
        this.id = id;
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

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


    public Subscription() {
    }

    public Subscription(SubscriptionKey id) {
        this.id = id;
    }

}
