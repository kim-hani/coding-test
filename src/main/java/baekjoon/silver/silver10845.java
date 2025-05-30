package baekjoon.silver;

import java.util.ArrayDeque;
import java.util.Scanner;

public class silver10845 {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            String s = sc.nextLine();
            String cmd[]= s.split(" ");
            switch (cmd[0]) {
                case "push":
                    deque.add(Integer.parseInt(cmd[1]));
                    break;
                case "pop" :
                    System.out.println(!deque.isEmpty() ? deque.pop():-1);
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty" :
                    System.out.println(deque.isEmpty() ? 1:0);
                    break;
                case "front":
                    System.out.println(deque.peekFirst());
                    break;
                case "back" :
                    System.out.println(deque.peekLast());
                    break;
            }
        }

    }
}
