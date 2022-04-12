package cg.park.algorithmpcg.kko._2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//https://programmers.co.kr/learn/courses/30/lessons/92341
public class _03 {

    static HashMap<String, Integer> inoutMap = new HashMap<>();
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

    public static int secondParkingTime(StringTokenizer token) {
        return (Integer.parseInt(token.nextToken()) * 60) + (Integer.parseInt(token.nextToken()));
    }

    public static int toParkingTime(String time) {
        return secondParkingTime(new StringTokenizer(time, ":"));
    }

    public static void toInOut(String[] history) {
        if ("IN".equals(history[2])) {
            inoutMap.put((history[1]), toParkingTime(history[0]));
            sumMap.put((history[1]), 0);
            return;
        }
        int enterTime =  inoutMap.get(history[1]);// 입장 시간
        int exitTime = toParkingTime(history[0]);// 종료 시간
        int playTime = exitTime - enterTime;// 이용 시간
        int sumTime = sumMap.get(history[1]);// 누적 이용 시간
        sumMap.put(history[1], playTime + sumTime);
        inoutMap.remove(history[1]);
        //sumMap.put(toParkingTime(history[0]) - inoutMap.get(history[1]) + sumMap.getOrDefault(history[1], 0));// 위의 변수 대신 이렇게 한 줄로 사용 가능
    }

    public static int[] solution(int[] fees, String[] records) {
        Arrays.stream(records).forEach(record -> { toInOut(record.split(" ")); });
        if (!inoutMap.isEmpty()) {
            for (Map.Entry<String, Integer> map : inoutMap.entrySet()){
                int sumTime = sumMap.getOrDefault(map.getKey(), 0);// 누적 이용 시간
                sumMap.put(map.getKey(), 1439  - map.getValue() + sumTime);
            }
        }
        return getAnswer(fees);
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//        int[] fees = {1, 461, 1, 10};
//        String[] records = {"00:00 1234 IN"};
        int[] result = solution(fees, records);
        System.out.println(result);
    }

}
