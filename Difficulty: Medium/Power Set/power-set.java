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
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    List<String> result = new ArrayList<>();
    
    public void solve(String curr,String s,int idx)
    {
        // base
        if(idx==s.length())
        {
            result.add(curr);
            return;
        }
        
        curr+=s.charAt(idx);
        solve(curr,s,idx+1);
        curr = curr.substring(0,curr.length()-1);
        solve(curr,s,idx+1);
        
    }
    
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        String curr="";
        solve(curr,s,0);
        
        Collections.sort(result);
        return result;
    }
}