//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if(start == end) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));
        int[] m = new int[100000];
        Arrays.fill(m, Integer.MAX_VALUE);
        m[start] = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int steps = p.first;
            int num = p.second;
            for(int i = 0;i<arr.length;i++){
                int newNum = arr[i]* num;
                newNum %= 100000;
                if(m[newNum] > steps + 1){
                    m[newNum] = steps + 1;
                    q.add(new Pair(m[newNum], newNum));
                }
            }
        }
        return m[end] == Integer.MAX_VALUE ? -1 : m[end];
    }
}

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}