package level5_right.pritice.pritice0804;

//完全二叉树所有节点个数
public class Code308_CompleteTreeNodeNumber {
     public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

    public static int getNodeNumber(Node head) {
        if (head == null) {
            return 0;
        }
        return getNodeNumber(head, 1, mostLeftNodeLevel(head, 1));
    }

    private static int getNodeNumber(Node head, int level, int h) {
         if (level == h) {
            return 1;
         }
         if (mostLeftNodeLevel(head.right, level + 1) == h) {
             return (1 << (h - level)) + getNodeNumber(head.right, level + 1, h);
         } else {
             return (1 << (h - level - 1)) + getNodeNumber(head.left, level + 1, h);
         }
    }

    private static int mostLeftNodeLevel(Node head, int level) {
         while (head != null) {
             level++;
             head = head.left;
         }
         return level - 1;
    }

    public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(getNodeNumber(head));

	}
}
