class Solution {
    
    private static boolean[] visited;
    private static int[][] computer;
    
    private static void dfs(int now){
        visited[now] = true;
        
        for(int i = 0 ; i < computer[now].length ; i++){
            if(computer[now][i] == 1 && !visited[i]) dfs(i);
        }
    }
    
    public int solution(int n, int[][] computers) {
        // computers를 기준으로 그래프 구성
        // visited배열을 사용하여 방문여부 확인
        visited = new boolean[n];
        int answer = 0;
        
        computer = computers;
        
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
}
