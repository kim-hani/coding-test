import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int n = friends.length;
        
        // 사람별로 인덱스 설정 -> 2차원 배열에서 사용됨
        Map<String,Integer> people = new HashMap<>();
        for(int i = 0 ; i < n ; i++)
            people.put(friends[i],i);
        
        // 1. 준사람과 받은 사람 서로 담을 2차원 배열 설정
        int gt[][] = new int[n][n];
        // 2. 사람별로 준 선물 , 받은 선물 선물을 담을 1차원 배열들
        int gived[] = new int[n];
        int received[] = new int[n];
        
        for(String gift : gifts){  
            int idx = gift.indexOf(' ');   // 주고받은 내역을 공백을 기준으로 구분하기 위함
            String giver = gift.substring(0,idx);  // 선물을 준 사람
            String receiver = gift.substring(idx+1);  // 선물을 받은 사람
            
            int gIdx = people.get(giver);
            int rIdx = people.get(receiver);
            
            gt[gIdx][rIdx]++;
            gived[gIdx]++;
            received[rIdx]++;
        }
        
        // 3. 선물지수를 담을 배열
        int point[] = new int[n];
        for(int i =0 ; i < n ; i++){
            point[i] = gived[i] - received[i];
        }
        
        // 4. 다음달에 받을 선물 수를 담을 1차원 배열
        int next[]= new int[n];
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(gt[i][j] > gt[j][i]){
                    next[i]++;
                }
                else if(gt[i][j] < gt[j][i]){
                    next[j]++;
                }
                else{
                    if(point[i] > point[j]) next[i]++;
                    else if(point[i] < point[j]) next[j]++;
                }
            }
        }
        
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            if(next[i] > max) max = next[i];
        }
        return max;
    }
}
