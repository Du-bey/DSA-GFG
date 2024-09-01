//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i =0;i<V;i++){
            revAdj.add(new ArrayList<>());
            if(!vis[i]){
                dfs1(i, vis, st, adj);
            }
        }
        
        for(int i =0;i<V;i++){
            vis[i] = false;
            for(int v : adj.get(i)){
                revAdj.get(v).add(i);
            }
        }
        int cnt = 0;
        while(!st.isEmpty()){
            int u = st.pop();
            if(!vis[u]){
                cnt++;
                dfs2(u, vis, revAdj);
            }
        }
        return cnt;
    }
    
    public void dfs1(int u, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        vis[u] = true;
        for(int v : adj.get(u)){
            if(!vis[v]){
                dfs1(v, vis, st, adj);
            }
        }
        st.push(u);
    }
    
    public void dfs2(int u, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[u] = true;
        for(int v : adj.get(u)){
            if(!vis[v]){
                dfs2(v, vis, adj);
            }
        }
    }
}
