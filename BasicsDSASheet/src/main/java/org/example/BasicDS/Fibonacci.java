package org.example.BasicDS;

public class Fibonacci {
    public static void main(String[] args) {
      System.out.println("Hello World");
      int n = 6;

      System.out.println("fibb" + fibb(n));
    }

    private static int fibb(int n){
      if(n <= 1 ){
        return n ;
      }
      System.out.println("n is" + n);
      int num = fibb(n-1) + fibb(n-2);
      System.out.println("factirial is " + num);
      return num;
    }
  }

