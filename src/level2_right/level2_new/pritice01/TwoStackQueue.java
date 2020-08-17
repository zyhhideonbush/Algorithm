package level2_right.level2_new.pritice01;

import java.util.Stack;

public class TwoStackQueue {
	public static class StackQueue{
		private Stack<Integer> PushStack ;
		private Stack<Integer> PopStack ;
		
		public StackQueue(){
			this.PushStack = new Stack<Integer>() ;
			this.PopStack = new Stack<Integer>() ;
		}
		
		public void push(int value){
			this.PushStack.push(value) ;
		}
		
		public int poll(){
			if(PopStack.isEmpty()&&PushStack.isEmpty()){
				throw new RuntimeException("This queue is empty") ;
			}else if(PopStack.isEmpty()){
				while(!PushStack.isEmpty()){
					PopStack.push(PushStack.pop()) ;
				}
			}
			return PopStack.pop() ;
		}
		
		public int peek(){
			if(PopStack.isEmpty()&&PushStack.isEmpty()){
				throw new RuntimeException("This queue is empty") ;
			}else if(PopStack.isEmpty()){
				while(!PushStack.isEmpty()){
					PopStack.push(PushStack.pop()) ;
				}
			}
			return PopStack.peek() ;
		}
	}
}
