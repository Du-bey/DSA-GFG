//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    
    public static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        int size = rows*cols;
        DisjointSet ds = new DisjointSet(size);
        int n = operators.length;
        boolean[][] matrix = new boolean[rows][cols];

        boolean[] vis = new boolean[size];
        List<Integer> finalAns = new ArrayList<>();

        int[] rowDel = {-1,0,1, 0};
        int[] colDel = {0,1,0, -1};

        int ans = 0;
        for(int i =0;i<n;i++){
            var rop = operators[i][0];
            var cop = operators[i][1];
            int disNo = cols*rop+cop;
            if(!matrix[rop][cop]) {
                vis[disNo] = true;
                matrix[rop][cop] = true;
                ans++;

                for (int j = 0; j < 4; j++) {
                    int nrow = rop+rowDel[j];
                    int nCol = cop+colDel[j];

                    if(nrow >= 0 && nCol >=0 && nrow < rows && nCol<cols && matrix[nrow][nCol]){
                        int newDsNode = nrow*cols+ nCol;
                        int opDsNode =  rop*cols +cop;
                        if(ds.findUPar(newDsNode) != ds.findUPar(opDsNode)){
                            ds.unionBySize(newDsNode, opDsNode);
                            ans--;
                        }
                        else{
                            ds.unionBySize(newDsNode, opDsNode);
                        }
                    }
                }
            }
            finalAns.add(ans);
        }
        return finalAns;

    }
    
}


 class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i =0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        var pNode = parent.get(node);
        if(node == pNode){
            return node;
        }
        int ulp = findUPar(pNode);
        parent.set(node, ulp);
        return ulp;
    }

    public void unionByRank(int u, int v){
        int up = findUPar(u);
        int vp = findUPar(v);

        if(up == vp) return;
        int ru = rank.get(u);
        int rv = rank.get(v);
        if(rv > ru){
            parent.set(up, vp);
        }
        else if(ru > rv){
            parent.set(vp, up);
        }
        else{
            parent.set(vp, up);
            int upRank = rank.get(up);
            upRank++;
            rank.set(up, upRank);
        }
    }

    public void unionBySize(int u, int v){
        int up = findUPar(u);
        int vp = findUPar(v);

        if(up == vp) return;
        int ru = size.get(u);
        int rv = size.get(v);
        if(rv > ru){
            parent.set(up, vp);
            size.set(vp, size.get(up) + size.get(vp));
        }

        else{
            parent.set(vp, up);
            size.set(up, size.get(up) + size.get(vp));
        }
    }

}




//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends