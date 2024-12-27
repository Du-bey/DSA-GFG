//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    static class FastReader{ 
		BufferedReader br; 
		StringTokenizer st; 
  
		public FastReader(){ 
			br = new BufferedReader(new InputStreamReader(System.in)); 
		} 
  
		String next(){ 
			while (st == null || !st.hasMoreElements()){ 
				try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
			} 
			return st.nextToken(); 
		} 
  
		String nextLine(){ 
			String str = ""; 
			try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
			return str; 
		} 
		
		int nextInt(){
		    return Integer.parseInt(next());
		}
	}
	
    public static void main(String args[])throws IOException
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0;i < n;i++)
                arr[i] = sc.nextInt();
            int q = sc.nextInt();
            int queries[] = new int[2*q];
            for(int i = 0;i < 2*q;i++)
                queries[i] = sc.nextInt();
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.querySum(n, arr, q, queries);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < ans.size();i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    List<Integer> querySum(int n, int arr[], int q, int queries[])
    {
        int[] segTree = new int[4*n];
        buildTree(0, 0, n - 1, segTree, arr);
        List<Integer> ans = new ArrayList<>();
        
        for(int i =0;i<q;i++){
            int start = queries[2*i] - 1;
            int end = queries[2*i + 1] - 1;
            ans.add(sumQuery(start, end, 0, 0, n-1, segTree));
        }
        return ans;
    }
    
    public int sumQuery(int start, int end, int i, int l, int r, int[] segTree){
        if(l > end || r < start) return 0;
        if(l >= start && r <= end) return segTree[i];
        
        int mid = (l + r) / 2;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        return sumQuery(start, end, left, l, mid, segTree)
                + sumQuery(start, end, right, mid + 1, r, segTree);
    }
    
    public void buildTree(int i, int l, int r, int[] segTree, int[] arr){
        if(l == r){
            segTree[i] = arr[l];
            return;
        }
        
        int mid = (l + r) / 2;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        buildTree(left, l, mid, segTree, arr);
        buildTree(right, mid + 1, r, segTree, arr);
        
        segTree[i] = segTree[left] + segTree[right];
    }
}