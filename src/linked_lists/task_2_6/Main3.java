package linked_lists.task_2_6;

import java.util.Stack;

/**
 * Created by Polomani on 17.09.2017.
 * Checks whether a linked list is a palindrom. (Reversed list & runners approach)
 */

public class Main3 {

    public static boolean isPalindrome (Node list) {

        Node reversed = null;
        Node slow = list;
        Node fast = list;

        while (fast !=null && fast.next!=null) {
            Node slowCopy = new Node (slow);
            slowCopy.next = reversed;
            reversed = slowCopy;
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast!=null) {
            slow = slow.next;
        }

        while (slow!=null) {
            if (slow.value != reversed.value) {
                return false;
            }
            reversed = reversed.next;
            slow = slow.next;
        }

        return true;
    }

}

