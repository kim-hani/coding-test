class Solution {
    private int N, M;
    private int[] dy = {-1, 1, 0, 0};
    private int[] dx = {0, 0, -1, 1};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        N = board.length;
        M = board[0].length;
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int y, int x, int idx) {
        
        if (idx == word.length() - 1) {
            return true;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx] == word.charAt(idx + 1)) {
                if (dfs(board, word, ny, nx, idx + 1)) return true;
            }
        }

        visited[y][x] = false;
        
        return false;
    }

    private boolean isValid(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
