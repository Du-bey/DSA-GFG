//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends



class Solution {
    static Node segregate(Node head) {
        Node z = new Node(-1);
        Node o = new Node(-1);
        Node t = new Node(-1);
        Node temp = head;
        Node d0 = z;
        Node d1 = o;
        Node d2 = t;
        while(temp != null){
            int data = temp.data;
            if(data == 0){
                z.next = temp;
                z = temp;
            }
            else if(data == 1){
                o.next = temp;
                o = temp;
            }
            else{
                t.next = temp;
                t = temp;
            }
            temp = temp.next;
        }
        z.next = d1.next != null ? d1.next : d2.next;
        o.next = d2.next;
        t.next = null;
        
        return d0.next;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends