
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


/*
https://leetcode.com/problems/insert-interval/

Our overall algorithm will look like this:

Skip all intervals which end before the start of the new interval, i.e., skip all intervals with the following condition:
    intervals[i].end < newInterval.start
Let’s call the last interval b that does not satisfy the above condition. If b overlaps with the new interval a (i.e. b.start <= a.end), we need to merge them into a new interval c:
    c.start = min(a.start, b.start)
    c.end = max(a.end, b.end)
*/
class Solution {
   public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new LinkedList<>();
	    int i = 0;
	    // add all the intervals ending before newInterval starts
	    while (i < intervals.length && intervals[i][1] < newInterval[0]){
	        result.add(intervals[i]);
            System.out.println("adding "+intervals[i]);
	        i++;
	    }
	    
	    // merge all overlapping intervals to one considering newInterval
	    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
	    	// we could mutate newInterval here also
            System.out.println( "merge " +intervals[i][0]);
	        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
	        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
	        i++;
	    }
	    
	    // add the union of intervals we got
	    result.add(newInterval); 
	    

	    // add all the rest
	    while (i < intervals.length){
	    	result.add(intervals[i]); 
	    	i++;
	    }
	    
	    return result.toArray(new int[result.size()][]);
    }
}
