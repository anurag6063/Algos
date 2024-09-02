package org.example.BasicDS;

class ListNode
{
  int val;
  ListNode next;
  ListNode(int x)
  {
    val = x;
    next = null;
  }
}

class Merge2LLEvenOdd{
  static ListNode head, tail; // head and tail of the LinkedList

  static void PrintList(ListNode head) // Function to print the LinkedList
  {
    ListNode curr = head;
    for (; curr != null; curr = curr.next)
      System.out.print(curr.val+"-->");
    System.out.println("null");
  }

  static void InsertatLast(int value) // Function for creating a LinkedList
  {

    ListNode newnode = new ListNode(value);
    if (head == null)
    {
      head = newnode;
      tail = newnode;
    }
    else
      tail = tail.next = newnode;
  }


  static ListNode SegregatetoOddEVen()
  {
    ListNode evenHead = new ListNode(0);
    ListNode evenTail = evenHead;

    ListNode oddHead = new ListNode(0);
    ListNode oddTail = oddHead;

    ListNode curr = head.next;

    while(curr != null){
      System.out.println( "data "+ curr.val);
      boolean even = (curr.val % 2 == 0) ? true : false;
      if(true == even){
        System.out.println("evenTail "+ evenTail.val );

        evenTail.next = curr;
        evenTail = evenTail.next;
      }else{
        System.out.println("oddTail "+ oddTail.val);
        // false
        oddTail.next = curr;
        oddTail = oddTail.next;
      }

      curr = curr.next;
    }
    System.out.println("evenTail "+ evenTail.val);
    System.out.println("oddTail "+ oddTail.val);
    System.out.println("oddHead "+ oddHead.next.val);
    // evenTail.next = oddHead.next;

    // final
    PrintList(evenHead);
    PrintList(oddHead);
    return evenHead.next;
  }

  public static void main(String args[])
  {
    InsertatLast(1);
    InsertatLast(2);
    InsertatLast(3);
    InsertatLast(4);
    System.out.println("Intial LinkedList : ");
    PrintList(head);
    ListNode newHead = SegregatetoOddEVen();
    System.out.println("LinkedList After Segregration ");
    PrintList(newHead);
  }
}