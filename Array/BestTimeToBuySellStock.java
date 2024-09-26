/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
[Pattern]: Min , Max Math.min/max, And the diff
[Tips]: Find the Min price, Find max profit at each step and compare it with last maxProfit; Think top down, I need to find max Profit, max profit = current price - min price, now this can or cannot be the maxprofit, so Max(max, current price - minPrice); Max profit = min price and then largest number after it, the difference of it. So brute force is to use 2 loops, i = 0 -> n and j = i+1 -> n ; then Math.max(maxP, min-prices[i])
[Revision]: 2
[Confidence]: 90%
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

// #Note: if there is double for loop and i am looking forward and finding something, i can rather look back and do both the things in one shot.
// #Note: looking forward sometimes makes things complex, so look back.
// Here i am looking behind. I am finding the min till now and then can i have a max profit from the found min profit. 


// brute force algorithm

class BestTimeToBuySellStock_BF {
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
// the brute force looks forward. so here. i need to find the min first and then the max profit. so it's double task.


class BestTimeToBuySellStock_OP {
    public int maxProfit(int[] prices) {
    
    // initialize
     int minPrice = prices[0];

     // set default value. and the answer
     int maxP = 0;

     // do sanity check
      if (prices.length < 2) {
        return 0;
      }

    // process
     for(int i=0; i< prices.length ; i++){
        // ideally i should have found first the min price and then fro then the max profit. but math.min will find the min till now.
        minPrice = Math.min(prices[i], minPrice);
        // ideally i should have found all the profits and then the max of it. so Math.max shortens it.
        maxP = Math.max(prices[i] - minPrice , maxP);

     }
    return maxP;
}
}




