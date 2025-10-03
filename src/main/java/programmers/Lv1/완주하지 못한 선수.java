import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        
        for(String complete : completion){
            hashMap.put(complete,hashMap.getOrDefault(complete,0)+1);
        }
        
        for(String part : participant){
            
            if(hashMap.getOrDefault(part,0) == 0){
                return part;
            }
            
            hashMap.put(part,hashMap.get(part)-1);
        }
        return null;
    }
}
