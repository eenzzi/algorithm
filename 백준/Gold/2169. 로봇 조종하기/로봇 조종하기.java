import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 번째 행의 값은 그대로 사용 (위에서 오는 경로가 없으므로)
        dp[0][0] = arr[0][0];
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }

        // 두 번째 행부터는 왼쪽에서 오는 경우, 오른쪽에서 오는 경우, 위에서 오는 경우를 모두 고려
        for (int i = 1; i < N; i++) {
            int[] leftToRight = new int[M];
            int[] rightToLeft = new int[M];

            // 왼쪽에서 오른쪽으로 탐색
            leftToRight[0] = dp[i - 1][0] + arr[i][0];
            for (int j = 1; j < M; j++) {
                leftToRight[j] = Math.max(dp[i - 1][j], leftToRight[j - 1]) + arr[i][j];
            }

            // 오른쪽에서 왼쪽으로 탐색
            rightToLeft[M - 1] = dp[i - 1][M - 1] + arr[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                rightToLeft[j] = Math.max(dp[i - 1][j], rightToLeft[j + 1]) + arr[i][j];
            }

            // 왼쪽에서 오른쪽과 오른쪽에서 왼쪽 중 최대값을 dp 배열에 저장
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(leftToRight[j], rightToLeft[j]);
            }
        }

        // 마지막 칸의 값 출력
        System.out.println(dp[N - 1][M - 1]);
    }
}
