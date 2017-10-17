package recursion_and_dynamic_programming.task_8_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Polomani on 15.10.2017.
 * Prints all valid combinations of n pairs of parentheses
 */
public class Main {

    public static void main(String args[]) {
        System.out.println(generateParens(3));
    }

    public static LinkedList<String> generateParens(int n) {
        LinkedList<String> response = new LinkedList<String>();
        generateParens(response, n, n, 0, new char[n * 2]);
        return response;
    }

    private static void generateParens (LinkedList<String> response, int leftNeed, int rightNeed, int index, char[] src) {
        if (leftNeed < 0 || rightNeed < leftNeed) return;

        if (leftNeed==0 && rightNeed==0) {
            response.add(String.copyValueOf(src));
        } else {
            src[index] = '(';
            generateParens(response, leftNeed-1, rightNeed, index+1, src);

            src[index] = ')';
            generateParens(response, leftNeed, rightNeed-1, index+1, src);
        }
    }

}
