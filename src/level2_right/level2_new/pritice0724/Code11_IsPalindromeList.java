package level2_right.level2_new.pritice0724;


import java.util.Stack;

public class Code11_IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
           return true;
        }
        Stack<Integer> stack = new Stack<Integer>();
        Node node = head;
        while (node != null) {
            stack.push(node.value);
            node = node.next;
        }
        node = head;
        while (!stack.isEmpty()) {
            if (node.value != stack.pop()) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
           return true;
        }
        Node node1 = head;
        Node node2 = head;
        while (node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        node2 = node1.next;
        node1.next = null;
        Node node3;
        while (node2 != null) {
            node3 = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = node3;
        }
        node3 = node1;
        node2 = head;
        boolean res = true;
        while (node2 != null && node1 != null) {
            if (node2.value != node1.value) {
                res = false;
                break;
            }
            node2 = node2.next;
            node1 = node1.next;
        }
        node2 = node3.next;
        node3.next = null;
        while (node2 != null) {
            node1 = node2.next;
            node2.next = node3;
            node3 = node2;
            node2 = node1;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }

}
