 import java.util.*;
 public class climbingStairs{
    //recursion -> TLE
    public static int countWays(int n){

        if(n == 0) return 0;
        if(n <= 2) return n;

        return countWays(n-1) + countWays(n-2);
    }

    //memoization
    public static int countWays(int n, int dp[]){
        if(n == 0) return 1;
        if(n < 1) return 0;

        if(dp[n] != -1) {  // Return memoized result if already computed
           return dp[n];
        }

         // Compute the result and store it in the memoization array
        return dp[n] = countWays(n-1, dp) + countWays(n-2, dp);
    }

    
    
    public static void main(String args[]){
        int n = 5; //n=3 -> 3, n=4 -> 5 => 8
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1); // Initialize memoization array with -1
        System.out.println(countWays(n));
        System.out.println(countWays(n, dp));
    }
 }