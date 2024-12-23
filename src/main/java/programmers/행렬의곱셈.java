package programmers;

public class 행렬의곱셈 {

    public static int[][] solution(int[][] arr1,int[][] arr2) {

        int a1_row = arr1.length;   // 첫번째 행렬의 행 수
        int a1_col = arr1[0].length;  // 첫번째 행렬의 열 수
        int a2_row = a1_col;    // 두번째 형렬의 행 수
        int a2_col = arr2[0].length;   // 두번째 행렬의 열 수

        /*
         * 행렬의 곱셈에서는
         * a1_col = a2_row 을 만족하고
         * 곱셈으로 만들어지는 새로운 행렬은
         * arr[a1_row][ a2_col]
         * */

        int result[][] = new int[a1_row][a2_col];

        for (int i = 0; i < a1_row; i++) {
            for (int j = 0; j < a2_col; j++) {
                for (int k = 0; k < a1_col; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return result;
    }
}
