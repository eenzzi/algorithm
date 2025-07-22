import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, count;
    static int[] arr; // 한 열에는 하나의 값만 들어갈 수 있으니까 idx: 열 / 값: 행

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        count = 0;

        recur(0);

        System.out.println(count);

    }

    public static void recur(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if (possible(depth)) {
                recur(depth + 1);
            }
        }
    }

    public static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) { // arr[col]은 지금 놓는 곳의 행 값, arr[i]는 이전에 놓았던 곳의 행 값 => 서로 겹치면 안 됨
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) { // 대각선인 경우
                return false;
            }
        }

        return true;
    }

}
