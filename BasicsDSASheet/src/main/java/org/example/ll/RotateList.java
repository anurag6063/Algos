package java.org.example.ll;
/*
* https://leetcode.com/problems/rotate-list/submissions/
*/
public class RotateList {

  public ListNode rotateRight(ListNode head, int k) {
    if(head == null){
      return head;
    }
    ListNode i = head;
    int x = 0;
    while( i != null){
      x++;
      i = i.next;
    }
    ListNode dummy = head;
    ListNode slow = head;
    ListNode fast = head;

    int count = 0;
    while(fast.next != null){
      // System.out.println(fast.val);
      if(count >= k%x){
        slow = slow.next;;
      }
      fast = fast.next;
      count++;
    }

    // System.out.println(slow.val);
    // System.out.println(fast.val);
    fast.next = dummy;
    head = slow.next;
    slow.next = null;

    return head;
  }
}
