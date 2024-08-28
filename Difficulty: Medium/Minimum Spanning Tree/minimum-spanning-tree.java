//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int spanningTree(int v, int e, List<List<int[]>> adj) {
        ArrayList<Trio> edges=new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            List<int[]> node=adj.get(i);
            for(int[] arr:node){
                int nei=arr[0];
                int wei=arr[1];
                edges.add(new Trio(wei,i,nei));
            }
        }
        Collections.sort(edges);
        
        //now make the minimum spanning tree
        DisjointSet ds=new DisjointSet(v);
        int sumOfWei=0;
        for(int i=0;i<edges.size();i++){
            Trio edge=edges.get(i);
            int wei=edge.wei;
            int node=edge.node;
            int nei=edge.nei;
            if(ds.unionBySize(node,nei)){
                sumOfWei+=wei;
            }
        }
        return sumOfWei;
    }
}
class DisjointSet{
    ArrayList<Integer> par=new ArrayList<>();
    ArrayList<Integer> rank=new ArrayList<>();
    ArrayList<Integer> size=new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<n;i++){
            par.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    
    int findUltPar(int node){
        if(par.get(node)==node){
            return node;
        }
        int ultPar=findUltPar(par.get(node));
        par.set(node,ultPar);
        return par.get(node);
    }
    
    boolean unionByRank(int u,int v){
        int parU=findUltPar(u);
        int parV=findUltPar(v);
        if(parU==parV){
            return false;
        }
        int rankParU=rank.get(parU);
        int rankParV=rank.get(parV);
        if(rankParU>rankParV){
            par.set(parV,parU);
        }else if(rankParV>rankParU){
            par.set(parU,parV);
        }else{
            par.set(parU,parV);
            rank.set(parV,parV+1);
        }
        return true;
    }
    
    boolean unionBySize(int u,int v){
        int parU=findUltPar(u);
        int parV=findUltPar(v);
        if(parU==parV){
            return false;
        }
        int sizeParU=size.get(parU);
        int sizeParV=size.get(parV);
        if(sizeParU>sizeParV){
            par.set(parV,parU);
            size.set(parU,parU+parV);
        }else{
            par.set(parU,parV);
            size.set(parV,parU+parV);
        }
        return true;
    }
}
class Trio implements Comparable<Trio>{
    int wei;
    int node;
    int nei;
    Trio(int wei,int node,int nei){
        this.wei=wei;
        this.node=node;
        this.nei=nei;
    }
    public int compareTo(Trio o){
        return this.wei-o.wei;
    }
}