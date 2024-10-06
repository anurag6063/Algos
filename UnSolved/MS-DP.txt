/*
https://leetcode.com/discuss/interview-question/5219652/Microsoft-OA

Unique and Sorted Elements:

By working with unique and sorted elements, we ensure that checking for consecutive integers is straightforward and efficient.
Dynamic Programming (DP) Array:

dp[i] represents the number of good subsequences that end with uniqueElements[i].
Initializing dp[i] to 1 accounts for the subsequence consisting of the element uniqueElements[i] itself.
Extending Subsequences:

If uniqueElements[i] can be added to any subsequence ending at uniqueElements[j] (where they are consecutive), then the number of such subsequences is incremented by dp[j].
This ensures that we count all valid subsequences without missing any possibilities.

*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoodSubsequences {
    
    public static long countGoodSubsequences(int[] arr) {
        // Step 1: Extract unique elements and sort them
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : arr) {
            uniqueSet.add(num);
        }
        Integer[] uniqueElements = uniqueSet.toArray(new Integer[0]);
        Arrays.sort(uniqueElements);
        
        int n = uniqueElements.length;
        long[] dp = new long[n];
        long totalGoodSubsequences = 0;
        
        // Step 2: Initialize the dp array
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Single element subsequence
        }
        
        // Step 3: Update the dp array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (uniqueElements[i] == uniqueElements[j] + 1) {
                    dp[i] += dp[j];
                }
            }
            totalGoodSubsequences += dp[i];
        }
        
        return totalGoodSubsequences;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 1, 2, 8};
        int[] arr2 = {7, 5, 6, 8, 4};

        System.out.println(countGoodSubsequences(arr1)); // Expected output: 10
        System.out.println(countGoodSubsequences(arr2)); // Expected output: 15
    }
}
