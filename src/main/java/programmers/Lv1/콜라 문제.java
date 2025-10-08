class Solution {
    public int solution(int a, int b, int n) {
        int full = 0;
        int empty = n;
        
        while(empty/a >= 1){
            full += (empty/a) * b;
            empty = (empty/a) * b + empty%a;
        }
        return full;
    }
}
