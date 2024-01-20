
/*
[Note]
[Reference]: https://www.youtube.com/watch?v=53Rux5-mEDQ
[Problem]: https://leetcode.com/problems/next-greater-element-iii/
[Pattern]: 2 pointers; swap; reverse
[Tips]: find first dip from back; swap no with just greater than dip; reverse post the dip. Brute Force: find all permutations, sort them; return first no that's greater than given number.
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
    public int nextGreaterElement(int n) {
    
        
        char[] chars = (""+ n).toCharArray();
        int i = chars.length -2; // start from back with i buffer
        
        while(i >= 0 && chars[i] >= chars[i+1]){
            i--;
        }
        
        if(i == -1) return -1;
        
        int j = chars.length-1;
        while( j > i && chars[j] <= chars[i] ){
            j--;
        }
        
        swap(chars, i, j);
        
        reverse(chars, i+1);
        
        try{
            return Integer.parseInt(new String(chars));
        } catch(Exception e){
            return -1;
        }
    }
    
    private void swap(char[] chars, int i, int j ){
        
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;        
    }
    
    private void reverse(char[] chars, int start){
        int l = start; 
        int r = chars.length -1;
        
        while(l < r){
            swap(chars, l,r);
            l++;
            r--;
        }
    }
}


