/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/find-the-highest-altitude/?envType=list&envId=ph9f65i7
[Pattern]: keep adding and always find the max
[Tips]: Find the next num and then find the max of the resulting till now. It's like find the max of all the all no till no will be stored in max, now when i see the new no, find the exact no and now compare if the newly formed no is the max or now. Very sismilar to what i would have done manually.
[Revision]: 2
[Confidence]: 100%
[Next]: Practice 
[Steps]: For loop, find the exact no, find the current max.
[Code]	
	
[/Code]
[/Note]

*/

/*
https://leetcode.com/problems/find-the-highest-altitude/?envType=list&envId=ph9f65i7

There is a biker going on a road trip. The road trip consists of n + 1 points at different
 altitudes. The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in altitude
 between points i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
*/

// cumulative sum
// max cum sum = 0
// cum sum = 0
// i= 0->n
//max cum sum

class FindtheHighestAltitude {
  public int largestAltitude(int[] gain) {
    int maxAltitude = 0;
    int currentAltitude = 0;

    for (int i = 0; i < gain.length; i++) {
      currentAltitude += gain[i];
      maxAltitude = Math.max(maxAltitude, currentAltitude);
    }
    return maxAltitude;
  }
}

