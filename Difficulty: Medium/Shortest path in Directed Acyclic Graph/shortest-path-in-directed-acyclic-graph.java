//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int n, int m, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i =0;i<n;i++){
		    adj.add(new ArrayList<>());
		}
		for(int[] row : edges){
		    int u = row[0];
		    int v = row[1];
		    int d = row[2];
		    adj.get(u).add(new Pair(v, d));
		}
		int[] dis = new int[n];
		Arrays.fill(dis, (int) 1e9);
		dis[0] = 0;
		int[] tsort = topoSort(n, adj);
		for(int i =0;i<n;i++){
		    int u = tsort[i];
		    for(Pair p : adj.get(u)){
		        int v = p.first;
		        int d = p.second;
		        if(dis[v] > dis[u] + d){
		            dis[v] = dis[u] + d;
		        }
		    }
		}
		
		for(int i=0;i<n;i++){
		    if(dis[i] == (int) 1e9){
		        dis[i] = -1;
		    }
		}
		return dis;
		
	}
	
	int[] topoSort(int V, ArrayList<ArrayList<Pair>> adj) 
    {
        // add your code here
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        for(int i =0;i<V;i++){
            for(Pair p : adj.get(i)){
                indegree[p.first]++;
            }
        }
        int ind = 0;
        int[] ans = new int[V];
        for(int i =0;i<V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int u = q.poll();
            ans[ind++] = u;
            for(Pair p : adj.get(u)){
                int v = p.first;
                indegree[v]--;
                if(indegree[v] == 0){
                    q.add(v);
                }
            }
        }
        return ans;
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