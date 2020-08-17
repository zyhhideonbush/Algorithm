package level2_right.level2_new.pritice01;


public class SmallEqualBigger {
	public static class Node{
		private int value ;
		private Node next ;
		public Node(int value){
			this.value = value ;
		}
	}
	
	public static Node fun1(Node head,int num){
		if(head==null){
			return head ;
		}
		int i = 0 ;
		Node cur = head ;
		while(cur!=null){
			i++ ;
			cur = cur.next ;
		}
		Node[] nodes = new Node[i] ;
		cur = head ;
		for(i=0 ; i!=nodes.length ; i++){
			nodes[i] = cur ;
			cur = cur.next ;
		}
		NodePirtition(nodes,num) ;
		for(i=1 ; i!=nodes.length ; i++){
			nodes[i-1].next = nodes[i] ;
		}
		nodes[i-1].next = null ;
		return nodes[0];
	}

	private static void NodePirtition(Node[] nodes, int num) {
		int small = -1 ;
		int big = nodes.length ;
		int cur = 0 ;
		while(cur<big){
			if(nodes[cur].value<num){
				swap(nodes,++small,cur++) ;
			}else if(nodes[cur].value == num){
				cur++ ;
			}else{
				swap(nodes,cur,--big) ;
			}
		}
	}

	private static void swap(Node[] nodes, int i, int j) {
		Node tem = nodes[i] ;
		nodes[i] = nodes[j] ;
		nodes[j] = tem ;
	}
	
	public static Node fun2(Node head,int num){
		Node sH = null ;
		Node sE = null ;
		Node eH = null ;
		Node eE = null ;
		Node bH = null ;
		Node bE = null ;
		Node next = null ;
		while(head!=null){
			next = head.next ;
			head.next = null ;
			if(head.value<num){
				if(sH == null){
					sH = head ;
					sE = head ;
				}else{
					sE.next = head ;
					sE = head ;
				}
			}else if(head.value == num){
				if(eH == null){
					eH = head ;
					eE = head ;
				}else{
					eE.next = head ;
					eE = head ;
				}
			}else{
				if(bH == null){
					bH = head ;
					bE = head ;
				}else{
					bE.next = head ;
					bE = head ;
				}
			}
			head = next ;
		}
		if(sE!=null){
			sE.next = eH ;
			eE = eE == null ? sE : eE ;
		}
		if(eE!=null){
			eE.next = bH ;
		}
		return sH!=null ? sH : eH!=null ? eH : bH ;
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
//		head1 = fun1(head1, 8);
		head1 = fun2(head1, 8);
		printLinkedList(head1);

	}
}
