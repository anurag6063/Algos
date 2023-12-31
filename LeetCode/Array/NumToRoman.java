/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/integer-to-roman/?envType=list&envId=ph9f65i7
[Pattern]: Trick 	
[Tips]: Use list of valid nums and list of valid corresponding char;
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: Use the valid list of chars and nums; now for each int valid(for), run a while (this is to allow adding multiple same chars like XX etc MM, also when does the char is valid; when valid value <= given incoming no; IN While - bum = num - value[i] si substract the valid no and to final ans string add the valid char like M,X etc; return string.toString; Use SB
[Code]	
	
[/Code]
[/Note]
*/
/**
 * https://leetcode.com/problems/integer-to-roman/?envType=list&envId=ph9f65i7
 * 
 */


class Solution {
    public String intToRoman(int num) {
    
    // these are the valid settings. now they can reperte too for that we have while loop
    // the num and it's minus-1 , roman  nos had importance to 5 too. 
    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    StringBuilder sb = new StringBuilder();
    
    for(int i=0;i<values.length;i++) {
        while(values[i] <= num) {
            System.out.printf("num %d value %d %n", num, values[i]);
            num -= values[i];
            sb.append(strs[i]);
        }
    }
    return sb.toString();
       
        // // 3 - iii
        // // 1994 mcmxciv

        // // 1994 - 1000(m) - 994 - 900(cm) - 94 - 90(xc) - 4 - 4(iv)

        // // for the no divide with max first
        // // 1994 - 4, 90, 900, 1000
        // // find each digit - find it's' represenation 
        // StringBuilder res = new StringBuilder();
        // int x = num;
        // while( x > 0){
        //     int digit = x%10;
        //     if(digit < 4 &&){
        //         res.add('i')
        //     }
        // } 

        
    }
}