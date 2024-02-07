/*
[Note]
[Reference]: https://www.youtube.com/watch?v=5P84A0YCo_Y&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=10
[Problem]: https://leetcode.com/problems/k-th-symbol-in-grammar/
[Pattern]: recursion
[Tips]: find mid, reduce k carefully as per mid, call itself
[Revision]: 1
[Confidence]: 40%
[Next]: Practice 
[Steps]: 
[Code]	
	return kthGrammar(n-1, k-mid) == 0 ? 1 : 0;
[/Code]
[Tags]: 
[/Note]
*/


class Solution {
	
	// prints and explained
	public int kthGrammar(int n, int k) {

        // base condition 
        if(n == 1 && k == 1) return 0;
        // since the grammar starts from 0

        // now we need to reduce n = n-1 and k which will depend on value of k. 
        int mid = (int) Math.pow(2,n-1)/2;

        System.out.printf(" n %d k %d \n", n, k);
        if(k <= mid){ // in first half 
             int x = kthGrammar(n-1, k);
             System.out.printf("Post n %d k %d %d \n", n, k, x );
             return x;
        }else{
            // i like this version better
             int x =  kthGrammar(n-1, k-mid) == 0 ? 1 : 0;
              System.out.printf("Post n %d k %d %d \n", n, k, x );
             return x;
        }
        
    }
	
	

    public int kthGrammar(int n, int k) {

        // base condiiton 
        if(n == 1 && k == 1) return 0;
        // since the grammar starts from 0

        // now we need to reduce n = n-1 and k which will depend on value of k. 
        int mid = (int) Math.pow(2,n-1)/2;

        if(k <= mid){ // in first half 
            return kthGrammar(n-1, k);
        }else{
            // i like this version better
            return kthGrammar(n-1, k-mid) == 0 ? 1 : 0;
        }

    }


    public int kthGrammar_1(int n, int k) {
        
        // base case 
        if(n == 1 && k == 1) return 0;

        // hypohesis with smaller value 
        // kthGrammer(n-1, k) // is does not gets smaller, but rather gives the answer.

        int mid = (int) Math.pow(2, n-1)/2;
        // int mid = (int) len/2;
        
        if(k <= mid ){
            return kthGrammar(n-1,k);
        }else{
             int t = kthGrammar(n-1,k-mid) ;
             return t^1;
             
        }
    }
}