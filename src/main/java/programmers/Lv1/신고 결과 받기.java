import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 같은 사람이 똑같은 사람을 여러번 신고는 1회로 처리
        
        // 유저별로 신고당한 횟수 저장
        HashMap<String,Integer> reported = new HashMap<>();
        
        // 유저별로 신고한 유저 저장
        HashMap<String,HashSet<String>> reportWho = new HashMap<>();
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0 ; i < id_list.length ; i++){
            reported.put(id_list[i],0);
            reportWho.put(id_list[i],new HashSet<>());
            answer[i] = 0;
        }
        
        // 누가 누구를 신고했는지 저장
        for(String s : report){
            String[] name = s.split(" ");
        
            if(!reportWho.get(name[0]).contains(name[1])) 
                reported.put(name[1],reported.getOrDefault(name[1],0)+1);
            reportWho.get(name[0]).add(name[1]);
        }
        
    // 정지된 유저 집합 만들기
    HashSet<String> banned = new HashSet<>();
    for (String user : id_list) {
        if (reported.getOrDefault(user, 0) >= k) {
            banned.add(user);
        }   
    }

    
    for (int i = 0; i < id_list.length; i++) {
        String reporter = id_list[i];
        for (String target : reportWho.get(reporter)) {
            if (banned.contains(target)) {
                answer[i]++;
            }
        }
    }


        // 각 유저별로 메일 받은 횟수를 배열로 담음
        return answer;
    }
}
