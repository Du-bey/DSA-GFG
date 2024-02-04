//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closedIslands(int[][] grid, int n, int m)
    {
        // Code here
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i == 0 || j ==0 || i == n-1 || j == m-1){
                    if((!vis[i][j] && grid[i][j] == 1)){
                        q.add(new Pair(i,j));
                        vis[i][j] = true;
                    }
                        
                }
            }
        }

        int[] delr = {0, -1, 0, 1};
        int[] delc = {-1, 0, 1, 0};

        bfs(grid, n, m, vis, q, delr, delc);

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    q.add(new Pair(i,j));
                    bfs(grid, n, m, vis, q, delr, delc);
                    vis[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private static void bfs(int[][] grid, int n, int m, boolean[][] vis, Queue<Pair> q, int[] delr, int[] delc) {
        while (!q.isEmpty()){
            var r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            for(int i1= 0; i1 < 4;i1++){
                int nr = r+ delr[i1];
                int nc = c+ delc[i1];
                if(nr >=0 && nc>=0 && nr< n && nc< m && grid[nr][nc] == 1 && !vis[nr][nc]){
                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }
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