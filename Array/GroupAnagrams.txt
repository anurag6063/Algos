
/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/group-anagrams/
[Pattern]: 
[Tips]: 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[Intution]: 
"""
It's about mapping the sorted string name with the given string. 

pain points have neen:
1. create a string out to char array. 
String str = new String(charrray);

2. to create a list of list. 
  I used a hashMap as ans
  then when the hashMap did not contain the the value created a new Linked List for the value. 
  then added a node to the LL as add. 
"""
[/Intution]
[QuestionNote]: 
"""

"""
[QuestionNote]
[/Note]
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sortedStr = new String(chars); // #Memorize

      System.out.printf(" key %s , value %s", sortedStr.toString(), str.toString());
      if (map.containsKey(sortedStr)) {
        map.get(sortedStr).add(str);
      } else {
        // create a new LL head itself
        map.put(sortedStr, new LinkedList<String>());
        // now fetch the LL and add a node to it.
        map.get(sortedStr).add(str);
      }
    }
    return new LinkedList<>(map.values()); // #Memorize - convert map to LL.
  }
}
