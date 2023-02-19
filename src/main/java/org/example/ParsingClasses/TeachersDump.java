package org.example.ParsingClasses;

import org.example.Tables.Teacher;
import org.hibernate.Session;

import java.text.ParseException;

public class TeachersDump {
    public static void doTeachers(Session session, Teacher st, String data)  {
        String[] w = data.split(",");
        st.setName(w[1]);
        st.setSalary(Integer.parseInt(w[2]));
        st.setAge(Integer.parseInt(w[3]));
        session.persist(st);
    }
}
