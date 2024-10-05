package org.example.recursion;

public class FindStringMostDistinctCharacters {
    public static String betterString(String str1, String str2) {
      // Code here
      // i have 2 string.
      // if i find the count of distinct chars in both.
      // and find that which one has more no of distict chars.
      // that will be the ans.

      Set<Character> s1 = new HashSet<>();
      for (int element : str1.toCharArray()) {
        s1.add((char)element);
      }

      // s1.stream().forEach(System.out::println);

      Set<Character> s2 = new HashSet<>();
      for (int element : str2.toCharArray()) {
        s2.add((char)element);
      }
      // System.out.println(s1.size() + " "+ s2.size());
      if(s2.size() > s1.size()){
        // System.out.println("s2 ");
        return str2;
      }else{
        return str1;
      }

    }
}

