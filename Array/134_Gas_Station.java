
"""
/*
# Algos
[Note]
[Reference]: https://leetcode.com/problems/gas-station/solutions/5070267/easy-as-baby-steps-explained-c-java-python-javascript
[Problem]: https://leetcode.com/problems/gas-station/description/
[Pattern]: Trick
[Tips]: 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[Intution]: 
"""
1. First check if i have enoughh fuel to complete the circuit. That its total gas shlould be greater than total cost
  Next i need to check for each index (skipping why not really sure) 
  Then for each outer index, fuel up and burn, just after fuel up check if current total gas is enough to go till next destination. 
  If not then move the start point to j set flag as false and break away the inner loop.
  try again from this starting index in outer loop. 

  if( j == length of circuit and flag is still true) means car made a round.
  at outer last return -1;
"""
[/Intution]
[QuestionNote]: 
"""

"""
[QuestionNote]
[/Note]
*/
"""
  
  class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        long totalCost = 0;
        long totalGas = 0;

        for (int i = 0; i < len; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }

        if (totalCost > totalGas) {
            return -1;
        }

        for (int i = 0; i < len; i++) {
            boolean flag = true;
            totalGas = 0;

            int j;
            for (j = i; j < len; j++) {
                totalGas += gas[j];
                if (cost[j] > totalGas) {
                    flag = false;
                    i = j;
                    break;
                } else {
                    // System.out.println("breaking away");
                }
                totalGas -= cost[j];
                // System.out.printf("IN total gas %d, i %d, j %d \n", totalGas, i, j);

            }
            // System.out.printf("OUT total gas %d, i %d, j %d \n", totalGas, i, j);

            if (j == len && flag) {
                return i;
            }
        }
        return -1;
    }
}
