import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        // 키 = 명령어 , 값 = 메세지
        HashMap<String,String> msg = new HashMap<>();
        msg.put("Enter","님이 들어왔습니다.");
        msg.put("Leave","님이 나갔습니다.");
        
        // 키 = 유저아이디 , 값 = 닉네임
        HashMap<String,String> users = new HashMap<>();
        
        for(String s : record){
            String[] parts = s.split(" ");
            if(parts.length == 3){
                users.put(parts[1],parts[2]);
            }
        }
        
        ArrayList<String> answers = new ArrayList<>();
        
        for(String s : record){
            String[] cmd = s.split(" ");
            if(msg.containsKey(cmd[0])){
                answers.add(users.get(cmd[1])+ msg.get(cmd[0]));
            }
        }
        
        return answers.toArray(new String[0]);
    }
}
