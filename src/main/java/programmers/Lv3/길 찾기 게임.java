import java.util.ArrayList;
import java.util.Arrays;

class Solution {     
   
    
    public int[][] solution(int[][] nodeinfo) {
        Node root = makeBT(nodeinfo);
        ArrayList<Integer> preOrderList = new ArrayList<>();
        preOrder(root,preOrderList);
        ArrayList<Integer> postOrderList = new ArrayList<>();
        postOrder(root,postOrderList);
        
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
}
