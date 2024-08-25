//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[V];
        boolean[] recSt = new boolean[V];
        for(int i =0;i<V;i++){
            if(!vis[i] && DFSRec(adj, i, vis, recSt) == true){
                return true;
            }
        }
        return false;
    }
    
    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj,int s, boolean[] visited, boolean[] recSt) { 
    	visited[s]=true;
    	recSt[s]=true;
        
        for(int u:adj.get(s)){
            if(!visited[u] && DFSRec(adj,u,visited,recSt)==true){
                return true;
            }
            else if(recSt[u]==true){
                return true;
            }
        }
        
        recSt[s]=false;
        return false;
	} 
}