


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, S, E, result;
    static ArrayList<Node>[] list;
    static int[] min;

    static class Node implements Comparable<Node>{
        int end, cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        min = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        result = 0;
        dijkstra(S);

        System.out.println(min[E]);
    }

    private static void dijkstra(int s) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        Arrays.fill(min, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N + 1];

        min[s] = 0;
        q.offer(new Node(s, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int cur = node.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node next : list[node.end]) {
                    if (!visited[next.end] && min[next.end] > min[cur] + next.cost) {
                        min[next.end] = min[cur] + next.cost;
                        q.offer(new Node(next.end, min[next.end]));
                    }
                }
            }
        }
    }


}
