package practic;

/*
Задания к главе 1
Вариант A
3. Вывести заданное количество случайных чисел с переходом и без перехода
на новую строку.
*/


 
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class prog {
    public static void main(String[] args) {
    	
    	Scanner in = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int count = in.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        int sumLength = 0;

        for (int i = 0; i < count; i++) {
            int number = random.nextInt(10000000); 
            numbers.add(number);
            sumLength += String.valueOf(number).length();
        }
        
        double averageLength = (double) sumLength / count;
        
        System.out.println("Числа с длиной меньше средней (" + averageLength + "):");
        for (int number : numbers) {
            if (String.valueOf(number).length() < averageLength) {
                System.out.println(number + " (Длина: " + String.valueOf(number).length() + ")");
            }
        }

        System.out.println("Числа с длиной больше средней (" + averageLength + "):");
        for (int number : numbers) {
            if (String.valueOf(number).length() > averageLength) {
                System.out.println(number + " (Длина: " + String.valueOf(number).length() + ")");
            }
        }
    }
}