/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/last-stone-weight/
[Pattern]: Heap, in reverse
[Tips]: use PriorityQueue<Integer>((x,y)-> Integer.compare(y,x) to have a heap with max at top.
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
    public int lastStoneWeight(int[] stones) {
        // we will keep this is priority queue, in reverse
        // use peek for top 2
        // check diff of weight if the weights are same, 
        // remove both
        // else the heavier one will get Y = Y-X; and remove the lighter one

        PriorityQueue<Integer> heap = new PriorityQueue<>((x,y) -> Integer.compare(y,x));

        for(int stone: stones){
            heap.add(stone);
        }

        while(heap.size() > 1){
            int y = heap.poll();
            int x = heap.poll();

            if( y > x){
                heap.add(y-x);
            }
        }

        return heap.size() == 0? 0: heap.peek();
    }
}