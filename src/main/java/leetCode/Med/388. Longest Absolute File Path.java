class Solution {
    public int lengthLongestPath(String input) {
        // 1. 일단 \n 단위로 잘라서 한 줄씩 본다.
        String[] lines = input.split("\n");
        
        // 각 층(Level)별 현재 경로 길이를 저장할 메모장
        // stack[1]에는 0층의 길이+1, stack[2]에는 1층의 길이+1 이 저장됨
        int[] stack = new int[lines.length + 1];
        
        int maxLen = 0;

        for (String line : lines) {
            // 2. 탭(\t) 개수 세기 = 나의 깊이(Level)
            // lastIndexOf("\t")는 탭이 없으면 -1, 1개면 0... 이런 식이라 +1 해줌
            int depth = line.lastIndexOf("\t") + 1;
            
            // 3. 내 진짜 이름 길이 구하기 (전체 길이 - 탭 개수)
            int nameLen = line.length() - depth;
            
            // 4. 현재까지의 경로 길이 = (부모 층의 길이) + (내 이름 길이)
            // stack[depth]에는 내 바로 윗단계까지의 길이(슬래시 포함)가 이미 들어있음
            int currentLen = stack[depth] + nameLen;

            // 5. 파일이면(.이 있으면) 정답 갱신!
            if (line.contains(".")) {
                maxLen = Math.max(maxLen, currentLen);
            } 
            // 6. 폴더면 다음 자식을 위해 메모장에 적어두기
            else {
                // 내 길이 + 1(슬래시 /)을 다음 층(depth+1) 자리에 저장
                stack[depth + 1] = currentLen + 1;
            }
        }
        
        return maxLen;
    }
}
