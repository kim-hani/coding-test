import java.util.List;
import java.util.ArrayList;

class Solution {
    // right down left up
    private static int[] dy = {0,1,0,-1};
    private static int[] dx = {1,0,-1,0};
    private int X,Y;
    private boolean[][] visited;

    public List<Integer> spiralOrder(int[][] matrix) {
        Y = matrix.length;
        X = matrix[0].length;
        int nowX = 0;
        int nowY = 0;
        int cnt = 0;
        int idx = 0;

        visited = new boolean[Y][X];

        List<Integer> result = new ArrayList<>();
        
        while(cnt < X*Y){
            result.add(matrix[nowY][nowX]);
            cnt++;
            visited[nowY][nowX] = true;

            int nextY = nowY + dy[idx];
            int nextX = nowX + dx[idx];

            if(isNotValid(nextY,nextX)){
                idx = (idx+1)%4;
                nextY = nowY + dy[idx];
                nextX = nowX + dx[idx];
            }
            nowX = nextX;
            nowY = nextY;
        }
        return result;

    }

    public boolean isNotValid(int y , int x){
        return x < 0 || y < 0 || x >= X || y >= Y || visited[y][x];
    }
}
