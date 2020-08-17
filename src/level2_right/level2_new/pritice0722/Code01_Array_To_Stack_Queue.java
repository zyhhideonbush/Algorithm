package level2_right.level2_new.pritice0722;

public class Code01_Array_To_Stack_Queue {

    public static class ArrayStack {
        private Integer[] arr;
        private int index;

        public ArrayStack(int initsize){
            if(initsize < 0){
                throw new IllegalArgumentException("This init size is less than 0");
            }
            arr = new Integer[initsize];
            index = - 1;
        }

        public Integer peek(){
            if(index == - 1){
                return null;
            }
            return arr[index];
        }

        public void push(int num){
            if(index == arr.length - 1){
                throw new ArrayIndexOutOfBoundsException("This ArrayStack is full");
            }
            arr[++index] = num;
        }

        public Integer pop(){
            if(index == - 1){
                throw new ArrayIndexOutOfBoundsException("This ArraysStack is null");
            }
            return arr[index--];
        }
    }
    public static class ArrayQueue {
        private Integer[] arr;
        private Integer first;
        private Integer last;
        private Integer size;

        public ArrayQueue(int initsize){
            if(size < 0){
                throw new IllegalArgumentException("Initsize can not less than 0");
            }
            arr = new Integer[initsize];
            first = 0;
            last = 0;
            size = 0;
        }

        public Integer peek(){
            if(size == 0){
                return null;
            }
            return arr[first];
        }

        public void push(int num){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("This ArrayQueue is full");
            }
            size ++;
            arr[last] = num;
            last = last + 1 == arr.length ? 0 : last + 1;
        }

        public Integer pop(){
            if(size == 0){
                return null;
            }
            size --;
            int tem = first;
            first = first + 1 == arr.length ? 0 : first + 1;
            return arr[tem];
        }
    }
}
