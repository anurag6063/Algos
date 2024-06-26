package patterns;

import java.util.HashSet;
import java.util.Set;

class SlidingWindow {
  public static void main(String[] args) {

    // setup
    int[] arr = {51, 3, -1, -3, 5, 9, 9, 19};
    int k = 3;

    // ex: find max average in a window size of K
    System.out.println(slidingWindowStaticWindowSizeK(arr, k));

    // find longest substring without repeating character.
    System.out.println(slidingWindowDynmaicWindowSize("abcabcs"));
  }

  private static int slidingWindowDynmaicWindowSize(String pattern) {

    int ans = 0; // answer

    // need to have left and a controller DS like HS etc. this is replacement of K
    int left = 0; // left
    Set<Character> supportingDSreplacedK = new HashSet<>(); // supporting DS

    // loop on the right part. and this always moves -> till the end.
    for (int right = 0; right < pattern.length(); right++) {

      // rather than using K i need to use this supporting DS
      // to control the size of window ie. to move the left specially.
      // since this is dynamic window, the suppoorting DS needs to bb altered
      // the DS can have elements added or removed.
      if (!supportingDSreplacedK.contains(pattern.charAt(right))) {
        supportingDSreplacedK.add(pattern.charAt(right));
      } else {
        while (supportingDSreplacedK.contains(pattern.charAt(right))) {
          supportingDSreplacedK.remove(pattern.charAt(left));
          left++;
        }

        supportingDSreplacedK.add(pattern.charAt(right));
      }

      ans = Math.max(ans, right - left + 1);
      //            right ++;
    }

    return ans;
  }

  private static int slidingWindowStaticWindowSizeK(int[] arr, int k) {

    int ans = Integer.MIN_VALUE; // this like like minSum etc
    int tempAns = 0; // like sum ; the final ans
    int left = 0;

    // right is the for loop
    for (int right = 0; right < arr.length; right++) {

      // some ops like find the sum/
      tempAns = tempAns + arr[right];
      // an ops that happens irrespective of the right element

      // when k-1 comes = right; ie first static window is hit.
      // calculate the first answer.
      // k-1 because k is 1 indexed while right is 0 indexed.
      if (right >= k - 1) {
        // ops like max, sumMax
        ans = Math.max(ans, tempAns);
        // generally answer is calculated here.

        tempAns = tempAns - arr[left];
        // move left now since in the next loop i need to loose left element
        left++;
      }
    }

    return ans; // the ans as sum or else for avg = finalAns/k
  }
}
