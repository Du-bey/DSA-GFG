//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] nums) {
        // your code here
        int n = nums.length;
        int r = 0;
        int l = 0;
        int jumps = 0;
        int max = 0;
        for(int i =0;i<n;i++){
            if(max < i) return -1;
            max = Math.max(max, i+ nums[i]);
        }
        while(r < n -1){
            int far = 0;
            for(int i =l;i<=r;i++){
                far = Math.max(far, i + nums[i]);
            }
            jumps++;
            l = r + 1;
            r = far;
        }
        return jumps;
    }
}