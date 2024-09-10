//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String arr[]) {
        // code here
        int n = arr.length;
        String s1 = arr[0];
        char c1 = s1.charAt(0);
        int st = c1 - 'a';
        int[] in = new int[26];
        int[] out = new int[26];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        
        for(String s : arr){
            char c = s.charAt(0);
            char c2 = s.charAt(s.length() - 1);
            int u = c - 'a';
            int v = c2 - 'a';
            
            in[v]++;
            out[u]++;
            adj.get(u).add(v);
        }
        for(int i=0; i<26; i++) {
            if(in[i] != out[i]) return 0;
        }
        boolean[] vis = new boolean[26];
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        while(!q.isEmpty()){
            int u = q.poll();
            vis[u] = true;
            for(int v : adj.get(u)){
                if(!vis[v]){
                    q.add(v);
                }
            }
        }
        for(int i=0; i<26; i++) {
            if(in[i] > 0 && vis[i] != true)
                return 0;
        }
        return 1;
    }
}