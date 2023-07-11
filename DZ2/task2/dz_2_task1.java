// Урок 2. Почему вы не можете не использовать API

// Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// Используйте StringBuilder для подготовки ответа. Далее создайте метод, который запишет
// результат работы в файл. Обработайте исключения и запишите ошибки в лог файл с помощью Logger.


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class dz_2_task1 {public static void main(String[] args) throws IOException {
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
            try (Scanner scanner = new Scanner(fileReader)) {
                StringBuilder stringBuilder = new StringBuilder();

                while (scanner.hasNextLine()) {
                    stringBuilder.append(scanner.nextLine());
                }

                String jsonString = stringBuilder.toString();
                System.out.println("Исходная JSON строка: " + jsonString);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }}