//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int i = 0;
        int j = 0;
        int n = arr1.size();
        int m = arr2.size();
        int sa = 0;
        int sb = 0;
        int ans = 0;
        while(i<n && j<m){
            if(arr1.get(i) < arr2.get(j)){
                sa += arr1.get(i++);
            }
            else if(arr1.get(i) > arr2.get(j)){
                sb += arr2.get(j++);
            }
            else{
                ans += Math.max(sa, sb) + arr1.get(i);
                sa = 0;
                sb = 0;
                i++;
                j++;
            }
        }
        
        while(i<n){
            sa += arr1.get(i++);
        }
        
        while(j<m){
            sb += arr2.get(j++);
        }
        ans += Math.max(sa, sb);
        return ans;
    }
}