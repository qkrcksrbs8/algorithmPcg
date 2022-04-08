package cg.park.algorithmpcg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static List<Set<Integer>> getLottos(int count) {
        List<Set<Integer>> lotto = new ArrayList<>();
        while (count --> 0) lotto.add(getLotto());
        return lotto;
    }
    public static List<Set<Integer>> getLottos() {
        List<Set<Integer>> lotto = new ArrayList<>();
        lotto.add(getLotto());
        return lotto;
    }

    public static Set<Integer> getLotto() {
        Set<Integer> number = new HashSet<>();
        while (number.size() < 6) number.add((int)(Math.random() * 45)+1);
        return number;
    }

    public static void main(String[] args) {
        getLottos(6);
        System.out.println("여기에 배열 출력");
    }
}
