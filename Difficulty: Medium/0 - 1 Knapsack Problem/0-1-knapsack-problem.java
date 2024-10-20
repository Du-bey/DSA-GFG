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
        int[][] dp = new int[n + 1][W + 1];

        // Fill the DP table
        for (int ind = 0; ind <= n; ind++) {
            for (int w = 0; w <= W; w++) {
                // Base case: If there are no items or weight capacity is 0
                if (ind == 0 || w == 0) {
                    dp[ind][w] = 0; // Maximum value is 0
                } else {
                    // Not taking the current item
                    int notTake = dp[ind - 1][w];

                    // Taking the current item (if its weight is less than or equal to current capacity)
                    int take = (wt[ind - 1] <= w) ? val[ind - 1] + dp[ind - 1][w - wt[ind - 1]] : Integer.MIN_VALUE;

                    // Store the maximum of taking or not taking the item
                    dp[ind][w] = Math.max(take, notTake);
                }
            }
        }
        return dp[n][W];
    }
    
}
