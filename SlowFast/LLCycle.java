/*
link: https://www.educative.io/courses/grokking-coding-interview-patterns-java/linked-list-cycle
Check whether or not a linked list contains a cycle. If a cycle exists, return TRUE. Otherwise, return FALSE. The cycle means that at least one node can be reached again by traversing the next pointer
*/

import java.util.*;

public class CycleDetection{
    public static boolean detectCycle(LinkedListNode head) {
    
    // if has no elements anyways its empty so no cycle.
    if(head == null) return false;

    // initalize the slow and fast 2 pointers to head.
    LinkedListNode slow = head;
    LinkedListNode fast = head.next;

    // while(fast != null && fast.next != null) this statement truly lets us go the end element. 
    while(fast != null && fast.next != null){
      if( fast == slow){
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}