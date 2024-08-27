//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int nums[]) {
        // add your code here
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i =0;i<n;i++){
            int x = nums[i];
            h.put(x, h.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(h.entrySet());
        list.sort((a, b) -> {
            int val = b.getValue().compareTo(a.getValue());
            if(val != 0){
                return val;
            }
            else{
                return a.getKey().compareTo(b.getKey());
            }
        });

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            int value = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result.add(value);
            }
        }
        return result;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends