/*
package java.org.example.dp;
*/
/*
# Algos
[Note]
[Reference]: https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
[Problem]: https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
[Pattern]: DP Basic , Space optimization, with modification
[Tips]:
[Revision]: 0
[Confidence]: 10%
[Next]: Practice
[Steps]:
[Code]
Basic recurdion,
just that i need to tc of finding height so i need height[] to be passed around.
also height array is needed to find energy so it's height[i] - height[i-1]
also as an second option it can be height[i] - height[i-1]
it's similar to previous question, just that now the branching factor in K.
so rather than doing jumpOne & jumpTwo.
i need to for loop it.
also once the ans is dound keep it in tempVariable to find the final minimum.
[/Code]
[Tags]:
[/Note]
*//*

import java.util.Arrays;

public class JumpingFrogKSteps {

  private static int solveUtilsTabulation(int n, int[] height, int[] dp, int k){
    dp[0] = 0;

    for(int j =1 ; j < n ; j++) {
        int mmSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
          if (n - i >= 0) {
            int jump = dp[n-1] + Math.abs(height[n] - height[n - i]);
            mmSteps = Math.min(mmSteps, jump);
          }
        }
        dp[j] = mmSteps;
    }
    return dp[n-1];
  }

  public static void main(String[] args) {
    int[] height = {30,10,60,10,60,50};
    int n = height.length;
    int k = 2;
    solve(n, height, k);
  }

  // -----

  public int minimizeCost(int k, int arr[]) {
    // code here
    return solveRecursion(arr, arr.length-1, k );

  }

  private static int solveRecursion(int[] arr, int n, int k ){
    if(n==0){
      return 0;
    }
    int mm = Integer.MAX_VALUE;
    for(int i = 1; i <= k ; i++){
      if(n - i >= 0 ){
        int min = solveRecursion(arr, n-i, k)+ Math.abs(arr[n] - arr[n-i]);
        mm = Math.min(mm, min);
      }

    }
    return mm;
  }

  // converted above to DP
  public int minimizeCost(int k, int arr[]) {
    // code here
    int[] dp = new int[arr.length];
    Arrays.fill(dp, -1);
    return solveRecursion(arr, k, arr.length-1, dp);
  }

  private static int solveRecursion(int[] arr, int k, int n, int[] dp){
    if(n <=0){
      return 0;
    }
    if(dp[n] != -1){
      return dp[n];
    }
    int mm = Integer.MAX_VALUE;
    for(int i =1; i <=k; i++){
      if(n-i >= 0){
        int cost = solveRecursion(arr, k, n-i, dp) + Math.abs(arr[n] - arr[n-i]);
        mm = Math.min(mm, cost);
      }
    }
    return dp[n] = mm;
    // return mm;
  }

  private static int solve(int[] arr, int n , int k){
    int[] dp = new int[arr.length];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for(int x = 1; x <=  n ; x++){
      int mm = Integer.MAX_VALUE;
      for(int i =1; i <=k; i++){
        if(x-i >= 0){
          int cost = dp[x-i] + Math.abs(arr[x] - arr[x-i]);
          mm = Math.min(mm, cost);
        }
      }
      dp[x] = mm;
    }

    return dp[n-1];
  }

}
*/
