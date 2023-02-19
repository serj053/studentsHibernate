package org.example.Tables;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {
    @EmbeddedId
    protected LinkedPurchaseListKey id;
    @Column(name = "student_id", insertable = false, updatable = false)
    private int student_id;
    @Column(name = "course_id", insertable = false, updatable = false)
    private int course_id;

    public LinkedPurchaseList(){}

    public LinkedPurchaseList(LinkedPurchaseListKey id){
        this.id = id;
    }

}
