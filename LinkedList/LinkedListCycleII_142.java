/*
[Note]
[Reference]: https://leetcode.com/problems/linked-list-cycle-ii/solutions/3274329/clean-codes-full-explanation-floyd-s-cycle-finding-algorithm-c-java-python3
[Problem]: https://leetcode.com/problems/linked-list-cycle-ii/?envType=list&envId=ecumdrrd
[Pattern]: LL, slow fast; 2 pointers
[Tips]: slow and fast; both together
[Revision]: 2
[Confidence]: 10%
[Next]: Practice 
[Steps]: find the loop if yes, set slow = head; till slow != fast; increase slow and fast by single step
[Code]	
	// find the head post finding the cyclic point
	slow = head;
	while(slow != fast){
		slow = slow.next;
		fast = fast.next;
	}
	return slow;
[/Code]
[Tags]: 2Pointers
[Intution]: 
"""
To find cycle the only way is to have a slow and fast pointers. 
Reset inside slow to head and then move at same pace. 
"""
[/Intution]
[QuestionNote]: 
"""

"""
[QuestionNote]
[/Note]
*/


public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
		
		// find the intersection point with slow and fast
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

			// this is when we have found the intersection point.
            if(slow == fast){
                // when they meet
				// now to find the point from where the cycle started.
                slow = head;
				
				// till they don't meet keep moving slow and fast both
                while(slow != fast){
                    // MEM: now both needs to go at same speed.
                    slow = slow.next;
                    fast = fast.next;
                }
				
				// now slow is the answer. 
                return slow;
            }
        }

        return null;
    }
}