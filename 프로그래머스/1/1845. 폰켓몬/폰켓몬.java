import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> pokeMon = new HashSet<>();
        
        for(int poke : nums){
            pokeMon.add(poke);
        }
        
        return Math.min(pokeMon.size(),nums.length/2);
        
    }
}