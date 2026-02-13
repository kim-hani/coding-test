import java.util.Arrays;

class Solution {

    // dp 테이블
    // [날짜][남은거래횟수][주식보유여부]
    // 날짜 : 최대 100,000 , 거래횟수 : 3 , 상태 :  2
    private Integer[][][] memo;
    private int[] prices;

    public int maxProfit(int[] prices) {
        this.prices = prices;

        // 거래횟수 2,1,0 때를 저장
        memo = new Integer[prices.length][3][2];
        
        return dfs(0,2,0);
    }

    // index : 현재 날짜 , k : 남은 거래 횟수 , hasStock : 1이면 주식 보유 , 0이면 미보유
    private int dfs(int idx,int k, int hasStock){

        if(k == 0 || idx == prices.length){
            return 0;
        }

        if(memo[idx][k][hasStock] != null){
            return memo[idx][k][hasStock];
        }

        int result = 0;

        if(hasStock == 1){
            // 주식을 가지고 있으면 팔기 vs 버티기
            int sell = prices[idx] + dfs(idx+1,k-1,0);

            int skip = dfs(idx+1,k,1);

            result = Math.max(sell,skip);
        }else{
            // 주식이 없으면 사기 vs 지켜보기
            int buy = -prices[idx] + dfs(idx+1,k,1);

            int skip = dfs(idx+1,k,0);

            result = Math.max(buy,skip);
        }

        memo[idx][k][hasStock] = result;
        return result;
    }
}
