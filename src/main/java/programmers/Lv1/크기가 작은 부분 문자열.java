class Solution {
    public int solution(String t, String p) {
        int size = p.length();
        int cnt=0;
        for(int i=0;i<t.length()-size+1;i++){
            String temp = t.substring(i,i+size);
            if(temp.compareTo(p)<=0) cnt++;
        }
        return cnt;
    }
}
