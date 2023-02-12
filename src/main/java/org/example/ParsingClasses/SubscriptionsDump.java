package org.example.ParsingClasses;

import org.example.Tables.Course;
import org.example.Tables.Student;
import org.example.Tables.Subscription;
import org.example.Tables.SubscriptionKey;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubscriptionsDump {
    public static void doSubscriptions(Session session,  String data) throws ParseException {


        String[] w = data.split(",");
        SubscriptionKey key = new SubscriptionKey(Integer.parseInt(w[0])
                ,Integer.parseInt(w[1]));
        Subscription st = new Subscription(key);

        Student student = new Student();
        st.setStudentid(student);
        //Integer.parseInt(w[0])
        Course course = new Course();
        st.setCourseid(course);
        //Integer.parseInt(w[1])
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(w[2]);
        st.setSubscriptionDate(date);

        session.persist(st);
    }
}
