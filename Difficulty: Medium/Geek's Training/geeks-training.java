//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][], int N) {
        // code here
        int[][] dp = new int[N][4];
        int lMax = 0;
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][1], Math.max(arr[0][2], arr[0][0]));
        
        for(int i =1;i<N;i++){
            for(int l = 0;l<=3;l++){
                dp[i][l] = 0;
                for(int task =0;task<3;task++){
                    if(task != l){
                        int p = arr[i][task] + dp[i-1][task];
                        dp[i][l] = Math.max(dp[i][l], p);
                    }
                }
            }
        }
        return dp[N-1][3];
    }
    
    public int f(int arr[][], int ind, int last, int[][] dp){
        
        if(dp[ind][last] != -1){
            return dp[ind][last];
        }
        int lMax = 0;
        for(int i =0;i<=2;i++){
            if(i != last){
                int p = arr[ind][i] + f(arr, ind - 1, i, dp);
                lMax = Math.max(lMax, p);
            }
        }
        dp[ind][last] = lMax;
        return dp[ind][last];
    }
}