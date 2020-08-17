package level2_right.level2_new.pritice01;

import java.util.Stack;


public class IsPalindromeList {
	public static class Node{
		private int value ;
		private Node next ;
		
		public Node(int data){
			this.value = data ;
		}
	}
	
	public static boolean isPalindrome1(Node head){
		Stack<Node> stack = new Stack<Node>() ;
		Node cur = head ;
		while(cur!=null){
			stack.push(cur) ;
			cur = cur.next ;
		}
		while(head!=null){
			if(stack.pop().value != head.value){
				return false ;
			}
			head = head.next ;
		}
		return true ;
	}
	
	public static boolean isPalindrome2(Node head){
		if(head==null||head.next==null){
			return true ;
		}
		Node one = head.next ;
		Node two = head ;
		while(two.next!=null&&two.next.next!=null){
			one = one.next ;
			two = two.next.next ;
		}
		Stack<Node> stack = new Stack<Node>() ;
		while(one!=null){
			stack.push(one) ;
			one = one.next ;
		}
		while(!stack.isEmpty()){
			if(stack.pop().value!=head.value){
				return false ;
			}
			head = head.next ;
		}
		return true;
		
	}
	
	public static boolean isPalindrome3(Node head){
		if(head==null||head.next==null){
			return true ;
		}
		Node n1 = head ;
		Node n2 = head ;
		while(n2.next!=null&&n2.next.next!=null){
			n1 = n1.next ;
			n2 = n2.next.next ;
		}
		n2 = n1.next ;
		n1.next = null ;
		Node n3 = null ;
		while(n2!=null){
			n3 = n2.next ;
			n2.next = n1 ;
			n1 = n2 ;
			n2 = n3;
		}
		n3 = n1 ;
		n2 = head ;
		boolean res = true ;
		while(n1!=null&&n2!=null){
			if(n1.value!=n2.value){
				res = false ;
				break ;
			}
			n1 = n1.next ;
			n2 = n2.next ;
		}
		n1 = n3.next ;
		n3.next = null ;
		while(n1!=null){
			n2 = n1.next ;
			n1.next = n3 ;
			n3 = n1 ;
			n1 = n2 ;
		}
		return res;
		
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

		Node head = null;
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

	}

}
