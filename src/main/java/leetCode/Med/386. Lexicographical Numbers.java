import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        // 1~9
        List<Integer> result = new ArrayList<>();
        int cur = 1;

        for(int i = 0 ; i < n ; i++){
            result.add(cur);

            if(cur * 10 <= n){
                cur *= 10;
            }else{
                while(cur%10 == 9 || cur+1 > n ){
                    cur /= 10;
                }
                cur++;
            }
        }

        return result;
    }
}
