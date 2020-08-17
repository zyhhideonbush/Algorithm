package level2_right.level2_new.pritice01;

public class Array_To_Queue {
	public static class ArrayQueue{
		
		private Integer[] arr ;
		private Integer start ;
		private Integer end ;
		private Integer size ;
		public ArrayQueue(Integer initsize){
			if(initsize<0){
				throw new IllegalArgumentException("The init size is less than 0 ") ;
			}
			arr = new Integer[initsize] ;
			start = 0 ;
			end = 0 ;
			size = 0 ;
		}
		
		public void push(int value){
			if(size==arr.length){
				throw new ArrayIndexOutOfBoundsException("This queue is full") ;
			}
			size++ ;
			arr[end] = value ;
			end = end == arr.length-1 ? 0 : end+1 ;
		}
		
		public int poll(){
			if(size==0){
				throw new ArrayIndexOutOfBoundsException("This queue is null") ;
			}
			size-- ;
			int tem = start ;
			start = start==arr.length-1 ? 0 : start+1 ;
			return arr[start] ;
		}
		
		public int peek(){
			if(size==0){
				throw new ArrayIndexOutOfBoundsException("This queue is null") ;
			}
			return arr[start] ;
		}
	}
}
