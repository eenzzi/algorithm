import java.util.Scanner;

public class Solution {

    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();

            int result = pow(M, N);

            System.out.println("#" + tc + " " + result);
        }

    }

    private static int pow(int M, int N) {
        if (M == 1) {
            return N;
        }

        if (M % 2 == 0) {
            int tmp = pow(M / 2, N);
            return tmp * tmp;
        } else {
            int tmp = pow((M - 1) / 2, N);
            return tmp * tmp * N;
        }
    }
}
