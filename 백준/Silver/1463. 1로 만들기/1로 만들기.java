import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static Integer[] dp;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];

        dp[0] = dp[1] = 0;

        System.out.println(recur(N));

    }

    private static int recur(int N) {

        if (dp[N] == null) {

            if(N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;

            } else if (N % 2 == 0) {

                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;


            } else if (N % 3 == 0) {

                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;

            } else {

                dp[N] = recur(N - 1) + 1;
            }
        }


        return dp[N];
    }




}