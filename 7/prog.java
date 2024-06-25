//21. Дан прямоугольный треугольник с катетами a и b. С помощью лямбда-выражения найти радиус вписанной в треугольник окружности.

package practic;

import java.util.function.BiFunction;

public class prog {
    public static void main(String[] args) {
        
        BiFunction<Double, Double, Double> hypotenuse = (a, b) -> Math.sqrt(a * a + b * b);

        BiFunction<Double, Double, Double> radius = (a, b) -> (a + b - hypotenuse.apply(a, b)) / 2;

        double a = 8.0;
        double b = 6.0;
        double r = radius.apply(a, b); 

        System.out.println("Радиус вписанной окружности: " + r);
    }
}

