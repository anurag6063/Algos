
/*
[Note]
[Reference]: https://leetcode.com/problems/reorder-list/solutions/1640806/java-2-approach-2-pointer-approach
[Problem]: https://leetcode.com/problems/reorder-list/?envType=list&envId=ruypfpvi
[Pattern]: reverse; reorder & merge all in one
[Tips]: First split the LL in 2 , then reverse the second half, then merge the 2 halfs
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: First split the LL in 2 , then reverse the second half, then merge the 2 halfs 
[Code]	
	
[/Code]
[/Note]
*/

class Solution {
   
    public ListNode midNode(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head, prev = null, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reorderList(ListNode head){
      // find the midnode first
      ListNode midNode = midNode(head);
      ListNode nextToMid = midNode.next;
      midNode.next = null; // we got a pointer to this and now ended the link, this will make it into 2 lists.
      
      ListNode p2 = reverse(nextToMid);
      ListNode p1 = head, p1Next;

      while(p1 != null && p2 != null){
          p1Next = p1.next;
          p1.next = p2;

          p1 = p2;
          p2 = p1Next;
      }
  }
}