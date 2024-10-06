package org.example.recursion;

public class MathPow {
    public double myPow(double x, int n) {
      if (n == 1) {
        return x;
      }
      // System.out.println(" n " + n);
      if (n > 0) {
        return x * myPow(x, n - 1);
      } else {
        return (1 / x * myPow(x, n + 1));
      }
    }
}
