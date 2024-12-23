package programmers;

import java.util.HashSet;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i<numbers.length-1;i++){
            for(int j = i+1 ;j<numbers.length;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
