import java.util.ArrayList;
import java.util.List;

class Solution {
    private static class Block{
        int i,j;
        public Block(int i , int j){
            this.i = i;
            this.j = j;
        }
    }

    private static int[][] numBoard;
    private static List<Block> empties;

    // 행/열/박스에 사용된 숫자 비트마스크 (bit k == 1이면 숫자 k가 이미 사용됨)
    // 인덱스 0~8, 사용 비트는 1<<1 .. 1<<9
    private static int[] rowMask, colMask, boxMask;

    private static boolean isValid(int num,int row,int col){
        int bit = 1 << num;
        int b = (row/3)*3 + (col/3);
        return (rowMask[row] & bit) == 0
            && (colMask[col] & bit) == 0
            && (boxMask[b]  & bit) == 0;
    }

    private static boolean inRow(int num,int row){
        int bit = 1 << num;
        return (rowMask[row] & bit) != 0;
    }

    private static boolean inCol(int num,int col){
        int bit = 1 << num;
        return (colMask[col] & bit) != 0;
    }

    // 3*3 박스 안에 같은 숫자가 있는지
    private static boolean inBox(int num,int row,int col){
        int bit = 1 << num;
        int b = (row/3)*3 + (col/3);
        return (boxMask[b] & bit) != 0;
    }

    // num 배치/해제 시 마스크 업데이트
    private static void place(int num, int row, int col){
        int bit = 1 << num;
        int b = (row/3)*3 + (col/3);
        numBoard[row][col] = num;
        rowMask[row] |= bit;
        colMask[col] |= bit;
        boxMask[b]  |= bit;
    }
    private static void remove(int num, int row, int col){
        int bit = 1 << num;
        int b = (row/3)*3 + (col/3);
        numBoard[row][col] = 0;
        rowMask[row] &= ~bit;
        colMask[col] &= ~bit;
        boxMask[b]  &= ~bit;
    }

    // 남은 칸 중 후보 수가 최소인 인덱스를 찾아 현재 idx와 스왑(MRV 휴리스틱)
    private static int selectNextIndex(int idx){
        int best = idx;
        int bestCount = 10; // 최대 9
        for(int k = idx; k < empties.size(); k++){
            Block b = empties.get(k);
            if(numBoard[b.i][b.j] != 0) continue; // 이미 채워졌다면 스킵
            int candidatesMask = candidateMask(b.i, b.j);
            int cnt = Integer.bitCount(candidatesMask);
            if(cnt < bestCount){
                bestCount = cnt;
                best = k;
                if(cnt == 1) break; // 더 줄 수 없음
            }
        }
        if(best != idx){
            Block tmp = empties.get(idx);
            empties.set(idx, empties.get(best));
            empties.set(best, tmp);
        }
        return bestCount; // 0이면 즉시 실패, 1~9면 진행
    }

    // 해당 칸에서 가능한 숫자 비트마스크(1~9 비트 사용)
    private static int candidateMask(int row, int col){
        int b = (row/3)*3 + (col/3);
        int used = rowMask[row] | colMask[col] | boxMask[b];
        int all = 0x3FE; // bits 1..9 set
        return all & ~used;
    }

    private static boolean findSolution(int idx){
        if(idx == empties.size()) return true;

        // MRV 선택 및 조기 가지치기
        int bestCount = selectNextIndex(idx);
        if(bestCount == 0) return false;

        Block cur = empties.get(idx);
        int row = cur.i , col = cur.j;

        int mask = candidateMask(row, col);
        // 비트마스크 순회: 낮은 숫자부터 시도
        while(mask != 0){
            int bit = mask & -mask;        // 최하위 set 비트
            int num = Integer.numberOfTrailingZeros(bit); // 1..9
            mask ^= bit;

            if(isValid(num,row,col)){
                place(num,row,col);
                if(findSolution(idx+1)) return true;
                remove(num,row,col);
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        boardInitialize(board);
        findSolution(0);
        convertBoardToChar(board);
    }

    private static void boardInitialize(char[][] board){
        numBoard = new int[9][9];
        empties = new ArrayList<>();
        rowMask = new int[9];
        colMask = new int[9];
        boxMask = new int[9];

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                char c = board[i][j];
                if(c == '.'){
                    numBoard[i][j] = 0;
                    empties.add(new Block(i,j));
                } else {
                    int num = c - '0';
                    numBoard[i][j] = num;
                    int bit = 1 << num;
                    int b = (i/3)*3 + (j/3);
                    rowMask[i] |= bit;
                    colMask[j] |= bit;
                    boxMask[b]  |= bit;
                }
            }
        }
        // 초기에도 불가능한 상태가 있으면 이후 탐색에서 자연스럽게 실패
    }

    private static void convertBoardToChar(char[][] board){
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                board[i][j] = numBoard[i][j]==0 ? '.' : (char)('0'+numBoard[i][j]);
            }
        }
    }
}
