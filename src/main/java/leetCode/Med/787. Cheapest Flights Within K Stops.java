import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    private static class Node{
        int dest;
        int price;
        int stops;

        public Node(int dest, int price,int stops){
            this.dest = dest;
            this.price = price;
            this.stops = stops;
        }
    }

    // n = 도시 수 , flights = 항공편 정보 , src = 출발 도시 , dst = 목적 도시 , k = 비행기 착륙 최대 허용횟수
    public int findCheapestPrice(int N, int[][] flights, int src, int dst, int k) {
        // 항공편의 정보를 담을 리스트
        ArrayList<int[]>[] nodeList = new ArrayList[N];
        
        // 리스트 초기화
        for(int i = 0 ; i < N ; i++) nodeList[i] = new ArrayList<>();

        // 인덱스 = 기준도시 , 첫번째 인자 = 목표 도시 , 두번째 인자 = 가격
        for(int[] flight : flights) 
            nodeList[flight[0]].add(new int[]{flight[1],flight[2]});
        
        // 최단 거리 값을 저장할 배열
        int[][] dist = new int[N][k+2];
        for(int i = 0 ; i < N ; i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[src][0] = 0;

        // 가격을 기준으로 오름차순
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.price,o2.price));
        pq.add(new Node(src,0,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.dest == dst) return now.price;

            if(now.stops == k + 1) continue;

            if(nodeList[now.dest].isEmpty()) continue;

            if(dist[now.dest][now.stops] < now.price) continue;

            for(int[] next : nodeList[now.dest]){
                int city = next[0];
                int price = next[1];
                int newCost = now.price+price;
                int nextStops = now.stops+1;
                if(newCost <  dist[city][nextStops]){
                    dist[city][nextStops] = dist[now.dest][now.stops] + price;
                    pq.add(new Node(city,newCost,nextStops));
                }
            }
        }

        return -1;
    }
}
