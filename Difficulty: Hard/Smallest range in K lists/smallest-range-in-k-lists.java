//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}

// } Driver Code Ends


class Solution
{
	static int[] findSmallestRange(int[][] nums,int z,int k)
	{
        int l = nums[0][0];
        int r = nums[0][0];
        PriorityQueue<Trip> pq = new PriorityQueue<>((a, b) -> a.f - b.f);
        for(int i =0;i<k;i++){
            int[] list = nums[i];
            int no = list[0];
            l = Math.min(l, no);
            r = Math.max(r, no);
            pq.add(new Trip(no, i, 0));
        }

        int[] ans = new int[]{l, r};
        while(true){
            Trip t = pq.poll();
            int n = t.f;
            int i = t.s;
            int idx = t.t;
            idx++;
            if(idx >= nums[i].length) break;
            int newNum = nums[i][idx];
            pq.add(new Trip(newNum, i, idx));

            r = Math.max(r, newNum);
            l = pq.peek().f;
            if(r - l < ans[1] - ans[0]){
                ans[1] = r;
                ans[0] = l;
            }
        }
        return ans;
    }
}

class Trip{
    int f;
    int s;
    int t;

    public Trip(int f, int s, int t){
        this.f = f;
        this.s = s;
        this.t = t;
    }
}