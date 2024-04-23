
/*
[Note]
[Reference]: Solution 
[Problem]: https://leetcode.com/problems/linked-list-cycle/description/?envType=list&envId=ruypfpvi
[Pattern]: slow and fast LL
[Tips]: while - fast and fast next, first move pointer and then check; while -> fast.next != null && fast.next.next != null
[Revision]: 1
[Confidence]: 30%
[Next]: Practice 
[Steps]: initilaize 2 pointers slow and fast, run while, move forward, check slow == fast; return; else at end return false.
[Tags]: #2Pointers
[Code]	
	
[/Code]
[/Note]
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
            
        }

        return false;
    }
}