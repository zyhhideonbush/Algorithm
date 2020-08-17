package level3_right.level3_new.pritice0814;

import java.util.Stack;

public class PreInPosTraversal {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
//        preTraversal2(node);
//        inTraversal2(node);
        posTraversal(node);
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int num) {
            value = num;
        }
    }

    public static void preTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preTraversal(node.left);
        preTraversal(node.right);
    }

    public static void inTraversal(Node node) {
        if (node == null) {
            return;
        }
        inTraversal(node.left);
        System.out.print(node.value + " ");
        inTraversal(node.right);
    }

    public static void posTraversal(Node node) {
        if (node == null) {
            return;
        }
        posTraversal(node.left);
        posTraversal(node.right);
        System.out.print(node.value + " ");
    }

    public static void preTraversal2(Node node) {
        if(node == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.add(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.value + " ");
            if(node.right != null) {
                stack.add(node.right);
            }
            if(node.left != null) {
                stack.add(node.left);
            }
        }
    }

    public static void inTraversal2(Node node) {
        if (node == null) {
           return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.value);
                node = node.right;
            }
        }
    }

    public static void posTraversal2(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.add(node);
        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.add(node);
            if (node.left != null) {
               stack1.add(node.right);
            }
            if (node.right!=null) {
                stack1.add(node.left) ;
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }



}
