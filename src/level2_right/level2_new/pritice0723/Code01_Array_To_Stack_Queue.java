package level2_right.level2_new.pritice0723;

public class Code01_Array_To_Stack_Queue {
    public static class ArrayStack {
        private int[] arr;
        private int index;

        public ArrayStack(int initSize) {
            if(initSize < 0) {
                throw new IllegalArgumentException("Initsize can not less than 0");
            }
            arr = new int[initSize];
            index = 0;
        }

        private void push(int num) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("This stack has been full");
            }
            arr[index ++] = num;
        }

        private Integer peek() {
            if (index == 0) {
                return null;
            }
            return arr[index - 1];
        }

        private Integer pop() {
            if (index == 0) {
               return null;
            }
            return arr[--index];
        }
    }

    public static class ArrayQueue {
        private int[] arr;
        private int first;
        private int last;
        private int size;

        public ArrayQueue(int initSize) {
            arr = new int[initSize];
            first = 0;
            last = 0;
            size = 0;
        }

        private void add(int num) {
            if (size == arr.length) {
               throw new IllegalArgumentException("This queue is full");
            }
            arr[first] = num;
            first = first + 1 == arr.length ? 0 : first + 1;
            size++;
        }

        private Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[last];
        }

        private Integer poll() {
            if (size == 0) {
               return null;
            }
            int res = arr[last];
            last = last + 1 == arr.length ? 0 : last + 1;
            size--;
            return res;
        }
    }
}
