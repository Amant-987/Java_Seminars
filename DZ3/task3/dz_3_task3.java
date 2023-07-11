// ; Урок 3. Коллекции JAVA: Введение
// ; Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями. Вывести название каждой планеты и количество его повторений в списке. Collections.frequency(list, item)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class dz_3_task3 {
    public static void main(String[] args) {
        List&lt;String&gt; planets = new ArrayList&lt;&gt;();
        planets.add("Меркурий");
        planets.add("Венера");
        planets.add("Земля");
        planets.add("Марс");
        planets.add("Земля");
        planets.add("Юпитер");
        planets.add("Сатурн");
        planets.add("Уран");
        planets.add("Нептун");
        planets.add("Земля");

        // Вывод названия каждой планеты и количество его повторений
        for (String planet : planets) {
            int frequency = Collections.frequency(planets, planet);
            System.out.println(planet + ": " + frequency);
        }
    }
}