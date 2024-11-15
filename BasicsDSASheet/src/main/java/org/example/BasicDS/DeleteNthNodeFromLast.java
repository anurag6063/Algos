package BasicsDSASheet.src.main.java.org.example.BasicDS;

public class DeleteNthNodeFromLast {
  // Function to print the linked list
  public static void printLL(Node head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  // Function to delete the Nth node from the end of the linked list
  public static Node DeleteNthNodefromEnd(Node head, int N){
    Node ahead = head;
    Node behind = head;

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
    int N = 2;
    Node head = new Node(arr[0]);
    head.next = new Node(arr[1]);
    head.next.next = new Node(arr[2]);
    head.next.next.next = new Node(arr[3]);
    head.next.next.next.next = new Node(arr[4]);

    // Delete the Nth node from the end and print the modified linked list
    head = DeleteNthNodefromEnd(head, N);
    printLL(head);
  }
}

