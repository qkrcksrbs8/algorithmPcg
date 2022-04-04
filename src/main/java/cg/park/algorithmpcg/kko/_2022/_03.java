package cg.park.algorithmpcg.kko._2022;

import java.util.StringTokenizer;

public class _03 {

    public static boolean isPrime(Long n) {
        if(n < 2) return false;
        if(n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) if(n % i == 0) return false;
        return true;
    }

    public static Long toEverynary (int n, int k) {
        return Long.parseLong(Integer.toString(n,k));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        StringTokenizer token = new StringTokenizer(Long.toString(toEverynary(n, k)), "0");
        while (token.countTokens() > 0) {
            if (isPrime(Long.parseLong(token.nextToken()))) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
//        int n = 437674;
//        int k = 3;
        System.out.println(solution(n,k));
    }

}
