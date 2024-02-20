/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=list&envId=ph9f65i7Given
[Pattern]: Matrix
[Tips]: 2 loops outside to go to each element, 1 inside loop to find the equality. grid[row][x] != grid[x][col], remember its x and col and row and x; 
[Revision]: 2
[Confidence]: 70%
[Next]: Practice 
[Steps]: 
[Code]:
			for(int x =0; x < grid[0].length; x++){
                if (grid[row][x] != grid[x][col]){
                    equal = false;
                    break;
                }
			}
	
[/Code]
[/Note]
*/
/**
 * https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=list&envId=ph9f65i7Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 */

class Solution {
    public int equalPairs(int[][] grid) {
        // 0 indexed
        // n * n - that's equal size
        //return pairs
        // equal means row and column contains same elemeent is same order
        // retunr just the count as int.


        // loop i and loop j compare if till end matched count ++

        int count = 0;

        for(int row=0; row < grid[0].length; row++){
            for(int col =0; col< grid[0].length; col++){
                System.out.println("row: "+ row+ " col: "+ col);
                System.out.println(grid[row][col]);
                boolean equal = true;
                for(int x =0; x < grid[0].length; x++){
                if (grid[row][x] != grid[x][col]){
                    equal = false;
                    break;
                }
                }
                if(equal) count++;
            }
        }
        return count;
    }
}
