
/*
[Note]
[Reference]: https://www.youtube.com/watch?v=4775IgUKfww
[Problem]: https://leetcode.com/problems/subarray-product-less-than-k/submissions
[Pattern]: 2 pointers, same direction
[Tips]: 2 pointers, same direction; move left conditionally; when product >= k; then move the left; else not. if product not reached add count = r-l+1, once reached, i need to loose the LHS till the left reaches apoint when the product again comes below given K.
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/
class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int l =0;
        int count = 0;
        int product = 1;
        for(int r =0; r < nums.length; r++){
            product *= nums[r];

            if(product >= k){
                while(product >= k && l <=r ){
                    product /= nums[l];
                    l++;
                }
            }

            count += r-l+1;
        }

        return count;
    }
    public int numSubarrayProductLessThanK_Self_Incorect(int[] nums, int k) {
        
        int l = 0;
        int r = 0;
        int count = 0;
        long product = 1;

        while( r < nums.length){

            product = product*nums[r];
            System.out.printf("count %d,  pro %d, l %d, r %d \n", count, product, l, r );
            if(product < k){
                System.out.println(" r-l+1 "+  (r-l+1));
                count += r-l+1;
            }else{
               
                l = r;
                product = 1;
            }
            r++;
        }

        return count;
    }
}