public class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        // if this new value changes the min, pop the previous min before it
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public int pop() {
        int ret = stack.pop();
        // if the value you popped is the min value
        // then the previous min value will be stored one before it
        // so pop again and set this to min
        if (ret == min) {
            min = stack.pop();
        }
        return ret;
    }

    public int getMin() {
        return this.min;
    }

    public int top() {
        return stack.peek();
    }
}