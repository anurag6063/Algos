
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
[Intution]: 
"""
To find cycle the only way is to have a slow and fast pointers. 
"""
[/Intution]
[QuestionNote]: 
"""

"""
[QuestionNote]
[/Note]
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        // validate:
        if(head == null) return false;

        // init:
        ListNode slow = head;
        ListNode fast = head;

        // loop & condition; 
        while(fast != null && fast.next != null){
            // init:

            // increment:
            slow = slow.next;
            fast = fast.next.next;

            // process:
            if(slow == fast){
                return true;
            }

        }

        return false;
    }
}