package BasicsDSASheet.src.main.java.org.example.heap;

public class MinHeap {

  private int[] heap;
  private int size;
  private int maxsize;

  private static final int FRONT = 1;

  public MinHeap (int size) {
    this.maxsize = size;
    this.size = 0;
    heap = new int[this.maxsize+1];
    heap[0] = Integer.MIN_VALUE;
  }

  private int parent(int pos){
    return (pos-1)/2;
  }

  private int leftChild(int pos){
    return 2*pos;
  }

  private int rightChild(int pos){
    return 2*pos + 1;
  }

  private boolean isLeaf(int pos){
    return pos > size / 2;
  }

  private void swap(int pos1, int pos2){
    int temp = heap[pos1];
    heap[pos1] = heap[pos2];
    heap[pos2] = temp;
  }

  private void minHeapify(int pos) {
    if (!isLeaf(pos)) {
      int swapPos = pos;

      // Find the smaller of the two children
      if (rightChild(pos) <= size) {
        swapPos = heap[leftChild(pos)] < heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
      } else {
        swapPos = leftChild(pos);
      }

      // Swap if the current node is greater than the smaller child
      if (heap[pos] > heap[swapPos]) {
        swap(pos, swapPos);
        minHeapify(swapPos);  // Recursively heapify the affected subtree
      }
    }
  }

}
