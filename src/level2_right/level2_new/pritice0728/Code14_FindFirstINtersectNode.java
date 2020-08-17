package level2_right.level2_new.pritice0728;

public class Code14_FindFirstINtersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Node getFirst(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
           return null;
        }
        Node loop1 = getLoop(head1);
        Node loop2 = getLoop(head2);
        if (loop1 == null && loop2 == null) {
           return noLoop(head1, head2); 
        } else if (loop1 != null && loop2 != null) {
            return haveLoop(head1, head2, loop1, loop2);
        }
        return null;
    }

    private static Node haveLoop(Node head1, Node head2, Node loop1, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int i = 0;
            while (cur1 != loop1) {
                cur1 = cur1.next;
                i++;
            }
            while (cur2 != loop2) {
                cur2 = cur2.next;
                i--;
            }
            cur1 = i > 0 ? head1 : head2;
            cur2 = cur1 == head2 ? head1 : head2;
            i = Math.abs(i);
            while (i != 0) {
                cur1 = cur1.next;
                i--;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while(cur1 != loop1) {
                if (cur1 == loop2) {
                   return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
           return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int i = 0;
        while (cur1 != null) {
            i++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            i--;
            cur2 = cur2.next;
        }
        cur1 = i > 0 ? head1 : head2;
        cur2 = cur1 == head2 ? head1 : head2;
        i = Math.abs(i);
        while (i != 0) {
            i--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private static Node getLoop(Node head) {
        if(head.next == null || head.next.next == null) {
             return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
               return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getFirst(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getFirst(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getFirst(head1, head2).value);

	}
}
