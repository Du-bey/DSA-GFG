//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends


class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r : edges){
            int u = r[0];
            int v = r[1];
            int d = r[2];
            adj.get(u).add(new Pair(d, v));
            adj.get(v).add(new Pair(d, u));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.d - b.d);
        pq.add(new Pair(0, 1));
        int[] dis = new int[n+1];
        int[] par = new int[n+1];
        for(int i =0;i<=n;i++){
            par[i] = i;
        }
        
        Arrays.fill(dis, (int) 1e9);
        dis[1] = 0;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int d = p.d;
            int u = p.node;
            for(Pair pair : adj.get(u)){
                int v = pair.node;
                int newdis = pair.d;
                if(dis[v] > dis[u] + newdis){
                    dis[v] = dis[u] + newdis;
                    par[v] = u;
                    pq.add(new Pair(dis[v], v));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        
        if(dis[n] == (int) 1e9){
            ans.add(-1);
            return ans;
        }
        
        int i = n;
        while(par[i] != i){
            ans.add(i);
            i = par[i];
        }
        ans.add(1);
        ans.add(dis[n]);
        Collections.reverse(ans);
        return ans;
    }
}

class Pair {
    int d, node;

    Pair(int d, int node) {
        this.d = d;
        this.node = node;
    }
}