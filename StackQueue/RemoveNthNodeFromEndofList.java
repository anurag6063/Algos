
/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=list&envId=ruypfpvi


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        while(fast != null && fast.next != null){
            if(n > 0){
                System.out.println("slow not started "+ n + " "+ fast.val + " slow "+ slow.val);
                n--;
                
            }else{
                System.out.println("slow HAS started "+ n + " "+ slow.val);
                slow = slow.next;
            }
            fast = fast.next;
        }
        System.out.println(slow.val);
        slow.next = slow.next.next;
        // tail.next = null;

        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveNthNodeFromEnd {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move the fast pointer ahead by n + 1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers until the fast pointer reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove the nth node from the end
        slow.next = slow.next.next;
        
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();
        int n = 2;
        ListNode newHead = solution.removeNthFromEnd(head, n);

        System.out.println("Original List:");
        printList(head);

        System.out.println("List after removing the " + n + "th node from the end:");
        printList(newHead);
    }
}
