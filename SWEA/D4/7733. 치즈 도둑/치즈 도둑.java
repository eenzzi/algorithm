

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 1;
            for (int d = 1; d <= 100; d++) {
                visited = new boolean[N][N];
                int result = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!visited[i][j] && graph[i][j] > d) {
                            dfs(d, i, j);
                            result++;
                        }
                    }
                }

                max = Math.max(result, max);
            }

            sb.append(max).append("\n");
        }
        wr.write(sb.toString());
        wr.flush();
    }

    private static void dfs(int day, int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && graph[nx][ny] > day) {
                    dfs(day, nx, ny);
                }
            }
        }
    }
}
