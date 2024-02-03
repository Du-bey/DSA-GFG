//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {
            
            
            int R = sc.nextInt();
            
            int C = sc.nextInt();
            
           
            
            int hospital[][] = new int[R][C];
            
            int cnt=0;
            for(int i = 0; i < R; i++)
                {
                    for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }
                    
                }
            
            Solution ob = new Solution();
            System.out.println(ob.helpaterp(hospital));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
     public int helpaterp(int[][] hospital) {
        // code here
        int n = hospital.length;
        int m = hospital[0].length;
        Queue<Triplet> q= new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(hospital[i][j] == 2){
                    q.add(new Triplet(0, i,j));
                    vis[i][j] = true;
                }
            }
        }
        
        int ans = -1;
        int[] delr = {0, -1, 0, 1};
        int[] delc = {-1, 0, 1, 0};
        while (!q.isEmpty()){
            var time = q.peek().first;
            int r = q.peek().second;
            int c = q.peek().third;
            q.remove();
            ans = Math.max(time, ans);
            for(int i1= 0; i1 < 4;i1++){
                int nr = r+delr[i1];
                int nc = c+delc[i1];
                if(nr >=0 && nr <n && nc >=0 && nc <m && !vis[nr][nc] && hospital[nr][nc] == 1){
                    q.add(new Triplet(time+1, nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(hospital[i][j] == 1 && !vis[i][j]){
                    return -1;
                }
            }
        }
        return ans;
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
