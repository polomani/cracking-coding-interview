package linked_lists.task_2_6;

/**
 * Created by Polomani on 16.09.2017.
 * Checks whether a linked list is a palindrom. (Recurcive approach)
 */

class Node {
    public int value;
    public Node next;

    public Node (int value) {
        this.value = value;
    }

    public Node add (int value) {
        next = new Node (value);
        return next;
    }

    public Node (Node node) {
        this.value = node.value;
    }
}

class AnswerWrapper {
    public Node node;
    public boolean palindrome = true;
}

public class Main {
    public static void main (String... args) {
        Node list = new Node(1);
        list.add(2).add(3).add(4).add(3).add(2).add(1);

        System.out.println(Main.isPalindrome(list));
        System.out.println(Main2.isPalindrome(list));
        System.out.println(Main3.isPalindrome(list));
    }

    public static boolean isPalindrome (Node list) {
        AnswerWrapper w = new AnswerWrapper();
        w.node = list;
        isPalindromeRecurce(w, list);
        return w.palindrome;
    }

    private static void isPalindromeRecurce (AnswerWrapper wrapper, Node node) {
        if (node != null && node.next!=null) isPalindromeRecurce(wrapper, node.next);
        if (wrapper.node.value != node.value) wrapper.palindrome = false;
        wrapper.node = wrapper.node.next;
    }
}
