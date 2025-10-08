import java.util.*;

class Solution {
    public int solution(int[] number) {
        Arrays.sort(number); 
        int cnt = 0;

        for (int i = 0; i < number.length - 2; i++) {
            int left = i + 1;
            int right = number.length - 1;

            while (left < right) {
                int sum = number[i] + number[left] + number[right];
                if (sum == 0) {
                    cnt++;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return cnt;
    }
}
