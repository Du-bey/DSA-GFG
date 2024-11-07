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
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int nums[]) {
        int[] dp = new int[n];
        int[] hash = new int[n];
        int ind = 0;
        for(int i =0;i<n;i++){
            dp[i] = 1;
            hash[i] = i;
        }
        int max = 1;
        for(int i =1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if(max < dp[i]){
                max = dp[i];
                ind = i;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[ind]);
        while(hash[ind] != ind){
            ind = hash[ind];
            ans.add(nums[ind]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
