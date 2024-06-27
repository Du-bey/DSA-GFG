//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] vis = new boolean[n][m];
        int cnt =0;

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    bfs(grid,vis,i, j);
                    cnt++;

                }
            }
        }

        return cnt;
    }
    
    public void bfs(char[][] grid, boolean[][] vis, int r, int c) {
        int n = grid.length;
        int m = grid[0].length;
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};
        Queue<Pair> q = new LinkedList<>();
        vis[r][c] = true;
        q.add(new Pair(r, c));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;
            for(int i =0;i<4;i++){
                for(int j =0;j<4;j++){
                    int nr = row + delr[i];
                    int nc = col + delc[j];
                    if(nr >=0 && nc >=0 && nr < n && nc < m && !vis[nr][nc] && grid[nr][nc] == '1'){
                        q.add(new Pair(nr, nc));
                        vis[nr][nc] = true;
                    }
                }
            }
        }
    }
}

class Pair{
    int r;
    int c;
    public Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}