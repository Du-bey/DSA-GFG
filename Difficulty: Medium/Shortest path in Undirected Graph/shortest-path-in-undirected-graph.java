//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int)(1e9);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while (!q.isEmpty()){
            int node =  q.peek();
            q.remove();
            for(int u : adj.get(node)){
                if(dist[u] > 1 + dist[node]){
                    dist[u] = 1 + dist[node];
                    q.add(u);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
}