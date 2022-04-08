package cg.park.algorithmpcg.kko._2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//https://programmers.co.kr/learn/courses/30/lessons/92341
public class _03 {

    static HashMap<String, String> inoutMap = new HashMap<>();
    static HashMap<String, Integer> sumMap = new HashMap<>();

    public static int[] getAnswer(int[] fees) {
        int[] answer = new int[sumMap.size()];
        //기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
        int defaultHour = fees[0];
        int defaultFee = fees[1];
        int defaultMinute = fees[2];
        int unit = fees[3];
        int index = 0;
        for (Map.Entry<String, Integer> entry : sumMap.entrySet()) {
            answer[index] = (defaultHour >= entry.getValue())
                            ? defaultFee
                            : defaultFee + ((entry.getValue() - defaultHour) / defaultMinute) * unit;
            index++;
        }
        return answer;
    }

    public static int getParkingTime(StringTokenizer token) {
        return (Integer.parseInt(token.nextToken()) * 60) + (Integer.parseInt(token.nextToken()));
    }

    public static int sumParkingTime(String carNo) {
        return getParkingTime(new StringTokenizer(inoutMap.get(carNo), ":"));
    }

    public static void toInOut(String[] history) {
        if ("IN".equals(history[2])) {
            inoutMap.put((history[1]), history[0]);
            return;
        }
        if (sumMap.containsKey((history[1])));
        sumMap.put((history[1]), sumParkingTime(history[1]) - sumMap.getOrDefault(history[1], 0));
    }

    public static int[] solution(int[] fees, String[] records) {
        Arrays.stream(records).forEach(record -> { toInOut(record.split(" ")); });
        return getAnswer(fees);
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(solution(fees, records));
    }

}
