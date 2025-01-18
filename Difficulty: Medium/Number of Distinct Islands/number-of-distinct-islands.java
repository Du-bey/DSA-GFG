//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

 class Solution {

    public static String dfs(int row, int col, int[][] arr) {
        StringBuilder sb = new StringBuilder();
        int n = arr.length;
        int m = arr[0].length;
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, 1, 0, -1 };
        int ab[] = {1, 2, 3, 4};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            int r = p.a;
            int c = p.b;
            for(int i =0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >=0 && nc >=0 && nr < n && nc < m && arr[nr][nc] == 1){
                    arr[nr][nc] = 2;
                    q.add(new Pair(nr, nc));
                    sb.append(ab[i]);
                }
                else{
                    sb.append(0);
                }
            }
        }
        return sb.toString();
    }
    
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    set.add(dfs(i, j, grid));
                }
            }
        }
        return set.size();
    }
}

class Pair{
    int a;
    int b;
    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}

