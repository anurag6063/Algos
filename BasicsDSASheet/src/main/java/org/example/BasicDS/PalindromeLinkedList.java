package BasicsDSASheet.src.main.java.org.example.BasicDS;

import static BasicsDSASheet.src.main.java.org.example.BasicDS.Node.printLL;

public class PalindromeLinkedList {
    public static boolean isPalindrome(Node head) {
      printLL(head);
      // find mid
      Node slow = head;
      Node fast = head;

      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      Node partitionA = head;
      Node partitionB = slow.next;

      System.out.println("a " + partitionA.data + " b " + partitionB.data);
      //   printLinkedList(partitionB);
      // break the printLinkedList in 2 parameters
      //   slow.next = null;

      // reverse the second half
      Node curr = partitionB;
      Node prev = null;
      Node next = partitionB;

      while (curr != null) {
        next = curr.next;
        curr.next = prev;

        prev = curr;
        curr = next;
      }

      partitionB = prev;

      //   System.out.println( "a "+ partitionA.data + " b "+ partitionB.data);
      System.out.println("B ");
      printLL(partitionB);
      // check palindrome
      while (partitionA != null && partitionB != null) {
        System.out.println("comparing: a " + partitionA.data + " b " + partitionB.data);

        if (partitionA.data != partitionB.data) {
          return false;
        }

        partitionA = partitionA.next;
        partitionB = partitionB.next;
      }
      return true;
    }

    public static void main(String[] args) {
      // Create a linked list with
      // values 1, 5, 2, 5, and 1 (15251, a palindrome)
      Node head = new Node(1);
      head.next = new Node(4);
      head.next.next = new Node(2);
      head.next.next.next = new Node(2);
      head.next.next.next.next = new Node(1);

      // Print the original linked list
      System.out.print("Original Linked List: ");
      printLL(head);

      // Check if the linked list is a palindrome
      if (isPalindrome(head)) {
        System.out.println("The linked list is a palindrome.");
      } else {
        System.out.println("The linked list is not a palindrome.");
      }
    }
  }


