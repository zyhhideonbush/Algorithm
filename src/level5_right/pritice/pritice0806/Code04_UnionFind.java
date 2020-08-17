package level5_right.pritice.pritice0806;

import java.util.HashMap;
import java.util.List;

public class Code04_UnionFind {
    public static class Node {

    }

    public static class UninFindSet {
        private HashMap<Node, Node> fatherNode;
        private HashMap<Node, Integer> nodeSize;

        public UninFindSet(List<Node> nodes) {
            makeSet(nodes);
        }

        private void makeSet(List<Node> nodes) {
            this.fatherNode = new HashMap<Node, Node>();
            this.nodeSize = new HashMap<Node, Integer>();
            for (Node node : nodes) {
                this.fatherNode.put(node, node);
                this.nodeSize.put(node, 1);
            }
        }

        public Node getHead(Node node) {
            if (node == null) {
               return null;
            }
            Node parent = fatherNode.get(node);
            while (parent != node) {
                parent = getHead(parent);
            }
            fatherNode.put(node, parent);
            return parent;
        }

        public boolean isSameSet(Node node1, Node node2) {
            return getHead(node1) == getHead(node2);
        }

        public void unionSet(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
               return;
            }
            Node head1 = getHead(node1);
            Node head2 = getHead(node2);
            int size1 = nodeSize.get(node1);
            int size2 = nodeSize.get(node2);
            if (size1 < size2) {
                fatherNode.put(head1, head2);
                nodeSize.put(head2, size1 + size2);
            } else {
                fatherNode.put(head2, head1);
                nodeSize.put(head1, size1 + size2);
            }
        }
    }
}
