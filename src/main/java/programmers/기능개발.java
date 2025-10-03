import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        int n = progresses.length;
        int dayLeft[] = new int[n];
        
        for(int i = 0 ; i < n ; i ++){
            dayLeft[i] = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }
        
        int max = dayLeft[0];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(max >= dayLeft[i]){
                count++;
            }
            else{
                answer.add(count);
                count = 1;
                max = dayLeft[i];
            }
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
