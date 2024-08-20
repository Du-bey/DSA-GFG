//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        Pair[] pair = new Pair[n];
        for(int i =0;i<n;i++){
            Pair p = new Pair(start[i], end[i]);
            pair[i] = p;
        }
        Arrays.sort(pair, (a, b) -> a.second - b.second);
        int last = pair[0].second;
        int ans = 1;
        for(int i =1;i<n;i++){
            if(last < pair[i].first){
                ans++;
                last = pair[i].second;
            }
        }
        return ans;
    }
    
    
    class Pair{
        int first;
        int second;
        
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
