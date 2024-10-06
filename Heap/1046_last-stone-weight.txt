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

/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.
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