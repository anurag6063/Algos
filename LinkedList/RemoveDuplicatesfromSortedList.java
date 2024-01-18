/*
[Note]
[Reference]: CGPT
[Problem]: https://leetcode.com/problems/remove-duplicates-from-sorted-list/?envType=list&envId=ruypfpvi
[Pattern]: Modify links of LL; #2Pointers
[Tips]: Once we reset the pointers, other nodes will still be pointing to the LL, but since they are not in our line when we accesusing head, we will ignore them.
[Revision]: 1
[Confidence]: 10%
[Next]: Practice again
[Steps]: Start with dummy; start while END; inside while a while till its reaches SECONDLAST or curr.val = curr.next.val; this will not throw exception since the in first part we are controling it to go till second last only, inside while loop update the curr to next; Outside - prev.next = curr ; then move prev to current ; prev = curr and then move curr to the next element ; curr = curr.next;
[Code]	
	while(curr.next != null && curr.val == curr.next.val ){
[/Code]
[/Note]

*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode curr = head;
        ListNode prev = dummy;
        while(curr != null){
            System.out.println("Curr "+curr.val);
            System.out.println("Prev "+ prev.val);

            while(curr.next != null && curr.val == curr.next.val ){
                curr = curr.next;
                System.out.println("In: "+curr.val);
            }

            prev.next = curr;
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}