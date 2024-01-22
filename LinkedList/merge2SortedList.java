/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=list&envId=ruypfpvi
[Pattern]: 2 Pointers on diff array, merge with while loop
[Tips]: use 3 while loop, onc to merge both, two to merge the other 2 ones. 
[Revision]: 1
[Confidence]: 30%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

/*
https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=list&envId=ruypfpvi
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {      

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                System.out.println(current.val);
                current.next = l1;
                l1 = l1.next;
            }else{
                System.out.println(current.val);
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        // remaining, we just need to change the head. no other action required.
        if(l1 != null){
            System.out.println("l1 "+current.val);
            current.next = l1;
        }else{
            System.out.println("l2 "+current.val);
            current.next = l2;
        }

        // System.out.println(current.val + " "+ node.val + " "+ node.next.val);
        return dummy.next;
        
    }
}


  // ListNode dummy = new ListNode(0);
        // ListNode current = dummy;

        // while (l1 != null && l2 != null) {
        //     if (l1.val < l2.val) {
                 
        //         current.next = l1;
        //         l1 = l1.next;
        //         System.out.println(current.val);
        //     } else {
                 
        //         current.next = l2;
        //         l2 = l2.next;
        //         System.out.println(current.val);
        //     }
        //     current = current.next;
        // }

        // // If one of the lists is not empty, append the remaining nodes
        // if (l1 != null) {
        //     System.out.println("l1 "+current.val);
        //     current.next = l1;
        // } else {
        //     System.out.println("l2 "+current.val);
        //     current.next = l2;
        // }

        // return dummy.next;
        