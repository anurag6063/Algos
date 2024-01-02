/*
[Note]
[Reference]: https://www.youtube.com/watch?v=UcGtPs2LE_c
[Problem]: https://leetcode.com/problems/rotate-list/?envType=list&envId=ruypfpvi

[Pattern]: Modify links of LL
[Tips]: we very conscios of the modification of link ; never loose the pointer to links ; sequence of modificationis important
[Revision]: 0
[Confidence]: 10%
[Next]: Practice and do similar question on LL, understand pointers
[Steps]: find to length of the nodes ; now go till length - size = length - k - 1 ; now do the switch 
[Code]	
	while (tail.next != null) { // imp
	---	
	ListNode newHead = cur.next;
    cur.next = null;
    tail.next = head;

    return newHead;
[/Code]
[/Note]
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
    public ListNode rotateRight(ListNode head, int k) {


        if(head == null) return head;

     int length = 1;
    ListNode tail = head;

// we need to get to tail.next != null; important
    while (tail.next != null) {
        tail = tail.next;
        length++;
    }

    k = k % length;
    if (k == 0) {
        return head;
    }

    ListNode cur = head;

    for (int i = 0; i < length - k - 1; i++) {
        cur = cur.next;
    }

    ListNode newHead = cur.next;
    cur.next = null;
    tail.next = head;

    return newHead;
    }
}


    