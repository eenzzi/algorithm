

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int[] cost, plan, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            cost = new int[4];
            plan = new int[13];
            dp = new int[13];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 13; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
//                dp[i] = 987654321;
            }


            for (int i = 1; i < 13; i++) {
                dp[i] = dp[i - 1] + Math.min(plan[i] * cost[0], cost[1]);

                //3개월 사용할 수 있는 경우 확인
                if (i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + cost[2]);
                }
            }

            int result = Math.min(dp[12], cost[3]);

            sb.append(result).append("\n");
        }
        wr.write(sb.toString());
        wr.flush();
    }
}
