import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T, n;
    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        dp[0][0] = 1; //n=0 일 때 0 호출 횟수
        dp[0][1] = 0; //n=0 일 때 1 호출 횟수
        dp[1][0] = 0; //n=1 일 때 0 호출 횟수
        dp[1][1] = 1; //n=1 일 때 1 호출 횟수

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            Integer[] fibonaccied = fibonacci(n);
            sb.append(fibonaccied[0]).append(" ").append(fibonaccied[1]).append("\n");
        }

        System.out.println(sb);
    }

    private static Integer[] fibonacci(int n) {

        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = dp[n - 1][1] + dp[n - 2][1];
        }

        return dp[n];
    }
}