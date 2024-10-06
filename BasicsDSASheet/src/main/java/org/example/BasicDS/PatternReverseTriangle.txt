package org.example.BasicDS;

class PatternReverseTriangle {
  static void pattern5(int N)
  {
    // This is the outer loop which will loop for the rows.
    for (int i = 0; i < N; i++)
    {
      // This is the inner loop which loops for the columns
      // no. of columns = (N - row index) for each line here.
//      for (int j = N; j > i; j--)
        for (int j = 0; j < N-1 ; j++) // both works

        {
        System.out.print("* ");
      }

      // As soon as stars for each iteration are printed, we move to the
      // next row and give a line break otherwise all stars
      // would get printed in 1 line.
      System.out.println();
    }
  }

  public static void main(String[] args) {

    // Here, we have taken the value of N as 5.
    // We can also take input from the user.
    int N = 5;
    pattern5(N);
  }
}