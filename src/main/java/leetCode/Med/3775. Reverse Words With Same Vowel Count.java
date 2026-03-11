class Solution {
    public String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");
        String[] copy = new String[words.length];
        for(int i = 0 ; i < words.length ; i++){
             copy[i] = words[i].replaceAll("[^aeiou]","");
        }

        for(int i = 1 ; i <words.length ; i++){
            if(copy[0].length() == copy[i].length()){
                String word = words[i];
                String reverse = new StringBuilder(word).reverse().toString();
                words[i] = reverse;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < words.length-1 ; i++){
            sb.append(words[i]).append(" ");
        }
        return sb.append(words[words.length-1]).toString();
    }
}
