/*
[Note]
[Reference]: https://www.youtube.com/watch?v=DEWBl549h24
[Problem]: https://leetcode.com/problems/queue-reconstruction-by-height
[Pattern]: trick
[Tips]: Sort it by height and then position, insert in LL
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

class 40_QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
     Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1]-b[1] : b[0] - a[0]);
     List<int[]> ordered = new LinkedList<>();
     for(int[] p : people) ordered.add(p[1], p);

     return ordered.toArray(new int[people.length][2]);   
    }
}