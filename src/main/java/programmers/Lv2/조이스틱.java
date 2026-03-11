import java.util.*;

// 1 + 6 + 3 + 3 + 1 = 14
// 4 + 1 + 3 + 3 + 6 = 17
// 1 + 5 + 1 + 3 + 3 + 6 =
// jaaaweaaeaabaaaaab 12 + 6 - 1 - 3
// 2. A는 무조건 패스 -> 다음 알파벳에 A가 나오면 커서를 왼쪽 or 오른쪽으로 옮길건지 고려 
// 3. 커서에 해당하는 알파벳을 바꿀때 -> A에서 위로 가는게 빠를지 아래로 가는게 빠를지 고려
// ex) char(c) - 'A' vs 'Z' - char(c) + 1 
// 위 아래는 그냥 계산하면 끝 but 오른쪽 왼쪽 이동은 어떻게 하지 
// 가장 가까운 곳으로만 가는것이 답이 아님

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        // 시작부터 끝까지 그냥 오른쪽으로 직진하는 경우
        int min = len - 1;
        
        for(int i = 0 ; i < len ; i++){
            // 위아래 이동 계산
            answer += upDown(name.charAt(i));
            
            // 뒤에 나오는 A의 개수 계산하기
            int next = i+1;
            
            // A가 끝나는 지점까지 인덱스 이동
            while(next < len && name.charAt(next) =='A'){
                next++;
            }
            
            // A를 패스했으면 현재 커서부터 오른쪽으로 갈지 왼쪽으로 갈지 최소값 계산 
            int rightThenLeft = i*2 + (len-next);
            int leftThenRight = i + (len-next)*2;
            
            min = Math.min(rightThenLeft,min);
            min = Math.min(leftThenRight,min);
        }
        return min + answer;
    }
    
    // 위아래 값
    public int upDown(char c){
        return Math.min(c-'A','Z'-c+1);
    }   
}
