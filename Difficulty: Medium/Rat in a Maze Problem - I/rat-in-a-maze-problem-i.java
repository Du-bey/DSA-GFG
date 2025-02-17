//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        String s = "";
        ArrayList<String> ans = new ArrayList<>();
        if(mat.get(0).get(0) == 0) return ans;
        solve(0, 0, mat, s, ans);
        return ans;
    }
    
    static void solve(int i, int j, ArrayList<ArrayList<Integer>> mat, String path, ArrayList<String> ans){
        int n = mat.size();
        if(i < 0 || j < 0 || i >= n || j >= n) return;
        if(mat.get(i).get(j) == 0) return;
        if(i == n-1 && j == n-1){
            ans.add(path);
            return;
        }
        
        mat.get(i).set(j, 0);
        
        
        solve(i+1, j, mat, path + 'D', ans);
        solve(i, j-1, mat, path + 'L', ans);
        solve(i, j+1, mat, path + 'R', ans);
        solve(i-1, j, mat, path + 'U', ans);
        
        mat.get(i).set(j, 1);
    }
}