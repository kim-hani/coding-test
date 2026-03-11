import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        int cnt = 0;
        int h = 0;
        for(int i = 0 ; i < citations.length ; i++){
            if(citations[i] == 0) continue;
            // cnt와 h를 비교
            // 10 11 12 13 -> cnt : 4 h : 10
            // 0 1 3 5 6 -> cnt 2 : h : 5
            // 0 1 2 4 5 6 cnt : 4 h : 2 max : 2
            // cnt 3 : h : 4 max : 2 
            cnt = citations.length - i; // 4
            h = citations[i];  // 10
            if(cnt == h) return cnt;
            if(cnt > h) max = h;
            if(cnt < h && max < cnt) return cnt;
                
        }
        return max;
    }
}
