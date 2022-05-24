package cg.park.algorithmpcg.mytest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class test {

    public static String toDirection(String prev, String next) {
        if ("E".equals(prev)) return ("S".equals(next)) ? "right" : "left";
        if ("S".equals(prev)) return ("W".equals(next)) ? "right" : "left";
        if ("W".equals(prev)) return ("N".equals(next)) ? "right" : "left";
        return ("E".equals(next)) ? "right" : "left";
    }

    public static String getNavi(int location, int way, String direction) {
        StringBuilder sb = new StringBuilder();
        sb.append("Time ")
                .append(location)// 현재 누적 위치
                .append(": Go straight ")
                .append(way)// 몇 미터 후 방향전환 하는지
                .append("m and turn ")
                .append(direction);// left or right
        System.out.printf(sb.toString());
        return sb.toString();
    }

    public static List<String> solution(String path) {
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        int sum = 0;
        String[] arr = path.split("");
        for (String next : arr) {
            if (stack.empty()) {
                stack.push(next);
                sum++;
                continue;
            }
            if (!stack.peek().equals(next)) {
                list.add(getNavi(
                        (sum > 5)? stack.size() - 5 : stack.size() - sum,
                        ((sum * 100) > 500)? 500 : (sum * 100),
                        toDirection(stack.peek(), next)));
                sum = 0;
            }
            sum++;
            stack.push(next);
        }
        return list;
    }

    public static void main(String[] args) {
        String path = "EEESEEEEEENNNN";
//        String path = "SSSSSSWWWNNNNNN";
        solution(path);
    }
}
