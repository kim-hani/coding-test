class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        int row = 3;
        int col = total/row;
        int b,y;
        
        while(true){
            col = total/row;
            if(total%row != 0 || row < col) {
                row++;
                continue;
            }
            
            b = row*2 + (col-2)*2;
            y = (col-2)*(row-2);
            
            if(brown == b && yellow == y){
                answer[0] = row;
                answer[1] = col;
                break;
            }else{
                row++;
            }
        }
        return answer;
    }
}
