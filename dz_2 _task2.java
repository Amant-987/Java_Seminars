// Урок 2. Почему вы не можете не использовать API

// Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// Используйте StringBuilder для подготовки ответа. Далее создайте метод, который запишет
// результат работы в файл. Обработайте исключения и запишите ошибки в лог файл с помощью Logger.
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        StringBuilder result = new StringBuilder();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i &lt; jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String фамилия = obj.getString("фамилия");
                String оценка = obj.getString("оценка");
                String предмет = obj.getString("предмет");

                result.append("Студент ").append(фамилия).append(" получил ")
                        .append(оценка).append(" по предмету ").append(предмет).append(".\n");
            }

            System.out.println(result.toString());

            // Запись результата в файл
            writeToFile("result.txt", result.toString());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Ошибка при парсинге JSON строки.", e);
        }
    }

    private static void writeToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Результат записан в файл: " + fileName);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при записи в файл.", e);
        }
    }

    static {
        try {
            FileHandler fileHandler = new FileHandler("error.log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при создании файла лога.", e);
        }
    }
}
