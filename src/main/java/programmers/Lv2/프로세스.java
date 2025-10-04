package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {
    public int solution(int[] priorities,int location){
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i< priorities.length;i++){
            queue.add(new int[]{priorities[i],i});
        }

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            boolean isHighestPriority = false;

            for(int doc[] : queue){
                if(doc[0] > current[0]){
                    isHighestPriority = true;
                    break;
                }
            }

            if(isHighestPriority){
                queue.add(current);
            }else{
                answer++;
                if(current[1]== location) return answer;
            }
        }

        return answer;
    }

}
