/*
# Algos
[Note]
[Reference]: https://www.youtube.com/watch?v=g_hIx4yn9zg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=20
[Problem]: https://leetcode.com/problems/longest-common-subsequence/
[Pattern]: DP + Choices - One if else , in else have to leave either  one.
[Tips]: Think basic DP with the choices. Then make it to DP.
[Revision]: 0
[Confidence]: 10%
[Next]: Practice
[Steps]:
[Code]

[/Code]
[Tags]:
[Intution]:
"""
In it's naive approach i have base condititon, choice and decrementicting value.
BC: when the length of the string goes below 0 it means there can be no match at the return in 0.
so BC is if( text.length() < 0 || text2.length() < 0) return 0;

Also as i know the recursive function works better from back, the best way is to decrement the length from the back.
So Self call : lcs with one lentgh less.

SO Choice and SL
if both the string's last char macthc then i know i have 1 mathc and i need to increase so +1, also now i have processed so i need to reduce the length.
so it becomes if(text1.charAt(m) == text2.charAt(n)) then ans +1 and redice both ie
return 1+ lcs(text1, text2, m-1, n-1)

if it does not matches then either one needs to be reduced ? why either one, because  mayone even if i decrease the length of one of the strincg it may match with the full length of the other one.
But i need one answer out of these 2 options so, it's Max of both
Also since it;s not the answer, i will not add an +1 ti return.
"""

[/Note]
*/
package DP;

public class LongestCommonSubsequence {

  public int naiveApproachLongestCommonSubsequence(String text1, String text2) {
    return lcs(text1, text2, text1.length()-1, text2.length()-1);
  }

  private static int lcs(String text1, String text2, int m, int n){
    if(m < 0 || n < 0){
      return 0;
    }

    if(text1.charAt(m) == text2.charAt(n)){
      return 1+ lcs(text1, text2, m-1, n-1);
    }else{
      return Math.max( lcs(text1, text2, m-1, n),
          lcs(text1, text2, m, n-1));
    }
  }
}
