// https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1?page=1&category[]=sliding-window&sortBy=submissions
//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class MaximumOfAllSubarraysK{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> results = new ArrayList<Integer>(n-k);
        int max = Integer.MAX_VALUE;
        int left = 0;
        for(int right =0; right < n-k+1 ; right++){
            max = arr[right];
            
            for(int i = 0; i < k; i++){
                max = Math.max(max, arr[i+right]);
              //  System.out.printf(" right %d, in %d max %d %n", right, i, max );
            }
            results.add(max);
            
            // max = Math.max(max, arr[right]);
            // if(right >= k-1){
            //     results.set(Math.max(max, arr[right]));
                
            //     left++;
            // }
        }
        return results;
    }
}
