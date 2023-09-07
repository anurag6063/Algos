// Java code O(n*k) solution for finding maximum sum of
// a subarray of size k
class GFG {
    // Returns maximum sum in
    // a subarray of size k.
    //https://www.geeksforgeeks.org/window-sliding-technique`
    static int maxSum(int arr[], int n, int k)
    {
        // Initialize result
        int max_sum = Integer.MIN_VALUE;
 
        // Consider all blocks starting with i.
        for (int i = 0; i < n - k + 1; i++) { // almost like controlling the left end. we use +1 because we do want to go on till the last element in the window.
            int current_sum = 0; // 
            for (int j = 0; j < k; j++) // // almost like controlling the right end. since it's initialized at j=0 , it looks simpler, condition is that in arr index we have to do i+j
                current_sum = current_sum + arr[i + j];
 
            // Update result if required.
            max_sum = Math.max(current_sum, max_sum);
        }
 
        return max_sum;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }
}
 
// This code is contributed by Aditya Kumar (adityakumar129)