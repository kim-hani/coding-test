class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (String b : babbling) {
            for (String w : words) {
                b = b.replace(w, " ");
            }
            if (b.trim().isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}