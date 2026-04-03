import java.util.ArrayDeque;

class Solution {
    
    // 경로 탐색을 위한 오프셋 배열
    private static final int[] rx = {0,0,1,-1};
    private static final int[] ry = {1,-1,0,0};
    
    private static class Node{
        // row , column
        int r,c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] maps) {
        
        // 미로판 크기
        int N = maps.length;
        int M = maps[0].length;
        
        // 시작 지점부터 각 칸까지의 거리(가중치)
        int[][] dist = new int[N][M];
        
        // 너비 우선 탐색을 위한 큐
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        // 너비 우선 탐색의 시작
        queue.addLast(new Node(0,0));
        // 최단 거리 1로 저장
        dist[0][0] = 1;
        
        // dfs 시작
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            
            // 오프셋 배열을 활용하여 주변 탐색
            for(int i = 0 ; i < 4 ;i++){
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];
                
                // 좌표가 배열을 벗어나면 패스
                if(nr < 0 || nc < 0 || nr >= N || nc >= M ) continue;
                // 해당 좌표에 벽이 있다면 패스
                if(maps[nr][nc] == 0) continue;
                
                // 갈 수 있는 경로라면 가중치+1을 하고 다음 좌표를 큐에 저장
                if(dist[nr][nc] == 0){
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                    queue.addLast(new Node(nr,nc));
                }
            }
        }
        
        // 목적지에 도달할 수 없으면 -1을 반환 
        // 도달했다면 가중치를 반환
        return dist[N-1][M-1] == 0 ? -1 : dist[N-1][M-1];
    }
}
