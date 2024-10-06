package org.example.BasicDS;


// Node class represents a node in a linked list
class Node2 {
  // Data stored in the node
  int data;
  // Pointer to the next node in the list
  Node2 next;

  // Constructor with both data
  // and next node as parameters
  Node2(int data, Node2 next) {
    this.data = data;
    this.next = next;
  }

  // Constructor with only data as
  // a parameter, sets next to null
  Node2(int data) {
    this.data = data;
    this.next = null;
  }
}

public class DeleteMiddleNode {

  // Function to delete the
  // middle node of a linked list
  public Node2 deleteMiddle(Node2 head){

    Node2 fast = head;
    Node2 slow = head;
    Node2 dummy = new Node2(0, head);
    Node2 prev = dummy;

    while(fast != null && fast.next != null){

      slow = slow.next;
      prev = prev.next;
      fast = fast.next.next;
    }

    prev.next = prev.next.next;

    return dummy.next;


  }




  static void printLL(Node2 head) {
    Node2 temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {

    DeleteMiddleNode main = new DeleteMiddleNode();

    // Creating a sample linked list:
    Node2 head = new Node2(1);
    head.next = new Node2(2);
    head.next.next = new Node2(3);
    head.next.next.next = new Node2(4);
    head.next.next.next.next = new Node2(5);

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

