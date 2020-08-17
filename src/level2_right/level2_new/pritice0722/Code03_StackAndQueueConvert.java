package level2_right.level2_new.pritice0722;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code03_StackAndQueueConvert {
    public static class TwoStackQueue {
        private Stack<Integer> stackData;
        private Stack<Integer> help;

        public TwoStackQueue() {
            stackData = new Stack<Integer>();
            help = new Stack<Integer>();
        }

        private void push(int num) {
            stackData.push(num);
        }
        // 1
        // 2
        // 3
        // 5
        private Integer peek() {
            if(stackData.isEmpty()){
               return null;
            }
            exchange();
            int res = help.peek();
            swap();
            return res;
        }

        private Integer poll() {
            if (stackData.isEmpty()) {
               return null;
            }
            exchange();
            int res = help.pop();
            swap();
            return res;
        }

        private void exchange() {
            while (!stackData.empty()) {
                help.push(stackData.pop());
            }
        }

        private void swap() {
            Stack<Integer> tem = stackData;
            stackData = help;
            help = tem;
        }
    }
    public static class TwoQueueStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        private void push(int num) {
            queue.add(num);
        }

        public Integer peek() {
            if (queue.isEmpty()) {
                return null;
            }
            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public Integer pop() {
            if(queue.isEmpty()){
                return null;
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            swap();
            return help.poll();
        }

        private void swap() {
            Queue<Integer> tem = help;
            help = queue;
            queue = tem;
        }

    }
}
