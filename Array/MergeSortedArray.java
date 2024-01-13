/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/merge-sorted-array/
[Pattern]: Copy will you exhaust; reverse
[Tips]: 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
 we need to put the result in same array 1, but we have extra space too.  that is m+n-1  start placing num from back since that way will avoid overriting.  can't use for loop at all since the array that i would like to write to, itself is changing.
[Code]	
 initialize: NA

while (j >= 0) {
	if (i >= 0 && nums1[i] > nums2[j]) {
					System.out.println(i + ": i "+ nums1[i]  );

		nums1[k--] = nums1[i--];
	} else {
					System.out.println( j +" :j "+ nums2[j] );

		nums1[k--] = nums2[j--];
	}
	
} 
[/Code]
[/Note]
*/

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

// ------
// own solution
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // find length of both
        // for loop smaller one
        // compare and place at end of num1
        // out
        // while on other and place it.
        int x = m+n-1;
        while(m > 0 && n > 0){
            if(nums1[m-1] > nums2[n-1]){
                nums1[x] = nums1[m-1]; 
                m--;
            }else{
                nums1[x]= nums2[n-1];
                n--;
            }
            x--;
        }
        while(m>0){
            nums1[x]= nums1[m-1];
            x--;
            m--;
        }

        while(n>0){
            nums1[x] = nums2[n-1];
            x--;
            n--;
        }

    }
}
//-------------------------

// here we do not have extra 2 while loop becuase the arrays are sorted by deafault. Since the array 1 is larger once we exhaust 
// array 2 we are sure array 1 's extra element are anyways sorted.
  class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        // since we need to actually sort only the J (nums2) since it has lesser element and also has to come and fit in nums1.
		// with this we don't have to copy the pending ones
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                            System.out.println(i + ": i "+ nums1[i]  );

                nums1[k--] = nums1[i--];
            } else {
                            System.out.println( j +" :j "+ nums2[j] );

                nums1[k--] = nums2[j--];
            }
            
        }
    }
}
