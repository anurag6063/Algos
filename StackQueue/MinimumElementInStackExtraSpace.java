/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/min-stack/description/?envType=list&envId=pheho7s5
[Pattern]: Stack - 2 of them. one for all ops except min, one for min
[Tips]: 
[Revision]: 1
[Confidence]: 80%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

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
    // kept outside so that all the functions can use it
    Stack<Integer> minStack;
    Stack<Integer> min;

    // initialize and empty one
    public MinStack() {
       minStack = new Stack<>();
       min = new Stack<>();
    }
    
    public void push(int val) {
        minStack.push(val);
        // if(min.isEmpty()) min.push(val);

        // push in min only when the value is really minimum or equal
        // equal is handeled in case duplicate values are present in other stack.
        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
        
        }

    public void pop() {
        // so the peeking first so that i don't have to pop and then add it again back
        if (minStack.peek().equals(min.peek())) {
// #Note: equals works here and not == or else i had to get them in 2 variables and them compare. for stack.peek()
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