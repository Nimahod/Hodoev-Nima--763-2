/* 
В символьном файле находится информация об N числах с плавающей запятой
с указанием локали каждого числа отдельно. Прочитать информацию из файла.
Проверить на корректность, то есть являются ли числа числами. Преобразовать
к числовымзначениями вычислить сумму и среднее значениепрочитанных чисел.
Создать собственный класс исключения. Предусмотреть обработку исключений, возникающих при нехватке памяти, отсутствии самого файла по заданному адресу,
отсутствии или некорректности требуемой записи в файле, недопустимом значении числа (выходящим за пределы максимально допустимых значений) и т.д
*/

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class main {
    public static void main(String[] args) {
        try {
            processNumbers("C:\\Users\\Lenovo 5\\eclipse-workspace\\firstproject\\src\\firstproject\\numbers.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void processNumbers(String filePath) throws IOException, ParseException, CustomException {
        
    	  try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
    	        String line;
    	        double sum = 0;
    	        int count = 0;
    	        Locale locale = null;

    	        while ((line = reader.readLine()) != null) {
    	            if (line.trim().isEmpty()) continue; 

    	            String[] parts = line.split("\\s+");
    	            if (parts.length != 2) {
    	                throw new CustomException("Некорректный формат данных в строке: " + line);
    	            }

    	            if (locale == null) {
    	                locale = new Locale(parts[1]); 
    	            }

    	            String numberString = parts[0];
    	            NumberFormat format = NumberFormat.getInstance(locale);

    	            Number number = format.parse(numberString);
    	            double value = number.doubleValue();

    	            if (Double.isNaN(value) || Double.isInfinite(value)) {
    	                throw new CustomException("Недопустимое значение числа в строке: " + line);
    	            }

    	            sum += value;
    	            count++;
    	        }

    	        if (count == 0) {
    	            throw new CustomException("Нет данных для обработки.");
    	        }

    	        double average = sum / count;
    	        System.out.printf("Сумма: %.2f , Среднее значение: %.2f%n", sum, average);
    	    }
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
