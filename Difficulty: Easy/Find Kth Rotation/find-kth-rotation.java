//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> nums) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        int ind = -1;
        int l = 0;
        int h = n-1;
        while(l <= h){
            int m = (l+h)/2;
            if(nums.get(l) <= nums.get(m)){
                if(nums.get(l) < ans){
                    ans = nums.get(l);
                    ind = l;
                }
                l = m + 1;
            }
            else{
                if(nums.get(m) < ans){
                    ans = nums.get(m);
                    ind = m;
                }
                h = m - 1;
            }
        }
        return ind;
    }
}