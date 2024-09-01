//{ Driver Code Starts
// Initial Template for Java
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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    private int timer = 1;
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int[] t = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        int[] mark = new int[n];
        for(int i =0;i<n;i++){
            if(!vis[i]){
                dfs(i, -1, mark, t, low, vis, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            if(mark[i] == 1){
                ans.add(i);
            }
        }
        if(ans.size() == 0){
            ans.add(-1);
            return ans;
        }
        return ans;
        
    }
    
    public void dfs(int u, int p, int[] mark, int[] t, int[] low, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[u] = true;
        low[u] = t[u] = timer;
        timer++;
        int child = 0;
        for(int v : adj.get(u)){
            if(v == p) continue;
            if(!vis[v]){
                dfs(v, u, mark, t, low, vis, adj);
                low[u] = Math.min(low[u], low[v]);
                if(low[v] >= t[u] && p !=-1){
                    mark[u] = 1;
                }
                child++;
            }
            else{
                low[u] = Math.min(low[u], t[v]);
            }
        }
        if(child > 1 && p == -1){
            mark[u] = 1;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}