import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] letters = s.toCharArray();
        char[] skipChar = skip.toCharArray();
        char[] a = new char[letters.length];
        
        HashSet<Character> skipSet = new HashSet<>();
        for(char c : skipChar){
            skipSet.add(c);
        }
        
        
        for(int i = 0 ; i < letters.length; i++){
            int count = index;
            char l = letters[i];
            while (count > 0) {
                // 1) 알파벳 한 칸 전진 (z -> a 순환)
                l = (char) ((l - 'a' + 1) % 26 + 'a');

                // 2) skip이면 카운트 줄이지 않고 계속 전진
                if (skipSet.contains(l)) continue;

                // 3) 통과 문자면 한 칸 이동 인정
                count--;
            }
            a[i] = l;
        }
        return new String(a);

    }
}
