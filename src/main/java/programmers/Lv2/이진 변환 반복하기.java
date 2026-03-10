class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zeroCnt = 0;
        
        while(!s.equals("1")){
            int length = s.length();            
            s = s.replace("0","");
            zeroCnt += length - s.length();
            s = Integer.toBinaryString(s.length());
            cnt++;
        }
        int[] answer = {cnt,zeroCnt};
        return answer;
    }
}
