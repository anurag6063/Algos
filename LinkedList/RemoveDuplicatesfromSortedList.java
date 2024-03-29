/*
[Note]
[Reference]: CGPT
[Problem]: https://leetcode.com/problems/remove-duplicates-from-sorted-list/?envType=list&envId=ruypfpvi
[Pattern]: Modify links of LL; #2Pointers
[Tips]: Think what to do whe they match. Just Move ahead, and when i complete that set the pointers;; Once we reset the pointers, other nodes will still be pointing to the LL, but since they are not in our line when we accesusing head, we will ignore them.
[Revision]: 2
[Confidence]: 50%
[Next]: Practice again
[Steps]: Start with dummy; start while END; inside while a while till its reaches SECONDLAST or curr.val = curr.next.val; this will not throw exception since the in first part we are controling it to go till second last only, inside while loop update the curr to next; Outside - prev.next = curr ; then move prev to current ; prev = curr and then move curr to the next element ; curr = curr.next; Use a prev and next when i have to loose or reverse some nodes. else remenber next is just prev.next. if it can work good.
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
	
	
	// we cannot use this can need to have a while loop inside the while loop, so that it can skip multipl duplicate values. In this code it misses skipping multiple duplicates-from-sorted-list/
	
	 public ListNode deleteDuplicates_incorrect(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        ListNode prev = dummy;

        while(curr != null){
            System.out.println(prev.val + " "+ curr.val);
            if(curr.val != prev.val){
                System.out.println("nums don't match");
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
     }
}


