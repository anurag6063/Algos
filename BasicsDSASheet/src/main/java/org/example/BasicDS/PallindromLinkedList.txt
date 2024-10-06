/*
package BasicDS;
// Node class represents a
// node in a linked list
class Node {
  // Data stored in the node
  int data;
  // Pointer to the next
  // node in the list
  Node next;

  // Constructor with both data
  // and next node as parameters
  Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }

  // Constructor with only data as
  // a parameter, sets next to null
  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class PallindromLinkedList {

    public static boolean isPalindrome(Node head) {
      printLinkedList(head);
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
      printLinkedList(partitionB);
      // check pallindrom
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

    // Function to print the linked list
    public static void printLinkedList(Node head) {
      Node temp = head;
      while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
      }
      System.out.println();
    }

    public static void main(String[] args) {
      // Create a linked list with
      // values 1, 5, 2, 5, and 1 (15251, a palindrome)
      Node head = new Node(1);
      head.next = new Node(5);
      head.next.next = new Node(2);
      head.next.next.next = new Node(2);
      head.next.next.next.next = new Node(1);

      // Print the original linked list
      System.out.print("Original Linked List: ");
      printLinkedList(head);

      // Check if the linked list is a palindrome
      if (isPalindrome(head)) {
        System.out.println("The linked list is a palindrome.");
      } else {
        System.out.println("The linked list is not a palindrome.");
      }
    }

  }}

*/
