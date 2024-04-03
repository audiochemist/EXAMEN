import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Input {

    private static Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
    public static int readInt(String message) {
        System.out.println(message);

        int value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                value = sc.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid integer.");
                sc.nextLine();
            }

        }

        return value;
    }

    public static String readString(String message) {
        System.out.println(message);

        String value = "";
        boolean valid = false;

        while (!valid) {
            try {
                value = sc.next();
                if (value.isEmpty()) {
                    throw new Exception();
                } else {
                    sc.nextLine();
                    valid = true;
                }
            } catch (Exception e) {
                System.err.println("Please enter a valid String");
                sc.nextLine();

            }
        }
        return value;
    }
}
