class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");

        int[] left = evaluate(parts[0]);
        int[] right = evaluate(parts[1]);

        int x = left[0] - right[0];
        int num = right[1] - left[1];

        if(x== 0 && num == 0){
            return "Infinite solutions";
        }else if(x ==0 && num != 0){
            return "No solution";
        }else{
            x = num/x;
        }
        return "x=" + String.valueOf(x);
    }

    private int[] evaluate(String expr){
        int[] res = new int[2]; // res[0] : x 계수 , res[1] : 상수

        String[] tokens = expr.split("(?=[-+])");
        
        for(String token : tokens){
            if(token.equals("")) continue;

            if(token.equals("x") || token.equals("+x")){
                res[0] += 1;
            }else if(token.equals("-x")){
                res[0] -= 1;
            }else if(token.contains("x")){
                res[0] += Integer.parseInt(token.substring(0,token.length()-1));
            }else{
                res[1] += Integer.parseInt(token);
            }
        }

        return res;
    }
}
