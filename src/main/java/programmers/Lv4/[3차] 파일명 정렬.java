import java.util.*;

class FileInfo{
    String head;
    int number;
    String original;
    
    public FileInfo(String head,int number,String original){
        this.head = head;
        this.number = number;
        this.original = original;
    }
}

class Solution {
    public String[] solution(String[] files) {
        List<FileInfo> fileList = new ArrayList<>();
        
        for(String file : files){
            fileList.add(parseFile(file));
        }
        
        Collections.sort(fileList,(f1,f2) -> {
            int headCompare = f1.head.toLowerCase().compareTo(f2.head.toLowerCase());
            if(headCompare != 0) return headCompare;
            
            return Integer.compare(f1.number,f2.number);
        });
        
        String[] answer = new String[files.length];
        for(int i=0; i<fileList.size(); i++) {
            answer[i]=fileList.get(i).original;
        }
        
        return answer;
    }
    
    private static FileInfo parseFile(String file){
        int idx = 0;
        int length = file.length();
        
        StringBuilder head = new StringBuilder();
        while(!Character.isDigit(file.charAt(idx))){
            head.append(file.charAt(idx));
            idx++;
        }
        
        StringBuilder number = new StringBuilder();
        while(idx<length && Character.isDigit(file.charAt(idx)) && number.length()<5){
            number.append(file.charAt(idx));
            idx++;
        }
        return new FileInfo(head.toString(),Integer.parseInt(number.toString()),file);
    }
}
