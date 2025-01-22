//package java.org.example.heap;
package BasicsDSASheet.src.main.java.org.example.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Memorize {

  public static void main(String[] args) {
    System.out.println(Math.pow(2,2));

    System.out.println((int)'a');
    System.out.println((int)'z');
    System.out.println((int)'A');
    System.out.println((int)'Z');
    System.out.println((int)'0');
    System.out.println((int)'9');
    // ASCII has 128 chars.
    // 0 to 9 -> 48 to 57
    // A to Z -> 65 to 90
    // a to z -> 97 to 122

    for(int i = 0 ; i < 128 ; i++){
      System.out.println((int) i + " : " + (char)i);
    }
    int count = (int)'z' - (int)'a' + 1;
    System.out.println("No of chars: "+ count);

    int[] arrChars = new int[26];
    arrChars['z'-'a'] = 1;
    int i = 'c'-'a';
    System.out.println(arrChars['z'-'a'] + " : "+ i);

    System.out.println(Character.isAlphabetic('a'));
    System.out.println(Character.isDigit('9'));
    System.out.println(Character.isLowerCase('a'));
    System.out.println(Character.isUpperCase('a'));
    System.out.println(Character.getNumericValue('a'));// return unicode value. not ASCII
    System.out.println(Character.isLetter('A'));
    System.out.println(Character.isSpaceChar(' '));
    System.out.println(Character.isWhitespace(' '));
    System.out.println(Character.isLetterOrDigit(10));


    Map<Integer, Integer> freqMap = new HashMap<>();
    int[] nums = {13,2,12,32,32,12,12};
    for(int j =0; j < nums.length; j++) {
      freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
      freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
    }
    freqMap.entrySet().stream().forEach(x -> System.out.println(x.getKey() + " : " + x.getValue()));
    charsInHM();
  }

  private static void charsInHM(){
    Map<String, List<String>> map = new HashMap<>();

    String str = "anurag";
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    String sorted = new String(chars);

    if(map.containsKey(sorted)){
      map.get(sorted).add(str);
    }else{
      map.put(sorted, Arrays.asList(str));
    }
    map.put("as", Arrays.asList(str));

    List<List<String>> list = new ArrayList<>(map.values());
  }
}
