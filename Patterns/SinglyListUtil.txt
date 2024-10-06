package patterns;

public class SinglyListUtil {

  public static void main(String[] args) {

    ListNode l1 = createListOfNode1();
    ListNode l2 = createListOfNode2();
    ListNode l3 = createListOfNode3();

    // find a loop
    System.out.println(slowAndFastPointer(l1));

    // th dummy node, used when i want to -1 from where i want to be
    // used when i have to create a new list.
    System.out.println(dummyNode(l1).val);

    //            System.out.println(reverseAllPointers(l1).val);
    ListNode reversedHead = reverseAllPointers(l1);
    ListNode.printAllValues(reversedHead);
  }

  private static ListNode reverseAllPointers(ListNode head) {

    System.out.println("head " + head.val);

    ListNode curr = head;
    ListNode prev = null;
    ListNode next = null;

    while (curr != null) {

      // remember the sequence
      // next -> curr.next -> prev -> curr -> next
      System.out.println("curr: " + curr.val);
      // since next was null; first set it to curr.next
      next = curr.next;
      // do the most important reversal
      curr.next = prev;
      // move everything ahead; prev to next and curr to next
      prev = curr;
      curr = next;

      // N C P C - No Path (N P ) take a C turn
      /*
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      */

    }
    System.out.println("prev: " + prev.val);
    return prev;
  }

  private static ListNode dummyNode(ListNode l1) {

    // create and set it's next to head.
    ListNode head = l1; // l1 actually holds the head.

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    // now i can use the head for ex for anything.
    // while returning the ans, i will need head
    // which is just dummy.next

    while (head != null) {
      head = head.next;
    }

    return dummy.next;
  }

  // Ex: used to find loop
  private static boolean slowAndFastPointer(ListNode head) {

    // has no need to dummy node.
    ListNode slow = head;
    ListNode fast = head;

    // this will tc of fast.next.next as null
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      System.out.println(slow.val);
      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  private static ListNode createListOfNode3() {

    ListNode head = new ListNode(0);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(5);

    return head;
  }

  private static ListNode createListOfNode1() {

    ListNode head = new ListNode(10);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode fourth = new ListNode(4);
    ListNode fifth = new ListNode(5);
    ListNode sixth = new ListNode(6);
    ListNode seventh = new ListNode(7);
    ListNode eight = new ListNode(8);

    head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = sixth;
    sixth.next = seventh;
    seventh.next = eight;
    eight.next = null;

    ListNode pointer = head;
    while (pointer != null) {
      System.out.println(pointer.val);
      pointer = pointer.next;
    }
    System.out.println(head);
    return head;
  }

  private static ListNode createListOfNode2() {

    ListNode head = new ListNode(21);
    ListNode second = new ListNode(24);
    ListNode third = new ListNode(32);
    ListNode fourth = new ListNode(41);
    ListNode fifth = new ListNode(12);
    ListNode sixth = new ListNode(11);
    ListNode seventh = new ListNode(37);
    ListNode eight = new ListNode(18);

    head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = sixth;
    sixth.next = seventh;
    seventh.next = eight;
    eight.next = null;

    ListNode pointer = head;
    while (pointer != null) {
      System.out.println(pointer.val);
      pointer = pointer.next;
    }
    System.out.println(head);

    return head;
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static void printAllValues(ListNode head) {

    System.out.println("printing: ");
    ListNode current = head;

    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
