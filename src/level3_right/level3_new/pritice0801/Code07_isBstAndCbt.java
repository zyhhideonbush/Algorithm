package level3_right.level3_new.pritice0801;


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

    public static boolean isBST(Node head) {
        if (head == null) {
           return false;
        }
        Stack<Node> stack = new Stack<Node>();
        int lastValue = Integer.MIN_VALUE;
        while (!stack.empty() || head != null) {
            if (head.left != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.value < lastValue) {
                    return false;
                }
                lastValue = head.value;
                head = head.right;
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
		System.out.println(isBST(head));
//		System.out.println(isCBT(head));

	}
}
