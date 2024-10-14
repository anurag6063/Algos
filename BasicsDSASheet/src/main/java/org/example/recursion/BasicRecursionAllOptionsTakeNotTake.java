package org.example.recursion;

public class BasicRecursionAllOptionsTakeNotTake {
 int MDD = 1000000007;
  public int perfectSum(int arr[],int n, int sum2)
  {
    // Your code goes here
    int[] count = new int[1];
    int[] sum = new int[1];
    findSum(arr, sum, 0, n);
    return count[0] % 1000000007;
  }


//  static int findSum(int arr[],int[] sum, int n,  int tempSum){
//    if(n==0){ if(tempSum == sum){ return 1;} return 0; } // Zeros in the begining. [0, 0, 4,5 ,5, 0 , 9, 0 ]
//
//    return findSum(arr, n, sum , n-1, arr[n] + tempSum) +
//        findSum(arr, n, sum, n-1, tempSum);
//  }

  static int findSum3(int[] arr, int[] sum, int tempSum, int n){
    if (n == 0) {
      if(tempSum == sum[0]){
        return 1;
      }
      return 0;
    }

    return findSum3(arr, sum, tempSum+arr[n], n-1) +
        findSum3(arr, sum, tempSum, n-1);
  }

  static int findSum(int[] arr, int[] sum, int tempSum, int n){
    if(n==-1){
      if(tempSum == sum[0]){
        return 1;
      }
      return 0;
    }
    return findSum(arr, sum, tempSum+arr[n], n-1) +
        findSum(arr, sum, tempSum, n-1);
    // take \ not take
  }
}



class BasicRecursionAllOptionsTakeNotTake2{
  int MOD = 1000000007;
  public int perfectSum(int arr[],int n, int sum)
  {
    // Your code goes here
    // int[] count = new int[1];
    // findSum(arr, n,  sum, 0, 0, count);
    int[] sum2 = new int[1];
    sum2[0] = sum;
    return findSum2(arr, sum2, n-1, 0) % MOD;


    // return count[0] % 1000000007;
  }


  static int findSum2(int arr[],int[] sum, int n,  int tempSum){
    if(n==-1){
      if(tempSum == sum[0]){
        return 1;
      }else{
        return 0;
      }

    } // Zeros in the begining. [0, 0, 4,5 ,5, 0 , 9, 0 ]

    return (findSum2(arr, sum , n-1, arr[n] + tempSum) % 1000000007  +
        findSum2(arr, sum, n-1, tempSum) % 1000000007)
        % 1000000007;
  }
}

