import java.util.*;

class Solution{
    public int solution(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            
            if(!st.isEmpty() && st.peek().equals(c)) st.pop();
            else{
                st.push(c);
            }
        }
        if(st.isEmpty()) return 1;
        else return 0;
    }
}
