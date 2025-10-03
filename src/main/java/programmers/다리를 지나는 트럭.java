import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int totalWeight = 0;
        int idx = 0;
        Deque<Integer> passing = new ArrayDeque<>();
        
        for(int i = 0 ; i<bridge_length;i++){
            passing.addLast(0);
        }
        
        while(idx < truck_weights.length){
            
            time++;
            
            totalWeight -= passing.pollFirst();
            
            if(totalWeight+truck_weights[idx] <= weight){
                passing.addLast(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                idx++;
            } else {
                passing.addLast(0); 
            }
        }

        return time + bridge_length;
    }
}
