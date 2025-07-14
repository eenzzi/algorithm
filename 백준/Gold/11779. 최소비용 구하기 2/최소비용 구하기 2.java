

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static class Bus implements Comparable<Bus> {
        int end, cost;

        public Bus(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        List<List<Bus>> graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Bus(e, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        int[] prev = new int[N + 1];

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus now = pq.poll();

            if (dist[now.end] < now.cost) continue;

            for (Bus next : graph.get(now.end)) {
                int cost = now.cost + next.cost;
                if (cost < dist[next.end]) {
                    dist[next.end] = cost;
                    prev[next.end] = now.end; // 이전 경로 저장
                    pq.offer(new Bus(next.end, cost));
                }
            }
        }

        System.out.println(dist[end]);

        List<Integer> path = new ArrayList<>();
        int now = end;
        while (now != 0) {
            path.add(now);
            now = prev[now];
        }

        System.out.println(path.size());

        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        for (int city : path) {
            sb.append(city + " ");
        }

        System.out.println(sb);
    }

}
