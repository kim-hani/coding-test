import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {
    
    public int solution(int n, int[][] edges) {
        ArrayList<Integer>[] nodeList = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        
        for(int i = 0 ; i < n+1 ; i++) nodeList[i] = new ArrayList<>();
        
        // 1 : 3 2
        // 2 : 3 1 4 5
        // 3 : 6 4 2 1
        // 4 : 3 2
        // 5 : 2
        // 6 : 3
        for(int[] edge : edges) {
            nodeList[edge[0]].add(edge[1]); 
            nodeList[edge[1]].add(edge[0]); 
        }
        
        int[] dist = new int[n+1];
        
        Arrays.fill(dist,-1);
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        dist[1] = 0;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
                    
            for(int next : nodeList[now]){
                if(dist[next] == -1){
                    dist[next] = dist[now]+1;
                    queue.add(next);
                }
            }
        }
        int max = 0 , answer = 0;
        for(int d : dist) if(d > max) max = d;
        for(int d : dist) if(d == max) answer++;
        return answer;
    }  
}
