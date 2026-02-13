import java.util.Arrays;

class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int[] dp = new int[m];

        Arrays.fill(dp,1);

        int maxLen = 1;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < i ; j++){
                boolean possible = true;
                for(String str : strs){
                    if(str.charAt(j) > str.charAt(i)){
                        possible = false;
                        break;
                    }
                }

                if(possible){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }

        return m - maxLen;
    }
}
