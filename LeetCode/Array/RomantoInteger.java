/**
 * https://leetcode.com/problems/roman-to-integer/description/?envType=list&envId=ph9f65i7
 */

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        // when ever i want to see what was stored last use a LL and make a peek. 
        // use Pop etc too. 
        LinkedList<Integer> ll = new LinkedList<>();
        char[] chars = s.toCharArray();
        for(int i = chars.length-1; i >= 0; i--){
            int num = convert(chars[i]);
            if(ll.size() > 0 && num < ll.peek() ){
               result = result - num; 
            }else{
                result = result + num;
            }
            ll.push(num);
        }
        return result;        
    }

    private int convert(char x){
        if(x == 'I'){
            return 1;
        }else if(x == 'V'){
            return 5;
        }else if(x == 'X'){
            return 10;
        }else if(x == 'L'){
            return 50;
        }else if(x == 'C'){
            return 100;
        }else if(x == 'D'){
            return 500;
        }else if(x == 'M'){
            return 1000;
        }

        return 0;
    }
}