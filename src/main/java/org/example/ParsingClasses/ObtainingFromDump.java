package org.example.ParsingClasses;

import org.example.Tables.Course;
import org.example.Tables.Student;
import org.example.Tables.Teacher;
import org.hibernate.Session;

import java.io.IOException;
import java.text.ParseException;

public class ObtainingFromDump {
    public void getDump(Session session) throws IOException, ParseException {
        String[] listStudent = ReadDump.getLineDump("data/dump.sql", "Students");
        for (String str : listStudent) {
            Student st = new Student();
            StudentsDump.doStudents(session, st, str);
        }

        String[] listSubscriptions = ReadDump.getLineDump("data/dump.sql", "Subscription");
        for (String str : listSubscriptions) {
            SubscriptionsDump.doSubscriptions(session, str);
        }

        String[] listTeachers = ReadDump.getLineDump("data/dump.sql", "Teachers");
        for (String str : listTeachers) {
            Teacher st = new Teacher();
            TeachersDump.doTeachers(session, st, str);
        }
        int n = 0;
        String[] listCourses = ReadDump.getLineDump("data/dump.sql", "Courses");
        for (String str : listCourses) {
            Course st = new Course();
            CoursesDump.doCourse(session, st, str);
        }
    }
}
