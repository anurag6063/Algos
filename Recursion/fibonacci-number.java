/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/fibonacci-number/description/
[Pattern]: recusrsion   
[Tips]: 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such
 * that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0, F(1) = 1 F(n) = F(n - 1) + F(n - 2), for n > 1.
 */
class Solution {

  public int fib(int n) {

    // base case
    if (n <= 1) {
      return n;
    }
    // here we are summing oursleves + n-1

    // hypothesis, the function signature and breaking in smaller parts using same
    int x = fib(n - 1);
    int y = fib(n - 2);

    // induction , doing the work
    return x + y;
    // return fib(n-1) + fib(n-2);
  }
}