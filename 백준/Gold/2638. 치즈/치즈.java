
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cheese, answer;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;
                if (a == 1) cheese++;
            }
        }

        while (cheese > 0) { // 치즈가 남을 때까지
            // BFS로 외부 공기와 내부 공기 나누기 -> visited = true 면 외부 공기
            visited = new boolean[N][M];
            bfs();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && canMelt(i, j)) { // 녹는 경우
                        cheese--;
                        arr[i][j] = 0;
                    }
                }
            }

            answer++;
        }

        System.out.println(answer);
    }

    private static boolean canMelt(int x, int y) {
        int cnt = 0; // 외부 접촉 개수

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (arr[nx][ny] == 0 && visited[nx][ny]) cnt++;
            if (cnt >= 2) return true;
        }
        return false;
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
                if (arr[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true; // 외부 공기 표시
                }
            }
        }
    }

}
