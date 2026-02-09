import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // enroll(판매원의 이름)과 referral(판매원을 조직에 참여시킨 판매원 이름) 1:1 대응
        // seller(칫솔을 판 판매원 이름)와 amount(판매원이 판매한 칫솔의 수량)대응
        
        // 1. enroll과 referral 대응시킬 해쉬맵
        HashMap<String,String> parent = new HashMap<>();
        for(int i = 0 ; i < enroll.length ; i++)
            parent.put(enroll[i],referral[i]);
        
        // 2. seller와 amount 대응시킬 해쉬맵
        HashMap<String,Integer> total = new HashMap<>();
        
        for(int i = 0 ; i < seller.length ; i++){
            String curName = seller[i];
            
            int money = amount[i] * 100;
            
            while(money > 0 && !curName.equals("-")){
                total.put(curName,total.getOrDefault(curName,0) + money - (money/10));
                
                curName = parent.get(curName);
                money /= 10;
            }
        }
        // for문이 끝나면 seller와 seller의 추천인의 판매 이익금 + 배당금 계산 완료
        
        int[] answer = new int[enroll.length];
        
        for(int i = 0 ; i < enroll.length ; i++){
            answer[i] = total.getOrDefault(enroll[i],0);
        }
        return answer;
        // enroll 이름 순서대로 이익금 총합 반환
    }
}
