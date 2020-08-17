package level7_right.pritice.pritice0807;

import java.util.Comparator;
import java.util.PriorityQueue;

//АнІЖ
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

    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], capital[i]);
        }

        PriorityQueue<Node> minCost = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxpro = new PriorityQueue<>(new MaxProfitComparator());

        for (int i = 0; i < nodes.length; i++) {
            minCost.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && minCost.peek().c < w) {
                maxpro.add(minCost.poll());
            }
            if (maxpro.isEmpty()) {
                return w;
            }
            w += maxpro.poll().p;
        }
        return w;
    }
}
