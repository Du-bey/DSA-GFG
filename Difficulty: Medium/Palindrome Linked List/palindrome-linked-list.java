//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);

            System.out.println(f ? "true" : "false");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        if(head == null || head.next == null) return true;
        ArrayList<Integer> a = new ArrayList<>();
        while(head != null){
            a.add(head.data);
            head = head.next;
        }
        int i=0;
        int j=a.size()-1;
        while(i<j){
            if(!a.get(i).equals(a.get(j)))
                    return false;
            i++;
            j--;
        }
        return true;
    }
    
    public Node reverse(Node head){
        Node temp = head;
        Node prev = null;
        while(temp != null){
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return temp;
    }
    
    
}

