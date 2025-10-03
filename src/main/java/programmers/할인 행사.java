import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
       
        int answer=0;
        
        // 주어지는 것 : 원하는 제품 , 제품의 수량 , 할인하는 제품
        // 1. 맵에 <제품 : 수량>을 먼저 저장하자
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < want.length ; i++){
            map.put(want[i],number[i]);
        }
        
        // 2. discount를 순회하면서 조사
        for(int i = 0 ; i <= discount.length-10 ; i++){
            HashMap<String,Integer> dis = new HashMap<>();
            for(int j=0;j<10;j++){
                String item = discount[i+j];
                dis.put(item,dis.getOrDefault(item,0)+1);
            }
            if(dis.equals(map)) answer++;
        }
        return answer;
    }
}
