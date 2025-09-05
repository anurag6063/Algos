package com.algo.linked.list;
import com.algo.linked.list.Node;

/**
 * This class provides a method to delete the middle node of a singly linked list.
 * 
 * <p>The middle node is defined as the ⌊n/2⌋-th node (0-based index) in the list,
 * where n is the total number of nodes in the linked list.</p>
 * 
 * <p>Edge cases:</p>
 * <ul>
 *   <li>If the list is empty, the method returns null.</li>
 *   <li>If the list contains only one node, the method returns null.</li>
 * </ul>
 * 
 * <p>The algorithm uses the two-pointer technique (slow and fast pointers) to find
 * the middle node in a single traversal of the list, ensuring O(n) time complexity.</p>
 */
public class DeleteMiddleNode {

    /**
     * Deletes the middle node of a singly linked list.
     * 
     * @param head The head of the singly linked list.
     * @return The head of the modified linked list after deleting the middle node,
     *         or null if the list is empty or contains only one node.
     */
    public Node deleteMiddle(Node head) {
        // Edge case: empty list or single-node list
        if (head == null || head.next == null) {
            return null;
        }

        // Create a dummy node to simplify edge cases
        Node dummy = new Node(0);
        dummy.next = head;

        Node slow = dummy;
        Node fast = dummy;
        Node prev = dummy;

        // Move fast pointer two steps and slow pointer one step
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Remove the middle node
        prev.next = prev.next.next;

        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DeleteMiddleNode main = new DeleteMiddleNode();

        // Creating a sample linked list:
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Display the original linked list
        System.out.print("Original Linked List: ");
        printLL(head);

        // Delete the middle node
        head = main.deleteMiddle(head);

        // Display the updated linked list
        System.out.print("Linked List After Deleting Middle Node: ");
        printLL(head);
    }
}

