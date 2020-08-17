package level7_right.pritice.priteice0810;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code03_IPO {
    public static class Node {
        private int p;
        private int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxPreComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaxFunction(int k, int w, int[] profits, int[] capital) {
        Node[] nodes = new Node[capital.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], capital[i]);
        }

        PriorityQueue<Node> minCost = new PriorityQueue<Node>(new MinCostComparator());
        PriorityQueue<Node> maxPro = new PriorityQueue<Node>(new MaxPreComparator());

        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && w > minCost.peek().c) {
                maxPro.add(minCost.poll());
            }
            if (maxPro.isEmpty()) {
               return 0;
            }
            w += maxPro.poll().p;
        }
        return w;
    }

}
