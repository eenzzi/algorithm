
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int T, N, answer;
    static int[] arr;
    static boolean[] visited, done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N + 1];
            done = new boolean[N + 1];
            answer = N;

            for (int i = 1; i <= N; i++) {
                if (done[i]) continue;
                dfs(i);
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int num) {
        if (done[num]) return;
        if (visited[num]) { // 사이클
            done[num] = true;
            answer--;
        }

        visited[num] = true;
        dfs(arr[num]);
        done[num] = true;
        visited[num] = false;
    }

}