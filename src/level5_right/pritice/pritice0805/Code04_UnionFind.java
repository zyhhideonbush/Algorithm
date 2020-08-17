package level5_right.pritice.pritice0805;


import java.util.HashMap;
import java.util.List;

public class Code04_UnionFind {
    public static class Node {

    }

    public static class UnionFindSet {
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> sizeMap;

        public UnionFindSet(List<Node> nodes) {
            makeSet(nodes);
        }

        private void makeSet(List<Node> nodes) {
            this.fatherMap = new HashMap<Node, Node>();
            this.sizeMap = new HashMap<Node, Integer>();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node getFatherNode(Node node) {
            if (node == null) {
                return null;
            }
            Node father = fatherMap.get(node);
            if (father != node) {
                father = getFatherNode(node);
            }
            fatherMap.put(node, father);
            return father;
        }

        public boolean isSameSet(Node node1, Node node2) {
            return getFatherNode(node1) == getFatherNode(node2);
        }

        public void union(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
                return;
            }
            Node head1 = getFatherNode(node1);
            Node head2 = getFatherNode(node2);
            if (head1 != head2) {
                int size1 = sizeMap.get(head1);
                int size2 = sizeMap.get(head2);
                if (size1 < size2) {
                    fatherMap.put(head1, head2);
                    sizeMap.put(head2, size1 + size2);
                } else {
                    fatherMap.put(head2, head1);
                    sizeMap.put(head1, size1 + size2);
                }
            }
        }
    }
}
