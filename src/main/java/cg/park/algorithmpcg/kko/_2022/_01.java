package cg.park.algorithmpcg.kko._2022;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// 신고 결과 받기
public class _01 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> resultMap = new HashMap<>();// 각 신고자의 신고 성공 횟수
        HashMap<String, List<String>> reportMap = new HashMap<>();
        Arrays.stream(id_list).forEach(id -> {
            resultMap.put(id, 0);
            reportMap.put(id, new ArrayList<>());
        });
        Arrays.stream(report).forEach(reports -> {
            StringTokenizer token = new StringTokenizer(reports, " ");
            String reporter = token.nextToken();
            String criminal = token.nextToken();
            List<String> array = reportMap.get(criminal);
            array.add(reporter);
            reportMap.put(criminal, array);
        });
        Arrays.stream(id_list).forEach(id -> {
            Set<String> set = new HashSet<>(reportMap.get(id));
            int count = set.size();
            if (count >= k)
                set.forEach(reporter -> { resultMap.put(reporter, resultMap.get(reporter) + 1); });
        });
        AtomicInteger x = new AtomicInteger();
        Arrays.stream(id_list).forEach(id -> {
            answer[x.get()] = resultMap.get(id);
            x.set(x.get() + 1);
        });
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"muzi", "frodo", "apeach", "neo"};
        String[] completion = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

//        String[] participant = {"con", "ryan"};
//        String[] completion = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;
        int[] result = solution(participant, completion, k);
        System.out.println(result);
    }

}
