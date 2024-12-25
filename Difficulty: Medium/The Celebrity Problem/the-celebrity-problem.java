//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int ans = -1;
        boolean found = false;
        for(int i =0;i<n;i++){
            found = false;
            for(int j =0;j<m;j++){
                if(mat[i][j] == 1){
                    found = true;
                    break;
                }
            }
            if(!found) {
                if(ans != -1) return -1;
                ans = i;
            }
        }
        if(ans == -1) return ans;
        found = false;
        for(int i =0;i<n;i++){
            if(ans != i && mat[i][ans] == 0){
                found = true;
                break;
            }
        }
        return found ? -1 : ans;
    }
}