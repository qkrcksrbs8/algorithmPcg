package cg.park.algorithmpcg.baekjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 백준 10866 덱
// https://www.acmicpc.net/problem/10866
public class _10866 {

    static Deque<Integer> deque = new ArrayDeque<>();

    public static void toDeque(String command) {
        if (command.startsWith("push_front")) {
            deque.offerFirst(Integer.parseInt(command.split(" ")[1]));
            return;
        }
        if (command.startsWith("push_back")) {
            deque.offerLast(Integer.parseInt(command.split(" ")[1]));
            return;
        }
        if ("pop_front".equals(command)) {
            System.out.println(deque.isEmpty()? -1 : deque.pollFirst());
            return;
        }
        if ("pop_back".equals(command)) {
            System.out.println(deque.isEmpty()? -1 : deque.pollLast());
            return;
        }
        if ("size".equals(command)) {
            System.out.println(deque.size());
            return;
        }
        if ("empty".equals(command)) {
            System.out.println(deque.isEmpty()? 1 : 0);
            return;
        }
        if ("front".equals(command)) {
            System.out.println(deque.isEmpty()? -1 : deque.getFirst());
            return;
        }
        if ("back".equals(command)) {
            System.out.println(deque.isEmpty()? -1 : deque.getLast());
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        while(cnt -- > 0 ){
             toDeque(br.readLine());
        }
    }
}
