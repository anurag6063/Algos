
/*
[Note]
[Reference]: NA
[Problem]: https://leetcode.com/problems/middle-of-the-linked-list/?envType=list&envId=ruypfpvi
[Pattern]: slow and fast pointers
[Tips]: Use && ; since if in case even no nodes if i don't checked fas.next != null; it whill givel bull pointer ; currFast != null && currFast.next != null ; initialize on head and move at diff speed, return slow, takes care of even and odd, returns the second element in case of even nodes
[Revision]: 1
[Confidence]: 70%
[Next]: Practice 
[Steps]: initialize on head and move at diff speed, return slow, takes care of even and odd, returns the second element in case of even nodes
[Code]	
	
[/Code]
[/Note]
*/


class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode currFast = head;
        while(currFast != null && currFast.next != null){
            currFast = currFast.next.next;
            slow = slow.next;
        }
       
        return slow;   
    }
}