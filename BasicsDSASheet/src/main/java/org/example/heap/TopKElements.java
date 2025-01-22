package BasicsDSASheet.src.main.java.org.example.heap;

//https://leetcode.com/problems/top-k-frequent-elements/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElements {
  public static int[] topKFrequent(int[] nums, int k) {
    // find frequency first
    Map<Integer, Integer> freqMap = new HashMap<>();
    for(int i =0; i < nums.length; i++) {
      freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
    }
      // Main issue was this logic.
      // if(freqMap.containsKey(nums[i])){
      //    freqMap.put(nums[i], freqMap.get(nums[i]+1));
      // }else{
      //     freqMap.put(nums[i], 1);
      // }
//    }

    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((x,y) -> Integer.compare(x.getKey(),y.getKey()));
    //   PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>());
    // [3,2,1 ]
    for(int key: freqMap.keySet()){
      queue.offer(new java.util.AbstractMap.SimpleEntry<>(freqMap.get(key), key));
      if(queue.size() > k){
        queue.poll();
      }
    }

    int[] ans = new int[k];
    for(int i = 0 ; i < k; i++){
      ans[i]=queue.poll().getValue();
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {1,1,1,2,2,3};

    int k = 2;
    int[] ans = topKFrequent(arr, k);
    System.out.println("The " + k + "rd smallest element is " + ans);
//    Arrays.sort(arr);
    Arrays.stream(ans).forEach(System.out::println);

  }
}
