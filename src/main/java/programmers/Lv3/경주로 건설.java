import java.util.ArrayDeque;

class Solution {
    
    private static class Node{
        int x,y,direction,cost;
        public Node(int x, int y , int direction , int cost){
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }  
    }
    // 0123 -> 상좌하우
    private static int[] rx = {0,-1,0,1};
    private static int[] ry = {-1,0,1,0};
    private static int N;
    private static int[][][] visited;
    
    private static boolean isValid(int x , int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
    
    private static boolean isBlocked(int[][] board , int x , int y){
        return (x==0 && y==0) || !isValid(x,y) || board[x][y] == 1;
    }
    
    private static int calculateCost(int direction , int preDirection, int cost){
        if(preDirection == -1 || (preDirection - direction) % 2 ==0)
            return cost+100;
        return cost + 600;
    }
    
    private static boolean isShouldUpdate(int x, int y, int direction, int newCost){
        return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;
    }
    
    // 직선 100 , 코너 500
    // 최소 비용 -> 너비 우선 탐색
    public int solution(int[][] board) {
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0,-1,0));
        N = board.length;
        visited = new int[N][N][4];
        
        int answer = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            for(int i = 0 ; i < 4 ;i++){
                int newX = now.x + rx[i];
                int newY = now.y + ry[i];
                
                if(isBlocked(board,newX,newY)) continue;
                
                int new_cost = calculateCost(i,now.direction,now.cost);
                
                if(newX == N-1 && newY == N-1)
                    answer = Math.min(answer,new_cost);
                
                else if(isShouldUpdate(newX,newY,i,new_cost)){
                    queue.add(new Node(newX,newY,i,new_cost));
                    visited[newX][newY][i] = new_cost;
                }
                
            }
        }
        return answer;
    }
}
