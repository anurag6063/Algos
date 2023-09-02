/**
 * link: https://www.educative.io/courses/grokking-coding-interview-patterns-java/remove-nth-node-from-end-of-list
 * Given a singly linked list, remove the  
 node from the end of the list and return its head.
 * 
 * 
 */


import java.util.*;

class ReverseLinkedList {
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        

        // intilize 2 pointers
    // 2 pointer approach.
    // initialize:            left and right to 0 and 0 ie. head
    // do till:              while(right != null) right reaches the end, the last element is null.
    // break and return if:  will go till end, ie. while(right != null) will work.
    // change:                  increase right since starting, increase left only after n+1 iteraction.
    //                        i use n+1 iteraction because i need to remove the Nth element,
    //                           So moving the next will be easier from Nth-1 so use N=1 to intialize the pointer.


        LinkedListNode left = head;
        LinkedListNode right = head;
        
        int i = n+1;
        while(right != null){
            right = right.next;

            if(i > 0){
                i--;
            }else{
                left = left.next;
            }
            if(left == head){
                System.out.println("stil first"+ i);
            }
           
        } 
        if(i == 1 && left == head && right == null){ 
               System.out.println("remove first");
                head = head.next;
               return head;
               }
        left.next = left.next.next;
        return head;
    }
}
