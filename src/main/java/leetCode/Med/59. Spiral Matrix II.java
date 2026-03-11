class Solution {

    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int dr = 0;
        int nowX = 0; int nowY =0;
        int idx = 1;

        while(idx <= n*n){
            matrix[nowY][nowX] = idx++;

            int nextX = nowX + dx[dr%4];
            int nextY = nowY + dy[dr%4];

            if(!isValid(nextX,nextY,n) || matrix[nextY][nextX] != 0){
                dr++;
                nowX += dx[dr%4];
                nowY += dy[dr%4];
            }
            else{
                nowX = nextX;
                nowY = nextY;
            }
        }

        return matrix;
    }

    private static boolean isValid(int x, int y,int n){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
