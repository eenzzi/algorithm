
import java.io.*;
import java.util.*;

public class Solution {

    static int N, K;
    static double[] score;
    static String[] result = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            score = new double[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int middle = Integer.parseInt(st.nextToken());
                int fin = Integer.parseInt(st.nextToken());
                int hw = Integer.parseInt(st.nextToken());

                double total = (middle * 0.35) + (fin * 0.45) + (hw * 0.2);
                score[i] = total;
            }

            int idx = 0;
            for (int i = 0; i < N; i++) {
                if (score[K - 1] > score[i]) {
                    idx++;
                }
            }

            wr.write("#" + tc + " " + result[idx / (N / 10)] + "\n");
            wr.flush();
        }


    }
}