
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, X;
    static List<List<Node>> graph;

    static class Node implements Comparable<Node> {
        int end, time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }


        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, t));
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int t1 = dijkstra(i, X);
            int t2 = dijkstra(X, i);

            answer = Math.max(answer, t1 + t2);
        }

        System.out.println(answer);
    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int cur = now.end;

            if (visited[cur]) continue;
            visited[cur] = true;

            for (Node next : graph.get(cur)) {
                if (dist[next.end] > dist[cur] + next.time) {
                    dist[next.end] = dist[cur] + next.time;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }

        }

        return dist[end];
    }

}
