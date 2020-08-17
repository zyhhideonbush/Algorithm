package level2_right.level2_new.pritice0723;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code03_StackAndQueueConvert {
    public static class TwoStackQueue {
        private Stack<Integer> dataStack;
        private Stack<Integer> help;

        public TwoStackQueue() {
            dataStack = new Stack<Integer>();
            help = new Stack<Integer>();
        }

        private void add(int num) {
            dataStack.push(num);
        }

        private Integer peek() {
            if (dataStack.isEmpty()) {
                return null;
            }
            while (!dataStack.isEmpty()) {
                help.push(dataStack.pop());
            }
            swap();
            return dataStack.peek();
        }

        private Integer poll() {
            if (dataStack.isEmpty()) {
                return null;
            }
            while (!dataStack.isEmpty()) {
                help.push(dataStack.pop());
            }
            swap();
            return dataStack.pop();
        }

        private void swap() {
            Stack<Integer> tem = dataStack;
            dataStack = help;
            help = tem;
        }
    }
    public static class TwoQueueStack {
        private Queue<Integer> dataQueue;
        private Queue<Integer> help;

        public TwoQueueStack() {
            dataQueue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        private void push(int num) {
            dataQueue.add(num);
        }

        private Integer peek() {
            if (dataQueue.isEmpty()) {
                return null;
            }
            dao();
            swap();
            return dataQueue.peek();
        }

        private Integer pop() {
            if (dataQueue.isEmpty()) {
                return null;
            }
            dao();
            swap();
            return dataQueue.poll();
        }

        private void swap() {
            Queue<Integer> tem = dataQueue;
            dataQueue = help;
            help = tem;
        }

        private void dao() {
            while (!dataQueue.isEmpty()) {
                help.add(dataQueue.poll());
            }
        }


    }
}
