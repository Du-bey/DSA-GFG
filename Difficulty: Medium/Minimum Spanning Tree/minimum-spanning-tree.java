//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        
        minHeap.offer(new Pair(0, 0));
        int totalWeight = 0;

        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            int node = current.node;
            int weight = current.weight;

            if (visited[node]) continue;

            visited[node] = true;

            totalWeight += weight;

            // Explore all the adjacent vertices
            for (int[] neighbor : adj.get(node)) {
                int adjacentNode = neighbor[0];
                int edgeWeight = neighbor[1];
                if (!visited[adjacentNode]) {
                    minHeap.offer(new Pair(adjacentNode, edgeWeight));
                }
            }
        }
        return totalWeight;
    }
}
class Pair {
    int node;
    int weight;

    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
    
    
    
    
    