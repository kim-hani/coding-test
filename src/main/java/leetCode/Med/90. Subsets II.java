import java.util.*;

class Solution {

    private static List<List<Integer>> result; 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();        
        Arrays.sort(nums);

        backTrack(result,new ArrayList<>() , nums , 0);

        return result;
    }

    private void backTrack(List<List<Integer>> result , List<Integer> temp ,int[] nums , int start ){
        result.add(new ArrayList<>(temp));
        
        for(int i = start ; i < nums.length ; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            
            backTrack(result,temp,nums,i+1);

            temp.remove(temp.size()-1);

        }
    }
}
