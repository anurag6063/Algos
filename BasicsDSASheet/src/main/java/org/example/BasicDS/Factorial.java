package org.example.BasicDS;

public class Factorial {
    public static void main(String[] args) {
      System.out.println("Hello World");

      int fact = printNos(1, 5, 1);
      System.out.println("sum "+ fact);
    }
    // 5 = 1*2*3*4*5

    private static int printNos(int i, int till, int fact){
      // base case
      if(i >= till){
        return fact*i;
      }

      fact =  fact * i;
      System.out.println("num "+ i + "fact "+ fact);

      return printNos( ++i, till, fact);


    }
  }


