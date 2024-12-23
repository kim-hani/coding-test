package programmers;

/*
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, ||  1, 2, 3, 4, 5, ...
        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, ||  2, 1, 2, 3, 2, 4, 2, 5, ...
        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ||  3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
        가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {

    public static int[] solution(int[] answers){

        // 수포자 정답 찍는 패턴
        int[][] pattern = {
                {1,2,3,4,5}, // pattern[0][0~4]
                {2,1,2,3,2,4,2,5}, // pattern[1][0~7]
                {3,3,1,1,2,2,4,4,5,5}  // pattern[2][0~9]
        };

        // 수포자들 점수 저장
        int score[] = new int[3];

        for(int i=0;i<answers.length;i++){
            for(int j=0;j<pattern.length;j++){
                if(answers[i] == pattern[j][i%pattern[j].length])  score[j]++;
            }
        }

        int maxScore = Arrays.stream(score).max().getAsInt();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<3;i++) {
            if(score[i] == maxScore) list.add(i+1);
        }

        return list.stream().mapToInt(Integer :: intValue).toArray();
    }
}
