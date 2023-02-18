//3* . Дана json строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

//Написать метод(ы), который распарсит json и, используя StringBuilder,
// создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].
//
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.

//import com.jayway.jsonpath.JsonPath;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;

import static javax.swing.UIManager.getString;

public class Ex_03_ParsJson {
    public static void main(String[] args) throws IOException {
//        Считываем из файла params.json
        String path = "person.json";
        String str = Files.readString(Paths.get(path));

        String result = getString(str);
        System.out.println(str);
        str = str.replace("[", "").replace("]", "")
                .replace("\n", "").replace(" ", "")
                .replace(":", "=").replace("},", "};");
        str = str.replaceAll("\"", "");
        String[] journal = str.split(";");

        for (int i = 0; i < journal.length; i++) {
            System.out.println(journal[i].replace("{фамилия=", "Студент ")
                    .replace(",оценка=", " получил ")
                    .replace(",предмет=", " по предмету ")
                    .replace("}", "."));
        }
    }
}
