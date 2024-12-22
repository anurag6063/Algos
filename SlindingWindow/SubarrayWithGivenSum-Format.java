//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&category[]=sliding-window&sortBy=submissions
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class SubarrayWithGivenSum{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s){
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        int sum = 0;
        for( int right =0; right< n; right++){
            sum = sum+arr[right];
            // System.out.printf(" left %d, right %d sum %d %n", left, right, sum );
            // while loop will be always there when i don;t know the window size
            while(sum > s && left < right){ // its right < left because we need atlease 1 element to be there.
            // if(sum > s){
                // System.out.println("sum in greater"+ sum);
                sum = sum - arr[left];
                left++;
                // System.out.println("sum in greater"+ sum);
            }
            // if is after because sometime the above while loop will get the value equated. we need to check and exit now.
            if(sum == s){
                // System.out.println("sum in equal");
                res.add(left+1);
                res.add(right+1);
                return res;
            }
        }
        res.add(-1);
        return res;
    }
}