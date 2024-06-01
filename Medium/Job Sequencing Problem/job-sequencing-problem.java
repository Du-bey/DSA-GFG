//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        int maxi = 0;
        for(int i =0;i<n;i++){
            maxi = Math.max(maxi, arr[i].deadline);
        }
        int[] ans = new int[maxi+1];
        Arrays.fill(ans, -1);
        int p = 0;
        int cnt = 0;
        for(Job j : arr){
            int id = j.id;
            int d = j.deadline;
            int profit = j.profit;
            int i = d;
            while(i>0){
                if(ans[i] == -1){
                    ans[i] = id;
                    cnt++;
                    p+=profit;
                    break;
                }
                i--;
            }
        }
        int[] fin = new int[2];
        fin[0] = cnt;
        fin[1] = p;
        return fin;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/