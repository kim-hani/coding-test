import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> c1 = new ArrayDeque<>();
        Deque<String> c2 = new ArrayDeque<>();
        
        for(int i = 0 ; i < cards1.length;i++)
            c1.addLast(cards1[i]);
        
        for(int i = 0; i <cards2.length;i++)
            c2.addLast(cards2[i]);
        
        for(int i = 0 ; i < goal.length;i++){
            if(goal[i].equals(c1.peekFirst()))
                c1.pollFirst();
            else if(goal[i].equals(c2.peekFirst()))
                c2.pollFirst();
            else return "No";
        }
        
        return "Yes";
    }
}
