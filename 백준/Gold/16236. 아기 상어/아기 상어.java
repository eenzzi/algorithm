

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, minX, minY, minDist, answer;
    static int[][] map, dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Shark baby;

    static class Shark {
        int x, y, size, eat;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 2;
            this.eat = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 9) {
                    baby = new Shark(i, j);
                    map[i][j] = 0; // 상어가 있던 곳 0으로 갱신
                }
            }
        }

        while (true) {
            dist = new int[N][N];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;

            bfs(baby.x, baby.y);

            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                baby.eat++;
                map[minX][minY] = 0;
                baby.x = minX;
                baby.y = minY;
                answer += dist[minX][minY];

                if (baby.eat == baby.size) {
                    baby.size++;
                    baby.eat = 0;
                }
            } else break;
        }

        System.out.println(answer);

    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int num = map[now[0]][now[1]];

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (dist[nx][ny] != 0) continue; // 이미 방문 했던 곳

                int next = map[nx][ny];
                if (next > baby.size) continue;

                dist[nx][ny] = dist[now[0]][now[1]] + 1;

                // 먹을 수 있는 경우
                if (next != 0 && next < baby.size) {
                    if (minDist > dist[nx][ny]) { // 더 가까운 물고기가 있는 경우
                        minDist = dist[nx][ny];
                        minX = nx;
                        minY = ny;
                    } else if (minDist == dist[nx][ny]) { // 같은 거리일 경우
                        if (minX == nx && minY > ny) { // x가 같고 y가 작다면
                            minX = nx;
                            minY = ny;
                        } else if (minX > nx) { // x가 더 작다면
                            minX = nx;
                            minY = ny;
                        }
                    }
                }

                q.offer(new int[]{nx, ny});
            }
        }
    }

}
