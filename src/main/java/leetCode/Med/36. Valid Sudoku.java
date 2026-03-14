import java.util.Set;
import java.util.HashSet;


/**
0 1 2
4 5 6
7 8 9
 */
class Solution {
    private static char[][] Board;

    public boolean isValidSudoku(char[][] board) {
        Board = board;

        for(int i = 0 ; i < 9 ; i ++){
            if(!checkRow(i)) return false;
        }

        for(int i = 0 ; i < 9 ; i ++){
            if(!checkCol(i)) return false;
        }

        for(int i = 0 ; i < 9 ; i += 3){
            for(int j = 0 ; j < 9 ; j += 3){
                if(!checkBox(i,j)) return false;
            }
        }

        return true;
    }

    private static boolean checkRow(int row){
        Set<Character> set = new HashSet<>(); 

        for(int i = 0 ; i < 9 ; i++){
            if (Board[row][i] == '.') continue;
            if(set.contains(Board[row][i])) return false;
            set.add(Board[row][i]);
        }
        return true;
    }

    private static boolean checkCol(int col){
        Set<Character> set = new HashSet<>(); 

        for(int i = 0 ; i < 9 ; i++){
            if (Board[i][col] == '.') continue;
            if(set.contains(Board[i][col])) return false;
            set.add(Board[i][col]);
        }
        return true;
    }

    private static boolean checkBox(int row,int col){
        Set<Character> set = new HashSet<>(); 
        int boxRow = (row/3)*3;
        int boxCol = (col/3)*3;

        for(int i = boxRow ; i < boxRow+3 ; i++){
            for(int j = boxCol ; j < boxCol+3 ; j++){
                if (Board[i][j] == '.') continue;
                if(set.contains(Board[i][j])) return false;
                set.add(Board[i][j]);
            }
        }
        return true;
    }
}
