/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=list&envId=ruypfpvi
[Pattern]: 2 Pointers on diff array, merge with while loop
[Tips]: use 3 while loop, onc to merge both, two to merge the other 2 ones when only one of them has elements. 
[Revision]: 1
[Confidence]: 30%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[Intution]: 
"""
For merging, i can have onlt 2 conditions, 
when both have the value, or when only one list has the values left. 
"""
[/Intution]
[QuestionNote]: 
"""

"""
[QuestionNote]
[/Note]
*/

/*
https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=list&envId=ruypfpvi
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // validate:

        // init:
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        
        // process:
        // loop & condition and increment:
        // when both the LL has elements. 
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                // to weave it, i need to set current.next = l1; curr's next should point to found node. 
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
                
            } else{
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        // when only one list still has elements
        while(l1 != null){
            curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
        }


        while(l2 != null){
            curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
        }

        return head.next;
    }
}