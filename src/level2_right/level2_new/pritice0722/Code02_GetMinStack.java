package level2_right.level2_new.pritice0722;

import level2_right.Code_02_GetMinStack;

import java.util.Stack;

public class Code02_GetMinStack {
    public static class MyStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MyStack(){
            dataStack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(Integer num){
            if (dataStack.isEmpty()) {
                minStack.push(num);
            } else {
                minStack.push(minStack.peek() < num ? minStack.peek() : num);
            }
            dataStack.push(num);
        }

        public Integer pop(){
            if(dataStack.isEmpty()){
                return null;
            }
            minStack.pop();
            return dataStack.pop();
        }

        public Integer getmin(){
            if(dataStack.isEmpty()){
                return null;
            }
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        Code02_GetMinStack.MyStack stack1 = new Code02_GetMinStack.MyStack();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());

        System.out.println("=============");
    }

}
