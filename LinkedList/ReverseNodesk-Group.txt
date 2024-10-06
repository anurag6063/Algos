
/*
https://leetcode.com/problems/reverse-nodes-in-k-group/?envType=list&envId=ruypfpvi

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

// 

#Repeat #UnderstandClearly
*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        

        if(head == null || k <= 1){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        int length = getLength(head);
        int groupCount = length/k;

        for(int i = 0; i < groupCount ; i++){
            ListNode groupStart = current;
            ListNode prevInGroup = null;

            // reverse the group
            for(int j=0; j < k; j++){
                // swap
                ListNode next = current.next;
                current.next = prevInGroup;
                prevInGroup = current;
                current = next;
            }

            prev.next = prevInGroup;
            groupStart.next = current;

            prev = groupStart;
        }

        return dummy.next;
          
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}