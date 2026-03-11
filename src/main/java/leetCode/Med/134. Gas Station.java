class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int remainGas = 0;
        int start = 0;

        for(int i  = 0 ; i < gas.length ; i++){
            
            int now = gas[i] - cost[i];

            totalGas += now;
            remainGas += now;

            if(remainGas < 0){

                start = i+1;
                remainGas = 0;
            }
        }

        return totalGas >= 0 ? start : -1;
    }
}
