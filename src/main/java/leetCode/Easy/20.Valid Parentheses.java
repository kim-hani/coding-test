import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '('); pair.put(']', '['); pair.put('}', '{');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else { // 닫는 괄호
                if (st.isEmpty() || st.pop() != pair.get(c)) return false;
            }
        }
        return st.isEmpty();
    }
}
