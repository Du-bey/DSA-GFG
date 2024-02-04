//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		obj.precompute();    	
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [][] = new int[M][2];
		    for(int i = 0;i<M;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.helpSanta(N, M, arr);
            System.out.println(ans);
    	    
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Complete{
    

    static ArrayList<Integer> primeList;
    static int cnt = 0;
    
    public static void precompute () {
        primeList = new ArrayList<>();
        
        boolean isPrime[] = new boolean[1000001];
        Arrays.fill(isPrime,true);
        
        isPrime[0]=false;
        isPrime[1]=false;
        
        for(int i=2;i<=1000000;i++){
            if(isPrime[i]==true){
                primeList.add(i);
                for(int j=2*i;j<=1000000;j+=i){
                    isPrime[j]=false;
                }
            }
        }
    }
    
    
    // Function for finding maximum and value pair
    public static int helpSanta (int n, int m, int g[][]) {
        //Complete the function
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<m;i++){
            int u = g[i][0];
            int v = g[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n+1];
        int maxSize = 0;
        for(int i =0;i<n;i++){
            if(!vis[i]){
                cnt = 0;
                dfs(adj, vis, i);
                
                maxSize = Math.max(maxSize, cnt);
            }
        }
        if(maxSize == 1) return -1;
        return primeList.get(maxSize - 1);
    }
    
    public static void dfs (List<List<Integer>> adj, boolean[] vis, int node) {
        //Complete the function
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(adj, vis, it);
            }
        }
        cnt++;
    }
    
}