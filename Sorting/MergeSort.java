// https://www.youtube.com/watch?v=ogjf7ORKfd8
// https://takeuforward.org/data-structure/merge-sort-algorithm/
// divide and merge algorithm 
// https://www.youtube.com/watch?v=ogjf7ORKfd8
// https://takeuforward.org/data-structure/merge-sort-algorithm/
// divide and merge algorithm 

import java.util.*;

class Solution {
    private static void merge(int[] arr, int low, int mid, int high) {
		// using 2 pointers merge 2 distince array, that are pointer by the indexes
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int left = low; // starting index of ledt array
		int right = mid+1; // starting index of right array
		
		
		while(left <=mid && right <= high){
			if(arr[left] > arr[right]){
				temp.add(arr[left]);
				left++;
			}else{
				temp.add(arr[right]);
				right++;
			}
			
			// now if there are extra elements remaining
			while(left <= mid){
				temp.add(arr[left]);
				left++;
			}
			
			while(right <= high){
				temp.add(arr[right]);
				right++;
			}
			
			// transfer elements from temp to original
			for(int i= low; i<= high; i++){
				arr[i] = temp.get(i-low);
			} 
		}
		
		
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if(low >= high) return;
		int mid = (low+high)/2;
		mergeSort(arr, low, mid);
		mergeSort(arr, low+1, high);
		
		merge(arr, low, mid, high);
		
    }
}
public class tUf {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 7;
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        System.out.println("Before sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Solution.mergeSort(arr, 0, n - 1);
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
