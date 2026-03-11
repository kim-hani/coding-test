package leetCode;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger13 {
    public int romanToInt(String s) {
        Map<String,Integer> roman = new HashMap<>();

        roman.put("I",1);
        roman.put("V",5);
        roman.put("X",10);
        roman.put("L",50);
        roman.put("C",100);
        roman.put("D",500);
        roman.put("M",1000);

        int result = 0;
        int pre = 0;

        for(int i = s.length()-1 ; i >=0 ; i --){
            int current = roman.get(String.valueOf(s.charAt(i)));

            if(current < pre) result -= current;
            else result += current;

            pre = current;
        }
        return result;

    }
}
