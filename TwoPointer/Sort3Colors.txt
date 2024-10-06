/**
 * https://www.educative.io/courses/grokking-coding-interview-patterns-java/sort-colors
 * Given an array, colors, which contains a combination of the following three elements:
    Sort the array in place so that the elements of the same color are adjacent, with the colors in the order of red, white, and blue. The function should return the same array.
 */

import java.util.*;

public class SortColors {
    public static int[] sortColors (int[] colors) {

        // now here too in brute force we will have 3 loops so 2 iterators. 
        // we have 3 pointer approach here. 

    // 3 pointer approach.
    // initialize: left and right and mid to 0 and 0 right to len-1.
    // do till:  while( mid <= right) , doing = too since we need to place the middle element too.
    //              we use mid and right and use it as a pivot to move, something like merge sort.
    //              the mid element is better since it's easier to move elements to left to right. 
    // break and return if: NA
    // change: if the element at mid is 0 swap with left. - mid++, left++; mid is also moved since we have sorted the left hand side, 
    //              the only element that can be still on the left of mid will have to be 1 only, that's why.  
                // if element at mid is 1 dont do anything - mid++
                // if element at mid is 2 swap with right - right--, since we swap with right, the value of right may have been anything.
                //                             so we don;t increment mid.

        int left = 0;
        int mid = 0;
        int right = colors.length-1;

        while(mid <= right){
            System.out.println( left + " " + mid + " " + right);
             System.out.println( colors[left] + " " + colors[mid] + " " + colors[right]);
            if(colors[mid] == 1){
                mid++;
            }
            else if(colors[mid] == 0){
                colors[mid] = colors[left];
                colors[left] = 0; 
                mid++;
                left++;
            }
            else if(colors[mid] == 2){
                colors[mid] = colors[right];
                colors[right] = 2;
                right--;
                
            }
        }

        return colors;
    }
}