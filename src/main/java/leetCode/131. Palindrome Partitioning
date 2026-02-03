import java.util.List;
import java.util.ArrayList;

class Solution {

    private List<List<String>> result = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {        

        backTrack(s,0);

        return result;
    }

    private void backTrack(String s , int start){

        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = start ; i < s.length() ; i++){
           if(!isPalindrome(s,start,i)) continue;

           /*
           0 0 a
           1 1 a a
           2 2 a a b
           3 3 add return! result = [[a,a,b]] remove b path : [a,a]
           2 3 a 
           1 2 a ab continue
           1 3 - 
           0 1 aa 
           2 2 aa b 
           3 3 result = [[a,a,b],[aa,b]] return! remove b path : [aa]
           2 3 remove aa
           0 2 aab continue
           end!
           */
           path.add(s.substring(start,i+1));    
           backTrack(s,i+1);
           path.remove(path.size()-1);

        }
    }

    private boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

}
