public class dp {

    //Fibonacci Memoization
    public static int fibMemo (int n, int[] f) {
        // Base case
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = fibMemo(n - 1, f) + fibMemo(n - 2, f);
        return f[n];
    }

    //Fibonacci Tabulation
    public static int fibTabu (int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[] f = new int[n + 1];
        System.out.println("Fibonacci: "+fibMemo(n, f));
        System.out.println("Tabulation: "+fibTabu(n));
    }
}