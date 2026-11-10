import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> set = new HashSet<>();
        
        String subs = s.substring(2,s.length()-2);
        
        String[] arr = subs.split("\\},\\{");
        
        Arrays.sort(arr,(o1,o2) -> Integer.compare(o1.length(),o2.length()));
        
        int[] answer = new int[arr.length];
        int idx = 0;
        
        for(String nums : arr){
            String[] temp = nums.split(",");
            for(String num : temp){
                int n = Integer.parseInt(num);
                if(set.add(n)) answer[idx++] = n;
            }
        }
        
        return answer;
    }
}