package org.example.BasicDS;

public class SumOfNosRecursion {
  public static void main(String[] args) {
    System.out.println("Hello World");

    int sum = printNos(0, 2, 0);
    System.out.println("sum "+ sum);
  }

  private static int printNos(int i, int till, int sum){
    // base case
    if(i >= till){
      return sum+i;
    }
    sum = sum + i;
    // i = i+1;
    return printNos(++i, till, sum);
  }
}

