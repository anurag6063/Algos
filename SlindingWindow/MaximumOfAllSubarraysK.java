// https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1?page=1&category[]=sliding-window&sortBy=submissions
//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
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