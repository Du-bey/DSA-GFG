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

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        if(head == null) return new Node(1);
        Node rev = rev(head);
        Node temp = rev;
        int c = 1;
        while(temp.next != null){
            int val = temp.data + c;
            c = val /10;
            val = val % 10;
            temp.data = val;
            temp = temp.next;
        }
        if(c == 1){
            Node temp2 = new Node(1);
            int val = temp.data + c;
            if(val > 9){
                val = val % 10;
                temp.data = val;
                temp.next = temp2;
            }
            else{
                temp.data = val;
            }
            
        }
        return rev(rev);
    }
    
    public Node rev(Node head) {
        Node prev = null;
        while(head != null){
            Node forw = head.next;
            head.next = prev;
            prev = head;
            head = forw;
        }
        return prev;
    }
}
