class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        
        int M = mat.length;
        int N = mat[0].length;
        int[] result = new int[M * N];
        
        int row = 0, col = 0;
        boolean goingUp = true;
        
        for (int i = 0; i < M * N; i++) {
            result[i] = mat[row][col];
            
            if (goingUp) { 
                if (col == N - 1) { 
                    row++;
                    goingUp = false;
                } else if (row == 0) { 
                    col++;
                    goingUp = false;
                } else { 
                    row--;
                    col++;
                }
            } else { 
                if (row == M - 1) { 
                    col++;
                    goingUp = true;
                } else if (col == 0) { 
                    row++;
                    goingUp = true;
                } else { 
                    row++;
                    col--;
                }
            }
        }
        
        return result;
    }
}
