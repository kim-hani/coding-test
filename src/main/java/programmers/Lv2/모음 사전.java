class Solution {
    public int solution(String word) {
        /*
        가중치
        1 : 781
        2 : 156
        3 : 31
        4 : 6
        5 : 1
        */
        int[] weight = {781,156,31,6,1};
        String vowels = "AEIOU";
        int answer = 0;
        
        for(int i = 0 ; i < word.length() ;i++){
            int idx = vowels.indexOf(word.charAt(i));
            answer += idx*weight[i] +1;
        }
        
        return answer;
    }
}
