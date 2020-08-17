package level2_right.level2_new.pritice0724;


public class Code12_SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node makesort(Node head, int num) {
        if (head == null) {
           return head;
        }
        int i = 0;
        Node cur = head;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        int[] arr = new int[i];
        cur = head;
        for (int j = 0; j < arr.length; j++) {
            arr[j] = cur.value;
            cur = cur.next;
        }
        partition(arr, num);
        cur = head;
        for (int j = 0; j<arr.length; j++) {
            cur.value = arr[j];
            cur = cur.next;
        }
        return head;
    }

    private static void partition(int[] arr, int num) {
        if (arr.length == 0 || arr.length < 2) {
           return;
        }
        int less = - 1;
        int more = arr.length;
        int i = 0;
        while (i < more) {
            if (arr[i] < num) {
               swap(arr, i++, ++less);
            } else if (arr[i] > num) {
                swap(arr, i, --more);
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

    public static Node makesort2(Node head, int num) {
        if (head == null) {
            return null;
        }
        Node sF = null;
        Node sL = null;
        Node mF = null;
        Node mL = null;
        Node bF = null;
        Node bL = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < num) {
                if(sF == null){
                    sF = head;
                    sL = head;
                } else {
                    sL.next = head;
                    sL = head;
                }
            } else if (head.value == num) {
                if(mF == null){
                    mF = head;
                    mL = head;
                } else {
                    mL.next = head;
                    mL = head;
                }
            } else {
                if(bF == null){
                    bF = head;
                    bL = head;
                }
                bL.next = head;
                bL = head;
            }
            head = next;
        }
        if (sL != null) {
            sL.next = mF;
            mL = mL == null ? bF : mL;
        }
        if (mL != null) {
            mL.next = bF;
        }
        return sF != null ? sF : mF != null ? mF : bF;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
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
		// head1 = listPartition1(head1, 4);
		head1 = makesort2(head1, 5);
		printLinkedList(head1);

	}


}
