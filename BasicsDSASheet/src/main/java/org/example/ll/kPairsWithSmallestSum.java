/*
package java.org.example.ll;

import java.util.HashMap;

//https://www.youtube.com/watch?v=2KgvcmQsIfA&t=1s
//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/solutions/3687075/video-solution-java-c-python/
// https://github.com/INFACTECHZONE/A-TO-Z-COMPANY-CODING-QUESTIONS/blob/main/LeetCode-Questions-CompanyWise-master/linkedin_1year.csv
public class kPairsWithSmallestSum {

}


import java.util.HashMap;

*/
/*
 * Implement the following interface.
 *
 * All methods must run in O(1) time.
 *//*

*/
/** o(1) *//*

 */
/* Example sequence
incrementKey("foo"); // void
incrementKey("foo"); // void
incrementKey("foo"); // void
incrementKey("foo"); // void
incrementKey("bar"); // void
incrementKey("bar"); // void
incrementKey("bar"); // void
incrementKey("bar"); // void
getMaxKey(); // "foo" or "bar" can be returned because foo -> 4, and bar -> 4
getMinKey(); // "foo" or "bar" can be returned because foo -> 4, and bar -> 4
decrementKey("foo"); // void
getMaxKey(); // "bar" because foo -> 3, and bar -> 4
getMinKey(); // "foo" because foo -> 3, and bar -> 4
decrementKey("foo"); // void
decrementKey("foo"); // void
decrementKey("foo"); // void
getMaxKey(); // "bar" because foo is not in the structure, and bar -> 4
getMinKey(); // "bar" because foo is not in the structure, and bar -> 4
*//*


*/
/**
 key - string,
 value - frequency  *//*

interface AllForOne {
  */
/**
   * Increment the provided key's frequency value by 1.  Or add the key with the frequency 1 if it's not present. // increment +1, put 1
   *
   * Note that the actual frequency value of the key is not necessary to expose to the caller; its value is only kept internally for bookkeeping purposes. // internal
   *//*

  void incrementKey(String key);

  */
/**
   * Decrement the provided key's frequency value by 1.  Or remove the key if its frequency is 1.  Do nothing if the key is not present.
   // Not - Do nothing,
   // 1 - remove - 0
   // more than 1 -> -1
   *
   * Note that the actual frequency value of the key is not necessary to expose to the caller; its value is only kept internally for bookkeeping purposes.
   *//*

  void decrementKey(String key);

  */
/**
   * Get one of the keys with the max frequency, or empty string if there are no keys.
   // max - one of them / either of them
   // HM- empty - ""
   *//*

  String getMaxKey();

  */
/**
   * Get one of the keys with the min frequency, or empty string if there are no keys.
   // min
   // ""
   *//*

  //  O(1)
  String getMinKey();
}

class AllForOneImpl implements AllForOne {

  Map<String, Node> map = new HashMap<>();
  Node head =

  public void incrementKey(String key){
    // Increment the provided key's frequency value by 1.  Or add the key with the frequency 1 if it's not present. // increment +1, put 1
    if(map.containsKey(key)){
      // go to the node referece and make increment value
      // set at right index.

    }else{
      // create the node object, add it to tail.
      // insert to map , with this new ref of new node and key
      Node newNode = new Node(1);
    }
  }


}

*/
/**
 max = key , val
 min = key, v
 fod, 3

 HM
 foo - 4
 bar - 6
 foo -> bar

 inr, dec, max, min
 HM - foo (key)
 LL - Node (val)

 -> - bar(4) - foo(4)  <- tail (min)


 min = bar,4
 max = foo,4

 */

