class Solution {
    public int solution(int n) {
        int answer = n-1;
        for(int i =2 ; i<n/2;i++){
            if(n%i == 1){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
