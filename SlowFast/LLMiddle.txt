/* link : https://www.educative.io/courses/grokking-coding-interview-patterns-java/middle-of-the-linked-list

    Try to solve the Middle of the Linked List problem.
    Given the head of a singly linked list, return the middle node of the linked list. If the number of nodes in the linked list is even, there will be two middle nodes, so return the second one.


    Q: this will find second element if there are 2 middle, how do we find the first. 
*/
import java.util.*;
public class MiddleNode{
    public static LinkedListNode middleNode(LinkedListNode head) {
    

    // initalize 2 pointers on the head
    LinkedListNode slow = head;
    LinkedListNode fast = head;

// N: how does th last node looks like. It has element but it point to NULL
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