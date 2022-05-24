package cg.park.algorithmpcg.baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17298 {

    static int count;
    static int[] nges;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());
        nges = new int[count+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < count; i++)
            nges[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(resultNges(i));
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static int resultNges(int i) {
        for (int j = i; j < count; j++)
            if (nges[i] < nges[j+1]) return nges[j+1];

        return -1;
    }

}
