/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/add-two-numbers/?envType=list&envId=ruypfpvi
[Pattern]: while loop; LL
[Tips]: better for all the cases is use a while loop with OR and then do if inside.
[Revision]: 2
[Confidence]: 80%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/
/*

*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        int carry = 0;

        while(l1 != null || l2 != null || carry == 1){
            int sum =0;

            if(l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + carry;

            carry = sum/10; // we need the extra one here as carry forward
            System.out.println(sum + " "+ sum/10 + " "+ sum%10) ;
            ListNode node = new ListNode(sum%10); //the remainder gets written // 35+89 = 5+9 -> 4 14 so we will here write 1 and carry forward 4 so 14/10= 
            curr.next = node;
            curr = curr.next;
        }
    return ans.next;
    }




/*
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int carry = 0;
        while(l1 != null ||  l2 != null || carry ==1){
            int sum =0;
            // System.out.println(l1.val + " " + l2.val);

            if(l1 != null ){
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }

            sum = sum + carry;
            carry = sum/10;

            ListNode node = new ListNode(sum%10);
            curr.next = node;
            curr = curr.next;
        }


        return res.next;
    }
    */
}