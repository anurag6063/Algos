/*
[Note]
[Reference]: https://leetcode.com/problems/kth-largest-element-in-a-stream/solutions/3553822/java-priorityqueue-7-lines-clean-code
[Problem]: https://leetcode.com/problems/kth-largest-element-in-a-stream/
[Pattern]: Heap
[Tips]: use add from cinstructor; keep K outside
[Revision]: 0
[Confidence]: 10%
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
        top.offer(val);  
        if(top.size() > k){
            top.poll();
        }  
        
        return top.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */