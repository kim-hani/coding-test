import java.util.List;
import java.util.ArrayList;

class Solution {

    private List<String> result = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12 || s.length() < 4) return result;

        backTrack(s,0);

        return result;

    }

    private void backTrack(String s,int offset){

        if(path.size() == 4){
            if(offset == s.length()){
                result.add(String.join(".",path));
            }
            return;
        }

        for(int len = 1 ; len <= 3 ; len++){

            if(offset+len > s.length()) break;

            String segment = s.substring(offset,offset+len);

            if(!isValid(segment)) break;

            path.add(segment);

            backTrack(s,offset+len);

            path.remove(path.size()-1);
        }

    }

    private boolean isValid(String s){
        if(s.charAt(0) == '0' && s.length() > 1) return false;

        int x = Integer.parseInt(s);

        return x <= 255;
    }
}
