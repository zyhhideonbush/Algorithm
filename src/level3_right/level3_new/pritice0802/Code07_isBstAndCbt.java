package level3_right.level3_new.pritice0802;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code07_isBstAndCbt {
     public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node (int value) {
            this.value = value;
        }
    }

    public static boolean isBst(Node head) {
         if(head == null) {
             return true;
         }
         Stack<Node> stack1 = new Stack<Node>();
         int lastNum = Integer.MIN_VALUE;
         while (!stack1.isEmpty() || head != null) {
             if (head.left != null) {
                 stack1.push(head);
                 head = head.left;
             } else {
                 head = stack1.pop();
                 if (head.value < lastNum) {
                    return false;
                 }
                 lastNum = head.value;
                 head = head.right;
             }
         }
         return true;
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        Node l = null;
        Node r = null;
        boolean leaf = false;
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);

		printTree(head);
		System.out.println(isBst(head));
		System.out.println(isCBT(head));

	}
}
