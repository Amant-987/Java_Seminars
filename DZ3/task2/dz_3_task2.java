package task2;
// ; Урок 3. Коллекции JAVA: Введение
// ;  Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка. Collections.max()

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class dz_3_task2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer> ();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(9);

        // Нахождение минимального значения
        int min = Collections.min(numbers);
        System.out.println("Минимальное значение: " + min);

        // Нахождение максимального значения
        int max = Collections.max(numbers);
        System.out.println("Максимальное значение: " + max);

        // Нахождение среднего арифметического значения
        double average = calculateAverage(numbers);
        System.out.println("Среднее арифметическое значение: " + average);
    }

    private static double calculateAverage(List<Integer>  numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }
}