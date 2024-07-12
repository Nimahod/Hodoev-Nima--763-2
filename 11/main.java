/*
 * Вариан-А
 * 3. Создать список из элементов каталога и его подкаталогов
*/

package firstproject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\Lenovo 5\\eclipse-workspace";
        List<String> fileList = listFiles(directoryPath);
        
        for (String filePath : fileList) {
            System.out.println(filePath);
        }
    }

    public static List<String> listFiles(String directoryPath) {
        List<String> fileList = new ArrayList<>();
        File directory = new File(directoryPath);
        
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileList.add(file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        fileList.addAll(listFiles(file.getAbsolutePath()));
                    }
                }
            }
        }
        
        return fileList;
    }
}
