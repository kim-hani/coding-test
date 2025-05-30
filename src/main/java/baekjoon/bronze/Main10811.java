package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Main10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] =new int[n];

        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }

        //[1,2,3,4,5,6,7,8,9,10]

        for(int k=0;k<m;k++){
            int i = sc.nextInt();
            int j = sc.nextInt();

            i--;
            j--;

            while (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
        }
    }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
