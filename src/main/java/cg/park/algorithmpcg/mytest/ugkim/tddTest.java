package cg.park.algorithmpcg.mytest.ugkim;


import java.util.Arrays;

public class tddTest {
    public static void main(String[] args) {

        splitAndsum(null);
    }

    // 1 => 1
    // 1,2 => 3
    // 1,2:3 => 6
    public static int splitAndSumTest(String text) {
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

    public static int splitAndsum(String number) {
        return (isBlank(number))
                ? 0
                : sum(toInt(number.split(",|:")));
    }

    public static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    public static int sum (int[] values) {
        return Arrays.stream(values).sum();
    }

    public static int[] toInt(String[] values) {
        return Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
    }



}
