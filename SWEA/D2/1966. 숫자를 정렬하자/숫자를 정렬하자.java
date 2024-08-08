import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N; i++) {
                int data = arr[i];
                int j;
                for (j = i - 1; j >= 0 && data < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = data;
            }

            wr.write("#" + tc + " ");
            for (int i = 0; i < N; i++) {
                wr.write(arr[i] + " ");
            }
            wr.write("\n");
            wr.flush();

        }

    }
}