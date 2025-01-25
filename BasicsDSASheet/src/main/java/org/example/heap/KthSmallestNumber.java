package BasicsDSASheet.src.main.java.org.example.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class KthSmallestNumber {
  private static int findKthSmallest(int[] arr, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x,y) -> Integer.compare(y,x));

    for(int i =0; i< arr.length; i++){
      priorityQueue.add(arr[i]);
      if(priorityQueue.size() > k){
        priorityQueue.poll();
      }
    }
    int ans = priorityQueue.poll();
    System.out.println("kth smallest is: "+ ans);
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {7, 10,1, 4, 3, 20, 15};

    int k = 3;
    System.out.println("The " + k + "rd smallest element is " + findKthSmallest(arr, k));
    Arrays.sort(arr);
    Arrays.stream(arr).forEach(System.out::println);
  }
}
