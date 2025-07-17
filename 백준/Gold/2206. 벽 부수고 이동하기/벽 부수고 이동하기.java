
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] graph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x, y, dist;
        boolean isMove;

        public Node(int x, int y, int dist, boolean isMove) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.isMove = isMove;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {

            String read = br.readLine();

            for (int j = 0; j < M; j++) {
                graph[i][j] = read.charAt(j) - '0';
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, false));

        int answer = Integer.MAX_VALUE;

        boolean[][][] visited = new boolean[N][M][2];

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                answer = now.dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (graph[nx][ny] == 1 && now.isMove) continue;

                int broken = now.isMove ? 1 : 0;

                // 벽일 경우
                if (graph[nx][ny] == 1 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.offer(new Node(nx, ny, now.dist + 1, true));
                } else if (graph[nx][ny] == 0 && !visited[nx][ny][broken]) {
                    visited[nx][ny][broken] = true;
                    q.offer(new Node(nx, ny, now.dist + 1, now.isMove));
                }
            }
        }

        if (answer == Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }

}
