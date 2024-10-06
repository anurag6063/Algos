
/*
[Note]
[Reference]: https://leetcode.com/problems/minimum-window-substring/solutions/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
[Problem]: https://leetcode.com/problems/minimum-window-substring/?envType=list&envId=ecumdrrd
[Pattern]: sliding window , dynamic size
[Tips]: UNSOLVED
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/


class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        HashMap<Character, Integer> mp = new HashMap<>();
// #Note: When i am about to do Math.min or the value has to be less to start with. Use Integer.MAX_VALUE
        int ans = Integer.MAX_VALUE;
        int start = 0;

        for (char x : t.toCharArray())
            mp.put(x, mp.getOrDefault(x, 0) + 1);

        int count = mp.size();

        int i = 0, j = 0;

        while (j < s.length()) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) - 1);
            if (mp.get(s.charAt(j)) == 0)
                count--;

            if (count == 0) {
                System.out.println("count is 0");
                while (count == 0) {
                    System.out.println("While count is 0");
                    if (ans > j - i + 1) {
                        ans = j - i + 1;
                        start = i;
                    }
                    System.out.println("ans "+ ans + "start "+ start);
                    mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
                    if (mp.get(s.charAt(i)) > 0)
                        count++;

                    i++;
                }
            }
            j++;
        }
        if (ans != Integer.MAX_VALUE)
            return s.substring(start, start + ans);
        else
            return "";
    }
}