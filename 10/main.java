/*В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия. При этом могут рассматриваться два варианта:
• каждая строка состоит из одного слова;
• каждая строка состоит из нескольких слов.
Имена входного и выходного файлов, а также абсолютный путь к ним могут
быть введены как параметры командной строки или храниться в файле.

3. В каждой строке найти слова, начинающиеся с гласной буквы.
*/

package firstproject;

import java.io.*;

public class  main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <input file> <output file>");
            return;
        }

        String inputFilename = args[0];
        String outputFilename = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split("\\s+")) {
                	System.out.println(word);
                    if (word.matches("^[AEIOUaeiou].*")) {
                        writer.write(word + " ");
                    }
                }
            }
            System.out.println("Успешно!");
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
