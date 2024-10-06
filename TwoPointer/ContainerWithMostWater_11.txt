
/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/container-with-most-water/?envType=list&envId=ecumdrrd
[Pattern]: 2 pointers; opposite end
[Tips]: Keep on edges and increase of the minimum only
[Revision]: 2
[Confidence]: 100%
[Next]: Imagine 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/



class Solution {
    public int maxArea(int[] height) {

// max area// 2 pointer opp end
    int left = 0, right = height.length -1 ;
    int maxArea = 0;
    while(left < right){
        int min = Math.min(height[left], height[right]);
        int area = (right - left) * min ;
        maxArea = Math.max(maxArea, area);
        // i move the one who's height is smaller since i want max water to get stored. 
        // so given 2 options it's better to move the less height one
        if(height[left] < height[right]){
            left++;
        }else{
            right--;
        }
    }
     return maxArea;
}
}
/*


        // can't use sorting sinc the placement is immportant'

        // sliding window but since it's container, do from the ends.'
        // start from both ends. 
        // find lesser of both and the length , 1*8 = 8
        // now move the lesser one in 
        // left = 1
        // now area = lesser of both * dis = 7*7
        // if( curr > area  ) area = curr
        
        int left =0, right = height.length-1 , vol = 0, wide = height.length-1 ;

        while(left < right){
            
            // System.out.println(height[left] + " " + height[right] + " wide "+ wide + " vol "+ vol);
            int curr = Math.min(height[left], height[right]) * wide;
            if(curr>vol){ vol = curr;}

            if(height[left] < height[right]){
                left++;
            }else{ right--;}

            wide --;
        }
    return vol;
    }
}
*/