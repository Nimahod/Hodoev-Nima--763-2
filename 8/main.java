package firstproject;


public class main {
    public static void main(String[] args) {
        String text = "bbblv 13  lblwl  435 ljvlq 43 llwlwr65 lwgl339";
        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
            }
        }

        System.out.println("Сумма всех цифр в тексте: " + sum);
    }
}

