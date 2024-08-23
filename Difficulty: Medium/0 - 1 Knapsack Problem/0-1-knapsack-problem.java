//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int n = wt.length;
        int[][] dp = new int[n][W+1];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return f(n-1, W, wt, val, dp);
    }
    
    public static int f(int ind, int w, int[] wt, int[] val, int[][] dp){
        if(ind == 0){
            if(wt[0] <= w){
                return val[0];
            }
            else{
                return 0;
            }
        }
        if(dp[ind][w] != -1){
            return dp[ind][w];
        }
        
        int notTake = f(ind - 1, w, wt, val, dp);
        int take = -1000000000;
        if(w >= wt[ind]){
            take = val[ind] + f(ind -1, w - wt[ind], wt, val, dp);
        }
        dp[ind][w] = Math.max(take, notTake);
        return dp[ind][w];
    }
}
