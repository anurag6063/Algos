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