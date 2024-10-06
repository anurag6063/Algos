package org.example.BasicDS;

class Node {
  public int data;
  public Node2 next;

  // Constructor for Node with data and next node
  public Node(int data1, Node2 next1) {
    data = data1;
    next = next1;
  }

  // Constructor for Node with only data (next set to null)
  public Node(int data1) {
    data = data1;
    next = null;
  }
}

public class DeleteNthNodeFromLast {
  // Function to print the linked list
  public static void printLL(Node2 head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  // Function to delete the Nth node from the end of the linked list
  public static Node2 DeleteNthNodefromEnd(Node2 head, int N){

    Node2 ahead = head;
    Node2 behind = head;

    while(ahead.next != null){
      if(N > 0){
        System.out.println("Not moving yet ");

        N--;
      }else{
        System.out.println(behind.data + " ");
        behind = behind.next;
      }

      ahead = ahead.next;
    }
    System.out.println("replacing next node from " + behind.data);
    behind.next = behind.next.next;

    return head;
  }


  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int N = 3;
    Node2 head = new Node2(arr[0]);
    head.next = new Node2(arr[1]);
    head.next.next = new Node2(arr[2]);
    head.next.next.next = new Node2(arr[3]);
    head.next.next.next.next = new Node2(arr[4]);

    // Delete the Nth node from the end and print the modified linked list
    head = DeleteNthNodefromEnd(head, N);
    printLL(head);
  }
}

