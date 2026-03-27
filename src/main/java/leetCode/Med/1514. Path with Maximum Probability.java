import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {

    private static class Node{
        int dest;
        double prob;

        public Node(int dest , double prob){
            this.dest = dest;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        ArrayList<Node>[] nodeList = new ArrayList[n];

        for(int i = 0 ; i < n ; i++) nodeList[i] = new ArrayList<>();

        for(int i = 0 ; i < edges.length ; i++){
            nodeList[edges[i][0]].add(new Node(edges[i][1],succProb[i]));
            nodeList[edges[i][1]].add(new Node(edges[i][0],succProb[i]));
        }

        double[] dist = new double[n];
        Arrays.fill(dist,-1);
        
        // 오름차순으로 정렬
        // 0 : (1,0.5) (2,0.2)
        // 1 : (0,0.5) (2,0.5)
        // 2 : (1,0.5) (0,0.2)
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) ->Double.compare(o2.prob,o1.prob));
        queue.add(new Node(start_node,1)); 
        dist[start_node] = 1;              

        // [0,1] [1,0.5] []
        //    1   0.5    0.2
        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(Node next : nodeList[now.dest]){
                if(dist[next.dest] == -1 || dist[next.dest] < dist[now.dest]*next.prob){
                    dist[next.dest] = dist[now.dest]*next.prob;
                    queue.add(new Node(next.dest,dist[next.dest]));
                }
            }
        }

        return dist[end_node] == -1 ? 0 : dist[end_node]; 
    }
}
