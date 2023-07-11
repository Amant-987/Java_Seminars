// ; Урок 3. Коллекции JAVA: Введение
// ; Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dz_3_task1 {
    public static void main(String[] args) {
        List&lt;Integer&gt; numbers = new ArrayList&lt;&gt;();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Удаление четных чисел
        removeEvenNumbers(numbers);

        // Вывод списка после удаления
        System.out.println("Список после удаления четных чисел:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    private static void removeEvenNumbers(List&lt;Integer&gt; numbers) {
        Iterator&lt;Integer&gt; iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }
    }
}