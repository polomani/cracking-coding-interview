package sorting_and_searching.task_10_3;

import java.util.Arrays;
import java.util.Random;

/**
 * Finds an element in a sorted array that has been rotated unknown number of times
 * This algorithm is from the book. Time complexity is much more better than my.
 */
public class Compare {

    static long startTime;
    static long elapsedTime;
    static long elapsedTime2;

    public static void main(String args[]) throws Exception {
        int times = 100;

        for (int i = 0; i < times; i++) {
            int[] a = Main.generateRandomArray();
            int x = a[new Random().nextInt(a.length)];
            startTime = System.nanoTime();
            int resp1 = search(a, 0, a.length - 1, x);
            elapsedTime += System.nanoTime() - startTime;
            startTime = System.nanoTime();
            int resp2 = Main.search(a, 0, a.length - 1, x);
            elapsedTime2 += System.nanoTime() - startTime;

            if (a[resp1]!=a[resp2])
                throw new Exception(resp1 +" "+ resp2);
        }
        if (elapsedTime >= elapsedTime2)
            System.out.println("ok");
        else
            System.out.println(elapsedTime/times +" "+ elapsedTime2/times);
    }

    public static int search(int a[], int left, int right, int x) {
        int mid = (left + right) / 2;
        if (x == a[mid]) { // Found element
            return mid;
        }
        if (right < left) {
            return -1;
        }

		/* While there may be an inflection point due to the rotation, either the left or
		 * right half must be normally ordered.  We can look at the normally ordered half
		 * to make a determination as to which half we should search.
		 */
        if (a[left] < a[mid]) { // Left is normally ordered.
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x);
            } else {
                return search(a, mid + 1, right, x);
            }
        } else if (a[mid] < a[left]) { // Right is normally ordered.
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            } else {
                return search(a, left, mid - 1, x);
            }
        } else if (a[left] == a[mid]) { // Left is either all repeats OR loops around (with the right half being all dups)
            if (a[mid] != a[right]) { // If right half is different, search there
                return search(a, mid + 1, right, x);
            } else { // Else, we have to search both halves
                int result = search(a, left, mid - 1, x);
                if (result == -1) {
                    return search(a, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}
