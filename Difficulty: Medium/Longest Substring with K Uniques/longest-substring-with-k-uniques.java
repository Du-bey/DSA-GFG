//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> h = new HashMap<>();
        int l = 0;
        int ans = -1;
        for(int r =0;r<n;r++){
            char c = s.charAt(r);
            h.put(c, h.getOrDefault(c, 0) + 1);
            while(h.size() > k){
                char c2 = s.charAt(l++);
                h.put(c2, h.get(c2) - 1);
                if(h.get(c2) <= 0) h.remove(c2);
            }
            if(h.size() == k) ans = Math.max(ans, r - l + 1); 
        }
        return ans;
    }
}