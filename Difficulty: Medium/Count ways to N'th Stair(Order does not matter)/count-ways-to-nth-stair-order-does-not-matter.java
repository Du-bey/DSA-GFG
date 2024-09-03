//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public long nthStair(int n) {
        // Code here
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return f(n, dp);
    }

    public long f(int n, long[] dp){
        if(n == 0) return 1;
        if(n == 1) return 1;
        
        if(dp[n] != -1) return dp[n];
        dp[n] = 1 + Math.min(f(n-1, dp), f(n-2, dp));
        return dp[n];
    }
}