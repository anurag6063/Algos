/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
[Pattern]: BS, trick
[Tips]: find flux point, ex the point where value is less than prev but creater than next, thats answer, else if val at right < num[mid] move to right else left
[Revision]: 0
[Confidence]: 10%
[Next]: Understand
[Steps]: 
[Code]	
	
[/Code]
[Intution]: 
"""
MOST IMPORTANT 2 POINTS:
1. If the first element is greater than the last one, then first element is the smallest one. 
2. In a sorted rotated array only at the minimum element ( 6, 8, 9 , 2, 3 ) will it happen that the previous number is greater than the next. 
	So see in a sorted array always the previous num is smaller that the next one. 
 	But here just for once ex here at 2 it will not happen. And i need to find that. 

  	Now since i don;t know where that point will be i can find that with the check. 
   	if num[mid] < num[mid-1] OR if -> num[mid] > num[mid+1]

    	The trick to write the above check condition is, remember i may have got mid as the minimum or else it may be the previous one too. 
     	So i need to check mid with mid -1 and mid with mid+1
      	Now in a normal sorted array what will be the relation b/w mid , mid+1 and mid -1 
       		num[mid] > num[mid-1] ---> num[mid] < num[mid-1] 
	 	num[mid] < num[mid+1] ---> num[mid] > num[mid+1]
   		So here we just reverse it and chek for the flux point. as in RHS 
     		
In this the i am not finding mid point like we generally do. Rather the condition itself is something to check. 
in normal BS
if nums[index] == x 
if nums[mid] > x -> search left
if(nums[mid] < x -> search right 

here i don't have mid so use condition instead. 
"""
[Tags]: 
[/Note]

*/
/*
 while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
*/

public class RotatedSortedArray {
    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // If the array is not rotated, return the first element
        if (arr[low] < arr[high]) {
            return arr[low];
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            // Check if mid is the minimum element
            if (arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }
            // Check if mid is the minimum element by comparing with mid-1
            if (arr[mid - 1] > arr[mid]) {
                return arr[mid];
            }
            // Decide which half to continue the search
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // If the array is properly sorted but rotated, return arr[0]
        return arr[0];
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int min = findMin(arr);
        System.out.println("Minimum element in the rotated sorted array: " + min);
    }
}


public class Main {
    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // If the array is not rotated, return the first element
        if (arr[low] < arr[high]) {
            System.out.println("sd");
            return arr[low];
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            // Check if mid is the minimum element
            if (arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }
            // Check if mid+1 is the minimum element
            if (arr[mid - 1] > arr[mid]) {
                return arr[mid];
            }
            // Decide which half to continue the search
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // If the array is properly sorted but rotated, return arr[0]
        return arr[0];
    }

    public static void main(String[] args) {
        int[] arr = { 6,5,4};
        int min = findMin(arr);
        System.out.println("Minimum element in the rotated sorted array: " + min);
    }
}



class Solution2 {
    public int findMin(int[] nums) {

        // containrs
        int size = nums.length;
        int l = 0, r = size-1;
        
        // process
        while(l < r){

            int mid = (r+l)/2;
            System.out.printf("mid %d, num %d \n",  mid, nums[mid]);
            // flux point
            if(nums[mid] < nums[mid+1]){
                return nums[mid];
            }
            else if(nums[mid] > nums[r]){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        return nums[0];
        
        
    }
}
class Solution {
    public int findMin(int[] nums) {

        // containers
        int size = nums.length;
        int l = 0, r = size-1;
        
        // process
        while(l <= r){
            int mid = (r + l) / 2;
            
            // flux point
            if( nums[(mid-1+size) % size] > nums[mid] && nums[mid] < nums[(mid+1) % size] ){
                return nums[mid];
            }
            else if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return nums[0];
    }
}
