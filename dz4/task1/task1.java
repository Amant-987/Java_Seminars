// Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список. Постараться не обращаться к листу по индексам.

import java.util.LinkedList;
import java.util.ListIterator;

public class task1 {
    public static void main(String[] args) {
        LinkedList&lt;Integer&gt; list = new LinkedList&lt;&gt;();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        LinkedList&lt;Integer&gt; reversedList = reverseLinkedList(list);

        System.out.println("Исходный список: " + list);
        System.out.println("Перевернутый список: " + reversedList);
    }

    private static &lt;T&gt; LinkedList&lt;T&gt; reverseLinkedList(LinkedList&lt;T&gt; list) {
        LinkedList&lt;T&gt; reversed = new LinkedList&lt;&gt;();
        ListIterator&lt;T&gt; iterator = list.listIterator(list.size());

        while (iterator.hasPrevious()) {
            reversed.add(iterator.previous());
        }
        return reversed;
    }
}