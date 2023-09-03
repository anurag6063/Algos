/**
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 */


 // initialize: NA
 // we need to put the result in same array 1, but we have extra space too. 
 // that is m+n-1
 // start placing num from back since that way will avoid overriting. 
 // can't use for loop at all since the array that i would like to write to, itself is changing. 

 
 class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}