/*
# Algos
[Note]
[Reference]: https://www.youtube.com/watch?v=qKczfGUrFY4
[Problem]: https://leetcode.com/problems/merge-intervals/?envType=study-plan-v2&envId=top-interview-150
[Pattern]: Intervals
[Tips]: Sort to decrease in order to search for overlap, check if lastEnd >= currentStart if yes lastEnd = Max(lastEnd, CurrentEnd)
[Revision]: 1
[Confidence]: 20%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[Intution]: 
"""
Need to find overlaps, one brute force way is to pick an element and look for overlap in the whole array. 
To reduce this used arrays sorting.

Now to find the overlap there is only one simple condition. 
lastEnd >= currentStart if yes lastEnd = Max(lastEnd, CurrentEnd)

Also Note:
to stream collections they areay have stream implementation. 
so list.stream()
For primitive array that could not be retro fitted. 
Stream.of(PrimtiveArrray).
"""
[/Intution]
[QuestionNote]: 
"""

"""
[QuestionNote]
[/Note]
*/


class Solution {
    public int[][] merge(int[][] intervals) {
        
        // validate 
        if(intervals.length < 2){
            return intervals;
        }
        // to reduce complexity sort first
        Arrays.sort(intervals, (x,y) -> Integer.compare(x[0], y[0]));
        Stream.of(intervals).forEach( temp -> System.out.println(temp[0] + " "+ temp[1]));
        // instantiate ans
        List<int[]> ans = new ArrayList<>();
        // instantitate result in ans
        int[] current_interval = intervals[0];
        ans.add(current_interval);
        ans.stream().forEach( temp -> System.out.println("Ans: "+temp[0] + " "+ temp[1]));

        for(int[] anInterval : intervals){
            int anIntervalStart = anInterval[0];
            int anIntervalEnd = anInterval[1];

            int lastIntervalStart = current_interval[0];
            int lastIntervalEnd = current_interval[1];

            // when to overlap 
            // when current intervals start is less that last intervals end
            // if(anIntervalStart <= lastIntervalEnd){
            if( lastIntervalEnd >= anIntervalStart){
                current_interval[1] = Math.max(anIntervalEnd, lastIntervalEnd);
            }else{
                // not merge
                // update current and put the current one in ans
                current_interval = anInterval;
                ans.add(current_interval);
            }

            ans.stream().forEach( temp -> System.out.println("Ans: "+temp[0] + " "+ temp[1]));
            System.out.println("------");

        }

        return ans.toArray(new int[ans.size()][]);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        Stream.of(intervals).forEach(i -> System.out.println(i[0] + " " + i[1]));

        List<int[]> ans = new ArrayList<>();
        int[] last = intervals[0];
        ans.add(last);

        for(int[] interval : intervals){
            int lastStart = last[0];
            int lastEnd = last[1];

            int currentStart = interval[0];
            int currentEnd = interval[1];

            if(lastEnd >= currentStart){
                last[1] = Math.max(lastEnd, currentEnd);
            }else{
                last = interval;
                ans.add(last);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

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
