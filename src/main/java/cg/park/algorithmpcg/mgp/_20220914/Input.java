package cg.park.algorithmpcg.mgp._20220914;

import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);

    public boolean input() {
        int a = 0;
        int b = 0;
        System.out.println("first int: ");
        a = sc.nextInt();
        System.out.println("second int: ");
        b = sc.nextInt();

        return a==b;
    }

    boolean run() {
        return this.input();
    }

}
