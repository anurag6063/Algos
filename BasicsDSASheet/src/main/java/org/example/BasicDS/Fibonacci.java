package BasicsDSASheet.src.main.java.org.example.BasicDS;

public class Fibonacci {
    public static void main(String[] args) {
      int n = 8;
      System.out.println("fibb: " + fibb(n));
    }

    private static int fibb(int n){
      if(n <= 1 ){
        return n ;
      }
//      System.out.println("n is" + n);
      int num = fibb(n-1) + fibb(n-2);
//      System.out.println("factorial is " + num);
      return num;
    }
  }

