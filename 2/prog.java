import java.util.Scanner;

public class chapter1 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> task1();
                case "2" -> task2();
                case "3" -> task3();
                case "4" -> task4();
                case "5" -> task5();
                case "6" -> task6();
                case "7" -> task7();
                case "8" -> task8();
                case "9" -> task9();
                case "0" -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный ввод. Выберите число от 0 до 9.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n========================================");
        System.out.println("Выберите номер задания (1-9) или 0 для выхода:");
        System.out.println("1. Таблица умножения");
        System.out.println("2. Массив в обратном порядке");
        System.out.println("3. Принадлежность числа k интервалам");
        System.out.println("4. Числа от 1 до 100, делящиеся на 3");
        System.out.println("5. Количество значащих нулей в числе 129");
        System.out.println("6. Найти основание системы счисления для 81 = 100_x");
        System.out.println("7. Перевод из 10-й СС в любую другую");
        System.out.println("8. Перевод из любой СС в любую другую");
        System.out.println("9. Название месяца по номеру");
        System.out.println("0. Выход");
        System.out.println("========================================");
    }

    private static void task1() {
        System.out.println("\n--- Задание 1: Таблица умножения ---");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }

    private static void task2() {
        System.out.println("\n--- Задание 2: Массив в обратном порядке ---");
        int[] arr = {10, 20, 30, 40, 50};
        
        System.out.print("Исходный массив: ");
        for (int val : arr) System.out.print(val + " ");
        System.out.println();

        System.out.print("В обратном порядке: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void task3() {
        System.out.println("\n--- Задание 3: Принадлежность k интервалам ---");
        try {
            System.out.print("Введите k: ");
            double k = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите n (левая граница): ");
            double n = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите m (правая граница): ");
            double m = Double.parseDouble(scanner.nextLine());

            if (n >= m) {
                System.out.println("Ошибка: n должно быть меньше m");
                return;
            }

            System.out.println("Интервал (n, m]: " + (k > n && k <= m));
            System.out.println("Интервал [n, m): " + (k >= n && k < m));
            System.out.println("Интервал (n, m): " + (k > n && k < m));
            System.out.println("Интервал [n, m]: " + (k >= n && k <= m));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено не число");
        }
    }

    private static void task4() {
        System.out.println("\n--- Задание 4: Числа от 1 до 100, делящиеся на 3 ---");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void task5() {
        System.out.println("\n--- Задание 5: Значащие нули в числе 129 ---");
        String binary = Integer.toBinaryString(129);
        int zeros = 0;
        for (char c : binary.toCharArray()) {
            if (c == '0') zeros++;
        }
        System.out.println("Число 129 в двоичной системе: " + binary);
        System.out.println("Количество значащих нулей: " + zeros);
    }

    private static void task6() {
        System.out.println("\n--- Задание 6: Найти основание СС для 81 = 100_x ---");
        System.out.println("Уравнение: 1 * x^2 + 0 * x^1 + 0 * x^0 = 81");
        System.out.println("x^2 = 81 => x = 9");
        System.out.println("Искомое основание системы счисления: 9");
    }

    private static void task7() {
        System.out.println("\n--- Задание 7: Из 10-й СС в любую другую ---");
        try {
            System.out.print("Введите целое десятичное число: ");
            int num = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите целевое основание (2-36): ");
            int base = Integer.parseInt(scanner.nextLine());

            if (base < 2 || base > 36) {
                System.out.println("Основание должно быть от 2 до 36");
                return;
            }

            String result = convertFromDecimal(num, base);
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода данных");
        }
    }

    private static void task8() {
        System.out.println("\n--- Задание 8: Из любой СС в любую другую ---");
        try {
            System.out.print("Введите число: ");
            String numStr = scanner.nextLine().trim().toUpperCase();
            System.out.print("Введите исходное основание (2-36): ");
            int baseFrom = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите целевое основание (2-36): ");
            int baseTo = Integer.parseInt(scanner.nextLine());

            // Шаг 1: Из исходной системы в 10-ю
            int decimalNum = Integer.parseInt(numStr, baseFrom);

            // Шаг 2: Из 10-й в целевую систему
            String result = convertFromDecimal(decimalNum, baseTo);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: неверный формат числа или основания");
        }
    }

    private static void task9() {
        System.out.println("\n--- Задание 9: Название месяца по номеру ---");
        String[] months = {
            "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        };

        System.out.print("Введите номер месяца (1-12): ");
        String input = scanner.nextLine().trim();

        // Проверка регулярным выражением, что введены только цифры
        if (input.matches("\\d+")) {
            int num = Integer.parseInt(input);
            if (num >= 1 && num <= 12) {
                System.out.println("Месяц: " + months[num - 1]);
            } else {
                System.out.println("Ошибка: число должно быть в диапазоне от 1 до 12");
            }
        } else {
            System.out.println("Ошибка: введено не целое положительное число");
        }
    }

    // Вспомогательный метод перевода из 10-й СС в любую другую
    private static String convertFromDecimal(int num, int base) {
        if (num == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean isNegative = num < 0;
        long temp = Math.abs((long) num);

        while (temp > 0) {
            result.insert(0, chars.charAt((int) (temp % base)));
            temp /= base;
        }

        if (isNegative) {
            result.insert(0, "-");
        }
        return result.toString();
    }
}
