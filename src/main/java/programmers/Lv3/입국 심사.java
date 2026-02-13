import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {        
        Arrays.sort(times);
        long low = 1;
        long high = (long)times[times.length-1]*n;
        long answer = high;
        
        while(low <= high){
            long mid = (low+high)/2;
            long total = 0;
            
            for(int t : times){
                total += mid/t;
            }
            
            if(total >= n){
                answer = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }
}
