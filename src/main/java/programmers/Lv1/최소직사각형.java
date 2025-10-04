class Solution {
    public int solution(int[][] sizes) {
        int width =0;
        int length =0;
        
        for(int i=0;i<sizes.length;i++){
            int tempW = Math.max(sizes[i][0],sizes[i][1]);
            int tempL = Math.min(sizes[i][0],sizes[i][1]);
            
            if(width < tempW) width = tempW;
            if(length < tempL) length = tempL;
        }
        
        return width*length;
    }
}
