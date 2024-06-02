//https://www.geeksforgeeks.org/window-sliding-technique/

class GFG {
 
    // Returns maximum sum in
    // a subarray of size k.
    static int maxSum(int arr[], int n, int k)
    {
        // n must be greater // initial check
        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }
 
        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum += arr[i];
 
        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            window_sum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }
 
        return max_sum;
    }

// brute force
  static int maxSum(int arr[], int n, int k)
    {   int ans = 0;
    
        // static window synchronized
        System.out.println(n-k);
        for(int i =0 ; i < n-k+1 ; i++){ // add +1 ; else last window is missed 
            System.out.println("element: "+arr[i]);
            int sum = 0;
            for(int j = i ; j < i+k ; j++){ // since i started from j = i; need to do j < i + k ; else the window of k will keep decreasing. 
                System.out.println("in: "+arr[j]);
                sum += arr[j];
            }
            
            ans = Math.max(ans, sum);
        }
        return ans;
    }

  static int maxSum(int arr[], int n, int k)
    {   int ans = 0;
    
        // static window 
        System.out.println(n-k);
        int sum =0;
        int left = 0;
        for(int i =0 ; i < n ; i++){
            
            sum += arr[i];
            System.out.println("element: "+arr[i]);
            

            if( i >= k-1){ // as window hit 
                ans = Math.max(ans, sum);
                sum = sum - arr[left];
                left++;
                
            }
            
            System.out.println("sum: "+ sum);
            System.out.println("max: "+ ans);
            
           
        }
        return ans;
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
 
