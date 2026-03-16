import java.util.Arrays;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int length  = nums.length;
        
        // 누적 합을 저장
        long[] prefix = new long[length+1];

        for(int i = 1 ; i < length+1 ; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix,Long.MAX_VALUE);     
        
        // 부분 배열의 길이 : R-L+1
        // (R+1)%k == L%k 이어야 조건 만족
        minPrefix[0] = 0;
        long answer = Long.MIN_VALUE;

        for(int R = 1 ; R <= length ; R++){
            long nowPrefix = prefix[R];

            if(minPrefix[R%k] != Long.MAX_VALUE){
                long sum = nowPrefix - minPrefix[R%k];
                answer = Math.max(sum,answer);
            }

            minPrefix[R%k] = Math.min(minPrefix[R%k],nowPrefix);
        }
        return answer;
              
    }
}
