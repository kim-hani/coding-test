import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int length;
        
        // string으로 주어지는 전화번호
        // 입력값이 백만이라 O(N^2) 은 안될듯
        // 접두사가 있으면 바로 return
        HashSet<String> set = new HashSet<>();
        for(String s : phone_book) set.add(s);
        
        for(String s : phone_book){
            for(int i = 1 ; i < s.length() ; i++){
                if(set.contains(s.substring(0,i))) return false;
            }
        }
        
        // 접두사가 있으면 false , 없으면 true반환
        return answer;
    }
}
