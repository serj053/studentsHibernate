package org.example.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscriptionKey id;
    @Column(name = "student_id", insertable = false, updatable = false)
    private int student_id;
    @Column(name = "course_id", insertable = false, updatable = false)
    private int course_id;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Subscription() {
    }

    public Subscription(SubscriptionKey id, int student_id, int course_id, Date subscriptionDate) {
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.subscriptionDate = subscriptionDate;
    }
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Course course;

}
