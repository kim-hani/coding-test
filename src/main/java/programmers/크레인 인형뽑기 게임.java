import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> stack = new Stack<>();
        int n = board.length;
        int cnt = 0;
        
        for(int move : moves){
            int col = move -1;
            for(int row = 0 ; row<n ; row++){
                if(board[row][col] != 0){
                    int doll = board[row][col];
                    board[row][col] =0;
                    if(!stack.isEmpty() && stack.peek() == doll){
                        stack.pop();
                        cnt += 2;
                    }
                    else{
                        stack.push(doll);
                    }
                    break;
                }
            }            
        }
        return cnt;
    }
}
