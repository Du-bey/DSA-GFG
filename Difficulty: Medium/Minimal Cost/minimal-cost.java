//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int minimizeCost(int arr[], int k) {
        int n = arr.length;
        int [] dp = new int[n];
        
        return f(n-1, arr, k, dp);
    }
    
    public int f(int i, int[] arr, int k,  int [] dp){
        if(i <= 0) return 0;
        if(dp[i] != -1) return dp[i];
        int cost = Integer.MAX_VALUE;
        for(int j = 1;j<=k;j++){
            int fs = Integer.MAX_VALUE;
            if(i >= j){
                fs = Math.abs(arr[i] - arr[i-j]) + f(i-j, arr, k, dp);
            }
            cost = Math.min(cost, fs);
        }
        dp[i] = cost;
        return dp[i];
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, k);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends