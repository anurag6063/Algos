// https://www.naukri.com/code360/problems/subset-sum_630213?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

package org.example.recursion;

public class SubsetSum {
    public static boolean isSubsetPresent(int n, int k,int []a) {
      // Write your code here

      return findSubset(n, k , a, 0, 0 );
    }

    static boolean findSubset(int n, int k, int[] a, int i, int tempSum){

      if(i == n){
        if(tempSum == k){
          return true;
        }
        return false;
      }

      // tempSum = tempSum + a[i];
      boolean resX = findSubset(n, k, a, i+1, tempSum + a[i]);


      // tempSum =tempSum - a[i];
      boolean resY = findSubset(n, k, a, i+1, tempSum - a[i]);
      return resX || resY ;

    }

}
