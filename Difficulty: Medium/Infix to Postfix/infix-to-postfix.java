//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        char[] ch = exp.toCharArray();
        int n = ch.length;
        Stack<Character> st = new Stack<>();
        String ans = "";
        
        int i =0;
        while(i < n){
            if(Character.isLetterOrDigit(ch[i])){
                ans = ans + ch[i];
            }
            else if(ch[i] == '('){
                st.add(ch[i]);
            }
            else if(ch[i] == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans = ans + st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && prec(ch[i]) <= prec(st.peek())){
                    ans = ans + st.pop();
                }
                st.push(ch[i]);
            }
            i++;
        }
        while(!st.isEmpty()){
            ans = ans + st.pop();
        }
        return ans;
    }
    
    static int prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;
        
            case '*':
            case '/':
                return 2;
        
            case '^':
                return 3;
        }
        
        return -1;
    }
}