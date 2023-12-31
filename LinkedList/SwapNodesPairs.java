/*
[Note]
[Reference]: YT solution; https://www.youtube.com/watch?v=o811TZLAWOo
[Problem]: https://leetcode.com/problems/swap-nodes-in-pairs/?envType=list&envId=ruypfpvi
[Pattern]: Swap nodes of LL
[Tips]: Have a pointer before and after the first and second (to be switched; point prev = first && first = after;
[Revision]: 1
[Confidence]: 30%
[Next]: Practice 
[Steps]: Find pointers befor and after, switch and move ahead
[Code]	
	All
[/Code]
[/Note]
*/
// best colution with best names - mine
class Solution {
    public ListNode swapPairs(ListNode head) {

    // create a dummy node, to start from so as to keep curr easily
    ListNode dummy = new ListNode(0);
    dummy.next = head; // link it to next/head

    // now we need two pointers to swap curr and prev
    ListNode first = head;
    ListNode prev = dummy;

    // loop till end
    while(first != null && first.next !=null  ){ // we need a pair to go ahead
        
        // save ptrs
        ListNode second = first.next;
        ListNode after = first.next.next;
        

        // swap
        second.next = first;
        first.next = after;
        prev.next = second;
        

        // System.out.printf("prev %d, current: %d , first %d , second %d \n", prev.val, current.val, after.val, second.val);
        
        prev = first;
        first = after;
    }

    // when i reach end, reach dummy next will the head
    return dummy.next;

    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {

    // create a dummy node, to start from so as to keep curr easily
    ListNode dummy = new ListNode(0);
    dummy.next = head; // link it to next/head

    // now we need two pointers to swap curr and prev
    ListNode current = head;
    ListNode prev = dummy;

    // loo[ till end]
    while(current != null && current.next !=null  ){
        
        // swap
        ListNode first = current;
        ListNode second = current.next;

        // swapping with three nodes
        // the sequence of the switch is also important.
        prev.next = second; // catch hold of the second, since that is about to become first and prev's next should always point to first node.
        first.next = second.next; // where ever second's node was pointing, first needs to point
        second.next = first; // and the first needs to be referenced by the second' next
        
        // after swap, prev should always come to first and current shoul go to first.next
        // this is done since now we need to move ahead of first
        prev = first;
        current = first.next;
    }
    // when i reach end, reach dummy next will the head
    return dummy.next;





        // // create a dummy node
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;

        // ListNode prev = dummy; // this is before the head now
        // ListNode current = head;

        // while(current != null && current.next != null){
        //     // nodes to be swapped
        //     ListNode first = current;
        //     ListNode second = current.next;

        //     // update the pointers
        //     prev.next = second;
        //     first.next = second.next;
        //     second.next = first;

        //     // move the pointers
        //     prev = first;
        //     current = first.next;
            
        // }

        // return dummy.next;
    }
}