//{ Driver Code Starts
// Initial Template for JAVA

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


// } Driver Code Ends
// User function Template for Java

class Solution {

    static ArrayList<Integer> topView(Node root) {
        // code here
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        HashMap<Integer, Integer> h = new HashMap<>();
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node u = p.first;
            int lev = p.second;
            min = Math.min(min, lev);
            
            if(!h.containsKey(lev)){
                h.put(lev, u.data);
            }
            if(u.left != null) q.add(new Pair(u.left, lev - 1));
            if(u.right != null) q.add(new Pair(u.right, lev + 1));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = min;h.containsKey(i);i++){
            ans.add(h.get(i));
        }
        return ans;
    }
}

class Pair{
    Node first;
    int second;
    
    public Pair(Node first, int second){
        this.first = first;
        this.second = second;
    }
}


//{ Driver Code Starts.

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();

            ArrayList<Integer> vec = ob.topView(root);
            for (int x : vec) System.out.print(x + " ");
            System.out.println();

            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends