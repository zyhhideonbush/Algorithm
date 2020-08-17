package level3_right.level3_new.pritice0801;

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
        public int height;
        public boolean isB;

        public returnValue(int height, boolean isB) {
            this.height = height;
            this.isB = isB;
        }
    }

    public static boolean isB(Node head) {
        return process(head).isB;
    }

    public static returnValue process(Node head) {
        if(head == null) {
            return new returnValue(0, true);
        }
        returnValue leftValue = process(head.left);
        if (!leftValue.isB) {
           return new returnValue(0, false);
        }
        returnValue rightValue = process(head.right);
        if (!rightValue.isB) {
            return new returnValue(0, false);
        }
        if (Math.abs(leftValue.height - rightValue.height) > 1) {
           return new returnValue(0, false);
        }
        return new returnValue(Math.max(leftValue.height, rightValue.height), true);
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
