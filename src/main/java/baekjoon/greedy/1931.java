import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        int cnt = 0;
        for(int n = 0; n < N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,(a,b) -> (a[1]== b[1]) ? a[0]-b[0] : a[1]-b[1]);
        
        int end = 0;
        for(int[] mt : arr){
            if(mt[0] >= end){
                end = mt[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
