package org.example;

import org.example.Tables.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GetStudentsTable {
    public static void main(String[] args) throws IOException, ParseException {
        /*получили массив наборов*/
        String[] arr = getLineDump("data/dump.sql", "Students");
        /*для каждого цикла получаем данные и сразу передаем в класс-сущность*/
        for (String str : arr) {
            Student student = new Student();
            buildTable(str, student);
        }
    }
    /*метод принимает путь к файлу с дампом базы данных и имя класса таблицы которая есть в базе(дампе)
     * а возвращает наборы значений для таблицы в виде массива наборов*/
    public static String[] getLineDump(String path, String name) throws IOException {
        List<String> lines;
        lines = Files.readAllLines(Paths.get(path));
        String[] studentDump = null;//массив наборов значений
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.contains("INSERT INTO") && line.contains(name)) {
                line = lines.get(i + 2);
                /*очищаем от внешних скобок*/
                String pureLine = line.substring(line.indexOf("(") + 1, line.indexOf(");"));
                /*разбиваем по наборам (столбцов в классе) и очищаем от промежуточных скобок*/
                studentDump = pureLine.split("\\),\\(");
                /*очистка от обрамляющих кавычек и возврат в массив*/
                for (int j = 0; j < studentDump.length; j++) {
                    String str1;
                    str1 = studentDump[j].replace("'", "");
                    studentDump[j] = str1;
                }
            }
        }
        return studentDump;
    }

    /*метод должен возвращать один набор полей для заполнения одного экземпляра класса
     * планируется передавать в цикл перебора массива с наборами*/
    public static void buildTable(String dataString, Student st) throws ParseException {
        String[] dataS = dataString.split(",");
        for (String str : dataS) {
            // System.out.println(str);
            String id = "";
            String name = "";
            String age = "";
            String regDate = "";
            String[] empty = {id, name, age, regDate};
            for (int g = 0; g < dataS.length; g++) {
                empty[g] = dataS[g];
            }
            id = empty[0];
            name = empty[1];
            age = empty[2];
            regDate = empty[3];
            /* в этом месте вызов методов класса*/
            st.setId(Integer.parseInt(id));
            st.setName(name);
            st.setAge(Integer.parseInt(age));
            st.setRegistrationDate(
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                            .parse(regDate));
            System.out.println("id:" + id + "   name:" + name + "   age:" + age + "   regDate:" + regDate);
        }

    }
}
