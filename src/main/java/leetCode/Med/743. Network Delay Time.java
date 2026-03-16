// times 는 [ui,vi,wi] 식으로 주어짐
// ui는 현재노드 , vi는 타겟노드 , wi는 현재노드에서 타겟노드로 이동시 가중치
// k노드에서 시작해 모든 노드가 시그널을 받을때까지 걸리는 시간의 최솟값
// 다익스트라
// 노드들의 정보를 어떻게 저장할까

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private static class Node{
        int dest;
        int time;

        public Node(int dest,int time){
            this.dest = dest;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Node>[] nodeList = new ArrayList[n+1];

        for(int i = 0 ; i <= n ; i ++) nodeList[i] = new ArrayList<>();

        // 인덱스가 기준노드 , 첫번째 인자가 목표노드 , 두번째 인자가 걸리는 시간
        for(int i = 0 ; i < times.length ; i++){
            nodeList[times[i][0]].add(new Node(times[i][1],times[i][2]));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.time,o2.time));
        pq.add(new Node(k,0));
        dist[k] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(nodeList[now.dest].isEmpty()) continue;

            if(dist[now.dest] < now.time) continue;

            for(Node next : nodeList[now.dest]){
                if(dist[next.dest] == -1 || dist[next.dest] > dist[now.dest] + next.time){
                    dist[next.dest] = dist[now.dest] + next.time;
                    pq.add(new Node(next.dest,dist[next.dest]));
                }
            }
        }

        int max = -1;
        // 리스트가 하나라도 비어있으면 -1
        for(int i = 1 ; i <= n ; i++){
            if(dist[i] == -1) return -1;
            if(dist[i] > max) max = dist[i];
        }
        return max;
    }
}
