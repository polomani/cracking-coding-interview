package bit_manipulation.task_5_2;

/**
 * Created by Polomani on 29.09.2017.
 * Prints the binary representation of double d (0 < d < 1)
 */

public class Main {
    public static void main(String args[]) {
        double d = 0.5;
        System.out.println(printBinary(d));
    }

    static String printBinary (double num) {
        if (num >= 1 || num <= 0)
            return "error";

        StringBuilder binary = new StringBuilder();
        binary.append('.');
        while (num>0) {

            if (binary.length()>32)
                return "error";

            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }
}