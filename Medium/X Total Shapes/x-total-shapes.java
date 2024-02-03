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
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.xShape(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int ans = 0;
            
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 'X' && !vis[i][j]){
                    bfs(i, j, grid, vis);
                    ans++;
                }
            }
        }
        return ans;
    }
        
    public static void bfs(int i, int j, char[][] grid, boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};
        Queue<Pair> q = new LinkedList<>();
        vis[i][j] = true;
        q.add(new Pair(i,j));
        while (!q.isEmpty()){
            var r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            for(int i1= 0; i1 < 4;i1++){
                int nr = r+delr[i1];
                int nc = c+delc[i1];
                if(nr >=0 && nc>=0 && nr<n && nc<m && grid[nr][nc] == 'X' && !vis[nr][nc]){
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