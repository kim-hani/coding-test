class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = (left+right)/2;

            if(nums[mid] == target){
                if(mid == 0){
                    start = 0;
                    break;
                }
                else if(nums[mid-1] != target){
                    start = mid;
                    break;
                }
                else {
                    left = 0;
                    right = mid-1;
                    continue;
                }
            }
            
            if(nums[mid] < target) left = mid+1;
            else right = mid-1; 
        }

        while(left <= right){
            int mid = (left+right)/2;

            if(nums[mid] == target){
                if(mid == nums.length-1){
                    end = nums.length-1;
                    break;
                }
                else if(nums[mid+1] != target){
                    end = mid;
                    break;
                }
                else {
                    left = mid+1;
                    right = nums.length-1;
                    continue;
                }
            }
            
            if(nums[mid] < target) left = mid+1;
            else right = mid-1; 
        }
        return new int[]{start,end};
    }
}
