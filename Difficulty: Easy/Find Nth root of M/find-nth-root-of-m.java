//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthRoot(int n, int m)
    {
        // code here
        int l = 1;
        
        if(m == 1 || n == 1) return m;
        int h = (int) Math.sqrt(m);
        while(l <= h){
            int mid = (l+h)/2;
            int pr = (int) Math.pow(mid, n);
            if(pr == m) return mid;
            else if(pr > m){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }
}