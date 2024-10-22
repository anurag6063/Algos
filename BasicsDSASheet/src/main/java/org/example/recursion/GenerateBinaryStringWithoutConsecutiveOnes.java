package BasicsDSASheet.src.main.java.org.example.recursion;

//https://www.geeksforgeeks.org/generate-binary-strings-without-consecutive-1s/?utm_source=youtube

// Do not forget to add return in the base condition block.
public class GenerateBinaryStringWithoutConsecutiveOnes {
  public static void main(String[] args) {
    int k =3;
    fun(k);
  }

  static void fun(int k){
    if(k <= 0){
      return;
    }
    char[]  ch = new char[k];
    ch[0]= '0';
    generate(k, ch, 1);

    ch[0] = '1';
    generate(k, ch, 1);
  }

  static void generate(int k, char[] ch, int n){
    if(n == k){
      System.out.println(new String(ch));
      return;
    }

    if(ch[n-1]== '0'){
      ch[n] = '0';
      generate(k, ch, n+1);
      ch[n] = '1';
      generate(k, ch, n+1);
    }

    if(ch[n-1]== '1'){
      ch[n] = '0';
      generate(k, ch, n+1);
    }
  }
}