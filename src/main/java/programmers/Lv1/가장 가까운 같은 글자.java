import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        char[] arr = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int[] answer = new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                answer[i] = i-map.get(arr[i]);
                map.replace(arr[i],i);
            }
            else{
                answer[i] = -1;
                map.put(arr[i],i);
            }
        }
        return answer;
    }
}
