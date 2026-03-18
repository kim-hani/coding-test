class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        //(a+bi) * (c + di) = (ac-bd) + (ad+bc)i 
        String[] n1 = num1.split("\\+");
        String[] n2 = num2.split("\\+");

        int a = Integer.parseInt(n1[0]);
        int c = Integer.parseInt(n2[0]);
        int b = Integer.parseInt(n1[1].substring(0,n1[1].length()-1));
        int d = Integer.parseInt(n2[1].substring(0,n2[1].length()-1));

        String a1 = String.valueOf(a*c-b*d);
        String a2 = String.valueOf(a*d+b*c);
        a2 += "i";

        return a1+"+"+a2;
    }
}
