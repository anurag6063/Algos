/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
[Pattern]: Min , Max Math.min/max
[Tips]: Find the Min profit, Find max profit at each step;
[Revision]: 0
[Confidence]: 50%
[Next]: Practice 
[Steps]: For(prices)-> 0 to <len ; find min ( minPrice, current value); maxP = Math.max(prices[i] - minPrice , maxP);; return the max profit;
[Code]		   
	minPrice = Math.min(prices[i], minPrice);
	maxP = Math.max(prices[i] - minPrice , maxP);
[/Code]
[/Note]
*/

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

 class Solution {
    public int maxProfit(int[] prices) {
     int minPrice = prices[0];
     int maxP = 0;
     if(prices.length < 2)
     return 0;

     for(int i=0; i< prices.length ; i++){
         
        minPrice = Math.min(prices[i], minPrice);
        maxP = Math.max(prices[i] - minPrice , maxP);

     }
    return maxP;
}
}

 // in this we just need to find the min and the max.
 // get the result.


 // initialze the maxProfit value that needs to be returned.
 // initialize minPrince 

 // loop all.
 //     if current price is lower than min
            // set new min
    // else 
      //  max will be Max of current profit or else previous max
      // maxP = Math.max(prices[i] - minPrice , maxP);

 class Solution {
    public int maxProfit(int[] prices) {
     int minPrice = prices[0];
     int maxP = 0;
     if(prices.length < 2)
     return 0;

     for(int i=0; i< prices.length ; i++){

         if(prices[i]<minPrice)
            minPrice = prices[i];

        maxP = Math.max(prices[i] - minPrice , maxP);

     }
    return maxP;
}
}


// brute force algorithm

class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int n = prices.length;
    for( int i=0; i< n; i++){
      for(int j=i+1; j<n; j++){
        System.out.println(maxProfit);
          maxProfit = Math.max(maxProfit, prices[j]- prices[i]);
        }
    }
    return maxProfit;
  }
}


// my same modified code
class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int min=prices[0];
    int n = prices.length;
    for( int i=0; i< n; i++){
     // find the minimum and the maximum post the minimum
     if(prices[i] < min)
        min = prices[i];

      //  System.out.println(maxProfit);
     // even though the min price did not change, may be the max profit can change, since prices[i] is changing.
        maxProfit = Math.max(maxProfit, prices[i]- min);        
    }
    return maxProfit;
  }
}


