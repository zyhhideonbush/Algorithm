package level2_right.level2_new.pritice01;

import level2_right.Code_14_FindFirstIntersectNode.Node;

public class FindFirstIntersectNode {
	public static class Node{
		public int value ;
		public Node next ;
		public Node(int val){
			this.value = val ;
		}
	}
	
	public static Node fun(Node head1,Node head2){
		
		if(head1==null||head2==null){
			return null ;
		}
		Node Loop1 = getLoop(head1) ;
		Node Loop2 = getLoop(head2) ;
		
		if(Loop1 == null && Loop2 == null){
			return noLoop(head1,head2) ;
		}else if(Loop1!=null && Loop2!=null){
			return bothLoop(head1,head2,Loop1,Loop2) ;
		}
		return null ;
	}
	
	private static Node getLoop(Node head) {
		if(head==null||head.next==null||head.next.next==null){
			return null ;
		}
		Node node1 = head.next ;
		Node node2 = head.next.next ;
		while(node1!=node2){
			if(node2.next==null||node2.next.next==null){
				return null ;
			}
			node1 = node1.next ;
			node2 = node2.next.next ;
		}
		node2 = head ;
		while(node1!=node2){
			node1 = node1.next ;
			node2 = node2.next ;
		}
		return node1 ;
	}
	
	private static Node noLoop(Node head1, Node head2) {
		if(head1==null||head2==null){
			return null ;
		}
		int num = 0 ;
		Node node1 = head1 ;
		Node node2 = head2 ;
		while(node1.next!=null){
			num++ ;
			node1 = node1.next ;
		}
		while(node2.next!=null){
			num-- ;
			node2 = node2.next ;
		}
		if(node1!=node2){
			return null ;
		}
		node1 = num>0 ? head1 : head2 ;
		num = Math.abs(num) ;
		node2 = node1 == head1 ? head2 : head1 ;
		while(num!=0){
			node1 = node1.next ;
			num-- ;
		}
		while(node1!=node2){
			node1 = node1.next ;
			node2 = node2.next ;
		}
		return node1;
	}
	
	private static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
		Node node1 = null ;
		Node node2 = null ;
		if(loop1==loop2){
			node1 = head1 ;
			node2 = head2 ;
			int num = 0 ;
			while(node1!=loop1){
				num++ ;
				node1 = node1.next ;
			}
			while(node2!=loop2){
				num-- ;
				node2 = node2.next ;
			}
			node1 = num>0 ? head1 : head2 ;
			num = Math.abs(num) ;
			node2 = node1 == head1 ? head2 : head1 ;
			while(num!=0){
				num-- ;
				node1 = node1.next ;
			}
			while(node1!=node2){
				node1 = node1.next ;
				node2 = node2.next ;
			}
			return node1 ;
		}else{
			node1 = loop1.next ;
			while(node1!=loop1){
				if(node1==loop2){
					return loop1 ;
				}
				node1 = node1.next ;
			}
			return null ;
		}
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
		System.out.println(fun(head1, head2).value);

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
		System.out.println(fun(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(fun(head1, head2).value);

	}

	

	
}
