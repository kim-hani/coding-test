class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<food.length;i++){
            int temp = food[i]/2;
            for(int j=0;j<temp;j++){
                sb.append(i);
            }
        }
        StringBuilder original = new StringBuilder(sb);
        original.append(0);
        return original.append(sb.reverse()).toString();
    }
}
