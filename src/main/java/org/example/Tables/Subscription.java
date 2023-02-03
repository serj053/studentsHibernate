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
    private SubscriptionKey id;
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Subscription() {
    }

    public Subscription(SubscriptionKey id, int student_id, int course_id, Date subscriptionDate) {
        this.id = id;
        this.studentId = student_id;
        this.courseId = course_id;
        this.subscriptionDate = subscriptionDate;
    }
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Course course;

}
