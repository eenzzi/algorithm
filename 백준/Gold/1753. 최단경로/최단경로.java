

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int V, E, K, result;
    static int[] min;
    static ArrayList<ArrayList<Node>> graph;

    static class Node implements Comparable<Node> {

        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }


        dijkstra();
        for (int i = 1; i < V + 1; i++) {
            if (min[i] != Integer.MAX_VALUE) {
                System.out.println(min[i]);
            } else {
                System.out.println("INF");
            }
        }

    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        min = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            min[i] = Integer.MAX_VALUE;
        }

        pq.offer(new Node(K, 0));
        min[K] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nx = node.end;

            if (visited[nx]) {
                continue;
            }
            visited[nx] = true;

            for (Node next : graph.get(nx)) {
                if (min[next.end] > min[nx] + next.weight) {
                    min[next.end] = min[nx] + next.weight;
                    pq.offer(new Node(next.end, min[next.end]));
                }
            }
        }

    }


}
