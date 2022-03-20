package cg.park.algorithmpcg.baekjoon.stack;

import java.util.Arrays;
import java.util.Stack;

// 스택 수열 1874 문제
// https://www.acmicpc.net/problem/1874
public class _1874 {
    static Stack<Integer> stack = new Stack<>();
    static int cnt = 0;

    public static void toStack(String command) {

        if ("push".equals(command)) {
            cnt++;
            stack.push(cnt);
            return;
        }
        System.out.println(stack.pop());
    }

    public static void main(String[] args) {
        String[] arrs = {"push", "push", "push", "push", "pop", "pop", "push", "push", "pop", "pop"};
        Arrays.stream(arrs).forEach(arr ->  {toStack(arr);});
    }
}
