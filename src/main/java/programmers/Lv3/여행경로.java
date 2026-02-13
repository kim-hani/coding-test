import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String,PriorityQueue<String>> graph = new HashMap<>();
        
        for(String[] ticket : tickets){
            String start = ticket[0];
            String end = ticket[1];
            
            graph.computeIfAbsent(start,k -> new PriorityQueue<>()).add(end);
        }
        
        Deque<String> dq = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        
        dq.push("ICN");
         
        while(!dq.isEmpty()){
            String curr = dq.peek();
            
            if(graph.containsKey(curr) && !graph.get(curr).isEmpty()){
                dq.push(graph.get(curr).poll());
            }else{
                result.add(dq.poll());
            }
        }
        
        Collections.reverse(result);
        
        return result.toArray(new String[0]);
    }
}
