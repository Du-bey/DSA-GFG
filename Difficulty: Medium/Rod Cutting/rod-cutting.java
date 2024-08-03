//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int coins[], int target) {
        int n = coins.length;
        int[][] dp = new int[n][target+1];
        for(int t =0;t <= target;t++){
            dp[0][t] = t*coins[0];
        } 
        
        for(int i =1;i<n;i++){
            for(int j =0;j<= target;j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(i+1 <= j){
                    take = coins[i] + dp[i][j-(i+1)];
                }
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n-1][target];
    }
}