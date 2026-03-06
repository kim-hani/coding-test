import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    
    private static final int[] dx = {0,0,-1,1};
    private static final int[] dy = {-1,1,0,0};
    
    private static class Point{
        int nx,ny;
        
        public Point(int ny, int nx){
            this.ny = ny;
            this.nx = nx;
        }
    }
    
    private static int N,M;
    private static char[][] map;
    
    public int solution(String[] maps) {
        // (S -> L) + (L -> D)
        N = maps.length;
        M = maps[0].length();
        
        map = new char[N][M];
        
        for(int i = 0 ; i < N ; i++) 
            map[i] = maps[i].toCharArray();
        
        Point start = null , end = null , lever = null;
        
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 'S') start = new Point(i,j);
                else if(map[i][j] == 'E') end = new Point(i,j);
                else if(map[i][j] == 'L') lever = new Point(i,j);
            }
        }
        int startLever = getMinDistance(start,lever);
        int leverEnd = getMinDistance(lever,end);
        
        if(startLever == -1 || leverEnd == -1) return -1;
        
        else return startLever + leverEnd;
    }
    
    private static int getMinDistance(Point start,Point end){
        int[][] dist = new int[N][M];
        
        for(int i = 0 ; i < N ; i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        
        ArrayDeque<Point> dq = new ArrayDeque<>();
        dq.add(start);
        dist[start.ny][start.nx] = 0;
        
        while(!dq.isEmpty()){
            Point now = dq.poll();
            
            for(int i = 0 ; i < 4 ; i++){
                int nextY = now.ny + dy[i];
                int nextX = now.nx + dx[i];
                
                if(!isValid(nextY,nextX)) continue;
                
                if(dist[nextY][nextX] > dist[now.ny][now.nx]+1){
                    dist[nextY][nextX] = dist[now.ny][now.nx] + 1;
                    dq.add(new Point(nextY,nextX));       
                }
            }
        }
        if(dist[end.ny][end.nx] == Integer.MAX_VALUE) return -1;
        
        return dist[end.ny][end.nx];
    }
    
    private static boolean isValid(int nextY,int nextX){
        return nextY >= 0 && nextX >= 0 
            && nextY < N && nextX < M
            && map[nextY][nextX] != 'X';
    }
}
