import java.util.*;

class Solution {
    private static class Node{
        int y,x,cost;
        
        public Node(int y, int x, int cost){
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
    
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;
        
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        boolean[][] visited = new boolean[n][n];
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) 
                -> Integer.compare(o1.cost,o2.cost));
        pq.add(new Node(0,0,0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visited[now.y][now.x]) continue;
            
            visited[now.y][now.x] = true;
            answer += now.cost;
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
             
                if(ny >= n || nx >= n || ny < 0 || nx < 0) continue;
                
                int tempCost = Math.abs(land[ny][nx] - land[now.y][now.x]);
                int newCost = tempCost > height ? tempCost : 0;
                pq.add(new Node(ny,nx,newCost));
            }
        }
        
        return answer;
    }
}
