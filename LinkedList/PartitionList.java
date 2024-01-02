/*
[Note]
[Reference]: Solutions
[Problem]: https://leetcode.com/problems/partition-list/?envType=list&envId=ruypfpvi
[Pattern]: 2 pointers and merge
[Tips]: create 2 heads and 2 tail pointers, create the list, merge them. 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: Initialize tails and left and right, go till head!=null check the value of x ; accordinglt increase leftTail or rightTail, increase the current. Merge the LL, return left.next;
[Code]	
	 while(head!=null){
            // the leftTail and rightTail are acting like 2 pointers
            if(head.val < x){
                leftTail.next = head;
                leftTail = leftTail.next;
            }else{
                rightTail.next = head;
                rightTail = rightTail.next;
            }

            head = head.next;
        }

[/Code]
[/Note]
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

// this has been kept so that we can use them at the last to merge the 2 LL 
        ListNode leftTail = left;
        ListNode rightTail = right;

        // head is acting like a for loop here.
        while(head!=null){
            // the leftTail and rightTail are acting like 2 pointers
            if(head.val < x){
                leftTail.next = head;
                leftTail = leftTail.next;
            }else{
                rightTail.next = head;
                rightTail = rightTail.next;
            }

            head = head.next;
        }

        leftTail.next = right.next;
        rightTail.next = null;

        return left.next;
    }
}