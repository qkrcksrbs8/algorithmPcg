package cg.park.algorithmpcg.mgp._20220914;
import java.util.Scanner;

public class ProcessScore{

    static int jumsu;      // 점수
    static int count = 0;   // 학생들의 수
    static int max = -1;   // 최고 점수
    static int min = 101;   // 최저 점수
    static int sum = 0;   // 합계
    static double aver;   // 평균 점수

    static Scanner scan = new Scanner(System.in);

    public static void Jumsu(int jumsu ){

        // 점수가 -99가 아닌 동안 반복한다
        while (jumsu != -99) {
            count++;      // 학생들의 수를 1만큼 증가시킨다
            sum += jumsu;   // 합계를 계산한다
            // 최고 점수를 구한다
            if ( jumsu > max) max = jumsu;

            // 최저 점수를 구한다
            if ( jumsu < min) min = jumsu;
            // 점수를 입력받는다
            System.out.print("점수(더 이상 점수가 없다면 -99)를 입력하세요: ");
            jumsu = scan.nextInt();
        }

    }
    public static void main (String[] args) {
        // Scanner 객체를 만든다
        // 점수를 입력받는다
        System.out.print("점수(더 이상 점수가 없다면 -99)를 입력하세요: ");
        jumsu = scan.nextInt();

        Jumsu(jumsu);

        // 평균 점수를 계산한다
        aver = (double) sum / count;

        // 최고 점수, 최저 점수와 평균 점수를 출력한다
        System.out.println("최고 점수 = " + max);
        System.out.println("최저 점수 = " + min);
        System.out.println("평균 점수 = " + aver);
    }

}