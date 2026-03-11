class Solution {

    private static int[] balance;
    private static long answer;
    private static int point;
    
    public long minMoves(int[] balance) {
        // (idx+1)%balance.length
        this.balance = balance;
        int n = balance.length;
        point = -1;
        answer = 0;
        for(int i = 0 ; i < n ; i++){
            if(balance[i] < 0) point = i;
        }

        int right = point;
        int left = point;
        int dis = 1;
        
        while(left != right){
            right = (right+1)%n;
            left = (left-1);  
            if(left < 0) left = n-1;

            if(balance[left] != 0){
                answer += leftFirst(left,dis);
            }

            if(balance[right] != 0){
                answer += rightFirst(right,dis);
            }

            if(balance[point] >= 0) return answer;
            
            dis++;
        }
        
        right = (right+1)%n;
        left = (left-1);  
        if(left < 0) left = n-1;
        
        if(balance[left] != 0){
            if(balance[left] > Math.abs(balance[point])){
                answer += dis*balance[left];
            }else{
                answer += dis*balance[left];
                balance[point] += balance[left];
            }
        }

        if(balance[point] >= 0) return answer;

        if(balance[right] != 0){
            if(balance[right] > balance[point]){
                answer += dis*balance[point];
            }else{
                answer += dis*balance[right];
                balance[point] += balance[right];
            }
        }
        
        return balance[point] >= 0 ? answer : -1;
    }

    private static long leftFirst(int left,int leftDis){
        long total = 0;
        if(balance[left] != 0){
            if(balance[left] > Math.abs(balance[point])){
                total += leftDis*balance[left];
            }else{
                total += leftDis*balance[left];
                balance[point] += balance[left];
            }
        }
        return total;
    }

    private static long rightFirst(int right,int rightDis){
        long total =0;
        if(balance[right] != 0){
            if(balance[right] > balance[point]){
                total += rightDis*balance[right];
            }else{
                total += rightDis*balance[right];
                balance[point] += balance[right];
            }
        }
        return total;
    }
}
