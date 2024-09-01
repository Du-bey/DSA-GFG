//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
        {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Triplet> q = new PriorityQueue<>((x, y) -> x.first - y.first);
        int[][] dis = new int[n][m];

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[0][0] = grid[0][0];
        q.add(new Triplet(dis[0][0] , 0, 0));
        int[] delr = {0, -1, 0, 1};
        int[] delc = {-1, 0, 1, 0};

        while (!q.isEmpty()){
            int effort = q.peek().first;
            int r = q.peek().second;
            int c = q.peek().third;
            q.remove();
            for(int i=0;i<4;i++){
                int nr = r+delr[i];
                int nc = c+delc[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m ){
                    if(dis[nr][nc] > effort + grid[nr][nc]){
                        dis[nr][nc] = effort + grid[nr][nc];
                        q.add(new Triplet(dis[nr][nc], nr, nc));
                    }

                }
            }
        }
        return dis[n-1][m-1];
    }
}

class Triplet {
    int first;
    int second;
    int third;
    public Triplet(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}


