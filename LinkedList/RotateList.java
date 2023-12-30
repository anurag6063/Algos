/*

https://www.youtube.com/watch?v=UcGtPs2LE_c
https://leetcode.com/problems/rotate-list/?envType=list&envId=ruypfpvi

find to length of the nodes
now go till length - size = length - k - 1
now do the switch : #UnderstandMore
	ListNode newHead = cur.next;
    cur.next = null;
    tail.next = head;

    return newHead;
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


    