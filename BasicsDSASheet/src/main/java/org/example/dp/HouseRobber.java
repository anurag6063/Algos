package BasicsDSASheet.src.main.java.org.example.dp;

import java.util.ArrayList;

public class HouseRobber {

  private static int solve(ArrayList<Integer> arr) {
    int n = arr.size();
    int prev = arr.get(0);
    int prev2 = 0;

    for (int i = 1; i < n; i++) {
      int pick = arr.get(i);
      if (i > 1) {
        pick += prev2;
      }
      int nonPick = prev;
      int cur_i = Math.max(pick, nonPick);

      prev2 = prev;
      prev = cur_i;
    }
    return prev;
  }

  private static int robStreet(int n, ArrayList<Integer> arr) {
    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();

    if(n==1){
      return arr1.get(0);
    }

    for(int i =0; i < n ; i++){
      if(i !=0){
        arr1.add(arr.get(i)); // skip first element
      }
      if(i != n-1){
        arr2.add(arr.get(i));
      }
    }

    int ans1 = solve(arr1);
    int ans2 = solve(arr2);

    return Math.max(ans1, ans2);
  }

}
