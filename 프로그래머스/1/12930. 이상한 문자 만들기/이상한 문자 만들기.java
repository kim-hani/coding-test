class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ", -1);

        for (int i = 0; i < words.length; i++) {
            StringBuilder modifiedWord = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                if (j % 2 == 0) {
                    modifiedWord.append(Character.toUpperCase(ch));
                } else {
                    modifiedWord.append(Character.toLowerCase(ch));
                }
            }
            result.append(modifiedWord);
            if (i < words.length - 1) result.append(" "); 
        }

        return result.toString();
    }
}
