//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int last = arr[0];
        int ans = 1;
        int cnt = 1;
        for(int i =1;i<n;i++){
            if(arr[i] == last + 1){
                cnt++;
            }
            else if(arr[i] != last){
                cnt = 1;
            }
            last = arr[i];
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}