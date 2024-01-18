/*
[Note]
[Reference]: ChatGPT
[Problem]: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?envType=list&envId=ruypfpvi
[Pattern]: Find dupicate first then alter pointers	; #2Pointers
[Tips]: Since we have to skip the dupilicates altogether, the prev should never come to a duplicate value; the current will also just miss the values.
[Revision]: 0
[Confidence]: 20%
[Next]: Practice 
[Steps]: Dummy Node, start prev at dummy and curr at head; go till last node. IN : mark isDuplicate falg as False; IN: Till second last node and till value of current node and the next remains same, go ahead and marl iSDuplicate flag as true. OUT: if iSDuplicate is true prev.next = curr.next ++ Else prev = curr ++
[Code]	
	if(isDup){
		prev.next = curr.next;
		curr = curr.next;
	}else{
		prev = curr; 
		curr = curr.next;
	}

[/Code]
[/Note]
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // initialize with dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // have 2 pointers , curr will move ahead and prev will keep a track of initial point
        ListNode prev = dummy;
        ListNode curr = head;

        // go till last
        while(curr != null){
            boolean isDup = false;
            // go till 2nd last && till value matches
            while(curr.next != null && curr.val == curr.next.val){
                isDup = true; // if values are same
                curr = curr.next; // keep going ahead 
            }

            // now this will end after running while loop else not too. 
            // if while loop then it needs to skip all the dups in b/w
            if(isDup){
                prev.next = curr.next;
                curr = curr.next;
            }else{
                prev = curr; 
                curr = curr.next;
            }
        }

        return dummy.next;

    }
}
