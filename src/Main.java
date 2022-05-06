import java.util.Scanner;

/** Урок 8: Exception
 * Практическое задание №10 - Exception
 * Создать класс исключения:
 * Если в строке встречаются цифры или три одинаковые буквы
 * подряд,то выводится сообщение об ошибке. Помимо сообщения
 * необходимо вывести цифру или букву, которая встречается в
 * строке.
 * В самой программе реализовать цикл, который будет запрашивать
 * ввести строку до тех пор, пока в ней не будет ошибок.
 */
public class Main {
    public static void  main(String[] args) {
        boolean loopInput = true;
        while (loopInput) {
            try {
                System.out.print("Введите строку: ");
                System.out.println("Ввели строку: " + getInputString());
                loopInput = false;
            } catch (InvalidInputString ae) {
                System.out.println(ae.getMessage() + " [" + ae.getInvalidSymbol()+"]. please try again.");
            } catch (Exception e) {
                e.printStackTrace();
                loopInput = false;
            }
        }
    }

    // проверка на правильность введенной строки
    public static String validString(String str) {
        int j;
        char s1,s2,s3;
        if (str.length() > 0) {
            for (int i = 0; i < str.length(); i++) {
                // проверка встречаются ли цифры
                j = (int) str.charAt(i);
                if (j >= 48 && j <= 57) { //0123456789
                    return String.valueOf(str.charAt(i));
                }
                // проверка на три одинаковые буквы
                if (str.length() > 2 && (i < (str.length()-2))) {
                    s1 = str.charAt(i);
                    s2 = str.charAt(i+1);
                    s3 = str.charAt(i+2);
                    if (s1 == s2 && s2 == s3) {
                        return String.valueOf(s1);
                    }
                }
            }
        }
        return "";
    }

    // ввод строки
    public static String getInputString() {
        Scanner scr = new Scanner(System.in);
        String inputString = scr.nextLine();
        String invalidSymbol = validString(inputString);
        //System.out.println("invalid=["+invalidSymbol+"]");
        if (invalidSymbol.length()>0) {
            throw new InvalidInputString("Input invalid symbol", invalidSymbol);
        }
        return inputString;
    }

}
