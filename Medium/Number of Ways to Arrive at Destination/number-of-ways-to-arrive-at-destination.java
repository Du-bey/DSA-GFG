//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int countPaths(int n, List<List<Integer>> roads)
    {
        // Your code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> road : roads){
            int u = road.get(0);
            int v = road.get(1);
            int w = road.get(2);
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue< Pair5 > pq = new PriorityQueue < Pair5 > ((x, y) -> Long.compare(x.first, y.first));
        long[] dis = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(ways, 0);
        pq.add(new Pair5(0, 0));
        ways[0] = 1;
        dis[0] = 0;
        int mod = (int)(1e9 + 7);

        while(!pq.isEmpty()){
            long d = pq.peek().first;
            int u = pq.peek().second;
            pq.remove();

            for(Pair it : adj.get(u)){
                int v = it.first;
                int edW = it.second;
                if(dis[v] > d + edW){
                    dis[v] = d + edW;
                    ways[v] = ways[u];
                    pq.add(new Pair5(dis[v], v));
                }
                else if(dis[v] == d + edW){
                    ways[v] += ways[u];
                    ways[v] = ways[v] % mod;
                }
            }
        }
        return ways[n-1];
    }
}

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Pair5{
    long first;
    int second;

    public Pair5(long first, int second){
        this.first = first;
        this.second = second;
    }
}

// [
//     [0,6,7],
//     [0,1,2],
//     [1,2,3],
//     [1,3,3],
//     [6,3,3],
//     [3,5,1],
//     [6,5,1],
//     [2,5,1],
//     [0,4,5],
//     [4,6,2]
// ]