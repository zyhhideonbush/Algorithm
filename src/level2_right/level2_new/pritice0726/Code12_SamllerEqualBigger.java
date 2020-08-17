package level2_right.level2_new.pritice0726;

public class Code12_SamllerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void makesort2(Node head, int num) {
        if (head == null) {
           return;
        }
        int i = 0;
        Node cur = head;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        int[] arr = new int[i];
        cur = head;
        i = 0;
        while (cur != null) {
            arr[i] = cur.value;
            cur = cur.next;
            i++;
        }
        partition(arr, num);
        cur = head;
        i = 0;
        while (cur != null) {
            cur.value = arr[i];
            i++;
            cur = cur.next;
        }
    }

    private static void partition(int[] arr, int num) {
        int less = - 1;
        int more = arr.length;
        int i = 0;
        while (i < more) {
            if (arr[i] < num) {
                swap(arr, ++less, i++);
            } else if (arr[i] > num) {
                swap(arr, --more, i);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int tem = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tem;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static Node makesort1(Node head, int num) {
        Node sH = null;
        Node sL = null;
        Node mH = null;
        Node mL = null;
        Node bH = null;
        Node bL = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < num) {
                if (sH == null) {
                    sH = head;
                    sL = head;
                } else {
                    sL.next = head;
                    sL = head;
                }
            }
            if (head.value == num) {
                if (mH == null) {
                    mH = head;
                    mL = head;
                } else {
                    mL.next = head;
                    mL = head;
                }
            }
            if (head.value > num) {
                if (bH == null) {
                    bH = head;
                    bL = head;
                } else {
                    bL.next = head;
                    bL = head;
                }
            }
            head = next;
        }
        if (sL != null) {
            sL.next = mH;
            mL = mL == null ? sL : mL;
        }
        if (mL != null) {
            mL.next = bH;
        }
        return sH != null ? sH : mH != null ? mH : bH;
    }

    public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
		head1 = makesort1(head1, 5);
		printLinkedList(head1);
		System.out.print(2222);

	}
}
