package linked_lists.task_2_7;

/**
 * Created by Polomani on 17.09.2017.
 * Checks if two lists intersect. Returns the intersecting node.
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

    public String toString() {
        return "Node: " + value;
    }
}

public class Main {
    public static void main (String... args) {
        Node list = new Node(1);
        list.add(2).add(3).add(4).add(3).add(2).add(1);

        Node list2 = new Node (10);
        list2.next = list;

        System.out.println(intersection (list2, list));
    }

    public static Node intersection (Node node1, Node node2) {
        int len1 = 0, len2 = 0;
        Node index1 = node1;
        Node index2 = node2;

        while (index1!=null) {
            len1++;
            index1=index1.next;
        }

        while (index2!=null) {
            len2++;
            index2=index2.next;
        }

        if (index1!=index2) return null;

        if (len1<len2) {
            index1 = node1;
            index2 = node2;
        } else {
            index1 = node2;
            index2 = node1;
        }

        index2 = shift(index2, Math.abs(len1-len2));

        while (index1!=index2) {
            index1 = index1.next;
            index2 = index2.next;
        }

        return index1;
    }

    public static Node shift (Node node, int shift) {
        for (int i = 0; i < shift; ++i) {
            if (node!=null)
                node = node.next;
        }
        return node;
    }
}
