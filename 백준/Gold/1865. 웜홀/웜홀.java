
import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m, w;
    static List<List<Node>> graph;

    static class Node {
        int end, time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // 도로 입력
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                graph.get(start).add(new Node(end, time));
                graph.get(end).add(new Node(start, time)); // 도로는 방향이 없음 (양방향)
            }

            // 웜홀 입력
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                graph.get(start).add(new Node(end, -time)); // 웜홀은 방향이 있음
            }

            boolean answer = false;

            int[] dist = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                boolean update = false;

                for (int j = 1; j <= n; j++) {
                    for (Node node : graph.get(j)) {
                        int nextTime = dist[j] + node.time;
                        if (dist[j] != Integer.MAX_VALUE && nextTime < dist[node.end]) {
                            dist[node.end] = nextTime;
                            update = true;

                            if (i == n) answer = true; // 음수 사이클 존재
                        }
                    }
                }

                if (!update) break; // 더이상 갱신할 곳이 없음
            }

            System.out.println(answer? "YES" : "NO");
        }


    }


}