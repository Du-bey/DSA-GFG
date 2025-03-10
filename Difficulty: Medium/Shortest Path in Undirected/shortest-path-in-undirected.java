//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int n = adj.size();
        int[] dis = new int[n];
        Arrays.fill(dis, 100000000);
        dis[src] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, src));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int u = p.u;
            int d = p.d;
            for(int v : adj.get(u)){
                if(dis[v] > d + 1){
                    q.add(new Pair(d+1, v));
                    dis[v] = d + 1;
                }
            }
        }
        for(int i =0;i<n;i++){
            if(dis[i] >= 10000000) dis[i] = -1;
        }
        return dis;
    }
}


class Pair{
    int d;
    int u;
    public Pair(int d, int u){
        this.d = d;
        this.u = u;
    }
}