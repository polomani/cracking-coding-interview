package bit_manipulation.task_5_3;

/**
 * Created by Polomani on 29.09.2017.
 * Flips one bit to wins with the longest sequence of 1s
 */

public class Main {
    public static void main(String args[]) {
        System.out.println(flipAndWin(1775));//11011101111
    }

    static int flipAndWin (int num) {
        if (~num == 0) return Integer.SIZE;

        int longest = 0;
        int prev = 0;
        int last = 0;
        for (int i = 0; i < Integer.SIZE; ++i) {

            if ((num & 1) == 1) {
                last++;
            } else {
                prev = last;
                last = 0;
            }

            if (longest < prev+last)
                longest = prev+last;

            num >>>= 1;
        }
        return longest+1;
    }
}