package BasicsDSASheet.src.main.java.org.example.BasicDS;

import java.util.Iterator;

public class IncompleteMyArrayList<T> implements Iterable<T> {
  private int size;
  private int capacity;
  private Object[] elements;

  public void ArrayList() {
    int[] nums = new int[8];
    this.size = 0;
  }

  public void ArrayList(int capacity) {
    int[] nums = new int[capacity];
    this.capacity = capacity;
  }

  public int add(T element) {
    int makeCopy = this.capacity * 3/4;
    if (size >= makeCopy) {
      // create a list with double size and copy the elements.
    }
    return 0;
  }

  public int size() {
    return this.size;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }
}
