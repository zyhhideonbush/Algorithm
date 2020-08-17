package level2_right.level2_new.pritice01;

public class Array_to_Stack {
	
	public static class ArrayStackk {
		private Integer[] arr ;
		private Integer index ;
		
		public ArrayStackk(int size){
			if(size<0){
				throw new IllegalArgumentException("The init size is less than 0 ") ;
			}
			arr = new Integer[size] ;
			index = 0 ; 
		}
		
		public void push(int value) {
			if(value==arr.length){
				throw new ArrayIndexOutOfBoundsException("This stack is full") ;
			}
			arr[index++] = value ;
		}
		
		public int pop(){
			if(index == 0 ){
				throw new ArrayIndexOutOfBoundsException("This stack is null") ;
			}
			return arr[--index] ;
		}
		
		public int peek(){
			if(index == 0 ){
				throw new ArrayIndexOutOfBoundsException("This stack is null") ;
			}
			return arr[index-1] ;
		}
	}
	
}

