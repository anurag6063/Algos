
/*
[Note]
[Reference]: https://www.youtube.com/watch?v=2hVinjU-5SA
[Problem]: https://leetcode.com/problems/circular-array-loop/
[Pattern]: 2 pointers, slow and fast	
[Tips]: Find next position in cycle, to avoid overflow. Check direction mismacth, do for all indexs.
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
    public boolean circularArrayLoop(int[] arr) {
       
        if(arr.length <= 1) return false;
        
        for(int i = 0; i < arr.length; i++){
            
            int slow, fast;
            slow = fast = i;
            
            // if posistive it's true else false
            boolean ifForward= arr[i]>0;
            
            while(true){
                slow = getNextPosition(arr, slow, ifForward);
                if(slow == -1){break;}
                
                fast = getNextPosition(arr, fast, ifForward);
                if(fast == -1) break;
                
                fast = getNextPosition(arr, fast, ifForward);
                if(fast == -1) break;
                
                if(slow == fast) return true;
            }
        }
        
        return false;
    }
    
    private static int getNextPosition(int arr[], int index, boolean ifForward){
        boolean direction = arr[index] >= 0;
        if(direction != ifForward){
            return -1;
        }
        
        int nextIndex = (index + arr[index]) % arr.length;
        if(nextIndex < 0 ){ 
            nextIndex = nextIndex + arr.length;
        }
        
        if(nextIndex == index){ return -1; }
        
        return nextIndex;
        
    }
}