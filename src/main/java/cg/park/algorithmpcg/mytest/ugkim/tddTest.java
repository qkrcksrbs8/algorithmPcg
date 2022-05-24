package cg.park.algorithmpcg.mytest.ugkim;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public class tddTest {
    public static void main(String[] args) {
        int x = splitAndSum2("1,2:3");
        System.out.println(x);
    }

    // 1 => 1
    // 1,2 => 3
    // 1,2:3 => 6
    public static int splitAndSum(String text) {
        int result = 0;
        if (text == null || text.isEmpty()) {
            result = 0;
        }
        else {
            String [] values = text.split(",|:");
            for (String value : values) {
                result += Integer.parseInt(value);
            }
        }
        return result;
    }

    public static int splitAndSum2(String text) {
        return isBlank(text)
                ? 0
                : sum(toInt(text.split(",|:")));
    }

    public static boolean isBlank(String str) {
        return str == null || str.length() == 0;
    }

    private static int[] toInt(String[] values) {
        return Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
    }

    private static int sum(int[] values) {
        return Arrays.stream(values).sum();
    }

}
