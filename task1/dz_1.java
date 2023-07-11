package task1;
// Урок 1. Знакомство с языком программирования Java
// Формат сдачи: ссылка на подписанный git-проект.

// Задание

// 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
// 2) Вывести все простые числа от 1 до 1000
// 3) Реализовать простой калькулятор
// 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут 
// быть заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение до верного
// равенства. Предложить хотя бы одно решение или сообщить, что его нет.

// 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

public static void Factorial(){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter any number: ");
    int n = scan.nextInt();
    int summ = 1;
    for (int i = 1; i < n + 1; i++){
       summ = summ * i;
    }
    System.out.println(summ);


}


// 2) Вывести все простые числа от 1 до 1000


public static void SimpleNumbers(){

    int m,n;
    A:for (n = 2;  n<= 1000; n++) {
        for (m = 2;  m<= n/2; m++) {
            if (n%m==0) {
                continue A;
            }
        }
        System.out.println(n);
    }

}

// 3) Реализовать простой калькулятор

public static void Calculator(){

    double num1;
    double num2;
    double ans;
    char op;
    Scanner reader = new Scanner(System.in);
    System.out.print("Enter two numbers: ");
    num1 = reader.nextDouble();
    num2 = reader.nextDouble();
    System.out.print("\nEnter an operator (+, -, *, /): ");
    op = reader.next().charAt(0);
    switch(op) {
        case '+': ans = num1 + num2;
            break;
        case '-': ans = num1 - num2;
            break;
        case '*': ans = num1 * num2;
            break;
        case '/': ans = num1 / num2;
            break;
        default:  System.out.printf("Ошибка! Не верный оператор");
            return;
    }
    System.out.print("\nРезультат выражения:\n");
    System.out.printf(num1 + " " + op + " " + num2 + " = " + ans);
}




public static void main(String[] args) {
    Factorial();
    SimpleNumbers();
    Calculator();

}


// 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут 
// быть заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение до верного
// равенства. Предложить хотя бы одно решение или сообщить, что его нет.


public static void task04(){
    // Считываем выражение
    System.out.println("Введите выражение -> ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine().trim();
    // Определяем количество знаков вопроса
    int count = 0;
    for (char c : input.toCharArray()) {
        if (c == '?') count++;
    }
    // Перебираем все возможные варианты
    boolean hasDecision = false;
    for (int num = 0; num < Math.pow(10,count); num++) {
        // Подставляем значения
        String expr = input.trim();
        int n = num;
        while (expr.indexOf('?') > 0) {
            String numStr = String.valueOf(n % 10);
            n /= 10;
            expr = expr.replaceFirst("\\?", numStr);
        }
        // Выделяем и распознаем значения
        String[] members = expr.split("\\+|=");
        try {
            int firstMember = Integer.parseInt(members[0].trim());
            int secondMember = Integer.parseInt(members[1].trim());
            int result = Integer.parseInt(members[2].trim());
            if (firstMember + secondMember == result) {
                System.out.println(expr);
                hasDecision = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    if (!hasDecision) {
        System.out.println("Решение не найдено");
    }
    scanner.close();
}
