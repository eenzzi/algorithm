

import java.io.*;

public class Solution {

    static int N = 16;
    static int sx, sy, tx, ty, result;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            int k = Integer.parseInt(br.readLine());

            graph = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String read = br.readLine();
                for (int j = 0; j < N; j++) {
                    graph[i][j] = read.charAt(j) - '0';

                    if (graph[i][j] == 2) {
                        sx = i;
                        sy = j;
                    }

                    if (graph[i][j] == 3) {
                        tx = i;
                        ty = j;
                    }
                }
            }

            result = 0;
            dfs(sx, sy);

            sb.append(result).append("\n");
        }
        wr.write(sb.toString());
        wr.flush();
    }

    private static void dfs(int x, int y) {
        if (x == tx && y == ty) {
            result = 1;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && graph[nx][ny] != 1) {
                    dfs(nx, ny);
                }
            }
        }

    }

}
