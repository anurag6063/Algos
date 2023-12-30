
/*

need to understand this.
https://leetcode.com/problems/car-fleet/?envType=list&envId=pheho7s5
*/
import java.util.Arrays;

public class CarFleet {

     public int carFleet(int target, int[] position, int[] speed) {
         int n = position.length;
        if (n == 0) {
            return 0;
        }

        // Create an array of pairs (position, time) and sort it based on position in descending order
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        System.out.println(Arrays.deepToString(cars));

        int fleets = 1; // Initialize with at least one fleet (the last car)

        for (int i = 0; i < n - 1; i++) {
            // if a car which started from behind is taking lesser time that a car in front of it, they will form a fleet together.
            if (cars[i][1] < cars[i + 1][1]) {
                 System.out.println("different fleets"+fleets );
                fleets++;
            } else {
                // If the current car cannot catch up to the car in front, it becomes the leader of a new fleet 
                cars[i + 1][1] = cars[i][1];
                 System.out.println("jaoining fleets" );
            }
        }

        return fleets;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        int result = carFleet(target, position, speed);
        System.out.println(result);
    }
}
