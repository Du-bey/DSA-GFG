//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(s[j]);
            }
        }

        return mat;
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (ArrayList<Integer> a : m) {
            for (int e : a) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int e = Integer.parseInt(br.readLine());
            int v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.connectedcomponents(v, edges);
            Collections.sort(res, (a, b) -> Integer.compare(a.get(0), b.get(0)));
            IntMatrix.print(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<ArrayList<Integer>> connectedcomponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r : edges){
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for(int i =0;i<n;i++){
            if(!vis[i]){
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(i, vis, adj, temp);
                Collections.sort(temp);
                ans.add(temp);
            }
        }
        return ans;
    }

    public void dfs(int u, boolean[] vis, List<List<Integer>> adj, ArrayList<Integer> temp){
        vis[u] = true;
        temp.add(u);
        for(int v : adj.get(u)){
            if(!vis[v]){
                dfs(v, vis, adj, temp);
            }
        }
    }
}
