/*
[Note]
[Reference]: https://leetcode.com/problems/kth-largest-element-in-a-stream/solutions/3553822/java-priorityqueue-7-lines-clean-code
[Problem]: https://leetcode.com/problems/kth-largest-element-in-a-stream/
[Pattern]: Heap
[Tips]: use add from instructor; keep K outside
[Revision]: 1
[Confidence]: 50%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

class KthLargest {

    PriorityQueue<Integer> top = new PriorityQueue<Integer>();
    int k ;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums){
            add(num);
           
        }
    }
    
    public int add(int val) {
        // the queue does not has a size, it lets add whatever comes in. 
        top.offer(val);  
        // i have to make cure if the elements have increased too many, then reduce an element 
        // so tat finally i can get tthe top when i finally do a peek.
        if(top.size() > k){
            top.poll();
        }  
        // the pd size has been set to reuqired one. 
        // queue peek will have the answer/ 
        return top.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */