/*
Задания к главе 1
Вариант A
3. Вывести заданное количество случайных чисел с переходом и без перехода
на новую строку.
*/

package practic;
 
import java.util.Random;
import java.util.Scanner;

public class prog {
    public static void main(String[] args) {
    	 Scanner in = new Scanner(System.in);
    	System.out.println("Введите количество случайных чисел начало: ");
    	int begin = in.nextInt();
    	
    	System.out.println("Введите количество случайных чисел конец: ");
    	int end = in.nextInt();
        int count = 10; 
        Random random = new Random();

        System.out.println("Числа с переходом на новую строку:");
        for (int i = 0; i < count; i++) {
            System.out.println(random.nextInt(begin, end));
        }

        System.out.print("Числа без перехода на новую строку:");
        for (int i = 0; i < count; i++) {
            System.out.print(random.nextInt(begin, end) + " ");
        }
    }
}
