package sorting_and_searching.task_10_3;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Polomani on 17.10.2017.
 * Finds an element in a sorted array that has been rotated unknown number of times
 * This is bad algorithm and its time complexity is much worse than one from the book.
 */
public class Main {

    public static void main(String args[]) {
        int[] a = generateRandomArray();
        int x = a[new Random().nextInt(a.length)];
        System.out.println(x);
        System.out.println(Arrays.toString(a));
        System.out.println("index of " + x + " is " + search(a, 0, a.length-1, x));
    }

    public static int search(int a[], int left, int right, int x) {
        if (right < left) return -1;
        int middle = (left + right) / 2;
        if (a[middle] == x) return middle;


        int res = -1;
        if (a[left] <= x || x < a[middle]) {
            res = search(a, left, middle - 1, x);
        }

        if (res!=-1) {
            return res;
        } else if (a[middle] < x || x <= a[right]) {
            return search(a, middle+1, right, x);
        }

        return -1;
    }

    public static int[] generateRandomArray() {
        Random r = new Random();
        int a[] = new int[r.nextInt(300)+1];
        for (int i = 0; i < a.length; ++i) {
            a[i] = r.nextInt(100);
        }
        Arrays.sort(a);
        int[] b = new int[a.length];
        int rotate = r.nextInt(a.length);
        for (int i = 0; i < a.length; i++) {
            b[(i + rotate)%b.length] = a[i];
        }
        return b;
    }
}
