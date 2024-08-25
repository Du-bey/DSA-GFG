//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wildCard(String p, String s) {
        
        int n = p.length();
        int m = s.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(n-1, m-1, p, s, dp);
    }
    
    public int f(int i, int j, String p, String s, int[][] dp){
        if(i < 0 && j >= 0) return 0;
        if(i < 0 && j < 0) return 1;
        if(i >= 0 && j < 0){
            for(int ind = 0;ind <=i;ind++){
                char c = p.charAt(ind);
                if(c != '*') return 0;
            }
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        
        if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?'){
            dp[i][j] = f(i-1, j-1, p, s, dp);
        }
        else if(p.charAt(i) == '*'){
            int a = f(i-1, j, p, s, dp) + f(i, j-1, p, s, dp);
            if(a > 0) dp[i][j] = 1;
            else dp[i][j] = 0;
        }
        else dp[i][j] = 0;
        return dp[i][j];
    }
}
