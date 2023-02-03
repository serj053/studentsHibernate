package org.example.ParsingClasses;

import org.example.Tables.Course;
import org.example.Tables.PurchaseList;
import org.example.Tables.Student;
import org.example.Tables.Subscription;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubscriptionsDump {
    public static void doSubscriptions(Session session, Subscription st, String data) throws ParseException {
        String[] w = data.split(",");
        Student student = new Student();
        st.setStudent(student);
        Course course = new Course();
        st.setCourse(course);
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(w[2]);
        st.setSubscriptionDate(date);

        session.persist(st);
    }
}
