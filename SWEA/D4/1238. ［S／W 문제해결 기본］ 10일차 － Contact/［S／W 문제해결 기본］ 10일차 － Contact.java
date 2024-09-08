
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int N, start, max, result;
    static int[][] graph;
    static int[] visited;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            graph = new int[101][101];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N / 2; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
            }

            q = new LinkedList<>();
            visited = new int[101];
            result = 0;
            bfs(start);

            for (int i = 1; i < 101; i++) {
                if (visited[i] == max) {
                    result = Math.max(i, result);
                }
            }

            sb.append(result).append("\n");
        }

        wr.write(sb.toString());
        wr.flush();
    }

    private static void bfs(int start) {
        q.offer(start);
        visited[start] = 1;
        max = 1;

        while (!q.isEmpty()) {
            int V = q.poll();

            for (int i = 1; i < 101; i++) {
                if (visited[i] == 0 && graph[V][i] == 1) {
                    q.offer(i);
                    visited[i] = visited[V] + 1;
                    max = Math.max(max, visited[i]);
                }

            }

        }
    }
}
