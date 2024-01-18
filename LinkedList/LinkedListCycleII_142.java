/*
[Note]
[Reference]: https://leetcode.com/problems/linked-list-cycle-ii/solutions/3274329/clean-codes-full-explanation-floyd-s-cycle-finding-algorithm-c-java-python3
[Problem]: https://leetcode.com/problems/linked-list-cycle-ii/?envType=list&envId=ecumdrrd
[Pattern]: LL, slow fast; 2 pointers
[Tips]: slow and fast; both together
[Revision]: 1
[Confidence]: 10%
[Next]: Practice 
[Steps]: find the loop if yes, set slow = head; till slow != fast; increase slow and fast by single step
[Code]	
	// fininf the head post finding the link
	slow = head;
	while(slow != fast){
		slow = slow.next;
		fast = fast.next;
	}
	return slow;
[/Code]
[Tags]: 2Pointers
[/Note]
*/


public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                // when they meet

                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}