package org.example.Tables;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@Table(name = "purchaselist")
public class PurchaseList  implements Serializable {
    @EmbeddedId
    protected PurchaseListKey id;

    public PurchaseListKey getId() {
        return id;
    }

    private int price;
    private Date subscription_date;

}
