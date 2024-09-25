// https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem
package org.example.recursion;

public class PerfectSum {
    public int perfectSum(int arr[],int n, int sum)
    {
      // Your code goes here
      Integer count = 0;
      findSum(arr, n,  sum, 0, 0, count);
      return count;

    }

    static void findSum(int arr[],int n, int sum,int i,  int tempSum, int count){
      if(i == n){
        if(tempSum == 10){
          count++;
          return;
        }
        return;
      }

      tempSum = arr[i] + tempSum;
      findSum(arr, n, sum , i+1, tempSum, count);

      tempSum = tempSum - arr[i];
      findSum(arr, n, sum, i+1, tempSum, count);

    }
  }
