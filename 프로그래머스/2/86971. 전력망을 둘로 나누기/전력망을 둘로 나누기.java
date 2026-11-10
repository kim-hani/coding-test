import java.util.ArrayList;

class Solution {
    
    private static ArrayList<Integer>[] nodeList;
    private static boolean[] visited;
    private static int N,answer;
    
    public int solution(int n, int[][] wires) {
        
        N = n;
        answer = n-1;
        
        nodeList = new ArrayList[n+1];
        
        for(int i = 0 ; i < n+1 ; i++){
            nodeList[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            nodeList[wire[0]].add(wire[1]);
            nodeList[wire[1]].add(wire[0]);
        }
        
        visited = new boolean[n+1];
        dfs(1);
        return answer;
    }
    
    public static int dfs(int now){
        
        visited[now] = true;
        
        int sum = 0;
        
        for(int next : nodeList[now]){
            if(!visited[next]){
                
                int cnt = dfs(next);
                answer = Math.min(answer,Math.abs(N-cnt*2));
                
                sum += cnt;
            }
        }
        return sum + 1;
    }
    
}