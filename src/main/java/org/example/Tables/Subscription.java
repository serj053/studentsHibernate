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
    @JoinColumn(name = "studentid_id", insertable = false, updatable = false)
    private Student studentid;

    @ManyToOne
    @JoinColumn(name = "courseid_id", insertable = false, updatable = false)
    private Course courseid;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Subscription() {
    }

    public Subscription(SubscriptionKey id) {
        this.id = id;
    }

}
