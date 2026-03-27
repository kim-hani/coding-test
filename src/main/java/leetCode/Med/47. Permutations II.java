import java.util.ArrayList;
import java.util.List;

class Solution {

    private static List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums,visited,new ArrayList<>());
        return result;
    }

    private static void backtrack(int[] nums,boolean[] visited,List<Integer> path){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(visited[i]) continue;

            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;

            visited[i] = true;
            path.add(nums[i]);
            backtrack(nums,visited,path);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }
}
