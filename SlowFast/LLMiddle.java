import java.util.*;

// The code in "LinkedList.java" can be used to create a linked list out of a list. 
// The code in "LinkedListTraversal.java" can be used to traverse the linked list.
// The code in "LinkedListReversal.java" can be used to reverse the linked list.

public class MiddleNode{
    public static LinkedListNode middleNode(LinkedListNode head) {
    
    LinkedListNode slow = head;
    LinkedListNode fast = head;

// how does th last node looks like. It has element but it point to NULL
// else it can be NULL itself. 
// how does a valid node looks.
// it has a data ie not null and it's next also points to something. 
// thus this if condition.

    while( fast != null && fast.next != null){

      slow = slow.next;
      fast = fast.next.next;
      System.out.println("slow: "+ slow.data);

    }

    return slow;
  }
}