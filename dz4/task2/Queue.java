// Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
// Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
import java.util.LinkedList;

public class Queue {
    private LinkedList&lt;Integer&gt; queue;

    public Queue() {
        queue = new LinkedList&lt;&gt;();
    }

    public void enqueue(int element) {
        queue.addLast(element);
    }

    public int dequeue() {
        return queue.removeFirst();
    }

    public int first() {
        return queue.getFirst();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Первый элемент: " + queue.first());
        System.out.println("Извлеченный элемент: " + queue.dequeue());
        System.out.println("Первый элемент после извлечения: " + queue.first());
    }
}