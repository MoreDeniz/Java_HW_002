// 1 . Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
//
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

//program for reading a JSON file
import java.io.File;
import java.io.IOException ;
import java.util.Scanner;

public class Ex_01_sql {
    public static void main(String[] args) throws IOException {
        StringBuilder sql = new StringBuilder("select * from students where ");
        String str = "";
        String journal = "";
//        Считываем из файла params.json
        String path = "params.json";
        File file = new File(path);

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            System.out.println(str);
        }

        String params = str.replace(":", "=")
                .replace("{", "")
                .replace("}", "").replaceAll("\"","");
        String[] get_params = params.split(", ");

        for (int i = 0; i < get_params.length; i++) {
            if (!get_params[i].contains("null")) {
                sql.append(get_params[i]);
                System.out.println(sql);
                sql.append(" AND ");
            }
        }
        scanner.close();
    }
}

