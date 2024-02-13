
/*
[Note]
[Reference]: chatgpt
[Problem]: https://leetcode.com/problems/k-closest-points-to-origin/
[Pattern]: heap with complex DS inside it
[Tips]: use map inside it
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

import java.util.Map;
import java.util.PriorityQueue;
import java.util.AbstractMap;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Create a priority queue to store the distance and point pairs
        PriorityQueue<Map.Entry<Integer, int[]>> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.getKey(), b.getKey()));

        // Calculate the distance for each point and add it to the priority queue
        for (int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1]; // Calculate the distance
            heap.add(new AbstractMap.SimpleEntry<>(distance, point)); // Add the distance and point to the priority queue
        }

        // Retrieve the k closest points from the priority queue
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, int[]> entry = heap.poll();
            ans[i] = entry.getValue();
        }

        return ans;
    }
}


/*class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // find a closest point closest to origin
        // origin distace is x = sqrt(x^2 + y^2);
        // we don't need to caluculate just do a sum of x^2 + y^2 and
        // put in priority queue, since closest we want, min heap is what ot generally maintains
        // find the distance and put.
        // then loop for no on k times and ket it out and put the value of point in the answer. 

        PriorityQueue<Map.Entry<Integer, int[]>> heap = new PriorityQueue<>();
        Map<Integer, int[]> map = new HashMap<>();

        for(int[] point: points){
            map.put( point[0]*point[0]+ point[1]*point[1], point);
        }

        for(Map.Entry<Integer, int[]> entry: map.entrySet()){
            heap.add(entry);
        }

        int[][] ans = new int[k][2];
        for(int i=0; i<k;i++){
            Map.Entry<Integer, int[]> entry = heap.poll();
            ans[i]= entry.getValue();
        }
        
        return ans;
    }
}

*/