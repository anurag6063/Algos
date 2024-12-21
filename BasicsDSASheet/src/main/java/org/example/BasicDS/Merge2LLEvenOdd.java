package BasicsDSASheet.src.main.java.org.example.BasicDS;

class Merge2LLEvenOdd{
  public static Node head, tail; // head and tail of the LinkedList
  private static void printList(Node head) // Function to print the LinkedList
  {
    Node curr = head;
    for (; curr != null; curr = curr.next) {
      System.out.print(curr.data + "-->");
    }
    System.out.println("null");
  }

  private static void insertAtLast(int dataue) // Function for creating a LinkedList
  {
    Node newnode = new Node(dataue);
    if (head == null)
    {
      head = newnode;
      tail = newnode;
    }
    else
      tail = tail.next = newnode;
  }

  private static Node segregateOddEven()
  {
    Node evenHead = new Node(0);
    Node evenTail = evenHead;

    Node oddHead = new Node(0);
    Node oddTail = oddHead;

    Node curr = head.next;

    while(curr != null){
      System.out.println("data " + curr.data);
      boolean even = curr.data % 2 == 0;
      if(true == even){
        System.out.println("evenTail " + evenTail.data);
        evenTail.next = curr;
        evenTail = evenTail.next;
      }else{
        System.out.println("oddTail " + oddTail.data);
        // false
        oddTail.next = curr;
        oddTail = oddTail.next;
      }

      curr = curr.next;
    }
    System.out.println("evenTail " + evenTail.data);
    System.out.println("oddTail " + oddTail.data);
    System.out.println("oddHead " + oddHead.next.data);
    // evenTail.next = oddHead.next;

    // final
    printList(evenHead);
    printList(oddHead);
    return evenHead.next;
  }

  public static void main(String args[])
  {
    insertAtLast(1);
    insertAtLast(2);
    insertAtLast(3);
    insertAtLast(4);
    System.out.println("Intial LinkedList : ");
    printList(head);
    Node newHead = segregateOddEven();
    System.out.println("LinkedList After Segregration ");
    printList(newHead);
  }
}