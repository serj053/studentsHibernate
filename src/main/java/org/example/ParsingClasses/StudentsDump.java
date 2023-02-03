package org.example.ParsingClasses;

import org.example.Tables.Student;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentsDump {
    public static void doStudents(Session session, Student st, String data) throws ParseException {
        String[] w = data.split(",");
        st.setName(w[1]);
        st.setAge(Integer.parseInt(w[2]));
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(w[3]);
        st.setRegistrationDate(date);
        session.persist(st);
    }
}
