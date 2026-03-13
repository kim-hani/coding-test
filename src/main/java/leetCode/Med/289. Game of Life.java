class Solution {
    // 1 -> 살아있는 세포
    // 0 -> 죽은 세포  
    /**살아 있는 세포의 규칙
    1. 살아있는 이웃이 2명 미만이면 죽음
    2. 2~3 세포 살아있으면 산다
    3. 3개 세포 넘게 살아있으면 죽음

    죽은 세포 규칙
    1. 정확히 3개의 세포가 주변에 살아있으면 산다.
     */ 
   private static int[][] DIRS = new int[][]{
    {-1,-1}, {-1,0}, {-1,1},
    {0,-1},          {0,1},
    {1,-1},  {1,0},  {1,1}
    };
    private int M;
    private int N;
    private int[][] Board;

    public void gameOfLife(int[][] board) {
        M = board.length;
        N = board[0].length;

        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                int aliveNeighbors = countAlive(board, i, j);

                if(board[i][j] == 1) { 
                    // 원래 살아있는 세포 
                    if(aliveNeighbors < 2 || aliveNeighbors > 3) {
                        board[i][j] = 2; // 다음 세대에는 죽음
                    }
                    // (2명이나 3명이면 그대로 1 유지)
                } else if(board[i][j] == 0) { 
                    // 원래 죽어있는 세포
                    if(aliveNeighbors == 3) {
                        board[i][j] = 3; // 다음 세대에는 부활 
                    }
                }
            }
        }

        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                if(board[i][j] == 2) board[i][j] = 0;      // 죽기로 예약된 놈은 죽임
                else if(board[i][j] == 3) board[i][j] = 1; // 부활하기로 예약된 놈은 살림
            }
        }
    }

    private int countAlive(int[][] board, int m, int n){
        int count = 0;
        
        for(int i = 0 ; i < 8 ; i++){
            int nextM = m + DIRS[i][0];
            int nextN = n + DIRS[i][1];
            
            if(isValid(nextM, nextN)) {
                
                if(board[nextM][nextN] == 1 || board[nextM][nextN] == 2) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValid(int m, int n){
        return m >= 0 && n >= 0 && m < M && n < N;
    }
}
