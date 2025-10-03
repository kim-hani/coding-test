import java.util.*;

class Solution {
    public int solution(String s) {
        
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        int cnt = 0;
        
        int n = s.length();
        s += s;
        
        A: for(int i = 0 ; i < n ; i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            for(int j=i ; j < n+i ; j++){
                char c = s.charAt(j);
                
                if(!map.containsKey(c)) stack.push(c);
                else{
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }
            if(stack.isEmpty()) cnt++;
        }
        return cnt;
        
    }
}
