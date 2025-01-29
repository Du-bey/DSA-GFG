//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long N = sc.nextLong();

            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for (long num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        ArrayList<Long> ans = new ArrayList<>();
        f(1, 1, n, ans);
        return ans;
    }
    
    static void f(long x, long val, long n, ArrayList<Long> ans){
        if(val <= n) ans.add(val);
        else return;
        x += 1;
        val *= x;
        f(x, val, n, ans);
    }
}