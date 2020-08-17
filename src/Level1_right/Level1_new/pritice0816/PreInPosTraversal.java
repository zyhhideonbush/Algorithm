package Level1_right.Level1_new.pritice0816;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.Stack;

public class PreInPosTraversal {
    private static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node next;

        public Node (int value) {
            this.value = value;
        }
    }

    public static void preTravel(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.value + " ");
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void inTravel(Node node) {
        if (node == null) {
           return;
        }
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || node != null) {
            if (node != null) {
               stack.push(node);
               node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.value + " ");
                node = node.right;
            }
        }
    }

    public static void posTravel(Node node) {
        if (node == null) {
           return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
               stack1.push(node.left);
            }
            if(node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        inTravel(node);
    }
}
