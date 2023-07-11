// Урок 5. Хранение и обработка данных ч2: множество коллекций Map
// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map&lt;String, List&lt;String&gt;&gt; phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap&lt;&gt;();
    }

    public void addContact(String name, String phoneNumber) {
        List&lt;String&gt; phoneNumbers = phoneBook.getOrDefault(name, new ArrayList&lt;&gt;());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers);
    }

    public List&lt;String&gt; getPhoneNumbers(String name) {
        return phoneBook.getOrDefault(name, new ArrayList&lt;&gt;());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("John", "1234567890");
        phoneBook.addContact("John", "9876543210");
        phoneBook.addContact("Alice", "5555555555");

        List&lt;String&gt; johnPhoneNumbers = phoneBook.getPhoneNumbers("John");
        System.out.println("Телефоны John: " + johnPhoneNumbers);

        List&lt;String&gt; alicePhoneNumbers = phoneBook.getPhoneNumbers("Alice");
        System.out.println("Телефоны Alice: " + alicePhoneNumbers);
    }
}