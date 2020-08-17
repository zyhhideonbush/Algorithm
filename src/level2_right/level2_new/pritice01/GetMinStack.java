package level2_right.level2_new.pritice01;

import java.util.Stack;

import level2_right.Code_02_GetMinStack.MyStack1;

public class GetMinStack {
	public static class MyStack{
		private Stack<Integer> DataStack ;
		private Stack<Integer> MinStack ;
		
		public MyStack(){
			this.DataStack = new Stack<Integer>() ;
			this.MinStack = new Stack<Integer>() ;
		}
		
		public void push(int value){
			if(this.MinStack.isEmpty()){
				this.MinStack.push(value) ;
			}else if(value<=this.getMin()){
				this.MinStack.push(value) ;
			}
			this.DataStack.push(value) ;
		}
		
		public Integer pop(){
			if(this.DataStack.isEmpty()){
				throw new RuntimeException("Your stack is empty") ;
			}
			if(this.DataStack.peek() == this.getMin()){
				this.MinStack.pop() ;
			}
			return this.DataStack.pop() ;
		}
		
		public Integer peek(){
			if(this.DataStack.isEmpty()){
				throw new RuntimeException("Your stack is empty") ;
			}
			return this.DataStack.peek() ;
		}

		private int getMin() {
			if(this.MinStack.isEmpty()){
				throw new RuntimeException("Your stack is empty") ;
			}
			return this.MinStack.peek();
		}
	}
	
	public static void main(String[] args) {
		MyStack1 stack1 = new MyStack1();
		stack1.push(3);
		System.out.println(stack1.getmin());
		stack1.push(4);
		System.out.println(stack1.getmin());
		stack1.push(1);
		System.out.println(stack1.getmin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getmin());

		System.out.println("=============");

		MyStack1 stack2 = new MyStack1();
		stack2.push(3);
		System.out.println(stack2.getmin());
		stack2.push(4);
		System.out.println(stack2.getmin());
		stack2.push(1);
		System.out.println(stack2.getmin());
		System.out.println(stack2.pop());
		System.out.println(stack2.getmin());
	}

}
