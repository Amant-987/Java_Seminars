// Урок 2. Почему вы не можете не использовать API
// *Получить исходную json строку из файла, используя FileReader или Scanner
// Дана json строка вида:
// String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
// "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
// "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        // Создание файла и запись в него JSON строки
        try {
            File file = new File("data.json");
            java.io.FileWriter writer = new java.io.FileWriter(file);
            writer.write(json);
            writer.close();
            System.out.println("JSON строка записана в файл.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Чтение JSON строки из файла с использованием FileReader
        try {
            FileReader fileReader = new FileReader("data.json");
            Scanner scanner = new Scanner(fileReader);
            StringBuilder stringBuilder = new StringBuilder();

            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }

            String jsonString = stringBuilder.toString();
            System.out.println("Исходная JSON строка: " + jsonString);

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}