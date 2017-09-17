package linked_lists.task_2_6;

import java.util.Stack;

/**
 * Created by Polomani on 17.09.2017.
 * Checks whether a linked list is a palindrom. (Stack & runners approach)
 */

public class Main2 {

    public static boolean isPalindrome (Node list) {

        Stack<Integer> stack = new Stack<Integer>();
        Node slow = list;
        Node fast = list;

        while (fast !=null && fast.next!=null) {
            fast = fast.next.next;
            stack.push(slow.value);
            slow = slow.next;
        }

        if (fast!=null) {
            slow = slow.next;
        }

        while (slow!=null) {
            if (slow.value != stack.pop().intValue()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

}
