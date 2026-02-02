class Solution {
    
    private static int N;
    private static boolean[] width;
    private static boolean[] diagonal1;
    private static boolean[] diagonal2;
        
    private static int getAns(int y){
        int ans = 0;
        
        if(y == N) ans++;
        
        else{
            for(int i = 0 ; i < N ; i++){
                if(width[i] || diagonal1[i+y] || diagonal2[i-y+N]) continue;
                width[i] = diagonal1[i+y] = diagonal2[i-y+N] = true;
                ans += getAns(y+1);
                width[i] = diagonal1[i+y] = diagonal2[i-y+N] = false;  
            }
        }
        return ans;
    }
    
    public int solution(int n) {
        N = n;
        width = new boolean[n];
        diagonal1 = new boolean[n*2];
        diagonal2 = new boolean[n*2];
        int answer = getAns(0);
        return answer;
        
    }
    
}
