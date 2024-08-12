
import java.io.*;
import java.util.*;

public class Solution {

    static int N, K;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            int result = 0;
            //배열 초기화 하면서 가로에서 찾기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int count = 0;
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) {
                        count++;
                    } else {
                        if (count == K) {
                            result++;
                        }
                        count = 0;
                    }
                }
                if (count == K) {
                    result++;
                }

            }

            //세로에서 찾기
            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int j = 0; j < N; j++) {
                    if (arr[j][i] == 1) {
                        count++;
                    } else {
                        if (count == K) {
                            result++;
                        }
                        count = 0;
                    }
                }
                if (count == K) {
                    result++;
                }

            }

            wr.write("#" + tc + " " + result + "\n");
            wr.flush();
        }


    }
}