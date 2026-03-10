import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> type1 = new HashSet<>();
        Map<Integer,Integer> type2  =new HashMap<>();
        
        for(int top : topping){
            type2.put(top,type2.getOrDefault(top,0)+1);
        }
        
        for(int top : topping){
            type1.add(top);
            if(type2.containsKey(top)){
                type2.put(top,type2.get(top)-1);
            }
            
            if(type2.get(top).equals(0)) type2.remove(top);
            
            if(type1.size() > type2.size()) break;
            
            if(type1.size() == type2.size()) answer++;
        }
        
        return answer;
    }
}
