// Урок 2. Почему вы не можете не использовать API
// *Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9};

        // Сортировка пузырьком
        bubbleSort(array);

        // Запись результата каждой итерации в лог-файл
        writeIterationsToLog(array);
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i &lt; n - 1; i++) {
            for (int j = 0; j &lt; n - i - 1; j++) {
                if (array[j] &gt; array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void writeIterationsToLog(int[] array) {
        try (FileWriter writer = new FileWriter("sort_iterations.log")) {
            for (int i = 0; i &lt; array.length; i++) {
                writer.write("Iteration " + (i + 1) + ": " + Arrays.toString(array) + "\n");
            }
            System.out.println("Результаты итераций записаны в лог-файл: sort_iterations.log");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при записи в лог-файл.", e);
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
