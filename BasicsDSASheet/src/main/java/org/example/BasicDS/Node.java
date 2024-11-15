
package BasicsDSASheet.src.main.java.org.example.BasicDS;

// Node class represents a node in a linked list
 public class Node {
  // Data stored in the node
  int data;
  // Pointer to the next node in the list
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




  static void printLL(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

}
