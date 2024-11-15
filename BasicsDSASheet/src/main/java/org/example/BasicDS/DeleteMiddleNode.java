package BasicsDSASheet.src.main.java.org.example.BasicDS;

import static BasicsDSASheet.src.main.java.org.example.BasicDS.Node.printLL;

public class DeleteMiddleNode {
  // Function to delete the
  // middle node of a linked list
  public Node deleteMiddle(Node head) {
    Node fast = head; // double hop, starting from head.
    Node slow = head; // single hop starting from head.
    Node dummy = new Node(0, head); // will be used to find answer
    Node prev = dummy; // it is kept one step behind slow so that it can help in crossing over prev.

    while(fast != null && fast.next != null){
      slow = slow.next;
      prev = prev.next;
      fast = fast.next.next;
    }
    prev.next = prev.next.next;
    return dummy.next;
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

    // Deleting the middle node
    head = main.deleteMiddle(head);

    // Displaying the updated linked list
    System.out.print("Updated Linked List: ");
    printLL(head);
  }
}

