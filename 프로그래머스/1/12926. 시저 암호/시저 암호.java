class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            sb.append(shiftAlphabet(ch,n));
        }
        return sb.toString();
    }
    
    public char shiftAlphabet(char c,int n){
        if(Character.isUpperCase(c)){
            return (char)((c - 'A' + n +26)%26 + 'A');
        }
        else if(Character.isLowerCase(c)) {
            return (char)((c - 'a' + n +26)%26 + 'a');
        }
        else return c;
    }
}