
/*
[Note]
[Reference]: https://leetcode.com/problems/palindrome-linked-list/solutions/510629/java-0-ms-beating-100-o-n-time-o-1-space-simple-solution-with-explanations
[Problem]: https://leetcode.com/problems/palindrome-linked-list/?envType=list&envId=ruypfpvi
[Pattern]: Split in 2, reverse, compare
[Tips]: split, reverse, compare 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: Split in 2, reverse, compare
[Code]	
	
[/Code]
[/Note]
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        // reverse the first half
        ListNode prevSlowNode = null;
        ListNode slowNode = head;
        ListNode fastNode = head;

        while(fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;

            ListNode nextSlowNode = slowNode.next;
            slowNode.next = prevSlowNode;
            prevSlowNode = slowNode;
            slowNode = nextSlowNode;
        }
        ListNode firstHalfPointer = prevSlowNode;   
        // find pointer to the start of first and second half
        ListNode secondHalfPointer = null;
        if(fastNode == null){ // no of elements even
            secondHalfPointer = slowNode;
        }else if(fastNode.next == null) // odd nodess
        {
            secondHalfPointer = slowNode.next;
        }

        // now compare both the halves
        while(firstHalfPointer != null && secondHalfPointer != null){
            if(firstHalfPointer.val != secondHalfPointer.val){
                return false;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        return true;
    }
}