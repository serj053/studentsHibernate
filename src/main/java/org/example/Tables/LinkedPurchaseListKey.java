package org.example.Tables;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinkedPurchaseListKey implements Serializable {
    private int student_id;
    private int course_id;

    protected LinkedPurchaseListKey(){}
    public LinkedPurchaseListKey(int student_id, int course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedPurchaseListKey that)) return false;
        return student_id == that.student_id && course_id == that.course_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, course_id);
    }
}
