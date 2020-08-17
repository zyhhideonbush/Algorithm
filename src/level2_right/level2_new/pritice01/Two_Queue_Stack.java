package level2_right.level2_new.pritice01;

import java.util.LinkedList;
import java.util.Queue;

public class Two_Queue_Stack {
	public static class QueueStack{
		private Queue<Integer> HelpQueue ;
		private Queue<Integer> MainQueue ;
		
		public QueueStack(){
			this.HelpQueue = new LinkedList<Integer>() ;
			this.MainQueue = new LinkedList<Integer>() ;
		}	
		
		public void Push(int value){
			MainQueue.add(value) ;
		}
		
		public int pop(){
			if(MainQueue.isEmpty()){
				throw new RuntimeException("Your stack is empty") ;
			}
			while(MainQueue.size()!=1){
				HelpQueue.add(MainQueue.poll()) ;
			}
			int res = MainQueue.poll() ;
			swap() ;
			return res ;
		}
		
		private void swap() {
			Queue<Integer> tem = MainQueue ;
			MainQueue = HelpQueue ;
			HelpQueue = tem ;
			
		}

		public int peek(){
			if(MainQueue.isEmpty()){
				throw new RuntimeException("Your stack is empty") ;
			}
			while(MainQueue.size()!=1){
				HelpQueue.add(MainQueue.poll()) ;
			}
			int res = MainQueue.poll() ;
			HelpQueue.add(res) ;
			swap() ;
			return res ;
		}
	}
	
	
}
