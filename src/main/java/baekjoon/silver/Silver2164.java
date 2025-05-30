package baekjoon.silver;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Silver2164 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) queue.add(i + 1);

        while (queue.size() > 1) {
            queue.pollFirst();
            queue.add(queue.pollFirst());
        }
        System.out.println(queue.poll());
    }
}
