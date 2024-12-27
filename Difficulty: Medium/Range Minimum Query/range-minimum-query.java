//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Minimum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
              GfG gfg = new GfG();
            int Q = sc.nextInt();
            
            
            int st[] = gfg.constructST(arr, n);
            int l,r;
            for(int i = 0; i < Q; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                l = Math.min(a,b);
                r = Math.max(a,b);
                
                System.out.print(gfg.RMQ(st, n, l, r) + " ");
                
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/* The functions which 
builds the segment tree */
class GfG
{
    
    public static int[] constructST(int arr[], int n)
    {
        int[] st = new int[4*n];
        buildTree(0, 0, n - 1, st, arr);
        return st;
    }
    
    
    public static int RMQ(int st[], int n, int l, int r)
    {
        return minQuery(l, r, 0, 0, n-1, st);
    }
    
    
    public static int minQuery(int start, int end, int i, int l, int r, int[] st){
        if(l > end || r < start) return Integer.MAX_VALUE;
        if(l >= start && r <= end) return st[i];
        
        int mid = (l + r) / 2;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        return Math.min(minQuery(start, end, left, l, mid, st),
                minQuery(start, end, right, mid + 1, r, st));
    }
    
    public static void buildTree(int i, int l, int r, int[] st, int[] arr){
        if(l == r){
            st[i] = arr[l];
            return;
        }
        
        int mid = (l + r) / 2;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        buildTree(left, l, mid, st, arr);
        buildTree(right, mid + 1, r, st, arr);
        
        st[i] = Math.min(st[left], st[right]);
    }
    
    
}