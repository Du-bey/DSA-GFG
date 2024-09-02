//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends

class Solution
{
	public int minOperations(String s1, String s2) { 
	    int n = s1.length();
	    int m = s2.length();
	    int[][] dp = new int[n+1][m+1];
	    for(int[] row : dp){
	        Arrays.fill(row, -1);
	    }
	    return f(n, m, s1, s2, dp);
	} 
	
	public int f(int i, int j, String s1, String s2, int[][] dp){
	    if(i == 0) return j;
	    if(j == 0) return i;
	    
	    if(dp[i][j] != -1) return dp[i][j];
	    
	    int c1 = s1.charAt(i-1);
	    int c2 = s2.charAt(j-1);
	    if(c1 == c2){
	        dp[i][j] = f(i-1, j-1, s1, s2, dp);
	    }
	    else{
	        int a = f(i-1, j, s1, s2, dp);
            int b = f(i, j-1, s1, s2, dp);
            dp[i][j] = 1 + Math.min(a, b);
	    }
        return dp[i][j];
	       
	}
}