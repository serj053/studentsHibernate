package org.example.ParsingClasses;

import org.example.Tables.Course;
import org.example.Tables.Student;
import org.example.Tables.Subscription;
import org.example.Tables.Teacher;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TeachersDump {
    public static void doTeachers(Session session, Teacher st, String data) throws ParseException {
        String[] w = data.split(",");
        st.setName(w[1]);
        st.setSalary(Integer.parseInt(w[2]));
        st.setAge(Integer.parseInt(w[3]));


        session.persist(st);
    }
}
