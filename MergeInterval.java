
/**
https://leetcode.com/problems/merge-intervals/
https://github.com/Chanda-Abdul/Several-Coding-Patterns-for-Solving-Data-Structures-and-Algorithms-Problems-during-Interviews/blob/main/%E2%9C%85%20%20Pattern%2004%20:%20Merge%20Intervals.md

if there is an overlap ib. a.end < b.start
merged.start = a.start;
merged.end = Max(a.end,b.end)
  
  */
class Solution {
   public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] i : intervals){
            System.out.println(i[1]);
            if (!merged.isEmpty() && merged.getLast()[1] >= i[0])
                merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);
            else merged.add(i);
        }
        return merged.toArray(new int[0][]);
    }
}
