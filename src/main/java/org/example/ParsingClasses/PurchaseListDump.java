package org.example.ParsingClasses;

import org.example.Tables.PurchaseList;
import org.example.Tables.Student;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PurchaseListDump {
    public static void doPurchaseList(Session session, PurchaseList st, String data) throws ParseException {
        String[] w = data.split(",");
        Student student = new Student();
        st.setStudent(student);
        st.setCourseName(w[1]);
        st.setPrice(Integer.parseInt(w[2]));
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(w[3]);
        st.setSubscriptionDate(date);

        session.persist(st);
    }
}











//(course_name, student_name, price, subscription_date)