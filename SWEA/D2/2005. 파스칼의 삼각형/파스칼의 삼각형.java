
import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            arr = new int[N + 1][N + 1];

            wr.write("#" + tc + "\n");

            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j <= i; j++) {
                    if (j == 1) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                    }
                    wr.write(arr[i][j] + " ");
                }
                wr.write("\n");
            }

            wr.flush();
        }


    }
}