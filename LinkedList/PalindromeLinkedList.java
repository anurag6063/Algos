
/*
[Note]
[Reference]: https://leetcode.com/problems/palindrome-linked-list/solutions/510629/java-0-ms-beating-100-o-n-time-o-1-space-simple-solution-with-explanations
[Problem]: https://leetcode.com/problems/palindrome-linked-list/?envType=list&envId=ruypfpvi
[Pattern]: 2 Pointers , LL , Reversal 
[Tips]: Go to middle Split in 2, reverse, compare
[Revision]: 1
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
	
	// using new way of reversal of nodes
	 public boolean isPalindrome(ListNode head){
      
        if(head == null || head.next == null) return true;
        
        ListNode fast = head;
        // ListNode dummy = new ListNode(0, head);
        ListNode curr = head; // slow one
        ListNode prev = null;
        ListNode next = null;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            
            // need to reverse the first half
            // next -> curr.next -> prev -> curr 
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;            
            
        }
        
        ListNode p1 = prev;
        ListNode p2 = null;
        
        if(fast == null){
            p2 = curr;
        }else if(fast.next == null){
            p2 = curr.next;
        }
    
        // now half has reached half
    
        while(p1 != null && p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
    return true;
    }
	
	// ------------------
	
	
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