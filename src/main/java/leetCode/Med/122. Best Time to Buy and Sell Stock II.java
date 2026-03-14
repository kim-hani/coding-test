class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0 ; i < prices.length-1 ; i++){
            if(minPrice > prices[i]) minPrice = prices[i];
            if(prices[i] > prices[i+1]){
                totalProfit += prices[i] - minPrice;
                minPrice = prices[i];
                continue;
            }
            if(i+1 == prices.length-1) totalProfit += prices[i+1] - minPrice;
            
        }
        return totalProfit;
    }
}
