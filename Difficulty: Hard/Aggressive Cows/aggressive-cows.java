//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int l =0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x : stalls){
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        int h = max- min;
        while(l <= h){
            int m = (l+h)/2;
            if(possible(m, k, stalls)){
                l = m + 1;
            }
            else{
                h = m - 1;
            }
        }
        return h;
    }
    public static boolean possible(int m, int k, int[] stalls){
        int cnt = 1;
        int last = stalls[0];
        for(int i =0;i< stalls.length;i++){
            if(stalls[i] - last >= m){
                cnt++;
                last = stalls[i];
            }
            if(cnt >= k) return true;
        }
        return false;
    }
}