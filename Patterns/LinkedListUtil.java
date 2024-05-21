package patterns;

import java.util.LinkedList;

public class LinkedListUtil {
  public static LinkedList<Integer> ll;

  public static void main(String[] args) {
    LinkedList<Integer> ll = createALinkList();
  }

  public static LinkedList<Integer> createALinkList() {

    ll = new LinkedList<>();
    ll.add(10);
    ll.add(30);
    ll.add(3);

    System.out.println(ll);
    System.out.println(ll.getFirst());

    return ll;
  }
}
