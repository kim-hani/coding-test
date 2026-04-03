import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    private static class Node{
        int dest,cost;
        
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
 
    public int solution(int N, int[][] road, int K) {
        
        ArrayList<Node>[] nodeList = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i++){
            nodeList[i] = new ArrayList<>();
        }
        
        for(int[] edge : road){
            nodeList[edge[0]].add(new Node(edge[1],edge[2]));
            nodeList[edge[1]].add(new Node(edge[0],edge[2]));
        }
        
        int dist[] = new int[N+1];
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1,o2) -> Integer.compare(o1.cost,o2.cost));
        
        queue.add(new Node(1,0));
        dist[1] = 0;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            if(dist[now.dest] < now.cost) continue;
            
            for(Node next : nodeList[now.dest]){
                if(dist[next.dest] > now.cost + next.cost){
                    dist[next.dest] = now.cost + next.cost;
                    queue.add(new Node(next.dest,dist[next.dest]));
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 1 ; i <= N ;i++){
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
}
