package BasicsDSASheet.src.main.java.org.example.dp;
/*
# Algos
[Note]
[Reference]: https://takeuforward.org/data-structure/dynamic-programming-introduction/
[Problem]: https://takeuforward.org/data-structure/dynamic-programming-introduction/
[Pattern]: DP Basic , Space optimization
[Tips]:
[Revision]: 0
[Confidence]: 10%
[Next]: Practice
[Steps]:
[Code]
Basic fib code is that
BC: if(n <=1) return n;
and then return of self calls with -1 and -2;

But here rather than returning the ans i will first store it into a arr called dp[[ or ans[].
Once the value has been calculated. I can then return it. So this is how i set the value when i find one.

Now to use the value; just before I do the self calls. I will check if the array index still has the initial value.
if not then use it. since that means i have already calculated it.


Also climibing stairs problem also can same thing.
It has 2 choices either to climb by 1 or 2 so since the problem has 2 sun problems i can use DP.
the base case if different. if( n == 0 || n == 1 ) return 1;
[/Code]
[Tags]:
[/Note]
*/

import java.util.Arrays;

public class BasicFibonacciSeries {

  public static void main(String[] args) {

    int n = 10;
    int[] ans = new int[n+1];
    Arrays.fill(ans, -1);

    System.out.println(fibbo(n, ans));
    System.out.println(fibboSpaceOptimized(10, ans));
  }
  private static int fibbo(int n , int[] ans){
    if(n <=1){
      return n;
    }
    if(ans[n] != -1){
      return ans[n];
    }
    ans[n] = fibbo(n-1, ans) + fibbo(n-2, ans);
    return ans[n];
  }

  private static int fibboSpaceOptimized(int n , int[] ans){

    int prev_1 = 1;
    int prev_2 = 0;

    for(int i = 2; i <= n ; i++){
      int curr = prev_1 + prev_2;
      prev_2 = prev_1;
      prev_1 = curr;
    }
    System.out.println(prev_1 + " " + prev_2 );
    return prev_1;
  }
}
