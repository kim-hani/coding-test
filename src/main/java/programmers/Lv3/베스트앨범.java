import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        /*
        * 1. 가장 많이 재생된 장르부터 선택
        * 2. 장르에서 재생순으로 수록
        * 3. 재생횟수가 같으면 고유 번호가 낮은 순서대로
        * 4. 장르 별로 2개씩
        */
        
        // 매개변수의 인덱스가 노래의 고유 번호
        // ex) genres[0](classic) -> 고유번호 0
        // ex) plays[0](300) -> 고유번호 0 
    
        /*
        * 어떻게 풀까?
        * 해시맵 -> 고유번호(인덱스) : 장르 or 장르 : 플레이수
        * 해시맵 -> 고유번호(인덱스) : 플레이수
        */
        
        
        // < 장르 : [고유번호,재생횟수] >
        HashMap<String,ArrayList<int[]>> genreMap = new HashMap<>();
        
        // < 장르 : 장르 총 재생수 > 
        HashMap<String,Integer> playMap = new HashMap<>();
        
        for(int i = 0 ; i < genres.length ; i++){
            String genre = genres[i];
            int play = plays[i];
            
            if(!genreMap.containsKey(genre)){
                genreMap.put(genre,new ArrayList<>());
                playMap.put(genre,0);
            }
            
            genreMap.get(genre).add(new int[]{i,play});
            playMap.put(genre,playMap.get(genre) + play);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        Stream<Map.Entry<String,Integer>> sortedGenre = playMap.entrySet()
            .stream()
            .sorted((o1,o2) -> Integer.compare(o2.getValue(),o1.getValue()));
        
        sortedGenre.forEach(entry -> {
           Stream<int[]> sortedSongs = genreMap.get(entry.getKey())
               .stream()
               .sorted((o1,o2) -> Integer.compare(o2[1],o1[1]))
               .limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }     
}
