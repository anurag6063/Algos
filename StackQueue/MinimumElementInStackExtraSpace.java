/*
1. minimum element in stack with extra space, supporting stack.
2. push and pop is done on the main stack and it's also supported from there.
3. then to support the minimum element finding. use supporting stack.
4. Push: 
	when a element is main stack is pushed and it's smaller and equal to that element in top of supporting stack
	let it get pushed.
	
	
	We have to push even when we have same element in SS, so that if there are dupicate element our code can handle it. 
5. Pop: when an elementis popped from the main stack.
	pop from main stack.
	check if the same element is on top of the SS. 
	

*/

class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> min;
    public MinStack() {
       minStack = new Stack<>();
       min = new Stack<>();
    }
    
    public void push(int val) {
        minStack.push(val);
        // if(min.isEmpty()) min.push(val);

        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
        // if(min.size()>0){
        //     System.out.println(min.peek() + " MIN " +min.size());
        // }
        // System.out.println(minStack.peek() + " "+ minStack.size());
    }

    public void pop() {
    if (minStack.peek().equals(min.peek())) {
        min.pop();
    }
    minStack.pop();

}

    public int top() {
       return minStack.peek();
    }
    
    public int getMin() {
        // return !min.isEmpty()? min.peek(): -1;
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */