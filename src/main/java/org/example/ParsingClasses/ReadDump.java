package org.example.ParsingClasses;

import org.example.Tables.Student;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadDump {
    public static String[] getLineDump(String path, String name) throws IOException {
        List<String> lines;
        lines = Files.readAllLines(Paths.get(path));
        String[] dump = null;//массив наборов значений
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.contains("INSERT INTO") && line.contains(name)) {
                line = lines.get(i + 2);
                /*очищаем от внешних скобок*/
                String pureLine = line.substring(line.indexOf("(") + 1, line.indexOf(");"));
                /*разбиваем по наборам (столбцов в классе) и очищаем от промежуточных скобок*/
                dump = pureLine.split("\\),\\(");
                /*очистка от обрамляющих кавычек и возврат в массив*/
                for (int j = 0; j < dump.length; j++) {
                    String str1;
                    str1 = dump[j].replace("'", "");
                    dump[j] = str1;
                }
            }
        }
        return dump;
    }
}
