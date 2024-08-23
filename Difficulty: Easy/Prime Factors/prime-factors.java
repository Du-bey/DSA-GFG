//{ Driver Code Starts


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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution
{
    public int[] AllPrimeFactors(int n)
    {
        // code here
        List<Integer> l = new ArrayList<>();
        for(int i =2;i<=n;i++){
            if(n % i == 0){
                l.add(i);
                while(n % i == 0){
                    n = n / i;
                }
            }
        }
        int s = l.size();
        int[] ans = new int[s];
        for (int i = 0; i < s; i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }
}