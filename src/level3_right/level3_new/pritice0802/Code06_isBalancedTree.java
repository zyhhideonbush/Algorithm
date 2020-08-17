package level3_right.level3_new.pritice0802;


public class Code06_isBalancedTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class returnValue {
        public boolean balance;
        public int height;
        public returnValue(boolean balance, int height) {
            this.balance = balance;
            this.height = height;
        }
    }

    public static boolean isB(Node head) {
        return process(head).balance;
    }

    public static returnValue process(Node head) {
        if (head == null) {
           return new returnValue(true, 0);
        }
        returnValue left = process(head.left);
        if (!left.balance) {
           return new returnValue(false, 0);
        }
        returnValue right = process(head.right);
        if (!right.balance) {
           return new returnValue(false, 0);
        }
        if (Math.abs(left.height - right.height) > 1) {
           return new returnValue(false, 0);
        }
        return new returnValue(true, Math.max(right.height, left.height) + 1);
    }

    public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isB(head));

	}
}
