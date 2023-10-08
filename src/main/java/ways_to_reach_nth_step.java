import java.util.Scanner;

public class ways_to_reach_nth_step {

    /*
    A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs.

Examples:

Input : 4
Output : 7
Explanation:
Below are the seven ways
 1 step + 1 step + 1 step + 1 step
 1 step + 2 step + 1 step
 2 step + 1 step + 1 step
 1 step + 1 step + 2 step
 2 step + 2 step
 3 step + 1 step
 1 step + 3 step

Input : 3
Output : 4
Explanation:
Below are the four ways
 1 step + 1 step + 1 step
 1 step + 2 step
 2 step + 1 step
 3 step
     */

    // Solution using dynamic programming

    /*
    Complexity Analysis:
Time Complexity: O(n).
Only one traversal of the array is needed. So Time Complexity is O(n).
Space Complexity: O(n).
To store the values in a DP, n extra space is needed.
     */

    public static int countWays(int n){
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for(int i=3; i<=n; i++){
            res[i] = res[i-1] + res[i-2] + res[i-3];
        }
        return res[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        System.out.println(countWays(input));
    }
}
