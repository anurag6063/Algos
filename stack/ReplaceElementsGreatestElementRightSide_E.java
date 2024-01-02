/*
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        
       return bruteForce(arr);
    }

    private int[] bruteForce(int[] arr){
        int[] res = new int[arr.length];
        for(int i =0; i< arr.length; i++){
            if(i != arr.length-1){
            int max = arr[i+1];
            for(int j=i+1; j< arr.length; j++){
                if(arr[j] > max){
                    max = arr[j];
                }
            }
            res[i] = max;
            }
            else{
                res[arr.length-1]=-1;
            }
        }
        
        return res;
    }
}