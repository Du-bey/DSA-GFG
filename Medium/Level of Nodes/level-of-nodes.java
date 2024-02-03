//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    public static int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int x)
    {
        boolean[] vis = new boolean[V];
        vis[0] = true;
        return dfs(V, adj, vis, x, 0, 0);
    }
    
    private static int dfs(int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int x, int node, int level){
        if(node == x) return level;
        vis[node] = true;
        int ans = 0;
        for(int it : adj.get(node)){
            if(!vis[it]){
                if(it == x) return level+1;
                ans = dfs(V, adj, vis, x, it, level+1);
                if(ans != -1) return ans;
            }
            
        }
        return -1;
    }
}