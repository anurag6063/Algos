package org.example.BasicDS;


class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

class ReverseDoublyLinkedList {
  public DLLNode reverseDLL(DLLNode head) {

    DLLNode curr = head;
    DLLNode prev = null;
    DLLNode next = head;

    while (curr != null) {
      //   System.out.println(" curr" + curr.data);
      next = curr.next;

      curr.next = prev;
      curr.prev = next;

      prev = curr;
      curr = next;
    }
    return prev;
  }
}

